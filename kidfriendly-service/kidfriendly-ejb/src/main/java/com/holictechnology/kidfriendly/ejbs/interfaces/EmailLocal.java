package com.holictechnology.kidfriendly.ejbs.interfaces;


import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dtos.EmailDto;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface EmailLocal {

    /**
     * @param emailDto
     * @throws KidFriendlyException
     */
    void sendSimpleEmail(EmailDto emailDto) throws KidFriendlyException;
}
