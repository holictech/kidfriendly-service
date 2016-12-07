package com.holictechnology.kidfriendly.ejbs;


import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.dtos.RatingDto;
import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;
import com.holictechnology.kidfriendly.domain.dtos.result.ResultDto;
import com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Stateless
public class RatingEJB extends AbstractEJB implements RatingLocal {

    private static final long serialVersionUID = 5701134070335928714L;

    @Override
    @Transactional(value = TxType.SUPPORTS)
    public Collection<RatingDto> listPending() throws KidFriendlyException {
        Boolean stActive = Boolean.FALSE;
        TypedQuery<RatingDto> typedQuery = entityManager.createQuery(createHql(null, stActive, Boolean.TRUE).toString(), RatingDto.class);
        setParametersHql(typedQuery, null, stActive);

        return typedQuery.getResultList();
    }

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

    /**
     * @param idCompany
     * @param isOrderBy
     * @return
     */
    private StringBuffer createHql(Long idCompany, Boolean stActive, boolean isOrderBy) {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT new com.holictechnology.kidfriendly.domain.dtos.RatingDto(rating.idRating, rating.dtRating, rating.desRating, rating.desAnswer, "
                + "statusKidFriendly.idStatusKidFriendly, company.idCompany, company.desName, user.idUser, user.desName, user.imgUser) ");
        hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.Rating rating ");
        hql.append("    INNER JOIN rating.statusKidFriendly statusKidFriendly ");
        hql.append("    INNER JOIN rating.company company ");
        hql.append("    INNER JOIN rating.user user ");
        hql.append("WHERE 1 = 1 ");
        hql.append(((stActive != null)) ? "    AND rating.stActive = :stActive" : " ");
        hql.append(((idCompany != null)) ? "    AND company.idCompany = :idCompany" : " ");
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
}
