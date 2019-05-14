package com.mellisphera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.User;
import com.mellisphera.entities.UserPref;
import com.mellisphera.repositories.UserRepository;

@Service
@RestController
@RequestMapping("/userPref")
@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
public class UserPrefController {

	@Autowired UserRepository userRepository;
	
	public UserPrefController() {
		super();
	}
	
	@PutMapping("/update/{username}")
	public void updateUserPref(@PathVariable String username, @RequestBody UserPref userPref) {
		User user = this.userRepository.findUserByUsername(username);
		user.setUserPref(userPref);
		this.userRepository.save(user);
	}
	
	

}
