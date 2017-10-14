package com.holictechnology.kidfriendly.ejb;


import java.util.List;

import javax.ejb.Stateless;

import com.holictechnology.kidfriendly.domain.entity.FoodType;
import com.holictechnology.kidfriendly.ejb.interfaces.FoodTypeLocal;


/**
 * Session Bean implementation class FoodTypeEJB
 */
@Stateless
public class FoodTypeEJB extends AbstractEJB implements FoodTypeLocal {

    private static final long serialVersionUID = 2598476768630245693L;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejb.interfaces.TypeFoodLocal#listAll()
     */
    @Override
    public List<FoodType> listAll() {
        return entityManager.createQuery("SELECT foodType FROM FoodType AS foodType ORDER BY foodType.dsFoodType ASC", FoodType.class).getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejb.interfaces.TypeFoodLocal#
     * listByCompany(java.lang.Long)
     */
    @Override
    public List<FoodType> listByCompany(Long idCompany) {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT foodType ");
        hql.append("FROM CompanyFoodType AS companyFoodType ");
        hql.append("INNER JOIN companyFoodType.companyFoodTypePK.company AS company ");
        hql.append("INNER JOIN companyFoodType.companyFoodTypePK.foodType AS foodType ");
        hql.append("WHERE company.idCompany = :idCompany ");
        hql.append("ORDER BY foodType.dsFoodType ASC ");

        return entityManager.createQuery(hql.toString(), FoodType.class).setParameter("idCompany", idCompany).getResultList();
    }
}
