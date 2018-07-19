package com.example.demo.controllers;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Flower;
import com.example.demo.entities.ObservedFlower;
import com.example.demo.entities.User;
import com.example.demo.repositories.TheoricalFlowerRepository;

@RestController
@RequestMapping("/flowersth")
@CrossOrigin(origins = "http://localhost:4200")
public class TheoricalFlowerController {
	@Autowired
    private TheoricalFlowerRepository thFlowerRepository;
	
    public TheoricalFlowerController() {
	    }

    public TheoricalFlowerController(TheoricalFlowerRepository thFlowerRepository) {
	        this.thFlowerRepository = thFlowerRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping(value = "/{nom}", method = RequestMethod.GET, produces={"application/json"})
    public Flower getFlower(@PathVariable String nom){
	    List<Flower> flowers =  this.thFlowerRepository.findAll();
	    Flower flower = new Flower();
	    for(Flower f : flowers) {
	    	if ((f.getFrancais().toLowerCase().equals(nom.toLowerCase()))) {
	    		flower.setAutre(f.getAutre());
	    		flower.setButineur(f.getButineur());
	    		flower.setFamille(f.getFamille());
	    		flower.setFlomin(f.getFlomin());
	    		flower.setFlomax(f.getFlomax());
	    		flower.setForme(f.getForme());
	    		flower.setFrancais(f.getFrancais());
	    		flower.setGenre(f.getGenre());
	    		flower.setIdplante(f.getIdplante());
	    		flower.setLatin(f.getLatin());
	    		flower.setPol_equ(f.getPol_equ());
	    		flower.setPol_pol(f.getPol_pol());
	    		flower.setRemarq(f.getRemarq());
	    		flower.setRessource(f.getRessource());
	    	}
	    }
	    return flower;
    }


    @GetMapping("/all")
    public List<Flower> getAll(){
    List<Flower> flowers = this.thFlowerRepository.findAll();
    return flowers;
    }

    @GetMapping("/familles")
    public List<String> getAllFamily(){
    List<Flower> flowers =  this.thFlowerRepository.findAll();
    List<String> lesFamilles = new ArrayList<>();
    for(Flower f : flowers) {
    	if(!lesFamilles.contains(f.getFamille())) {
    		lesFamilles.add(f.getFamille());
    	}
    }
    return lesFamilles;
    }
    
    @GetMapping("/genres")
    public List<String> getAllGenre(){
    List<Flower> flowers =  this.thFlowerRepository.findAll();
    List<String> lesGenres = new ArrayList<>();
    for(Flower f : flowers) {
    	if(!lesGenres.contains(f.getGenre())) {
    		lesGenres.add(f.getGenre());
    	}
    }
    return lesGenres;
    }
    
    @GetMapping("/formes")
    public List<String> getAllForme(){
    List<Flower> flowers =  this.thFlowerRepository.findAll();
    List<String> lesFormes = new ArrayList<>();
    for(Flower f : flowers) {
    	if(!lesFormes.contains(f.getForme())) {
    		lesFormes.add(f.getForme());
    	}
    }
    return lesFormes;
    }
    
    @GetMapping("/ressources")
    public List<String> getAllRessource(){
    List<Flower> flowers =  this.thFlowerRepository.findAll();
    List<String> lesRessources = new ArrayList<>();
    for(Flower f : flowers) {
    	if(!lesRessources.contains(f.getRessource())) {
    		lesRessources.add(f.getRessource());
    	}
    }
    return lesRessources;
    }
    
    @GetMapping("/butineurs")
    public List<String> getAllButineur(){
    List<Flower> flowers =  this.thFlowerRepository.findAll();
    List<String> lesButineurs = new ArrayList<>();
    for(Flower f : flowers) {
    	if(!lesButineurs.contains(f.getButineur())) {
    		lesButineurs.add(f.getButineur());
    	}
    }
    return lesButineurs;
    }
    
    
    @RequestMapping(value = "/recherche", method = RequestMethod.PUT)
    public List<Flower> getRecherche(@RequestBody Flower flower){
    List<Flower> flowers =  this.thFlowerRepository.findAll();
    List<Flower> resFlowers = new ArrayList<>();
    //Collections.copy(resFlowers, flowers);
    
    //On cherche les fleurs qui correspondent au flomin et flomax
   	//resFlowers.clear();
   	for (Flower f :flowers) {
   		if ( (flower.getFlomin() <= f.getFlomin()) && (flower.getFlomax() >= f.getFlomax()) ) {
   			resFlowers.add(f);
   		}
   	}
   	flowers.clear();
   	flowers = new ArrayList<>(resFlowers);
	Collections.copy(flowers,resFlowers);
    
    //On cherche les fleurs qui correspondent à la famille demandé
    if (!(flower.getFamille().equals(""))) {
    	resFlowers.clear();
    	for (Flower f :flowers) {
    		if ( flower.getFamille().equals(f.getFamille()) ) {
    			resFlowers.add(f);
    		}
    	}
    	flowers.clear();
    	flowers = new ArrayList<>(resFlowers);
		Collections.copy(flowers,resFlowers);
    }
    
    //On cherche les fleurs qui correspondent au genre demandé
    if (!(flower.getGenre().equals(""))) {
    	resFlowers.clear();
    	for (Flower f :flowers) {
    		if ( flower.getGenre().equals(f.getGenre()) ) {
    			resFlowers.add(f);
    		}
    	}
    	flowers.clear();
    	flowers = new ArrayList<>(resFlowers);
		Collections.copy(flowers,resFlowers);
    }
    
    //On cherche les fleurs qui correspondent à la forme demandé
    if (!(flower.getForme().equals(""))) {
    	resFlowers.clear();
    	for (Flower f :flowers) {
    		if ( flower.getForme().equals(f.getForme()) ) {
    			resFlowers.add(f);
    		}
    	}
    	flowers.clear();
    	flowers = new ArrayList<>(resFlowers);
		Collections.copy(flowers,resFlowers);
    }
    
    //On cherche les fleurs qui correspondent aux ressoucres demandées
    if (!(flower.getRessource().equals(""))) {
    	resFlowers.clear();
    	for (Flower f :flowers) {
    		if ( flower.getRessource().equals(f.getRessource()) ) {
    			resFlowers.add(f);
    		}
    	}
    	flowers.clear();
    	flowers = new ArrayList<>(resFlowers);
		Collections.copy(flowers,resFlowers);
    }
    
    //On cherche les fleurs qui correspondent aux butineurs demandés
    if (!(flower.getButineur().equals(""))) {
    	resFlowers.clear();
    	for (Flower f :flowers) {
    		if ( flower.getButineur().equals(f.getButineur()) ) {
    			resFlowers.add(f);
    		}
    	}
    	flowers.clear();
    	flowers = new ArrayList<>(resFlowers);
		Collections.copy(flowers,resFlowers);
    }
    
    
  //On cherche les fleurs qui contient la chaine de caractère rentrée dans le nom francais
    if (!(flower.getFrancais().equals(""))) {
    	resFlowers.clear();
    	for (Flower f :flowers) {
    		if ( f.getFrancais().toLowerCase().contains(flower.getFrancais().toLowerCase())) {
    			resFlowers.add(f);
    		}
    	}
    	flowers.clear();
    	flowers = new ArrayList<>(resFlowers);
		Collections.copy(flowers,resFlowers);
    }
    
    //On cherche les fleurs qui contient la chaine de caractère rentrée dans le nom latin
    if (!(flower.getLatin().equals(""))) {
    	resFlowers.clear();
    	for (Flower f :flowers) {
    		if ( f.getLatin().toLowerCase().contains(flower.getLatin().toLowerCase())) {
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
