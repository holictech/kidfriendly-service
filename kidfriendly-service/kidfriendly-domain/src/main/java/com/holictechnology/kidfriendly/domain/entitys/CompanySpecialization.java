package com.holictechnology.kidfriendly.domain.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the COMPANY_SPECIALIZATION database table.
 * 
 */
@Entity
@Table(name="COMPANY_SPECIALIZATION")
@NamedQuery(name="CompanySpecialization.findAll", query="SELECT c FROM CompanySpecialization c")
public class CompanySpecialization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMPANY_SPECIALIZATION")
	private String idCompanySpecialization;

	@Column(name="DS_COMPANY_SPECIALIZATION")
	private String dsCompanySpecialization;

	public CompanySpecialization() {
	}

	public String getIdCompanySpecialization() {
		return this.idCompanySpecialization;
	}

	public void setIdCompanySpecialization(String idCompanySpecialization) {
		this.idCompanySpecialization = idCompanySpecialization;
	}

	public String getDsCompanySpecialization() {
		return this.dsCompanySpecialization;
	}

	public void setDsCompanySpecialization(String dsCompanySpecialization) {
		this.dsCompanySpecialization = dsCompanySpecialization;
	}

}