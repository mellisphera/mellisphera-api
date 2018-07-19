package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ObservedFlower;
import com.example.demo.entities.OneObservedFlower;
import com.example.demo.repositories.ObservedFlowerRepository;

@Service
@RestController
@RequestMapping("/flowers")
@CrossOrigin(origins = "http://localhost:4200")
public class ObservedFlowerController {

	@Autowired
    private ObservedFlowerRepository ObservedFlowerRepository;
	
	public ObservedFlowerController (){ 
		
	}
	
	public ObservedFlowerController(ObservedFlowerRepository FleurRepository) {
        this.ObservedFlowerRepository = FleurRepository;
    }

	//Récupère toutes les plantes observées
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
	public List<ObservedFlower> getAllFlowers() {
		List<ObservedFlower> allFlowers=this.ObservedFlowerRepository.findAll();
		
		return allFlowers;
	}
	
	//Find all flowers for one Apiary 
	@RequestMapping(value = "/{username}/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
	public List<ObservedFlower> getAllUserFlowers(@PathVariable String username, @PathVariable String idApiary) {
		List<ObservedFlower> allFlowers=this.ObservedFlowerRepository.findAll();
		List<ObservedFlower> userApiaryFlowers = new ArrayList<>();
		for (ObservedFlower f : allFlowers) {
			if(f.getUsername().equals(username) && f.getIdApiary().equals(idApiary)) {
	    		userApiaryFlowers.add(f);
	    	}
		}
		
		return userApiaryFlowers;
	
	}
	
	
	//Récupères les noms de fleurs du rucher
	@RequestMapping(value = "/namesflowers/{username}/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
	public List<String> getNamesFlowers(@PathVariable String username, @PathVariable String idApiary) {
		List<ObservedFlower> allFlowers=getAllUserFlowers(username,idApiary);
		List<String> noms = new ArrayList<>();
				
		for (ObservedFlower f : allFlowers) {
			if(f.getIdApiary().equals(idApiary)) {
				noms.add(f.getNom());
	    	}
		}
		
		return noms;
	}
	
	//Récupères la date de début et de fin de floraison théorique d'une fleur dans un rucher
	@RequestMapping(value = "/datesthflowers/{username}/{idApiary}/{name}", method = RequestMethod.GET, produces={"application/json"})
	public List< int[] > getDatesThFlowers(@PathVariable String username, @PathVariable String idApiary, @PathVariable String name) {
		List<ObservedFlower> allFlowers=getAllUserFlowers(username,idApiary);
		int dateIntD[] = new int[3];
		int dateIntF[] = new int[3];
		List< int[] > dates = new ArrayList<>();
		int i = 0;
		for (ObservedFlower f : allFlowers) {
			if (f.getNom().equals(name)) {
				dateIntD[0] = i;
				dateIntD[1] = f.getDateThDebut();
				dateIntD[2] = 3;
				
				dateIntF[0] = i;
				dateIntF[1] = f.getDateThFin();
				dateIntF[2] = 3;
				
				dates.add(dateIntD);
				dates.add(dateIntF);
			}
			i++;
		}
		
		return dates;
	}
	
	//Récupères la date de début et de fin de floraison théorique d'une fleur dans un rucher
		@RequestMapping(value = "/datesthflowersd/{username}/{idApiary}/{name}", method = RequestMethod.GET, produces={"application/json"})
		public List< String[] > getDatesThFlowersD(@PathVariable String username, @PathVariable String idApiary, @PathVariable String name) {
			List<ObservedFlower> allFlowers=getAllUserFlowers(username,idApiary);
			String dateIntD[] = new String[2];
			String dateIntF[] = new String[2];
			List< String[] > dates = new ArrayList<>();
			int i = 0;
			for (ObservedFlower f : allFlowers) {
				if (f.getNom().equals(name)) {
					dateIntD[1] = name;
					dateIntD[0] = f.getDateThDebutd();
					
					dateIntF[1] = name;
					dateIntF[0] = f.getDateThFind();
					
					dates.add(dateIntD);
					dates.add(dateIntF);
				}
				i++;
			}
			
			return dates;
		}
	
		
		
	
	//Retourne les dates de début et fin de floraison observées d'une plante pour un utilisateur ,un rucher et une année
	@RequestMapping(value = "/datesobflowers/{username}/{idApiary}/{name}/{annee}", method = RequestMethod.GET, produces={"application/json"})
	public List< int[] > getDatesObFlowers(@PathVariable String username, @PathVariable String idApiary, @PathVariable String name,@PathVariable String annee) {
		List<ObservedFlower> allFlowers=getAllUserFlowers(username,idApiary);
		int dateIntD[] = new int[3];
		int dateIntF[] = new int[3];
		List< int[] > dates = new ArrayList<>();
		int i = 0;

		for (ObservedFlower f : allFlowers) {
			if (f.getNom().equals(name)) {
					if(f.getDateDebut().get(annee) != 0) {
						dateIntD[0] = i;
						dateIntD[1] = f.getDateDebut().get(annee);
						dateIntD[2] = 3;
						
						dates.add(dateIntD);
					}
					if (f.getDateFin().get(annee) != 0) {
						dateIntF[0] = i;
						dateIntF[1] = f.getDateFin().get(annee);
						dateIntF[2] = 3;
						
						dates.add(dateIntF);
					}
			}
			i++;
		}
		return dates;
	}
	
	//Retourne les dates de début et fin de floraison observées d'une plante pour un utilisateur ,un rucher et une année
	@RequestMapping(value = "/datesobflowersd/{username}/{idApiary}/{name}/{annee}", method = RequestMethod.GET, produces={"application/json"})
	public List< String[] > getDatesObFlowersd(@PathVariable String username, @PathVariable String idApiary, @PathVariable String name,@PathVariable String annee) {
		List<ObservedFlower> allFlowers=getAllUserFlowers(username,idApiary);
		String dateIntD[] = new String[2];
		String dateIntF[] = new String[2];
		List< String[] > dates = new ArrayList<>();
		int i = 0;

		for (ObservedFlower f : allFlowers) {
			if (f.getNom().equals(name)) {
					if(!(f.getDateDebutd().get(annee).equals("0"))) {
						dateIntD[1] = name;
						dateIntD[0] = f.getDateDebutd().get(annee);
						
						dates.add(dateIntD);
					}
					if (!(f.getDateFind().get(annee).equals("0"))) {
						dateIntF[1] = name;
						dateIntF[0] = f.getDateFind().get(annee);
						
						dates.add(dateIntF);
					}
			}
			i++;
		}
		return dates;
	}
	
	
		
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable("id") String id){
	    this.ObservedFlowerRepository.deleteById(id);
	 }
	

	 @PostMapping
	 public void insert(@RequestBody ObservedFlower Flower){
	     this.ObservedFlowerRepository.insert(Flower);
	 }
	 
	 //Modifie la date de début floraison observée 
	 @RequestMapping(value = "/updateDeb/{id}/{annee}", method = RequestMethod.PUT) 
	 public void updateDebut(@PathVariable("id") String id, @PathVariable String annee, @RequestBody int dateDebut){ 
		 List<ObservedFlower> flowers= this.ObservedFlowerRepository.findAll();
	 	 for(ObservedFlower f : flowers){
	    	 if(f.getId().equals(id)) {
	    		 f.setDateDebut(annee,dateDebut);
	         	this.ObservedFlowerRepository.save(f);
	         }
	     }
	 }
	 
	//Modifie la date de début floraison observée 
		 @RequestMapping(value = "/updateDebd/{id}/{annee}", method = RequestMethod.PUT) 
		 public void updateDebudt(@PathVariable("id") String id, @PathVariable String annee, @RequestBody String dateDebut){ 
			 List<ObservedFlower> flowers= this.ObservedFlowerRepository.findAll();
		 	 for(ObservedFlower f : flowers){
		    	 if(f.getId().equals(id)) {
		    		 f.setDateDebutd(annee,dateDebut);
		         	this.ObservedFlowerRepository.save(f);
		         }
		     }
		 }
	 
	 //Modifie la date de fin floraison observée 
	 @RequestMapping(value = "/updateFin/{id}/{annee}", method = RequestMethod.PUT) 
	 public void updateFin(@PathVariable("id") String id, @PathVariable String annee, @RequestBody int dateFin){ 
	 	 List<ObservedFlower> flowers= this.ObservedFlowerRepository.findAll();
	 	 for(ObservedFlower f : flowers){
	    	 if(f.getId().equals(id)) {
	    		 f.setDateFin(annee,dateFin);
	         	this.ObservedFlowerRepository.save(f);
	         }
	     }
	     
	 }
	 
	 //Modifie la date de fin floraison observée 
	 @RequestMapping(value = "/updateFind/{id}/{annee}", method = RequestMethod.PUT) 
	 public void updateFind(@PathVariable("id") String id, @PathVariable String annee, @RequestBody String dateFin){ 
	 	 List<ObservedFlower> flowers= this.ObservedFlowerRepository.findAll();
	 	 for(ObservedFlower f : flowers){
	    	 if(f.getId().equals(id)) {
	    		 f.setDateFind(annee,dateFin);
	         	this.ObservedFlowerRepository.save(f);
	         }
	     }
	     
	 }
	 
	 //Modifie la Presence d'une fleur dans un rucher
	 @RequestMapping(value = "/updatePresence/{id}", method = RequestMethod.PUT) 
	 public void updatePresence(@PathVariable("id") String id, @RequestBody String presence){ 
	 	 List<ObservedFlower> flowers= this.ObservedFlowerRepository.findAll();
	     for(ObservedFlower f : flowers){
	    	 if(f.getId().equals(id)) {
	         	f.setPresence(presence);
	         	this.ObservedFlowerRepository.save(f);
	         }
	     }
	 }
	 
	 
	 
	 //ajoute une plante à un rucher s'il elle n'existe pas encore 
	 @RequestMapping(value = "/add/{id}/{annee}", method = RequestMethod.PUT) 
	 public void addFlower(@PathVariable("id") String id, @RequestBody OneObservedFlower flower,@PathVariable String annee){ 
		 List<String> flowers = getNamesFlowers(flower.getUsername(),id);
		 ObservedFlower f = new ObservedFlower();
		 if (!(flowers.contains(flower.getNom()))) {
			 f.setNom(flower.getNom());
			 f.setDateThDebut(flower.getDateThDebut());
			 f.setDateThFin(flower.getDateThFin());
			 f.setDateThDebutd(flower.getDateThDebutd());
			 f.setDateThFind(flower.getDateThFind());
			 f.setUsername(flower.getUsername());
			 f.setPhoto(flower.getPhoto());
			 f.setPresence(" ");
			 f.setIdApiary(id);
			 f.dateDebut = new HashMap<String, Integer>();
			 //On initialise les années de flo début présenté sur le graph
			 f.setDateDebut("2018",0);
			 f.setDateDebut("2019",0);
			 f.setDateDebut("2020",0);
			 f.dateFin = new HashMap<String, Integer>();
			 //On initialise les années de flo fin présenté sur le graph
			 f.setDateFin("2018",0);
			 f.setDateFin("2019",0);
			 f.setDateFin("2020",0);
			 f.dateDebutd = new HashMap<String, String>();
			 f.setDateDebutd("2018","0");
			 f.setDateDebutd("2019","0");
			 f.setDateDebutd("2020","0");
			 f.dateFind = new HashMap<String, String>();
			 f.setDateFind("2018","0");
			 f.setDateFind("2019","0");
			 f.setDateFind("2020","0");
		 	 this.ObservedFlowerRepository.save(f);
		 }
	 }
	 
	 
}
