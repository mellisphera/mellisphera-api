package com.mellisphera.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.mellisphera.entities.InspUser;
import com.mellisphera.entities.InspConf;
import com.mellisphera.entities.InspCat;
import com.mellisphera.repositories.InspUserRepository;

@Service
@RestController
@RequestMapping("/inspUser")
@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN') or hasRole('TEST')")
public class InspUserController {

    @Autowired private InspUserRepository inspUserRepository;

    public InspUserController(){}

    @GetMapping(value = "/_id/{_id}")
    public InspUser getInspUserBy_id(@PathVariable String _id){
    	return this.inspUserRepository.findInspUserBy_id(_id);
    }

    @GetMapping(value = "/idUser/{idUser}")
    public InspUser getInspUserByIdUser(@PathVariable String idUser){
    	return this.inspUserRepository.findInspUserByIdUser(idUser);
    }

    @GetMapping(value = "/exists/{idUser}")
    public boolean exists(@PathVariable String idUser){
        return this.inspUserRepository.existsByIdUser(idUser);
    }
  
    @PostMapping("/insert")
    public InspUser createInspUser(@RequestBody InspUser inspUser){
    	return this.inspUserRepository.insert(inspUser);
    }

    @PostMapping("/update")
    public InspUser updateInspUser(@RequestBody InspUser inspUser){
    	return this.inspUserRepository.save(inspUser);
    }
}
