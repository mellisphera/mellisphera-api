/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



package com.mellisphera.mail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	 @Value("${mellisphera.app.mail.mail}")
	 private String email;
	 @Value("${mellisphera.app.mail.password}")
	 private String password;
	 @Value("${mellisphera.app.mail.host}")
	 private String host;
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setPort(587);
		mailSender.setUsername(email);
		mailSender.setPassword(password);
		Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.auth.mechanisms","NTLM");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.auth", "true");
		
        return mailSender;
	}

}
