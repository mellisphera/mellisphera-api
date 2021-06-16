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



package com.mellisphera.security.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.mellisphera.entities.UserPref;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String email;
	private String lang;
	private Long connexions;
	private String country;
	private UserPref userPref;
	private String idUser;
	private boolean active;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtResponse(String idUser, String accessToken, Long connexions, String username, String email, Collection<? extends GrantedAuthority> authorities, String country, UserPref userPref, String lang, boolean active) {
		this.lang = lang;
		this.token = accessToken;
		this.username = username;
		this.email = email;
		this.authorities = authorities;
		this.connexions = connexions;
		this.country = country;
		this.idUser = idUser;
		this.userPref = userPref;
		this.active = active;
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

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public UserPref getUserPref() {
		return userPref;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
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

	public boolean getActive(){
		return this.active;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

}
