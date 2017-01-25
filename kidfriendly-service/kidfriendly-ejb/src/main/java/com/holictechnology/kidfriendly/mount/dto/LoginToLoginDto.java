package com.holictechnology.kidfriendly.mount.dto;

import java.util.ArrayList;
import java.util.List;

import com.holictechnology.kidfriendly.domain.dtos.LoginDto;
import com.holictechnology.kidfriendly.domain.entitys.Login;

/**
 * Classa mount data login for logindto
 * @author paulo
 *
 */
public class LoginToLoginDto {

	/**
	 * GetInstance for class logintologindto
	 * @return
	 */
	public static LoginToLoginDto getInstance(){
		return new LoginToLoginDto();
	}
	
	/**
	 * Method in login for loginDto
	 * @param logins
	 * @return
	 */
	public List<LoginDto> loginToLoginDto(List<Login> logins){
		LoginDto loginDto = null;
		List<LoginDto> loginDtos = new ArrayList<LoginDto>();
		
		if(logins != null){
			if(!logins.isEmpty()){
				for(Login login : logins){
					loginDto = new LoginDto();
					loginDto.setIdLogin(login.getIdLogin());
					loginDto.setDesPassword(login.getDesPassword());
					loginDto.setStActive(login.getStActive());
					
					loginDtos.add(loginDto);
				}
			}
		}
		
		return loginDtos;
	}
	
}