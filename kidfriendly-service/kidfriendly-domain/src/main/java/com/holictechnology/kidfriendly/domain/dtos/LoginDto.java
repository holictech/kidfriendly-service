package com.holictechnology.kidfriendly.domain.dtos;

/**
 * Espelho para retorno da entidade login
 * @author paulo
 *
 */
public class LoginDto {

    private String idLogin;

    private String desPassword;

    private Boolean stActive;

	public String getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(String idLogin) {
		this.idLogin = idLogin;
	}

	public String getDesPassword() {
		return desPassword;
	}

	public void setDesPassword(String desPassword) {
		this.desPassword = desPassword;
	}

	public Boolean getStActive() {
		return stActive;
	}

	public void setStActive(Boolean stActive) {
		this.stActive = stActive;
	}
	
}