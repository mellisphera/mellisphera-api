package com.mellisphera.security.service;

import com.mellisphera.security.entities.BmAuth;

public interface BmAuthService {
	BmAuth getBmAuth(String username, String password);
}
