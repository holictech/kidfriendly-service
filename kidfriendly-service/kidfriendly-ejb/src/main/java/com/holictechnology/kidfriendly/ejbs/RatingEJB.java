package com.holictechnology.kidfriendly.ejbs;


import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
    private static final long QUANTITY_OF_MONTHS = 1;

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
        Boolean stDelete = Boolean.FALSE;
        TypedQuery<RatingDto> typedQuery = entityManager.createQuery(createHql(null, stActive, stDelete, Boolean.TRUE).toString(), RatingDto.class);
        setParametersHql(typedQuery, null, stActive, stDelete);

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
        Boolean stDelete = Boolean.FALSE;
        TypedQuery<Number> typedQueryCount = entityManager.createQuery(createHqlCount(createHql(idCompany, stActive, stDelete, Boolean.FALSE)).toString(),
                Number.class);
        setParametersHql(typedQueryCount, idCompany, stActive, stDelete);
        paginatorDto.setSize(typedQueryCount.getSingleResult().longValue());
        List<RatingDto> ratings = new LinkedList<RatingDto>();

        if (paginatorDto.getSize() > BigInteger.ZERO.longValue()) {
            TypedQuery<RatingDto> typedQuery = entityManager.createQuery(createHql(idCompany, stActive, stDelete, Boolean.TRUE).toString(), RatingDto.class);
            setParametersHql(typedQuery, idCompany, stActive, stDelete);
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
        rating = merge(rating);
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
        sql.append("FROM RATING AS rating ");
        sql.append("WHERE rating.ST_ACTIVE = :stActive AND rating.ST_DELETE = :stDelete AND rating.ID_COMPANY = :idCompany ");
        sql.append("GROUP BY rating.ID_COMPANY");
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("stActive", Boolean.TRUE);
        query.setParameter("stDelete", Boolean.FALSE);
        query.setParameter("idCompany", company.getIdCompany());

        try {
            Number numRate = (Number) query.getSingleResult();

            if (numRate != null) {
                company.setNumRate(numRate.shortValue());
                merge(company);
            }
        } catch (NoResultException exception) {}
    }

    /**
     * @param idCompany
     * @param stActive
     * @param stDelete
     * @param isOrderBy
     * @return
     */
    private StringBuffer createHql(Long idCompany, Boolean stActive, Boolean stDelete, boolean isOrderBy) {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT new com.holictechnology.kidfriendly.domain.dtos.RatingDto(rating.idRating, rating.dtRating, rating.desRating, rating.desAnswer, "
                + "statusKidFriendly.idStatusKidFriendly, company.idCompany, company.desName, user.idUser, user.dsName, user.mgUser) ");
        hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.Rating AS rating ");
        hql.append("INNER JOIN rating.statusKidFriendly AS statusKidFriendly ");
        hql.append("INNER JOIN rating.company AS company ");
        hql.append("INNER JOIN rating.user AS user ");
        hql.append("WHERE 1 = 1 ");
        hql.append(((idCompany != null)) ? "AND company.idCompany = :idCompany " : " ");
        hql.append(((stActive != null)) ? "AND rating.stActive = :stActive " : " ");
        hql.append(((stDelete != null)) ? "AND rating.stDelete = :stDelete " : " ");
        hql.append((isOrderBy) ? "ORDER BY rating.dtRating DESC " : "");

        return hql;
    }

    /**
     * @param query
     * @param idCompany
     * @param stActive
     * @param stDelete
     */
    private void setParametersHql(Query query, Long idCompany, Boolean stActive, Boolean stDelete) {
        if (idCompany != null) {
            query.setParameter("idCompany", idCompany);
        }

        if (stActive != null) {
            query.setParameter("stActive", stActive);
        }

        if (stDelete != null) {
            query.setParameter("stDelete", stDelete);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal#delete(java.
     * lang.Long)
     */
    @Override
    public void delete(Long primaryKey) throws KidFriendlyException {
        Rating rating = find(Rating.class, primaryKey);

        if (rating == null) {
            throw new KidFriendlyException(Status.NOT_FOUND, KidFriendlyMessages.ERROR_NOT_FOUND_RATING);
        }

        rating.setStDelete(Boolean.TRUE);
        merge(rating);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal#include(com.
     * holictechnology.kidfriendly.domain.entitys.Rating)
     */
    @Override
    public void include(Rating rating) throws KidFriendlyException {
        rating.setDtRating(new Date());
        rating.setStActive(Boolean.FALSE);
        rating.setStDelete(Boolean.FALSE);
        persist(rating);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal#hasPermission
     * (java.lang.Long, java.lang.Long)
     */
    @Override
    @Transactional(value = TxType.SUPPORTS)
    public boolean hasPermission(Long idCompany, Long idUser) throws KidFriendlyException {
        boolean hasPermission = Boolean.FALSE;
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT TIMESTAMPDIFF(MONTH, MAX(rating.DT_RATING), CURRENT_TIMESTAMP()) as quantityOfMonths ");
        sql.append("FROM RATING AS rating ");
        sql.append("WHERE rating.ID_COMPANY = :idCompany AND rating.ID_USER = :idUser ");
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("idCompany", idCompany);
        query.setParameter("idUser", idUser);

        try {
            Number quantityOfMonths = (Number) query.getSingleResult();
            hasPermission = (quantityOfMonths == null || quantityOfMonths.longValue() >= QUANTITY_OF_MONTHS);
        } catch (NoResultException e) {}

        return hasPermission;
    }
}
