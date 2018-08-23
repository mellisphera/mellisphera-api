package com.apiwatch.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import com.apiwatch.entities.ObservedFlower;
import com.apiwatch.entities.OneObservedFlower;
import com.apiwatch.repositories.ObservedFlowerRepository;

@Service
@RestController
@RequestMapping("/flowersOb")
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
public class ObservedFlowerController {

	@Autowired
    private ObservedFlowerRepository observedFlowerRepository;
	
	public ObservedFlowerController (){ 
		
	}
	
	public ObservedFlowerController(ObservedFlowerRepository ObservedFlowerRepository) {
        this.observedFlowerRepository = ObservedFlowerRepository;
    }

	//Récupère toutes les plantes observées
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
	public List<ObservedFlower> getAllFlowers() {
		List<ObservedFlower> allFlowers=this.observedFlowerRepository.findAll();
		
		return allFlowers;
	}
	
	//Find all flowers for one Apiary 
	@RequestMapping(value = "/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
	public List<ObservedFlower> getAllUserFlowers(@PathVariable String idApiary) {
		
		List<ObservedFlower> fleurs =this.observedFlowerRepository.findObservedFlowerByIdApiary(idApiary);
		return fleurs;
	
	}
	
	
	//Récupères les noms de fleurs du rucher
	@RequestMapping(value = "/namesflowers/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
	public List<String> getNamesFlowers(@PathVariable String idApiary) {
		List<ObservedFlower> allFlowers=getAllUserFlowers(idApiary);
		List<String> noms = new ArrayList<>();
				
		for (ObservedFlower f : allFlowers) {
			noms.add(f.getNom());
		}
		
		return noms;
	}
	
	//Récupères la date de début et de fin de floraison théorique d'une fleur dans un rucher
	@RequestMapping(value = "/datesthflowers/{id}/{username}/{idApiary}/{name}", method = RequestMethod.GET, produces={"application/json"})
	public List< int[] > getDatesThFlowers(@PathVariable String id,@PathVariable String username, @PathVariable String idApiary, @PathVariable String name) {
		List<ObservedFlower> allFlowers=getAllUserFlowers(idApiary);
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
		@RequestMapping(value = "/datesthflowersd/{id}", method = RequestMethod.GET, produces={"application/json"})
		public List< String[] > getDatesThFlowersd(@PathVariable String id) {
			List< String[] > dates = new ArrayList<>();
			Date date = new Date(); // your date
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int year = cal.get(Calendar.YEAR);
			String dateIntD[] = new String[2];
			String dateIntF[] = new String[2];
			
			ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);
			dateIntD[1] = flower.getNom();
			dateIntD[0] = year+"-"+flower.getDateThDebutd();
			
			dateIntF[1] = flower.getNom();;
			dateIntF[0] = year+"-"+flower.getDateThFind();
			
			dates.add(dateIntD);
			dates.add(dateIntF);
			return dates;
		}
	
		
		
	
	//Retourne les dates de début et fin de floraison observées d'une plante pour un utilisateur ,un rucher et une année
	@RequestMapping(value = "/datesobflowers/{id}/{username}/{idApiary}/{name}/{annee}", method = RequestMethod.GET, produces={"application/json"})
	public List< int[] > getDatesObFlowers(@PathVariable String id,@PathVariable String username, @PathVariable String idApiary, @PathVariable String name,@PathVariable String annee) {
		List<ObservedFlower> allFlowers=getAllUserFlowers(idApiary);
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
	@RequestMapping(value = "/datesobflowersd/{id}/{annee}", method = RequestMethod.GET, produces={"application/json"})
	public List< String[] > getDatesObFlowersd(@PathVariable String id, @PathVariable String annee) {
		List< String[] > dates = new ArrayList<>();
		Date date = new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		String dateIntD[] = new String[2];
		String dateIntF[] = new String[2];
		
		ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);
		
		if(!(flower.getDateDebutd().get(annee).equals("0"))) {
			dateIntD[1] = flower.getNom();;
			dateIntD[0] = year+"-"+flower.getDateDebutd().get(annee);
			dates.add(dateIntD);
		}
		if (!(flower.getDateFind().get(annee).equals("0"))) {
			dateIntF[1] = flower.getNom();;
			dateIntF[0] = year+"-"+flower.getDateFind().get(annee);
			
			dates.add(dateIntF);
		}
		return dates;
	}
	
	
		
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable("id") String id){
	    this.observedFlowerRepository.deleteById(id);
	 }
	

	 @PostMapping
	 public void insert(@RequestBody ObservedFlower flower){
	     this.observedFlowerRepository.insert(flower);
	 }
	 
	 //Modifie la date de début floraison observée 
	 @RequestMapping(value = "/updateDeb/{id}/{annee}", method = RequestMethod.PUT) 
	 public void updateDebut(@PathVariable("id") String id, @PathVariable String annee, @RequestBody int dateDebut){ 
		 
		 ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);
	 	 flower.setDateDebut(annee,dateDebut);
	 	 this.observedFlowerRepository.save(flower);

	 }
	 
	//Modifie la date de début floraison observée 
	 @RequestMapping(value = "/updateDebd/{id}/{annee}", method = RequestMethod.PUT) 
	 public void updateDebutd(@PathVariable("id") String id, @PathVariable String annee, @RequestBody String dateDebut){ 
		 ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);
	 	 flower.setDateDebutd(annee,dateDebut);
	 	 this.observedFlowerRepository.save(flower);
		 	 
	}
	 
	 //Modifie la date de fin floraison observée 
	 @RequestMapping(value = "/updateFin/{id}/{annee}", method = RequestMethod.PUT) 
	 public void updateFin(@PathVariable("id") String id, @PathVariable String annee, @RequestBody int dateFin){ 
		 
		 ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);
	 	 flower.setDateFin(annee,dateFin);
	 	 this.observedFlowerRepository.save(flower);

	 }
	 
	 //Modifie la date de fin floraison observée 
	 @RequestMapping(value = "/updateFind/{id}/{annee}", method = RequestMethod.PUT) 
	 public void updateFind(@PathVariable("id") String id, @PathVariable String annee, @RequestBody String dateFin){ 
	 	 
	 	 ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);
	 	 flower.setDateFind(annee,dateFin);
	 	 this.observedFlowerRepository.save(flower);

	     
	 }
	 
	 //Modifie la Presence d'une fleur dans un rucher
	 @RequestMapping(value = "/updatePresence/{id}", method = RequestMethod.PUT) 
	 public void updatePresence(@PathVariable("id") String id, @RequestBody String presence){ 
		 ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);

		 flower.setPresence(presence);
      		if (presence.equals("Faible")) {
      			flower.setPoid(0.2);
      			this.observedFlowerRepository.save(flower);
      		} else if (presence.equals("Moyen")) {
      			flower.setPoid(0.6);
      			this.observedFlowerRepository.save(flower);
      		} else {
      			flower.setPoid(1);
      			this.observedFlowerRepository.save(flower);
      		}

	 }
	 
	 
	 
	 //ajoute une plante à un rucher s'il elle n'existe pas encore 
	 @RequestMapping(value = "/add/{id}", method = RequestMethod.PUT) 
	 public void addFlower(@PathVariable("id") String id, @RequestBody OneObservedFlower flower){ 
		 List<String> flowers = getNamesFlowers(id);
		 ObservedFlower f = new ObservedFlower();
		 if (!(flowers.contains(flower.getNom()))) {
			 f.setNom(flower.getNom());
			 f.setDateThDebut(flower.getDateThDebut());
			 f.setDateThFin(flower.getDateThFin());
			 f.setDateThDebutd(flower.getDateThDebutd());
			 f.setDateThFind(flower.getDateThFind());
			 f.setDateThDebutdate(flower.getDateThDebutdate());
			 f.setDateThFindate(flower.getDateThFindate());
			 f.setUsername(flower.getUsername());
			 f.setPhoto(flower.getPhoto());
			 //Par défault on attribut la présence "faible"
			 f.setPresence("Faible");
			 f.setPoid(0.2);
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
		 	 this.observedFlowerRepository.save(f);
		 }
	 }
	 
}
