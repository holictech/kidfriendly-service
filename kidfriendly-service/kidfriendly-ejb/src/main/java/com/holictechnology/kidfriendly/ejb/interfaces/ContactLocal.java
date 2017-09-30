package com.holictechnology.kidfriendly.ejb.interfaces;


import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dto.EmailDto;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface ContactLocal {

    /**
     * Method to send contact e-mail to administrators.
     * 
     * @param emailDto
     * @throws KidFriendlyException
     */
    void contactUs(EmailDto emailDto);

    /**
     * Method to send e-mail indicating new establishments.
     * 
     * @param emailDto
     * @throws KidFriendlyException
     */
    void indicate(EmailDto emailDto);
}
