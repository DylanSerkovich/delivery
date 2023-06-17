package com.business.delivery.service;

import com.business.delivery.model.Persona;
import com.business.delivery.util.ContentMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendVerificationEmail(Persona persona, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = persona.getUsuario().getEmailUsuario();
        String fromAddress = "enviacms123@gmail.com";
        String senderName = "Las Gaviotas";
        String subject = "Verifica tu Registro Porfavor";
        String contenido = "";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        String verifyURL = siteURL + "/verify?code=" + persona.getUsuario().getVerificationCode();
        contenido = ContentMessage.verifyHTML(persona.getNomPersona(),verifyURL);
        helper.setText(contenido, true);
        System.out.println("Enviar Email");
        mailSender.send(message);
    }

    @Async
    public void SenResetPassEmail(String email, String URL) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("enviacms123@gmail.com", "Soporte de Rysoft");
        helper.setTo(email);

        String subject = "Aquí esta el enlace para restablecer contraseña";

        String content = ContentMessage.resPassHTML(URL);

        helper.setSubject(subject);

        helper.setText(content, true);
        System.out.println("Se envio");
        mailSender.send(message);
    }

}
