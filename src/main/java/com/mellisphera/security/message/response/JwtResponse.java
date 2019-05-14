package com.mellisphera.security.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.mellisphera.entities.UserPref;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String email;
	private Long connexions;
	private String country;
	private UserPref userPref;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtResponse(String accessToken, Long connexions, String username, String email, Collection<? extends GrantedAuthority> authorities, String country, UserPref userPref) {
		this.token = accessToken;
		this.username = username;
		this.email = email;
		this.authorities = authorities;
		this.connexions = connexions;
		this.country = country;
		this.userPref = userPref;
	}
	
	public JwtResponse(String accessToken, Long connexions, String username, String email, Collection<? extends GrantedAuthority> authorities, String country) {
		this.token = accessToken;
		this.username = username;
		this.email = email;
		this.authorities = authorities;
		this.connexions = connexions;
		this.country = country;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public UserPref getUserPref() {
		return userPref;
	}

	public void setUserPref(UserPref userPref) {
		this.userPref = userPref;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setConnexions(Long connexions) {
		this.connexions = connexions;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
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
