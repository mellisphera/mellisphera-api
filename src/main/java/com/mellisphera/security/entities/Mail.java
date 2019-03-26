package com.mellisphera.security.entities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;

public interface Mail {

	Properties getProperties();
	Session getSession();
	Message getMessage();
	
}
