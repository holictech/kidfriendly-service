package com.holictechnology.kidfriendly.ejbs.interfaces;


import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dtos.EmailDto;


@Local
public interface EmailLocal {

    /**
     * @param emailDto
     */
    void sendSimpleEmail(EmailDto emailDto);
}
