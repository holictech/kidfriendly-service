package com.holictechnology.kidfriendly.ejbs;


import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.holictechnology.kidfriendly.domain.dtos.EmailDto;
import com.holictechnology.kidfriendly.domain.dtos.EmailDto.Recipient;
import com.holictechnology.kidfriendly.ejbs.interfaces.EmailLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
public class EmailEJB extends AbstractEJB implements EmailLocal {

    private static final long serialVersionUID = -4488307229929149557L;
    private static final String HOST_NAME = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    private static final String USERNAME = "holictechnology@gmail.com";
    private static final String PASSWORD = "fabiane0912@";

    @Override
    @Asynchronous
    @Transactional(value = TxType.NOT_SUPPORTED)
    public void sendSimpleEmail(EmailDto emailDto) throws KidFriendlyException {
        illegalArgument(emailDto);

        try {
            SimpleEmail simpleEmail = new SimpleEmail();
            simpleEmail.setMsg(emailDto.getMessage());
            send(simpleEmail, emailDto);
        } catch (EmailException ee) {
            throw new KidFriendlyException(KidFriendlyMessages.ERROR_EMAIL_SEND, ee);
        }
    }

    /**
     * @param email
     * @param emailDto
     * @throws EmailException
     */
    private void send(Email email, EmailDto emailDto) throws EmailException {
        if (email == null) {
            return;
        }

        email.setHostName(HOST_NAME);
        email.setSmtpPort(SMTP_PORT);
        email.setStartTLSEnabled(Boolean.TRUE);
        email.setSSLOnConnect(Boolean.TRUE);
        email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
        email.setFrom(emailDto.getFromEmail(), emailDto.getFromName());

        if (emailDto.getRecipients() != null && !emailDto.getRecipients().isEmpty()) {
            for (Recipient recipient : emailDto.getRecipients()) {
                email.addTo(recipient.getEmail(), recipient.getName());
            }
        } else {
            throw new EmailException(KidFriendlyMessages.ERROR_EMAIL_NOT_RECIPIENT);
        }

        email.setSubject(emailDto.getSubject());
        email.send();
    }
}
