package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.City;
import com.holictechnology.kidfriendly.domain.entitys.Country;
import com.holictechnology.kidfriendly.domain.entitys.State;


@Local
public interface LocalityLocal {

    /**
     * Method to list all countries
     * 
     * @return
     * @throws Exception
     */
    List<Country> listAllCountries();

    /**
     * Method to list states by country.
     * 
     * @param idCountry
     *            - key {@link Country}
     * @return
     * @throws Exception
     */
    List<State> listStateByCountry(Integer idCountry);

    /**
     * 
     * Method to list cities by state.
     * 
     * @param idState
     *            - key {@link Country}
     * @return
     * @throws Exception
     */
    List<City> listCityByState(Integer idState);
}
