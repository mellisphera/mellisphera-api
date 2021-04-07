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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.mellisphera.entities.InspHive;
import com.mellisphera.repositories.InspHiveRepository;
import com.mellisphera.entities.InspApiary;
import com.mellisphera.repositories.InspApiaryRepository;
import com.mellisphera.entities.Apiary;
import com.mellisphera.repositories.ApiaryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
@RestController
@RequestMapping("/inspHive")
@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN') or hasRole('TEST')")
public class InspHiveController {

    @Autowired private InspHiveRepository inspHiveRepository;
    @Autowired private InspApiaryRepository inspApiaryRepository;
    @Autowired private ApiaryRepository apiaryRepository;

    public InspHiveController(){}

    @GetMapping(value = "/_id/{_id}")
    public InspHive getInspHiveById(@PathVariable String _id){
    	return this.inspHiveRepository.findInspHiveBy_id(_id);
    }

    @GetMapping(value = "/inspId/{inspId}")
    public List<InspHive> getInspHiveByInspId(@PathVariable String inspId){
    	return this.inspHiveRepository.findInspHiveByInspId(inspId);
    }

    @GetMapping(value = "/apiaryId/{apiaryId}")
    public List<InspHive> getInspHiveByApiaryId(@PathVariable String apiaryId){
    	return this.inspHiveRepository.findInspHiveByApiaryId(apiaryId);
    }

    @PostMapping(value = "/apiaryId/date/{apiaryId}")
    public List<InspHive> getInspHiveByApiaryIdAndDate(@PathVariable String apiaryId, @RequestBody Date date){
    	return this.inspHiveRepository.findInspHiveByApiaryIdAndDate(apiaryId, date);
    }

    @PostMapping(value = "/apiaryId/between/{apiaryId}")
    public List<InspHive> getInspHiveByApiaryIdAndDateBetween(@PathVariable String apiaryId, @RequestBody Date[] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
    	return this.inspHiveRepository.findInspHiveByApiaryIdAndDateBetween(apiaryId, range[0], range[1], sort);
    }

    @GetMapping(value = "/hiveId/{hiveId}")
    public List<InspHive> getInspHiveByHiveId(@PathVariable String hiveId){
    	return this.inspHiveRepository.findInspHiveByHiveId(hiveId);
    }

    @PostMapping(value = "/hiveId/date/{hiveId}")
    public List<InspHive> getInspHiveByHiveIdAndDate(@PathVariable String hiveId, @RequestBody Date date){
    	return this.inspHiveRepository.findInspHiveByHiveIdAndDate(hiveId, date);
    }

    @PostMapping(value = "/hiveId/between/{hiveId}")
    public List<InspHive> getInspHiveByHiveIdAndDateBetween(@PathVariable String hiveId, @RequestBody Date[] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
    	return this.inspHiveRepository.findInspHiveByHiveIdAndDateBetween(hiveId, range[0], range[1], sort);
    }

    @PostMapping("")
    public InspHive insert(@RequestBody InspHive inspHive){
        System.out.println("bonjour hive");
        Apiary a = this.apiaryRepository.findApiaryBy_id(inspHive.getApiaryId());
        inspHive.setInspId(a.get_id());
        System.out.println(inspHive);
        return inspHive;
    	//return this.inspHiveRepository.insert(inspHive);
    }


}