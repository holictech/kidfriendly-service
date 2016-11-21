package com.holictechnology.kidfriendly.ejbs;


import java.io.Serializable;
import java.math.BigInteger;

import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;


@Transactional
@TransactionManagement
public abstract class AbstractEJB implements Serializable {

    private static final long serialVersionUID = -7491514655187084894L;

    @PersistenceContext(unitName = "kidfriendlyUI")
    protected EntityManager entityManager;

    /**
     * @param sql
     * @return
     */
    protected StringBuffer createSqlCount(final StringBuffer sql) {
        StringBuffer sqlCount = new StringBuffer();
        sqlCount.append("SELECT COUNT(*) FROM (");
        sqlCount.append(sql);
        sqlCount.append(") TABLE_COUNT");

        return sqlCount;
    }

    /**
     * @param query
     * @param paginatorDto
     */
    protected void setParametersPaginator(Query query, final PaginatorDto paginatorDto) {
        query.setFirstResult(Long.valueOf((paginatorDto.getCurrentPage() - BigInteger.ONE.intValue()) * paginatorDto.getPageSize()).intValue());
        query.setMaxResults(paginatorDto.getPageSize().intValue());
    }
}
