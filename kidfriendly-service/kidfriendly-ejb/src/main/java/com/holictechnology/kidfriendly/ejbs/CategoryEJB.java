package com.holictechnology.kidfriendly.ejbs;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.entitys.Category;
import com.holictechnology.kidfriendly.ejbs.interfaces.CategoryLocal;


@Stateless
public class CategoryEJB extends AbstractEJB implements CategoryLocal {

    private static final long serialVersionUID = -2295749589618359917L;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.CategoryLocal#listAll()
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<Category> listAll() {
        StringBuffer hql = new StringBuffer();
        hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.Category category ORDER BY category.desCategory ASC");
        TypedQuery<Category> typedQuery = entityManager.createQuery(hql.toString(), Category.class);

        return typedQuery.getResultList();
    }
}
