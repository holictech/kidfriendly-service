package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.Collection;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entity.City;
import com.holictechnology.kidfriendly.domain.entity.Country;
import com.holictechnology.kidfriendly.domain.entity.State;
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

    /**
     * Method for obtaining the formatted address.
     * 
     * @param longitude
     * @param latitude
     * @return
     * @throws KidFriendlyException
     */
    String formattedAddress(Double longitude, Double latitude) throws KidFriendlyException;
}
