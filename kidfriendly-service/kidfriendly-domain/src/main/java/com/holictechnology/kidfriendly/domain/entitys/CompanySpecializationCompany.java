package com.holictechnology.kidfriendly.domain.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COMPANY_SPECIALIZATION_COMPANY database table.
 * 
 */
@Entity
@Table(name="COMPANY_SPECIALIZATION_COMPANY")
@NamedQuery(name="CompanySpecializationCompany.findAll", query="SELECT c FROM CompanySpecializationCompany c")
public class CompanySpecializationCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMPANY_SPECIALIZATION_COMPANY")
	private Long idCompanySpecializationCompany;

	@Column(name="ID_COMPANY")
	private Long idCompany;

	//bi-directional many-to-one association to CompanySpecialization
	@ManyToOne
	@JoinColumn(name="ID_COMPANY_SPECIALIZATION")
	private CompanySpecialization companySpecialization;

	public CompanySpecializationCompany() {
	}

	public Long getIdCompanySpecializationCompany() {
		return idCompanySpecializationCompany;
	}

	public void setIdCompanySpecializationCompany(Long idCompanySpecializationCompany) {
		this.idCompanySpecializationCompany = idCompanySpecializationCompany;
	}

	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	public CompanySpecialization getCompanySpecialization() {
		return companySpecialization;
	}

	public void setCompanySpecialization(CompanySpecialization companySpecialization) {
		this.companySpecialization = companySpecialization;
	}

	

}