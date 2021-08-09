/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



package com.mellisphera.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.CurrentIndex;

import com.mellisphera.repositories.CurrentIndexRepository;
import com.mellisphera.repositories.SensorRepository;

@Service
@RestController
@PreAuthorize("hasRole('PREMIUM') or hasRole('STANDARD') or hasRole('ADMIN')  or hasRole('TEST')")
@RequestMapping("/currentIndex")
public class CurrentIndexController {

    @Autowired private CurrentIndexRepository currentIdxRepository;
	public CurrentIndexController() {}

    @PostMapping("/apiary/ws/between/{apiaryId}")
    List<CurrentIndex> findByApiaryIdAndDateBetweenWS(@PathVariable String apiaryId, @RequestBody Date[] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.currentIdxRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1], sort)
                                        .stream().filter(elt -> elt.getOrigin().equals("WeatherSource"))
                                        .collect(Collectors.toList());
    }       

    @PostMapping("/apiary/local/between/{apiaryId}")
    List<CurrentIndex> findByApiaryIdAndDateBetweenLocal(@PathVariable String apiaryId, @RequestBody Date[] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.currentIdxRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1], sort)
                                        .stream().filter(elt -> elt.getOrigin().equals("local"))
                                        .collect(Collectors.toList());
    }

    @PostMapping("/apiary/local/sensor/between/{apiaryId}/{sensorRef}")
    List<CurrentIndex> findByApiaryIdAndDateBetweenLocal(@PathVariable String apiaryId, @PathVariable String sensorRef, @RequestBody Date[] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.currentIdxRepository.findByApiaryIdAndSensorRefAndDateBetween(apiaryId, sensorRef, range[0], range[1], sort);
                                        //.stream().filter(elt -> elt.getOrigin().equals("local"))
                                        //.collect(Collectors.toList());
    }
}