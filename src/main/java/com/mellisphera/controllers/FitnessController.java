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


    @GetMapping("/daily/{userId}/{start}/{end}")
    public List<Fitness> getDailyFintnessByUserId(@PathVariable String userId, @PathVariable long start, @PathVariable long end){
        return this.fitnessRepository.findByUserIdAndDateBetween(userId, new Date(start), new Date(end));
    }
}
