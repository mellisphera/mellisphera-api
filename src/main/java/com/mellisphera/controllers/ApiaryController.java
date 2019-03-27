package com.mellisphera.controllers;

import org.apache.catalina.connector.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.ShareApiary;
import com.mellisphera.entities.User;
import com.mellisphera.repositories.ApiaryRepository;
import com.mellisphera.repositories.ShareRepository;
import com.mellisphera.repositories.UserRepository;
import com.mellisphera.security.jwt.JwtAuthTokenFilter;
import com.mellisphera.security.jwt.JwtProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RestController
//@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM')")
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
    @PreAuthorize("hasRole('ADMIN')")
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
	@PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/id/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public Apiary getByid(@PathVariable String idApiary){
	    Apiary apiaries=this.apiaryRepository.findApiaryById(idApiary);
	    return apiaries;
    }
    
	@PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Apiary> getAllUserApiaries(@PathVariable String username, HttpServletResponse reponse){
    	
    	List<Apiary> userApiaries=this.apiaryRepository.findApiaryByUsername(username);    
	    if(userApiaries.isEmpty()) {
	    	reponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
	    }
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
   
	@PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public Apiary insert(@RequestBody Apiary apiary){
        return this.apiaryRepository.insert(apiary);
    }
	@PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/details/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public Apiary getApiaryDetails(@PathVariable String idApiary, HttpServletResponse reponse){
    	Apiary a = this.apiaryRepository.findApiaryById(idApiary);
    	if(a == null) {
    		reponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    	}
    	return a;
    	    
    }

	@PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Apiary Apiary){ 
    	Apiary a= this.apiaryRepository.findApiaryById(id);
    	a.setName(Apiary.getName());
    	a.setVille(Apiary.getVille());
 		a.setCodePostal(Apiary.getCodePostal());
 		a.setDescription(Apiary.getDescription());
 		this.apiaryRepository.save(a);
    }
    
    @PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/update/background/{idApiary}", method = RequestMethod.PUT)
    public void updateBackground(@PathVariable String idApiary ,@RequestBody String imgB64) {
    	Apiary apiary = this.apiaryRepository.findById(idApiary).get();
    	apiary.setPhoto(imgB64);
    	this.apiaryRepository.save(apiary);
    }
    
    /*
    @DeleteMapping("/sharedUser/{id}")
    public Boolean removeSharedUser(@PathVariable String id, HttpServletResponse reponse) {

    }*/
   
}
