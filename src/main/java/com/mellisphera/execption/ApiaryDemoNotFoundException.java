package com.mellisphera.execption;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class ApiaryDemoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ApiaryDemoNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
