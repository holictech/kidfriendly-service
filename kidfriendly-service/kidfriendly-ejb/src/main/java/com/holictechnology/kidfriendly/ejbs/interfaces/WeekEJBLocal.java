package com.holictechnology.kidfriendly.ejbs.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.Week;

@Local
public interface WeekEJBLocal {

	/**
	 * Method week all
	 * @return
	 */
	List<Week> weekAll();
	
}