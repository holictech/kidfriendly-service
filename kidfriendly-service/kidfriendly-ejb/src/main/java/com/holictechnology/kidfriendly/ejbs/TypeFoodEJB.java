package com.holictechnology.kidfriendly.ejbs;

import com.holictechnology.kidfriendly.domain.entitys.FoodType;
import com.holictechnology.kidfriendly.ejbs.interfaces.TypeFoodLocal;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Session Bean implementation class TypeFoodEJB
 */
@Stateless
public class TypeFoodEJB extends AbstractEJB implements TypeFoodLocal {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2598476768630245693L;

	/**
     * Default constructor. 
     */
    public TypeFoodEJB() {
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodType> foods() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT f FROM FoodType f ORDER BY f.dsFoodType asc ");
		
		Query query = entityManager.createQuery(sql.toString());
		
		return query.getResultList();
	}

}
