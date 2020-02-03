package com.mellisphera.controllers;

import com.mellisphera.entities.HubReferences;
import com.mellisphera.repositories.HubReferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
@RequestMapping("/hub")
public class HubReferencesController {

    @Autowired private HubReferencesRepository hubReferencesRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<HubReferences> getAll() {
        return this.hubReferencesRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<HubReferences> getByUserId(@PathVariable String userId) {
        return this.hubReferencesRepository.findByUserId(userId);

    }
}
