package com.mellisphera.controllers;

import com.mellisphera.entities.Swarm;
import com.mellisphera.repositories.SwarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('PREMIUM') or hasRole('STANDARD') or hasRole('ADMIN')")
@RequestMapping("/swarm")
public class SwarmController {

    @Autowired private SwarmRepository swarmRepository;

    public SwarmController(){}

    @GetMapping("/all")
    public List<Swarm> getAllSwarm() {
        return this.swarmRepository.findAll();
    }
}
