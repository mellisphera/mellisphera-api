/**
 * 
 */
package com.apiwatch.security.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.User;
import com.apiwatch.repositories.UserRepository;
import com.apiwatch.security.entities.ApiWatchUserDetails;

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
	public ApiWatchUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// load user and build the principal
		User user = userRepository.findUserByUsername(username);
		log.info(" Load User :"+ user.toString());
		// 
		if(user == null)
			throw  new UsernameNotFoundException("User Not Found with -> username : " + username);
		//
		return ApiWatchUserDetails.build(user);
	}

}
