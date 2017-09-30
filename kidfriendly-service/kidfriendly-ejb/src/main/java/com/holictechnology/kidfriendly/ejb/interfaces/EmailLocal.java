package com.holictechnology.kidfriendly.ejb.interfaces;


import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dto.EmailDto;


@Local
public interface EmailLocal {

    /**
     * Method to send e-mail.
     * 
     * @param emailDto
     */
    void sendSimpleEmail(EmailDto emailDto);
}
