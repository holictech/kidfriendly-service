package com.holictechnology.kidfriendly.ejbs;


import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.entitys.Image;
import com.holictechnology.kidfriendly.ejbs.interfaces.ImageLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Stateless
public class ImageEJB extends AbstractEJB implements ImageLocal {

    private static final long serialVersionUID = -2816749967447004036L;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.ImageLocal#listByCompany(
     * java.lang.Long)
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Collection<Image> listByCompany(Long idCompany) throws KidFriendlyException {
        illegalArgument(idCompany);
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT image ");
        hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.Image AS image ");
        hql.append("INNER JOIN image.company AS company ");
        hql.append("WHERE company.idCompany = :idCompany");
        TypedQuery<Image> typedQuery = entityManager.createQuery(hql.toString(), Image.class);
        typedQuery.setParameter("idCompany", idCompany);

        return typedQuery.getResultList();
    }
}
