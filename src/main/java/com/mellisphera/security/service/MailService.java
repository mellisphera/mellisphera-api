package com.mellisphera.security.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
	
	public void sendMail() {
		this.message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(this.username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mickael@mellisphera.com"));
			message.setSubject("Mail Subject");
			 
			String msg = "This is my first email using JavaMailer";
			 
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");
			 
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			 
			message.setContent(multipart);
			 
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
