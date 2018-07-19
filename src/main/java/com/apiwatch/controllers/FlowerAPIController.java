package com.apiwatch.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apiwatch.entities.Flower;
import com.apiwatch.entities.FlowerAPI;
import com.apiwatch.repositories.FleurTheoriqueRepository;
import com.apiwatch.weather.WeatherAPI;



@RestController
@RequestMapping("/fleurs-theoriques")
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
public class FlowerAPIController {

	@Autowired
	FleurTheoriqueRepository FleurTheoriqueRepository;

	
	
	public FlowerAPIController() {

	}

	public FlowerAPIController(FleurTheoriqueRepository fleurTheoriqueRepository) {
		FleurTheoriqueRepository = fleurTheoriqueRepository;
	}

	public FlowerAPI getListFleur(){ 	
		   
		   JSONObject obj = new JSONObject();
		   int[] a = new int[] {0,150,0,150,0,1,0,1,0,1,0,1,0,1,0,1,0,1,53,0,0,1};
		   
		   obj.put("id",1 );
		   obj.put("method","pLANTE");
		   obj.put("params", a);
		   
		   
		   HttpHeaders headers = new HttpHeaders();
	       headers.setContentType( MediaType.APPLICATION_JSON );
	       HttpEntity request= new HttpEntity( obj, headers );
	       
		   List<Flower> listeFleurs = new ArrayList<>();
		   RestTemplate restTemplate = new RestTemplate();
		   
		   FlowerAPI r= new FlowerAPI();
		 
		   FlowerAPI result =restTemplate.postForObject("http://apibotanica.inra.fr/botaniqueDB.json", request, FlowerAPI.class);
		   
		  return result;
	 }
	   
}
