package com.mellisphera.controllers;

import com.mellisphera.entities.Fitness;
import com.mellisphera.repositories.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/fitness")
public class FitnessController {

    @Autowired private FitnessRepository fitnessRepository;


    @GetMapping("/daily/{userId}")
    public List<Fitness> getDailyFintnessByUserId(@PathVariable String userId){
        Date start = new Date();
        start.setDate(new Date().getDate() - 1);
        start.setHours(0);
        start.setMinutes(0);
        return this.fitnessRepository.findByUserIdAndDateBetween(userId, start, new Date());
    }
}
