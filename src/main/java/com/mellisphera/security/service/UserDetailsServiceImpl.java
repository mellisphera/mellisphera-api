/**
 * 
 */
package com.mellisphera.security.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.User;
import com.mellisphera.repositories.UserRepository;
import com.mellisphera.security.entities.ApiWatchUserDetails;

/**
 * @author epa
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Log log = LogFactory.getLog(UserDetailsServiceImpl.class);
	@Autowired
	UserRepository userRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public ApiWatchUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// load user and build the principal
		User user = userRepository.findUserByEmail(email);
		log.debug(" Load User :"+ user.toString());
		// 
		if(user == null)
			throw  new UsernameNotFoundException("User Not Found with -> username : " + email);
		else 
			return ApiWatchUserDetails.build(user);
	}

}
