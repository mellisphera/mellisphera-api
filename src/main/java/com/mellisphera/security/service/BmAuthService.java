package com.mellisphera.security.service;

import com.mellisphera.entities.User;
import com.mellisphera.security.entities.BmAuth;

import java.sql.Timestamp;
import java.util.Date;

public interface BmAuthService {
	BmAuth getBmAuth(String username, String password);
	void saveBmData(BmAuth bmData, String username);

	public Date convertTimestampToDate(long time);
}
