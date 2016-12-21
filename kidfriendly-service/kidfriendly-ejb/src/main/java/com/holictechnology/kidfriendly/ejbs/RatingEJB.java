package com.holictechnology.kidfriendly.ejbs;


import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.core.Response.Status;

import com.holictechnology.kidfriendly.domain.dtos.RatingDto;
import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;
import com.holictechnology.kidfriendly.domain.dtos.result.ResultDto;
import com.holictechnology.kidfriendly.domain.entitys.Company;
import com.holictechnology.kidfriendly.domain.entitys.Rating;
import com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal;
import com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
public class RatingEJB extends AbstractEJB implements RatingLocal {

    private static final long serialVersionUID = 5701134070335928714L;

    @EJB
    private CompanyLocal companyLocal;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal#listPending()
     */
    @Override
    @Transactional(value = TxType.SUPPORTS)
    public Collection<RatingDto> listPending() throws KidFriendlyException {
        Boolean stActive = Boolean.FALSE;
        TypedQuery<RatingDto> typedQuery = entityManager.createQuery(createHql(null, stActive, Boolean.TRUE).toString(), RatingDto.class);
        setParametersHql(typedQuery, null, stActive);

        return typedQuery.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal#listByCompany
     * (java.lang.Long,
     * com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto)
     */
    @Override
    @Transactional(value = TxType.SUPPORTS)
    public ResultDto<RatingDto> listByCompany(Long idCompany, PaginatorDto paginatorDto) throws KidFriendlyException {
        Boolean stActive = Boolean.TRUE;
        TypedQuery<Number> typedQueryCount = entityManager.createQuery(createHqlCount(createHql(idCompany, stActive, Boolean.FALSE)).toString(),
                Number.class);
        setParametersHql(typedQueryCount, idCompany, stActive);
        paginatorDto.setSize(typedQueryCount.getSingleResult().longValue());
        List<RatingDto> ratings = new LinkedList<RatingDto>();

        if (paginatorDto.getSize() > BigInteger.ZERO.longValue()) {
            TypedQuery<RatingDto> typedQuery = entityManager.createQuery(createHql(idCompany, stActive, Boolean.TRUE).toString(), RatingDto.class);
            setParametersHql(typedQuery, idCompany, stActive);
            setParametersPaginator(typedQuery, paginatorDto);
            ratings.addAll(typedQuery.getResultList());
        }

        ResultDto<RatingDto> resultDto = new ResultDto<RatingDto>();
        resultDto.setPaginatorDto(paginatorDto);
        resultDto.setResults(ratings);

        return resultDto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal#activate(java
     * .lang.Long)
     */
    @Override
    public void activate(Long primaryKey) throws KidFriendlyException {
        Rating rating = find(Rating.class, primaryKey, "company");

        if (rating == null) {
            throw new KidFriendlyException(Status.NOT_FOUND, KidFriendlyMessages.ERROR_NOT_FOUND_RATING);
        }

        rating.setStActive(Boolean.TRUE);
        rating = update(rating);
        entityManager.flush();
        sessionContext.getBusinessObject(RatingLocal.class).calculateRating(rating.getCompany());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal#
     * calculateRating(com.holictechnology.kidfriendly.domain.entitys.Company)
     */
    @Asynchronous
    public void calculateRating(Company company) throws KidFriendlyException {
        StringBuffer sql = new StringBuffer();
        sql.append(
                "SELECT ROUND(((SUM(IF(rating.ID_STATUS_KIDFRIENDLY = 1, 1, 0)) * 1) + (SUM(IF(rating.ID_STATUS_KIDFRIENDLY = 2, 1, 0)) * 2) + (SUM(IF(rating.ID_STATUS_KIDFRIENDLY = 3, 1, 0)) * 3) + (SUM(IF(rating.ID_STATUS_KIDFRIENDLY = 4, 1, 0)) * 4)) / COUNT(rating.ID_COMPANY)) ");
        sql.append("FROM kidfriendly.RATING AS rating  ");
        sql.append("WHERE rating.ST_ACTIVE = :stActive AND rating.ID_COMPANY = :idCompany ");
        sql.append("GROUP BY rating.ID_COMPANY");
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("stActive", Boolean.TRUE);
        query.setParameter("idCompany", company.getIdCompany());

        try {
            Number numRate = (Number) query.getSingleResult();

            if (numRate != null) {
                company.setNumRate(numRate.shortValue());
                update(company);
            }
        } catch (NoResultException exception) {}
    }

    /**
     * @param idCompany
     * @param isOrderBy
     * @return
     */
    private StringBuffer createHql(Long idCompany, Boolean stActive, boolean isOrderBy) {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT new com.holictechnology.kidfriendly.domain.dtos.RatingDto(rating.idRating, rating.dtRating, rating.desRating, rating.desAnswer, "
                + "statusKidFriendly.idStatusKidFriendly, company.idCompany, company.desName, user.idUser, user.desName, user.imgUser) ");
        hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.Rating AS rating ");
        hql.append("    INNER JOIN rating.statusKidFriendly AS statusKidFriendly ");
        hql.append("    INNER JOIN rating.company AS company ");
        hql.append("    INNER JOIN rating.user AS user ");
        hql.append("WHERE 1 = 1 ");
        hql.append(((stActive != null)) ? "    AND rating.stActive = :stActive" : " ");
        hql.append(((idCompany != null)) ? "    AND company.idCompany = :idCompany" : " ");
        hql.append(" AND rating.deleteLogic =  ").append(Boolean.TRUE);
        hql.append((isOrderBy) ? " ORDER BY rating.dtRating DESC " : "");

        return hql;
    }

    /**
     * @param query
     * @param companyFilterDto
     */
    private void setParametersHql(Query query, Long idCompany, Boolean stActive) {
        if (stActive != null) {
            query.setParameter("stActive", stActive);
        }

        if (idCompany != null) {
            query.setParameter("idCompany", idCompany);
        }
    }

    @Override
    public void activateNotShow(Long key) throws KidFriendlyException {
        Rating rating = find(Rating.class, key, "company");

        if (rating == null) {
            throw new KidFriendlyException(Status.NOT_FOUND, KidFriendlyMessages.ERROR_NOT_FOUND_RATING);
        }

        rating.setDeleteLogic(Boolean.FALSE);
        update(rating);
    }

    @Override
    public void delete(Long primaryKey) throws KidFriendlyException {
        delete(Rating.class, primaryKey);
    }
}
