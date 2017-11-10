package com.holictechnology.kidfriendly.ejb;


import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.entity.Characteristic;
import com.holictechnology.kidfriendly.ejb.interfaces.CategoryLocal;
import com.holictechnology.kidfriendly.ejb.interfaces.CharacteristicLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Stateless
public class CharacteristicEJB extends AbstractEJB implements CharacteristicLocal {

    private static final long serialVersionUID = -9100126414841729617L;

    @EJB
    private CategoryLocal categoryLocal;

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.CharacteristicLocal#
     * listByCategory(java.lang.Integer)
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Collection<Characteristic> listByCategory(Integer idCategory) throws KidFriendlyException {
        illegalArgument(idCategory);
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT characteristic ");
        hql.append("FROM CategoryCharacteristic AS categoryCharacteristic ");
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
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Collection<Characteristic> listByCompanyCategory(Long idCompany, Integer idCategory) throws KidFriendlyException {
        illegalArgument(idCompany);
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT DISTINCT characteristic ");
        hql.append("FROM CompanyCategoryCharacteristic AS companyCategoryCharacteristic ");
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

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejb.interfaces.CharacteristicLocal#
     * listAll()
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Collection<Characteristic> listAll() throws KidFriendlyException {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT characteristic FROM Characteristic AS characteristic ORDER BY characteristic.desCharacteristic");
        TypedQuery<Characteristic> typedQuery = entityManager.createQuery(hql.toString(), Characteristic.class);

        return typedQuery.getResultList();
    }
}
