package com.holictechnology.kidfriendly.ejb;


import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.entity.Category;
import com.holictechnology.kidfriendly.ejb.interfaces.CategoryLocal;
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
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Collection<Category> listAll() throws KidFriendlyException {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT category FROM Category AS category ORDER BY category.desCategory ASC");
        TypedQuery<Category> typedQuery = entityManager.createQuery(hql.toString(), Category.class);

        return typedQuery.getResultList();
    }
}
