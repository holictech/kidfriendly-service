package com.holictechnology.kidfriendly.ejbs;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;

import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;

import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;
import com.holictechnology.kidfriendly.library.utilites.ArrayUtilites;
import com.holictechnology.kidfriendly.library.utilites.ReflectionUtilites;


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
     * @param sql
     * @return
     */
    protected StringBuffer createHqlCount(final StringBuffer hql) {
        StringBuffer hqlCount = new StringBuffer();
        hqlCount.append("SELECT COUNT(*) ");
        hqlCount.append(hql.substring(hql.toString().toUpperCase().indexOf("FROM")));

        return hqlCount;
    }

    /**
     * @param query
     * @param paginatorDto
     */
    protected void setParametersPaginator(Query query, final PaginatorDto paginatorDto) {
        query.setFirstResult(Long.valueOf((paginatorDto.getCurrentPage() - BigInteger.ONE.intValue()) * paginatorDto.getPageSize()).intValue());
        query.setMaxResults(paginatorDto.getPageSize().intValue());
    }

    /**
     * @param clazz
     * @param primaryKey
     * @param lazyAttribute
     * @return
     * @throws Exception
     */
    protected <T> T findWithLazyInitialization(final Class<T> clazz, final Serializable primaryKey, final String ... lazyAttributes) throws Exception {
        T object = entityManager.find(clazz, primaryKey);
        lazyInitialization(object, lazyAttributes);

        return object;
    }

    /**
     * @param object
     * @param lazyAttributes
     * @throws Exception
     */
    protected <T> void lazyInitialization(final T object, final String ... lazyAttributes) throws Exception {
        String _lazyAttributes[] = null;
        String lazyAttribute = null;
        Object _object = null;

        for (String strLazyAttribute : lazyAttributes) {
            _lazyAttributes = strLazyAttribute.split("\\.");
            lazyAttribute = _lazyAttributes[BigInteger.ZERO.intValue()];
            _lazyAttributes = ArrayUtilites.removeItem(_lazyAttributes, 0);
            _object = ReflectionUtilites.invoke(object, ReflectionUtilites.createMethodGet(lazyAttribute));
            lazyInitialization(_object);

            if (_object != null && _lazyAttributes != null && _lazyAttributes.length > BigInteger.ZERO.intValue()) {
                if (ReflectionUtilites.isCollection(_object.getClass())) {
                    for (Object item : (Collection<?>) _object) {
                        lazyInitialization(item, String.join(".", _lazyAttributes));
                    }
                } else {
                    lazyInitialization(_object, String.join(".", _lazyAttributes));
                }
            }
        }
    }

    /**
     * @param object
     */
    protected <T> void lazyInitialization(T object) {
        if (object != null && !Hibernate.isInitialized(object)) {
            Hibernate.initialize(object);
        }
    }
}
