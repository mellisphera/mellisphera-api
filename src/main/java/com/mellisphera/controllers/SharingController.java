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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.ShareApiary;
import com.mellisphera.entities.User;
import com.mellisphera.repositories.ApiaryRepository;
import com.mellisphera.repositories.ShareRepository;
import com.mellisphera.repositories.UserRepository;
import com.mellisphera.security.jwt.JwtAuthTokenFilter;
import com.mellisphera.sharing.SharingService;

@RestController
@RequestMapping("/sharing")
public class SharingController {
	private static final Log log = LogFactory.getLog(JwtAuthTokenFilter.class);
	
	@Autowired private ShareRepository shareRepository;	
	@Autowired private UserRepository userRepository;
	@Autowired private SharingService sharingService;

	public SharingController() {
	}
	
	@GetMapping(path = "")
	public List<ShareApiary> getSharing() {
		return this.shareRepository.findAll();
	}
	
	@GetMapping(path = "user/{userId}")
	public List<Apiary> getSharingApiaryByUser(@PathVariable String userId){
		try {
			List<Apiary> apiaryList = this.shareRepository.findSharingApiaryByUserId(userId).getsharingApiary();
			return apiaryList;
		}
		catch (NullPointerException e) {
			return new ArrayList<Apiary>();
		}
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("/demo-apiary")
//	public Apiary getApiaryDemo() {
//		return this.sharingService.getApiaryDemo();
//	}
//	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/name")
	public void renameApiaryDemo(@RequestBody String name) {
		this.sharingService.renameApiaryDemo(name);
	}
	
	
	
	
}
