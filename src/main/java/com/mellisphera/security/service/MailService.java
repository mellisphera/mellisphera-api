package com.mellisphera.security.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Value;

import javax.mail.Authenticator;
import com.mellisphera.security.entities.Mail;

public class MailService {
	
	@Value("${apiwatch.app.mail.username}")
	private String username;
	@Value("${apiwatch.app.mail.password}")
	private String password;
	Properties prop;
	Session session;
	Message message;
	public MailService() {
		this.prop.put("mail.smtp.auth", true);
		this.prop.put("mail.smtp.starttls.enable", "true");
		this.prop.put("mail.smtp.host", "smtp.mailtrap.io");
		this.prop.put("mail.smtp.port", "25");
		this.prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
		
		this.session = Session.getInstance(prop, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		});
	}
	
}
