package com.holictechnology.kidfriendly.ejbs;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.entitys.City;
import com.holictechnology.kidfriendly.domain.entitys.Country;
import com.holictechnology.kidfriendly.domain.entitys.State;
import com.holictechnology.kidfriendly.ejbs.interfaces.LocalityLocal;


@Stateless
public class LocalityEJB extends AbstractEJB implements LocalityLocal {

    private static final long serialVersionUID = -1040710575698707951L;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.LocalityLocal#listAll()
     */
    @Override
    @Transactional(value = TxType.SUPPORTS)
    public List<Country> listAllCountries() {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT country FROM com.holictechnology.kidfriendly.domain.entitys.Country country ORDER BY country.desCountry ASC");
        TypedQuery<Country> typedQuery = entityManager.createQuery(hql.toString(), Country.class);

        return typedQuery.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.LocalityLocal#
     * listStateByCountry(java.lang.Integer)
     */
    @Override
    @Transactional(value = TxType.SUPPORTS)
    public List<State> listStateByCountry(Integer idCountry) {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT state FROM com.holictechnology.kidfriendly.domain.entitys.State state WHERE state.country.idCountry = :idCountry ORDER BY state.desState ASC");
        TypedQuery<State> typedQuery = entityManager.createQuery(hql.toString(), State.class);
        typedQuery.setParameter("idCountry", idCountry);

        return typedQuery.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.LocalityLocal#
     * listCityByState(java.lang.Integer)
     */
    @Override
    @Transactional(value = TxType.SUPPORTS)
    public List<City> listCityByState(Integer idState) {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT city FROM com.holictechnology.kidfriendly.domain.entitys.City city WHERE city.state.idState = :idState ORDER BY city.desCity ASC");
        TypedQuery<City> typedQuery = entityManager.createQuery(hql.toString(), City.class);
        typedQuery.setParameter("idState", idState);

        return typedQuery.getResultList();
    }
}
