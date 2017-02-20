package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.Collection;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.City;
import com.holictechnology.kidfriendly.domain.entitys.Country;
import com.holictechnology.kidfriendly.domain.entitys.State;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface LocalityLocal {

    /**
     * Method to list all countries
     * 
     * @return
     * @throws KidFriendlyException
     */
    Collection<Country> listAllCountries() throws KidFriendlyException;

    /**
     * Method to list states by country.
     * 
     * @param idCountry
     *            - key {@link Country}
     * @return
     * @throws KidFriendlyException
     */
    Collection<State> listStateByCountry(Integer idCountry) throws KidFriendlyException;

    /**
     * Method to list states with cities by country.
     * 
     * @param idCountry
     *            - key {@link Country}
     * @return
     * @throws KidFriendlyException
     */
    Collection<State> listStateWithCityByCountry(Integer idCountry) throws KidFriendlyException;

    /**
     * 
     * Method to list cities by state.
     * 
     * @param idState
     *            - key {@link Country}
     * @return
     * @throws KidFriendlyException
     */
    Collection<City> listCityByState(Integer idState) throws KidFriendlyException;
}
