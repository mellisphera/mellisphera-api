package com.apiwatch.controllers;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.TheoricalFlower;
import com.apiwatch.repositories.TheoricalFlowerRepository;

@Service
@RestController
@RequestMapping("/flowersTh")
public class TheoricalFlowerController {

	@Autowired
    private TheoricalFlowerRepository theoricalFlowerRepository;
	
    public TheoricalFlowerController() {
	    }
    
    public TheoricalFlowerController(TheoricalFlowerRepository theoricalFlowerRepository) {
		this.theoricalFlowerRepository = theoricalFlowerRepository;
	} 
	
    
    //On récupère toutes les plantes theoriques
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
	public List<TheoricalFlower> getAllFlowers() {
		List<TheoricalFlower> allFlowers=this.theoricalFlowerRepository.findAll();
		
		return allFlowers;
	}
    
    //On récupère les types possible des plantes
    @GetMapping("/types")
    public List<String>  getAllGenre(){    	
    	List<String> lesTypes = new ArrayList<>();
    	lesTypes.add("Arbres");
    	lesTypes.add("Arbustres");
    	lesTypes.add("Herbacées");
    	lesTypes.add("Bulbes");
	    return lesTypes;
    }
	
    //On récupère les fleursTest qui correspondent aux nom (partiel ou entier) tapé par l'utilisateur dans sa recherche
    @RequestMapping(value = "/rechercheVar", method = RequestMethod.PUT)
    public List<TheoricalFlower> getRechercheVar(@RequestBody TheoricalFlower flower){
	    List<TheoricalFlower> flowers =  this.theoricalFlowerRepository.findAll();
	    List<TheoricalFlower> resFlowers = new ArrayList<>(flowers);
	    
	    //On cherche les fleurs qui contient la chaine de caractère rentrée dans le nom francais
	    if (!(flower.flowerInra.getFrancais().equals(""))) {
	    	resFlowers.clear();
	    	for (TheoricalFlower f :flowers) {
	    		if ( f.flowerInra.getFrancais().toLowerCase().contains(flower.flowerInra.getFrancais().toLowerCase())) {
	    			resFlowers.add(f);
	    		}
	    	}
	    	flowers.clear();
	    	flowers = new ArrayList<>(resFlowers);
			Collections.copy(flowers,resFlowers);
	    }
	    
	    return resFlowers;
    } 
    
    //On récupère les fleursTheorique qui correspondent aux filtres de type et de période de floraison
    @RequestMapping(value = "/recherchePer", method = RequestMethod.PUT)
    public List<TheoricalFlower> getRecherchePer(@RequestBody TheoricalFlower flower){
	    List<TheoricalFlower> flowers =  this.theoricalFlowerRepository.findAll();
	    List<TheoricalFlower> resFlowers = new ArrayList<>(flowers);
	    String[] datemin = new String[2];
	    String[] datemax = new String[2];
	    
	    //On cherche les fleurs qui correspondent à la famille demandé
	    if (!(flower.getType().equals(""))) {
	    	resFlowers.clear();
	    	for (TheoricalFlower f :flowers) {
	    		if ( flower.getType().equals(f.getType()) ) {
	    			resFlowers.add(f);
	    		}
	    	}
	    	flowers.clear();
	    	flowers = new ArrayList<>(resFlowers);
			Collections.copy(flowers,resFlowers);
	    }	    
	    
	  //On cherche les fleurs qui correspondent fleurisse à un certain mois
	    if (!(flower.flowerInra.getFlomind().equals("0"))) {
	    	resFlowers.clear();
	    	for (TheoricalFlower f :flowers) {
	    		datemin = f.flowerInra.getFlomind().split("-");
	    		datemax = f.flowerInra.getFlomaxd().split("-");
	    		if ( (Integer.parseInt(datemin[0]) <= Integer.parseInt(flower.flowerInra.getFlomind())) && (Integer.parseInt(datemax[0]) >= Integer.parseInt(flower.flowerInra.getFlomind())) ) {
	    			resFlowers.add(f);
	    		}
	    	}
	    	flowers.clear();
	    	flowers = new ArrayList<>(resFlowers);
			Collections.copy(flowers,resFlowers);
	    }
	    
	    return resFlowers;
    }

}
