package com.holictechnology.kidfriendly.ejbs;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.entitys.Characteristic;
import com.holictechnology.kidfriendly.ejbs.interfaces.CharacteristicLocal;


@Stateless
public class CharacteristicEJB extends AbstractEJB implements CharacteristicLocal {

    private static final long serialVersionUID = -9100126414841729617L;

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.CharacteristicLocal#
     * listByCategory(java.lang.Integer)
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<Characteristic> listByCategory(Integer idCategory) {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT characteristic ");
        hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.CategoryCharacteristic categoryCharacteristic ");
        hql.append("INNER JOIN categoryCharacteristic.categoryCharacteristicPK.characteristic characteristic ");
        hql.append("INNER JOIN categoryCharacteristic.categoryCharacteristicPK.category category ");
        hql.append("WHERE category.idCategory = :idCategory ");
        hql.append("ORDER BY characteristic.desCharacteristic ASC");
        TypedQuery<Characteristic> typedQuery = entityManager.createQuery(hql.toString(), Characteristic.class);
        typedQuery.setParameter("idCategory", idCategory);

        return typedQuery.getResultList();
    }
}
