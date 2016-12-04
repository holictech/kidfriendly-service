package com.holictechnology.kidfriendly.ejbs;


import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.dtos.CompanyDto;
import com.holictechnology.kidfriendly.domain.dtos.filters.CompanyFilterDto;
import com.holictechnology.kidfriendly.domain.dtos.result.ResultDto;
import com.holictechnology.kidfriendly.domain.entitys.Company;
import com.holictechnology.kidfriendly.domain.enums.StatusKidFriendlyEnum;
import com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal;


@Stateless
public class CompanyEJB extends AbstractEJB implements CompanyLocal {

    private static final long serialVersionUID = 1389485495399887684L;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal#find(java.
     * lang.Long)
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Company find(Long primaryKey) {
        return entityManager.find(Company.class, primaryKey);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal#
     * listLatestResearch(java.lang.Integer, java.lang.Long)
     */
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<CompanyDto> listLatestResearch(Integer limit, Long idUser) {
        return Collections.emptyList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal#
     * listSuggestions(java.lang.Integer)
     */
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<CompanyDto> listSuggestions(Integer limit) {
        StringBuffer sql = new StringBuffer();
        sql.append(
                "SELECT company.ID_COMPANY, company.DES_NAME, company.IMG_LOGO, company.NUM_RATE, company.ST_HIGHLIGHT, city.DES_CITY, state.DES_SIGLA ");
        sql.append("FROM COMPANY company ");
        sql.append("    INNER JOIN ( ");
        sql.append(
                "        SELECT company.ID_COMPANY FROM company WHERE company.ST_ACTIVE = 1 AND company.ST_HIGHLIGHT = 1 ORDER BY RAND() LIMIT :limit ");
        sql.append("    ) _company ON (_company.ID_COMPANY = company.ID_COMPANY) ");
        sql.append("    INNER JOIN address ON (address.ID_ADDRESS = company.ID_ADDRESS) ");
        sql.append("    INNER JOIN city ON (city.ID_CITY = address.ID_CITY) ");
        sql.append("    INNER JOIN state ON (state.ID_STATE = city.ID_STATE) ");
        sql.append("UNION ALL ");
        sql.append(
                "SELECT company.ID_COMPANY, company.DES_NAME, company.IMG_LOGO, company.NUM_RATE, company.ST_HIGHLIGHT, city.DES_CITY, state.DES_SIGLA ");
        sql.append("FROM COMPANY company ");
        sql.append("    INNER JOIN ( ");
        sql.append(
                "        SELECT company.ID_COMPANY FROM company WHERE company.ST_ACTIVE = 1 AND company.ST_HIGHLIGHT = 0 ORDER BY RAND() LIMIT :limit ");
        sql.append("    ) _company ON (_company.ID_COMPANY = company.ID_COMPANY) ");
        sql.append("    INNER JOIN address ON (address.ID_ADDRESS = company.ID_ADDRESS) ");
        sql.append("    INNER JOIN city ON (city.ID_CITY = address.ID_CITY) ");
        sql.append("    INNER JOIN state ON (state.ID_STATE = city.ID_STATE) ");
        sql.append("ORDER BY ST_HIGHLIGHT DESC, DES_NAME LIMIT :limit ");
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("limit", limit);

        return createResult(query.getResultList());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal#listNextToMe
     * (java.lang.Integer, java.lang.Double, java.lang.Double)
     */
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<CompanyDto> listNextToMe(Integer limit, Double longitude, Double latitude) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT company.ID_COMPANY, company.DES_NAME, company.IMG_LOGO, company.NUM_RATE, company.ST_HIGHLIGHT, city.DES_CITY, state.DES_SIGLA ");
        sql.append("FROM COMPANY company ");
        sql.append("    INNER JOIN ADDRESS address ON (address.ID_ADDRESS = company.ID_ADDRESS) ");
        sql.append("    INNER JOIN CITY city ON (city.ID_CITY = address.ID_CITY) ");
        sql.append("    INNER JOIN STATE state ON (state.ID_STATE = city.ID_STATE) ");
        sql.append(
                "WHERE company.ST_ACTIVE = 1 AND ST_Contains(ST_MakeEnvelope(Point((:longitude+(10/100)), (:latitude+(10/100))), Point((:longitude-(10/100)), (:latitude-(10/100)))), Point(address.NUM_LONGITUDE, address.NUM_LATITUDE)) ");
        sql.append("ORDER BY company.DES_NAME ");
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("longitude", longitude);
        query.setParameter("latitude", latitude);
        query.setFirstResult(BigInteger.ZERO.intValue());
        query.setMaxResults(limit);

        return createResult(query.getResultList());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal#search(com.
     * holictechnology.kidfriendly.domain.dtos.filters.CompanyFilterDto)
     */
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(value = TxType.NOT_SUPPORTED)
    public ResultDto<CompanyDto> search(CompanyFilterDto companyFilterDto) {
        Query query = entityManager.createNativeQuery(createSqlCount(createSqlSearch(companyFilterDto, Boolean.FALSE)).toString());
        setParametersSqlSearch(query, companyFilterDto);
        companyFilterDto.getPaginatorDto().setSize(((Number) query.getSingleResult()).longValue());
        List<CompanyDto> companys = new LinkedList<CompanyDto>();

        if (companyFilterDto.getPaginatorDto().getSize() > BigInteger.ZERO.intValue()) {
            query = entityManager.createNativeQuery(createSqlSearch(companyFilterDto, Boolean.TRUE).toString());
            setParametersSqlSearch(query, companyFilterDto);
            setParametersPaginator(query, companyFilterDto.getPaginatorDto());
            companys.addAll(createResult(query.getResultList()));
        }

        ResultDto<CompanyDto> resultDto = new ResultDto<CompanyDto>();
        resultDto.setPaginatorDto(companyFilterDto.getPaginatorDto());
        resultDto.setResults(companys);

        return resultDto;
    }

    /**
     * @param companyFilterDto
     * @return
     */
    private StringBuffer createSqlSearch(CompanyFilterDto companyFilterDto, boolean isOrderBy) {
        StringBuffer sql = new StringBuffer();
        sql.append(
                "SELECT company.ID_COMPANY, company.DES_NAME, company.IMG_LOGO, company.NUM_RATE, company.ST_HIGHLIGHT, city.DES_CITY, state.DES_SIGLA ");
        sql.append("FROM COMPANY company ");
        sql.append(createSqlSearch(companyFilterDto.getCharacteristics()));
        sql.append("    INNER JOIN ADDRESS address ON (address.ID_ADDRESS = company.ID_ADDRESS) ");
        sql.append("    INNER JOIN CITY city ON (city.ID_CITY = address.ID_CITY) ");
        sql.append("    INNER JOIN STATE state ON (state.ID_STATE = city.ID_STATE) ");
        sql.append("WHERE company.ST_ACTIVE = 1 ");
        sql.append(((companyFilterDto.isSuperKidFriendly()) ? "AND company.NUM_RATE = :superKidFriendly " : " "));
        sql.append(((companyFilterDto.getLongitude() != null && companyFilterDto.getLatitude() != null)
                ? "AND ST_Contains(ST_MakeEnvelope(Point((:longitude+(10/100)), (:latitude+(10/100))), Point((:longitude-(10/100)), (:latitude-(10/100)))), Point(address.NUM_LONGITUDE, address.NUM_LATITUDE)) "
                : ""));
        sql.append("GROUP BY company.ID_COMPANY, company.DES_NAME, company.IMG_LOGO, company.NUM_RATE, company.ST_HIGHLIGHT, city.DES_CITY, state.DES_SIGLA ");
        sql.append(((isOrderBy) ? "ORDER BY company.DES_NAME " : " "));

        return sql;
    }

    /**
     * @param idsCharacteristic
     * @return
     */
    private StringBuffer createSqlSearch(final List<Long> characteristics) {
        StringBuffer sql = new StringBuffer();

        if (characteristics != null && !characteristics.isEmpty()) {
            int size = characteristics.size();

            for (int index = 0; index < size; index++) {
                sql.append("    INNER JOIN COMPANY_CATEGORY_CHARACTERISTIC COMPANY_CATEGORY_CHARACTERISTIC_" + index
                        + " ON (company.ID_COMPANY = COMPANY_CATEGORY_CHARACTERISTIC_" + index + ".ID_COMPANY and COMPANY_CATEGORY_CHARACTERISTIC_" + index
                        + ".ID_CATEGORY = :idCategory and COMPANY_CATEGORY_CHARACTERISTIC_" + index + ".ID_CHARACTERISTIC = :parameter" + index + ")");
            }
        }

        return sql;
    }

    /**
     * @param query
     * @param companyFilterDto
     */
    private void setParametersSqlSearch(Query query, CompanyFilterDto companyFilterDto) {
        setParametersSqlSearch(query, companyFilterDto.getCharacteristics());
        query.setParameter("idCategory", companyFilterDto.getIdCategory());

        if (companyFilterDto.isSuperKidFriendly()) {
            query.setParameter("superKidFriendly", StatusKidFriendlyEnum.SUPER.getValue());
        }

        if (companyFilterDto.getLongitude() != null && companyFilterDto.getLatitude() != null) {
            query.setParameter("longitude", companyFilterDto.getLongitude());
            query.setParameter("latitude", companyFilterDto.getLatitude());
        }
    }

    private void setParametersSqlSearch(Query query, final List<Long> characteristics) {
        if (characteristics != null && !characteristics.isEmpty()) {
            int index = 0;

            for (Long characteristic : characteristics) {
                query.setParameter("parameter" + index++, characteristic);
            }
        }
    }

    /**
     * @param listObject
     * @return
     */
    private List<CompanyDto> createResult(List<Object []> listObject) {
        List<CompanyDto> listCompanyDto = new LinkedList<CompanyDto>();

        if (listObject != null) {
            CompanyDto companyDto;

            for (Object [] object : listObject) {
                companyDto = new CompanyDto();
                companyDto.setIdCompany((object[0] != null) ? Long.valueOf(object[0].toString()) : null);
                companyDto.setDesName((object[1] != null) ? object[1].toString() : null);
                companyDto.setImgLogo((object[2] != null) ? (byte []) object[2] : null);
                companyDto.setNumRate((object[3] != null) ? Short.valueOf(object[3].toString()) : 4);
                companyDto.setDesCity((object[5] != null) ? object[5].toString() : null);
                companyDto.setDesState((object[6] != null) ? object[6].toString() : null);
                listCompanyDto.add(companyDto);
            }
        }

        return listCompanyDto;
    }
}
