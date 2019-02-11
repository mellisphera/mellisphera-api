package com.apiwatch.controllers;

import org.apache.catalina.connector.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.ShareApiary;
import com.apiwatch.entities.User;
import com.apiwatch.repositories.ApiaryRepository;
import com.apiwatch.repositories.ShareRepository;
import com.apiwatch.repositories.UserRepository;
import com.apiwatch.security.jwt.JwtAuthTokenFilter;
import com.apiwatch.security.jwt.JwtProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RestController
@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM')")
@RequestMapping("/apiaries")
public class ApiaryController {
	private static final Log log = LogFactory.getLog(JwtAuthTokenFilter.class);
    @Autowired
    private ApiaryRepository apiaryRepository;
    @Autowired UserRepository userRepository;
    @Autowired ShareRepository shareRepository;
    @Autowired private JwtProvider tokenProvider;
    
    @DeleteMapping("/{id}")
	 public void delete(@PathVariable("id") String id){
	    this.apiaryRepository.deleteById(id);
	 }
    
    @DeleteMapping("/sharing/{idUsername}/{idApiary}")
    public void deleteSharing(@PathVariable String idUsername, @PathVariable String idApiary, HttpServletResponse reponse, HttpServletRequest request) {
    	Optional<User> userTarget = this.userRepository.findById(idUsername);
    	Optional<Apiary> apiary = this.apiaryRepository.findById(idApiary);
    	ShareApiary sharing = this.shareRepository.findShareHiveByidUsername(idUsername);
    	String username = this.tokenProvider.getUserNameFromJwtToken(getJwt(request));
    	User user = this.userRepository.findUserByUsername(username);
    	if(userTarget.isPresent() && apiary.isPresent()) {
    		apiary.get().removeSharedUser(userTarget.get());
    		sharing.removeApiary(apiary.get(), user.getId());
    		reponse.setStatus(Response.SC_OK);
    	}
    	else {
    		reponse.setStatus(Response.SC_NOT_FOUND);
    	}
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<Apiary> getAll(){
	    List<Apiary> apiaries=this.apiaryRepository.findAll();
	    return apiaries;
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
    @RequestMapping(value = "/id/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public Apiary getByid(@PathVariable String idApiary){
	    Apiary apiaries=this.apiaryRepository.findApiaryById(idApiary);
	    return apiaries;
    }
    
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Apiary> getAllUserApiaries(@PathVariable String username){
    	
    	List<Apiary> userApiaries=this.apiaryRepository.findApiaryByUsername(username);    
	    
	    return userApiaries;
    }
   
    /*
    @RequestMapping(value = "/name/{id}", method = RequestMethod.GET, produces={"application/json"})
    public Map<String,String>getRucherCity(@PathVariable String id){
    	Map<String,String> rucherName = new HashMap<>();
    	Apiary ap = this.apiaryRepository.findApiaryById(id);
    	if (ap != null) {
    		rucherName.put("name", ap.getVille());
        	
    	    return rucherName;
    	} else {
    		return null;
    	}
    	
    }*/
   
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public void insert(@RequestBody Apiary apiary){
        System.err.println(apiary.getPhoto());
        this.apiaryRepository.insert(apiary);
    }
    
    @RequestMapping(value = "/details/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public Apiary getApiaryDetails(@PathVariable String idApiary){
    	Apiary a = this.apiaryRepository.findApiaryById(idApiary);
    	return a;
    	    
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Apiary Apiary){ 
    	Apiary a= this.apiaryRepository.findApiaryById(id);
    	a.setName(Apiary.getName());
    	a.setVille(Apiary.getVille());
 		a.setCodePostal(Apiary.getCodePostal());
 		a.setDescription(Apiary.getDescription());
 		this.apiaryRepository.save(a);
    }
    
    /*
    @DeleteMapping("/sharedUser/{id}")
    public Boolean removeSharedUser(@PathVariable String id, HttpServletResponse reponse) {

    }*/
   
}
