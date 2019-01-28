/**
 * 
 */
package com.apiwatch.security.entities;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.apiwatch.entities.User;
import com.apiwatch.security.service.UserDetailsServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author epa
 *
 */
public class ApiWatchUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ApiWatchUserDetails.class);
	//private String id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public ApiWatchUserDetails(String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		//this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
/**
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
**/
	public static ApiWatchUserDetails build(User user) {
		log.debug("user :"+user.toString());
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());
		return new ApiWatchUserDetails( user.getUsername(), user.getEmail(),
				user.getPassword(), authorities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getAuthorities(
	 * )
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        ApiWatchUserDetails user = (ApiWatchUserDetails) o;
        return Objects.equals(username, user.username);
    }

}
