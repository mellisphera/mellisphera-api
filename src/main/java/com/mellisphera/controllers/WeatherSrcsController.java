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

import com.mellisphera.entities.WeatherSrcs;
import com.mellisphera.repositories.WeatherSrcsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

@Service
@RestController
@RequestMapping("/weathersrcs")
public class WeatherSrcsController {

    @Autowired private WeatherSrcsRepository wSRepository;
	
    public WeatherSrcsController() {}

    @GetMapping("/_id/{_id}")
    public WeatherSrcs findById(@PathVariable String _id){
	    return this.wSRepository.findWSrcsBy_id(_id);
    }

    @GetMapping("/apiaryId/{apiaryId}")
    public List<WeatherSrcs> findByApiaryId(@PathVariable String apiaryId){
	    return this.wSRepository.findWSrcsByApiaryId(apiaryId);
    }

    @GetMapping("/userId/{userId}")
    public List<WeatherSrcs> findByUserId(@PathVariable String userId){
	    return this.wSRepository.findWSrcsByUserId(userId);
    }

    @PostMapping("/apiaryId/between/{apiaryId}")
    public List<WeatherSrcs> findByApiaryIdAndDateBetween(@PathVariable String apiaryId, @RequestBody Date[] range){
	    return this.wSRepository.findWSrcsByApiaryId(apiaryId)
                                .stream().filter(_ws -> !( (_ws.getEnd() != null && _ws.getEnd().before(range[0])) || (_ws.getStart().after(range[1])) ) )
                                .collect(Collectors.toList());
    }

    @PostMapping("/userId/between/{userId}")
    public List<WeatherSrcs> findByUserIdAndDateBetween(@PathVariable String userId, @RequestBody Date[] range){
	    return this.wSRepository.findWSrcsByUserId(userId)
                                .stream().filter(_ws -> !( (_ws.getEnd() != null && _ws.getEnd().before(range[0])) || (_ws.getStart().after(range[1])) ) )
                                .collect(Collectors.toList());
    }

    @PostMapping("/current/userId/{userId}")
    public List<WeatherSrcs> findCurrentByUserId(@PathVariable String userId){
        return this.wSRepository.findWSrcsByUserId(userId)
                                .stream().filter(_ws -> _ws.getEnd() == null)
                                .collect(Collectors.toList());
    }

    @PostMapping("insert")
    public WeatherSrcs insert(@RequestBody WeatherSrcs ws){
        System.out.println(ws);
	    return this.wSRepository.insert(ws);
    }

    @PutMapping("update")
    public WeatherSrcs update(@RequestBody WeatherSrcs ws){
	    return this.wSRepository.save(ws);
    }

    @PostMapping("delete")
    public void delete(@RequestBody String[] wsIds){
        List<String> ids = Arrays.asList(wsIds);
    	this.wSRepository.deleteBy_idIn(ids);
    }
}