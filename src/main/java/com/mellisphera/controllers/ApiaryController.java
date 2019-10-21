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

import com.mellisphera.ImgTool.ImageTool;
import org.apache.catalina.connector.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.Sensor;
import com.mellisphera.entities.ShareApiary;
import com.mellisphera.entities.User;
import com.mellisphera.repositories.ApiaryRepository;
import com.mellisphera.repositories.SensorRepository;
import com.mellisphera.repositories.ShareRepository;
import com.mellisphera.repositories.UserRepository;
import com.mellisphera.security.jwt.JwtAuthTokenFilter;
import com.mellisphera.security.jwt.JwtProvider;
import sun.misc.BASE64Decoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RestController
//@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM')")
@RequestMapping("/apiaries")
public class ApiaryController {
	private static final Log log = LogFactory.getLog(JwtAuthTokenFilter.class);
	
    @Autowired private ApiaryRepository apiaryRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private ShareRepository shareRepository;
    @Autowired private JwtProvider tokenProvider;
    @Autowired private SensorRepository sensorRepository;
    
    @PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
    @DeleteMapping("/{id}")
	 public void delete(@PathVariable("id") String id){
    	this.sensorRepository.findSensorByApiaryId(id).stream().forEach(sensor -> {
    		sensor.setApiaryId(null);
    		sensor.setHiveId(null);
    		this.sensorRepository.save(sensor);
    	});
	    this.apiaryRepository.deleteById(id);
	 }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<Apiary> getAll(){
	    return this.apiaryRepository.findAll().stream().map(_apiary -> {
	    	_apiary.setPhoto(null);
	    	return _apiary;
	    }).collect(Collectors.toList());
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
	@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
    @RequestMapping(value = "/id/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public Apiary getByid(@PathVariable String idApiary){
	    Apiary apiaries=this.apiaryRepository.findById(idApiary).get();
	    return apiaries;
    }
    
	@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces={"application/json"})
    public List<Apiary> getAllUserApiaries(@PathVariable String userId, HttpServletResponse response){
    	List<Apiary> userApiaries=this.apiaryRepository.findApiaryByUserId(userId);
	    if(userApiaries.isEmpty()) {
	    	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
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
   
	@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public Apiary insert(@RequestBody Apiary apiary){
		ImageTool imageTool = new ImageTool(apiary.getPhoto(), apiary.getUserId());
		imageTool.convertToFile();
		apiary.setPhoto(imageTool.getPathClient());
        return this.apiaryRepository.insert(apiary);
    }
	@PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/details/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public Apiary getApiaryDetails(@PathVariable String idApiary, HttpServletResponse response){
    	Apiary a = this.apiaryRepository.findById(idApiary).get();
    	if(a == null) {
    		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    	}
    	return a;
    	    
    }

	@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String id, @RequestBody Apiary apiary){
		Apiary lastApiary = this.apiaryRepository.findById(id).get();
		if (!lastApiary.getPhoto().equals(apiary.getPhoto())) {
			ImageTool imageTool = new ImageTool(apiary.getPhoto(), apiary.getUserId());
			imageTool.convertToFile();
			apiary.setPhoto(imageTool.getPathClient());
		}
 		Apiary apiarySave = this.apiaryRepository.save(apiary);
 		List<Sensor> sensors = this.sensorRepository.findSensorByApiaryId(apiarySave.get_id());
 		if (sensors != null) {
 			for(Sensor s: sensors) {
 				if (!s.getApiaryId().equals(apiarySave.get_id())) {
 					s.setApiaryId(apiarySave.get_id());
 					this.sensorRepository.save(s);
 				}
 			}
 		}
    }
    
	@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
    @RequestMapping(value = "/update/background/{idApiary}", method = RequestMethod.PUT)
    public void updateBackground(@PathVariable String idApiary ,@RequestBody String imgB64) {
    	Apiary apiary = this.apiaryRepository.findById(idApiary).get();
		ImageTool imageTool = new ImageTool(imgB64, apiary.getUserId());
		imageTool.convertToFile();
		apiary.setPhoto(imageTool.getPathClient());
    	this.apiaryRepository.save(apiary);
    }


	@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
	@GetMapping("/notPicture/{username}")
	public List<Apiary> getApiaryUserNoPicture(@PathVariable String username){
		return this.apiaryRepository.findApiaryByUsername(username).stream().map(_apiary -> {
			_apiary.setPhoto(null);
			return _apiary;
		}).collect(Collectors.toList());
	}

    
    /*
    @DeleteMapping("/sharedUser/{id}")
    public Boolean removeSharedUser(@PathVariable String id, HttpServletResponse reponse) {

    }*/
   
}
