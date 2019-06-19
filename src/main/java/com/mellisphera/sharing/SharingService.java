package com.mellisphera.sharing;

import java.util.ArrayList;

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

	public SharingService() {
		// TODO Auto-generated constructor stub
	}

	public void addDemoApiaryNewUser(String idNewUser) throws ApiaryDemoNotFoundException {
		Apiary demoApiary = this.apiaryRepository.findApiaryById(ID_DEMO_APIARY);
		if (demoApiary == null) {
			throw new ApiaryDemoNotFoundException(EXCEPTION_MSG);
		}
		try {
			User newUser = this.getNewUser(idNewUser);
			ArrayList<Apiary> apiaryList = new ArrayList<Apiary>();
			apiaryList.add(demoApiary);
			ShareApiary onSharing = new ShareApiary(null,newUser.getId(),newUser.getUsername(), apiaryList);
			this.shareRepository.insert(onSharing);
		}
		catch(UserNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public User getNewUser(String idUser) throws UserNotFoundException {
		User user =  this.userRepository.findById(idUser).get();
		if (user == null) {
			throw new UsernameNotFoundException(EXCEPTION_USER);
		}
		return user;
	}
	
}
