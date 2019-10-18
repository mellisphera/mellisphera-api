package com.mellisphera.controllers;

import com.mellisphera.entities.Alerts;
import com.mellisphera.repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertsController {


    @Autowired private AlertRepository alertRepository;


    @GetMapping("/all")
    public List<Alerts> getAllAlerts() {
        return this.alertRepository.findAll();
    }

}
