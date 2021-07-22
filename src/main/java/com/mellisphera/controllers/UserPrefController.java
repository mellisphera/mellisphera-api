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



package com.mellisphera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import com.mellisphera.entities.User;
import com.mellisphera.entities.UserPref;
import com.mellisphera.repositories.UserRepository;
import com.mongodb.lang.Nullable;

@Service
@RestController
@RequestMapping("/userPref")
@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
public class UserPrefController {

	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder encoder;
	
	public UserPrefController() {
		super();
	}
	
	@PutMapping("/update/{username}")
	public void updateUserPref(@PathVariable String username, @RequestBody UserPref userPref) {
		User user = this.userRepository.findUserByUsername(username);
		user.setUserPref(userPref);
		this.userRepository.save(user);
	}
	
    @PutMapping("/updatePassword/{idUser}")
    public void changePassword(@PathVariable String idUser, @RequestBody String newPassword) {
		System.out.println("update pw");
    	User user = this.userRepository.findById(idUser).get();
    	user.setPassword(this.encoder.encode(newPassword));
    	this.userRepository.save(user);
    }

	@GetMapping("/{username}")
	public UserPref getUserPref(@PathVariable String username){
		User user = this.userRepository.findUserByUsername(username);
		return user.getUserPref();
	}

	@PutMapping("/updateRefDate/{username}")
	public void updateRefDate(@PathVariable String username, @Nullable @RequestBody Date date){
		System.out.println("Sending to mongodb");
		User user = this.userRepository.findUserByUsername(username);
		UserPref user_pref = user.getUserPref();
		user_pref.setDateRef(date);
		user.setUserPref(user_pref);
		System.out.println(user_pref);
		this.userRepository.save(user);
	}

}
