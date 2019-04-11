package com.mellisphera.security.service;

import com.mellisphera.entities.User;
import com.mellisphera.security.entities.BmAuth;

public interface BmAuthService {
	BmAuth getBmAuth(String username, String password);
	void saveBmData(BmAuth bmData, User user);
}
