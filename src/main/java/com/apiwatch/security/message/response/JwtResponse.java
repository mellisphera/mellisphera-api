package com.apiwatch.security.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String email;
	private Long connexions;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtResponse(String accessToken, Long connexions, String username, String email, Collection<? extends GrantedAuthority> authorities) {
		this.token = accessToken;
		this.username = username;
		this.email = email;
		this.authorities = authorities;
		this.connexions = connexions;
	}

	public String getAccessToken() {
		return token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getConnexions() {
		return this.connexions;
	}
	
	public void setConnexion(Long connexion) {
		this.connexions = connexion;
	}
	
	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

}
