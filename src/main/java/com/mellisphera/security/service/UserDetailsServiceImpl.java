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
