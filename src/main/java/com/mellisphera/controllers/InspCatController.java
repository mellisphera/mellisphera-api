package com.mellisphera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.mellisphera.entities.InspCat;
import com.mellisphera.repositories.InspCatRepository;

@Service
@RestController
@RequestMapping("/inspCat")
@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN') or hasRole('TEST')")
public class InspCatController {
    
    @Autowired private InspCatRepository inspCatRepository;

    public InspCatController(){}

    @GetMapping(value = "/all")
    public List<InspCat> getAllInspCat(){
    	return this.inspCatRepository.findAll();
    }

    @GetMapping(value = "/type/{type}")
    public List<InspCat> getInspCatByType(@PathVariable String type){
    	return this.inspCatRepository.findInspCatByType(type);
    }

    @PostMapping(value = "/applies")
    public List<InspCat> getInspCatByApplies(@RequestBody String[] applies){
    	return this.inspCatRepository.findInspCatByApply(applies);
    }

    @PostMapping(value = "/seasons")
    public List<InspCat> getInspCatBySeasons(@RequestBody String[] seasons){
    	return this.inspCatRepository.findInspCatbySeasons(seasons);
    }

}
