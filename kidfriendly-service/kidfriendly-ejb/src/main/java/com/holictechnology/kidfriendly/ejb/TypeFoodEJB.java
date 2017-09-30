package com.holictechnology.kidfriendly.ejb;


import java.util.List;

import javax.ejb.Stateless;

import com.holictechnology.kidfriendly.domain.entity.FoodType;
import com.holictechnology.kidfriendly.ejb.interfaces.TypeFoodLocal;


/**
 * Session Bean implementation class TypeFoodEJB
 */
@Stateless
public class TypeFoodEJB extends AbstractEJB implements TypeFoodLocal {

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
}
