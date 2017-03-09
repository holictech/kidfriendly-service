package com.holictechnology.kidfriendly.ejbs;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Hibernate;

import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;
import com.holictechnology.kidfriendly.library.utilites.ArrayUtilites;
import com.holictechnology.kidfriendly.library.utilites.ReflectionUtilites;


@Transactional
@TransactionManagement
public abstract class AbstractEJB implements Serializable {

    private static final long serialVersionUID = -7491514655187084894L;

    @PersistenceContext(unitName = "kidfriendlyUI")
    protected EntityManager entityManager;

    @Resource
    protected SessionContext sessionContext;

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
     * @param entity
     * @param lazyAttributes
     * @throws Exception
     */
    @Transactional(value = TxType.SUPPORTS)
    protected <T> void lazyInitialization(final T entity, final String ... lazyAttributes) throws KidFriendlyException {
        String _lazyAttributes[] = null;
        String lazyAttribute = null;
        Object _object = null;

        try {
            for (String strLazyAttribute : lazyAttributes) {
                _lazyAttributes = strLazyAttribute.split("\\.");
                lazyAttribute = _lazyAttributes[BigInteger.ZERO.intValue()];
                _lazyAttributes = ArrayUtilites.removeItem(_lazyAttributes, BigInteger.ZERO.intValue());
                _object = ReflectionUtilites.invoke(entity, ReflectionUtilites.createMethodGet(lazyAttribute));
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
        } catch (Exception exception) {
            throw new KidFriendlyException(exception);
        }
    }

    /**
     * @param entity
     */
    @Transactional(value = TxType.SUPPORTS)
    protected <T> void lazyInitialization(T entity) throws KidFriendlyException {
        if (entity != null && !Hibernate.isInitialized(entity)) {
            Hibernate.initialize(entity);
        }
    }

    /**
     * @param entityClass
     * @param primaryKey
     * @param lazyAttribute
     * @return
     * @throws Exception
     */
    @Transactional(value = TxType.SUPPORTS)
    protected <T> T find(final Class<T> entityClass, final Serializable primaryKey, final String ... lazyAttributes)
            throws KidFriendlyException {
        T entity = entityManager.find(entityClass, primaryKey);
        lazyInitialization(entity, lazyAttributes);

        return entity;
    }

    /**
     * @param entity
     */
    protected <T> void persist(T entity) throws KidFriendlyException {
        entityManager.persist(entity);
    }

    /**
     * @param entity
     * @return
     */
    protected <T> T merge(T entity) throws KidFriendlyException {
        return entityManager.merge(entity);
    }

    /**
     * @param entityClass
     * @param primaryKey
     */
    protected <T> void remove(Class<T> entityClass, Serializable primaryKey) throws KidFriendlyException {
        entityManager.remove(find(entityClass, primaryKey));
    }

    /**
     * @param argument
     * @return
     * @throws KidFriendlyException
     */
    protected void illegalArgument(Object ... argument) throws KidFriendlyException {
        for (Object object : argument) {
            if (object == null) {
                throw new KidFriendlyException(KidFriendlyMessages.ERROR_ILLEGALARGUMENT);
            }
        }
    }
}
