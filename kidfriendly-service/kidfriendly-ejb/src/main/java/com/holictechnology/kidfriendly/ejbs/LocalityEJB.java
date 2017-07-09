package com.holictechnology.kidfriendly.ejbs;


import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.holictechnology.kidfriendly.domain.entitys.City;
import com.holictechnology.kidfriendly.domain.entitys.Country;
import com.holictechnology.kidfriendly.domain.entitys.State;
import com.holictechnology.kidfriendly.ejbs.interfaces.LocalityLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
public class LocalityEJB extends AbstractEJB implements LocalityLocal {

    private static final long serialVersionUID = -1040710575698707951L;

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.LocalityLocal#
     * listAllCountries()
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Collection<Country> listAllCountries() throws KidFriendlyException {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT country FROM com.holictechnology.kidfriendly.domain.entitys.Country AS country ORDER BY country.desCountry ASC");
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
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Collection<State> listStateByCountry(Integer idCountry) throws KidFriendlyException {
        illegalArgument(idCountry);
        StringBuffer hql = new StringBuffer();
        hql.append(
                "SELECT state FROM com.holictechnology.kidfriendly.domain.entitys.State AS state WHERE state.country.idCountry = :idCountry ORDER BY state.desState ASC");
        TypedQuery<State> typedQuery = entityManager.createQuery(hql.toString(), State.class);
        typedQuery.setParameter("idCountry", idCountry);

        return typedQuery.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.LocalityLocal#
     * listStateWithCityByCountry(java.lang.Integer)
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Collection<State> listStateWithCityByCountry(Integer idCountry) throws KidFriendlyException {
        illegalArgument(idCountry);
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT state ");
        hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.City AS city INNER JOIN city.state AS state INNER JOIN state.country AS country ");
        hql.append("WHERE country.idCountry = :idCountry ");
        hql.append("GROUP BY state ");
        hql.append("ORDER BY state.desState ASC ");
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
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Collection<City> listCityByState(Integer idState) throws KidFriendlyException {
        illegalArgument(idState);
        StringBuffer hql = new StringBuffer();
        hql.append(
                "SELECT city FROM com.holictechnology.kidfriendly.domain.entitys.City AS city WHERE city.state.idState = :idState ORDER BY city.desCity ASC");
        TypedQuery<City> typedQuery = entityManager.createQuery(hql.toString(), City.class);
        typedQuery.setParameter("idState", idState);

        return typedQuery.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.LocalityLocal#
     * formattedAddress(java.lang.Double, java.lang.Double)
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public String formattedAddress(Double longitude, Double latitude) throws KidFriendlyException {
        illegalArgument(longitude, latitude);
        String address = null;

        try {
            GeoApiContext geoApiContext = new GeoApiContext().setApiKey("AIzaSyCxciD9NWnidLOnaWAD5CB1Xjklirkftbg");
            GeocodingResult [] results = GeocodingApi.reverseGeocode(geoApiContext, new LatLng(latitude, longitude)).language("pt-BR").await();

            if (results != null && results.length > BigInteger.ZERO.intValue()) {
                address = results[BigInteger.ZERO.intValue()].formattedAddress;
            }
        } catch (ApiException | InterruptedException | IOException exception) {
            getLogger(getClass()).error(exception.getMessage(), exception);
            throw new KidFriendlyException(KidFriendlyMessages.ERROR_GET_ADDRESS, exception);
        }

        return address;
    }
}
