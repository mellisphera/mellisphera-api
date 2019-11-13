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



package com.mellisphera.sharing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.ShareApiary;
import com.mellisphera.entities.User;
import com.mellisphera.execption.ApiaryDemoNotFoundException;
import com.mellisphera.execption.UserNotFoundException;
import com.mellisphera.repositories.ApiaryRepository;
import com.mellisphera.repositories.ShareRepository;
import com.mellisphera.repositories.UserRepository;

@Service
public class SharingService {

	
	@Autowired private UserRepository userRepository;
	@Autowired private ApiaryRepository apiaryRepository;
	@Autowired private ShareRepository shareRepository;	

	private static final String ID_DEMO_APIARY = "5bcde872dc7d274ec35e87cf";
	private static final String EXCEPTION_MSG = "Demo apiary not found";
	private static final String EXCEPTION_USER = "User not found";
	private static final String NAME_DEMO_APIARy = "Rucher demo";
	
	private Apiary apiaryDemo;

	@Autowired
	public SharingService() {
	}
	

	public void addDemoApiaryNewUser(String idNewUser) throws ApiaryDemoNotFoundException {
		Apiary demoApiary = this.apiaryRepository.findById(ID_DEMO_APIARY).get();
		if (demoApiary == null) {
			throw new ApiaryDemoNotFoundException(EXCEPTION_MSG);
		}
		try {
			demoApiary.setName(NAME_DEMO_APIARy);
			User newUser = this.getNewUser(idNewUser);
			ArrayList<Apiary> apiaryList = new ArrayList<Apiary>();
			apiaryList.add(demoApiary);
			ShareApiary onSharing = new ShareApiary(null, newUser.getId(), apiaryList);
			this.shareRepository.insert(onSharing);
		}
		catch(UserNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public User getNewUser(String idUser) throws UserNotFoundException {
		User user =  this.userRepository.findById(idUser).get();
		if (user == null) {
			throw new UsernameNotFoundException(EXCEPTION_USER);
		}
		return user;
	}
	
	public void renameApiaryDemo(String name) {
		int indexApiaryDemo = 0;
		Apiary apiaryDemo = this.apiaryRepository.findById(ID_DEMO_APIARY).get();
		List<ShareApiary> shareApiary = this.shareRepository.findAll();
		for (ShareApiary sApiary: shareApiary) {
			if ((indexApiaryDemo = findApiary(apiaryDemo, sApiary)) != -1) {
				sApiary.getsharingApiary().get(indexApiaryDemo).setName(name);
				this.shareRepository.save(sApiary);
			}
		}
	}

	private int findApiary(Apiary apiaryDemo, ShareApiary sApiary) {
		return sApiary.getsharingApiary().stream().map(apiary -> apiary.get_id()).collect(Collectors.toList()).indexOf(apiaryDemo.get_id());
	}
	
	
	
	
}
