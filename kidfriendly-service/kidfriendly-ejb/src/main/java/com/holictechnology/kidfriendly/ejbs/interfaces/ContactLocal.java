package com.holictechnology.kidfriendly.ejbs.interfaces;


import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dtos.EmailDto;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface ContactLocal {

    /**
     * @param emailDto
     * @throws KidFriendlyException
     */
    void contactUs(EmailDto emailDto);

    /**
     * @param emailDto
     * @throws KidFriendlyException
     */
    void indicate(EmailDto emailDto);
}
