package com.apiwatch.security.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private Long connexions;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtResponse(String accessToken, Long connexions, String username, Collection<? extends GrantedAuthority> authorities) {
		this.token = accessToken;
		this.username = username;
		this.authorities = authorities;
		this.connexions = connexions;
	}

	public String getAccessToken() {
		return token;
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
