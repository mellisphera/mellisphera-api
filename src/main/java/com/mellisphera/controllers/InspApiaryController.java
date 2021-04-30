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

import com.mellisphera.entities.InspApiary;
import com.mellisphera.repositories.InspApiaryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
@RestController
@RequestMapping("/inspApiary")
@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN') or hasRole('TEST')")
public class InspApiaryController {

    @Autowired private InspApiaryRepository inspApiaryRepository;

    public InspApiaryController(){}

    @GetMapping(value = "/_id/{_id}")
    public InspApiary getInspApiaryById(@PathVariable String _id){
    	return this.inspApiaryRepository.findInspApiaryBy_id(_id);
    }

    @GetMapping(value = "/apiaryId/{apiaryId}")
    public List<InspApiary> getInspApiaryByApiaryId(@PathVariable String apiaryId){
    	return this.inspApiaryRepository.findInspApiaryByApiaryId(apiaryId);
    }

    @PostMapping(value = "/apiaryId/date/{apiaryId}")
    public InspApiary getInspApiaryByApiaryIdAndDate(@PathVariable String apiaryId, @RequestBody Date date){
    	return this.inspApiaryRepository.findInspApiaryByApiaryIdAndDate(apiaryId, date);
    }

    @PostMapping(value = "/apiaryId/between/{apiaryId}")
    public List<InspApiary> getInspApiaryByApiaryIdAndDateBetween(@PathVariable String apiaryId, @RequestBody Date[] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
    	return this.inspApiaryRepository.findInspApiaryByApiaryIdAndDateBetween(apiaryId, range[0], range[1], sort);
    }

    @PostMapping("")
    public InspApiary insert(@RequestBody InspApiary inspApiary){
    	return this.inspApiaryRepository.insert(inspApiary);
    }


}
    
