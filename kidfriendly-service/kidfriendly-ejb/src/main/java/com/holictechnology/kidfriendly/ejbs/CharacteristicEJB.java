package com.holictechnology.kidfriendly.ejbs;


import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.entitys.Characteristic;
import com.holictechnology.kidfriendly.ejbs.interfaces.CharacteristicLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


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
    @Transactional(value = TxType.SUPPORTS)
    public Collection<Characteristic> listByCategory(Integer idCategory) throws KidFriendlyException {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT characteristic ");
        hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.CategoryCharacteristic AS categoryCharacteristic ");
        hql.append("INNER JOIN categoryCharacteristic.categoryCharacteristicPK.characteristic AS characteristic ");
        hql.append("INNER JOIN categoryCharacteristic.categoryCharacteristicPK.category AS category ");
        hql.append("WHERE category.idCategory = :idCategory ");
        hql.append("ORDER BY characteristic.desCharacteristic ASC");
        TypedQuery<Characteristic> typedQuery = entityManager.createQuery(hql.toString(), Characteristic.class);
        typedQuery.setParameter("idCategory", idCategory);

        return typedQuery.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.CharacteristicLocal#
     * listByCompanyCategory(java.lang.Long, java.lang.Integer)
     */
    @Override
    @Transactional(value = TxType.SUPPORTS)
    public Collection<Characteristic> listByCompanyCategory(Long idCompany, Integer idCategory) throws KidFriendlyException {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT DISTINCT characteristic ");
        hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.CompanyCategoryCharacteristic AS companyCategoryCharacteristic ");
        hql.append("INNER JOIN companyCategoryCharacteristic.companyCategoryCharacteristicPK.categoryCharacteristic AS categoryCharacteristic ");
        hql.append("INNER JOIN categoryCharacteristic.categoryCharacteristicPK.characteristic AS characteristic ");
        hql.append((idCategory == null) ? "" : "INNER JOIN categoryCharacteristic.categoryCharacteristicPK.category AS category ");
        hql.append("INNER JOIN companyCategoryCharacteristic.companyCategoryCharacteristicPK.company AS company ");
        hql.append("WHERE company.idCompany = :idCompany ");
        hql.append((idCategory == null) ? "" : "AND category.idCategory = :idCategory ");
        hql.append("ORDER BY characteristic.desCharacteristic ASC");

        TypedQuery<Characteristic> typedQuery = entityManager.createQuery(hql.toString(), Characteristic.class);
        typedQuery.setParameter("idCompany", idCompany);

        if (idCategory != null) {
            typedQuery.setParameter("idCategory", idCategory);
        }

        return typedQuery.getResultList();
    }
}
