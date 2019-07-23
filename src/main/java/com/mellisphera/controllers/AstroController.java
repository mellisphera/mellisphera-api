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
	
	@PostMapping("apiary/{idApiary}")
	public List<Astro> getAstroByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.astroRepositroy.findBy_idApiaryAndDateBetween(idApiary, range[0], range[1]);
	}

}