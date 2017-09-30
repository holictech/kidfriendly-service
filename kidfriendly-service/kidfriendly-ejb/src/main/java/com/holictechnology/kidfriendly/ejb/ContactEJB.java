package com.holictechnology.kidfriendly.ejb;


import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.dto.EmailDto;
import com.holictechnology.kidfriendly.domain.dto.EmailDto.Recipient;
import com.holictechnology.kidfriendly.ejb.interfaces.ContactLocal;
import com.holictechnology.kidfriendly.ejb.interfaces.EmailLocal;


@Stateless
public class ContactEJB extends AbstractEJB implements ContactLocal {

    private static final long serialVersionUID = -8246877693511264592L;

    @EJB
    private EmailLocal emailLocal;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejb.interfaces.ContactLocal#contactUs(com
     * .holictechnology.kidfriendly.domain.dto.EmailDto)
     */
    @Override
    @Asynchronous
    @Transactional(value = TxType.NOT_SUPPORTED)
    public void contactUs(EmailDto emailDto) {
        emailDto.getRecipients().add(new Recipient("Kid Friendly", "faleconosco@kidfriendly.com.br"));
        emailLocal.sendSimpleEmail(emailDto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejb.interfaces.ContactLocal#indicate(com.
     * holictechnology.kidfriendly.domain.dto.EmailDto)
     */
    @Override
    @Asynchronous
    @Transactional(value = TxType.NOT_SUPPORTED)
    public void indicate(EmailDto emailDto) {
        emailDto.getRecipients().add(new Recipient("Kid Friendly", "indicacao@kidfriendly.com.br"));
        emailLocal.sendSimpleEmail(emailDto);
    }
}
