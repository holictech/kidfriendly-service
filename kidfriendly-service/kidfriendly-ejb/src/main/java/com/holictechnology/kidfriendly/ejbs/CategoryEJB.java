package com.holictechnology.kidfriendly.ejbs;


import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.entitys.Category;
import com.holictechnology.kidfriendly.ejbs.interfaces.CategoryLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


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
    @Transactional(value = TxType.SUPPORTS)
    public Collection<Category> listAll() throws KidFriendlyException {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT category FROM com.holictechnology.kidfriendly.domain.entitys.Category AS category ORDER BY category.desCategory ASC");
        TypedQuery<Category> typedQuery = entityManager.createQuery(hql.toString(), Category.class);

        return typedQuery.getResultList();
    }
}
