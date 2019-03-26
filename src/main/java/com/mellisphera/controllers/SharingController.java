package com.mellisphera.controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
import com.mellisphera.security.jwt.JwtProvider;

@RestController
@RequestMapping("/sharing")
public class SharingController {
	private static final Log log = LogFactory.getLog(JwtAuthTokenFilter.class);
	
	@Autowired private ShareRepository shareRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private ApiaryRepository apiaryRepository;
	@Autowired private HiveController hiveController;
	@Autowired private JwtProvider tokenProvider;
	private SharingController() {
	}
	
	@GetMapping(path = "")
	public List<ShareApiary> getSharing() {
		return this.shareRepository.findAll();
	}
	
	@GetMapping(path = "user/{idUser}")
	public ShareApiary getApiaryShareById(@PathVariable String idUser){
		return this.shareRepository.findShareHiveByidUsername(idUser);
	}
	
	
	@PostMapping(path = "/share/")
	public Boolean shareHive(@RequestBody Apiary apiary, @RequestBody User userTarget, HttpServletRequest request, HttpServletResponse reponse) {
		String username = this.tokenProvider.getUserNameFromJwtToken(getJwt(request));
		User user = this.userRepository.findUserByUsername(username);
		if(user != null) {
			apiary.addSharedUser(userTarget);
			ShareApiary sharing = this.shareRepository.findShareHiveByidUsername(userTarget.getId());
			if(sharing != null) {
				sharing.addApiary(apiary, userTarget.getId());
				this.shareRepository.save(sharing);
			}
			else {
				sharing = new ShareApiary(null,userTarget.getId(),new HashMap<String, Apiary>());
				sharing.addApiary(apiary, user.getId());
				this.shareRepository.insert(sharing);
			}
			
			this.apiaryRepository.save(apiary);
			
			reponse.setStatus(Response.SC_CREATED);
			return true;
		}
		else {
			reponse.setStatus(Response.SC_NOT_FOUND);
		}
		
		return false;
	}
	
	private String getJwt(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		//
		log.debug("authHeader :"+authHeader);
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.replace("Bearer ", "");
		}

		return null;
	}
}
