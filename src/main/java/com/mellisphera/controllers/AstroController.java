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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.Astro;
import com.mellisphera.repositories.AstroRepository;

@RestController
@RequestMapping("/astro")
public class AstroController {
	
	@Autowired private AstroRepository astroRepositroy;
	
	@PostMapping("apiary/{apiaryId}")
	public List<Astro> getAstroByApiary(@PathVariable String apiaryId, @RequestBody Date[] range) {
		return this.astroRepositroy.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1]);
	}

}