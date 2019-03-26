package com.mellisphera.controllers;

import java.text.Normalizer;
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

import com.mellisphera.entities.ObservedFlower;
import com.mellisphera.entities.OneObservedFlower;
import com.mellisphera.repositories.ObservedFlowerRepository;

@Service
@RestController
@RequestMapping("/flowersOb")
public class ObservedFlowerController {

	@Autowired
    private ObservedFlowerRepository observedFlowerRepository;
	private HashMap<String, String> mois = new HashMap<>() ;
	
	
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
		@RequestMapping(value = "/datesthflowersd/{id}", method = RequestMethod.GET, produces={"application/json"})
		public List< String[]> getDatesThFlowersd(@PathVariable String id) {
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
	
		
	
	public static String stripAccents(String s) 
	{
	    s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    return s;
	}
	
	//Retourne les dates de début et fin de floraison observées d'une plante pour un utilisateur ,un rucher et une année
	@RequestMapping(value = "/datesobflowersd/{id}/{annee}", method = RequestMethod.GET, produces={"application/json"})
	public List< String[]> getDatesObFlowersd(@PathVariable String id, @PathVariable String annee) {
		List< String[] > dates = new ArrayList<>();
		Date date = new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		String dateIntD[] = new String[2];
		String dateIntF[] = new String[2];

		ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);
		
		if(!(flower.getDateDebutd().get(annee).equals(""))) {
			dateIntD[1] = flower.getNom();
			dateIntD[0] = year+"-"+flower.getDateDebutd().get(annee);
			dates.add(dateIntD);
		}
		if (!(flower.getDateFind().get(annee).equals(""))) {
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
	 @RequestMapping(value = "/updateDebd/{id}/{annee}", method = RequestMethod.PUT) 
	 public void updateDebutd(@PathVariable("id") String id, @PathVariable String annee, @RequestBody String dateDebut){ 	//Recupère if, annee & dateDebut	 
		 ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id); // recupère la fleur
		 System.out.println("datD : "+dateDebut);
                 /* Ajout dans map mois -> num */
		 this.mois.put("decembre","12");
		 this.mois.put("novembre","11");
		 this.mois.put("octobre","10");
		 this.mois.put("septembre","09");
		 this.mois.put("août","08");
		 this.mois.put("juillet","07");
		 this.mois.put("juin","06");
		 this.mois.put("mai","05");
		 this.mois.put("avril","04");
		 this.mois.put("mars","03");
		 this.mois.put("fevrier","02");
		 this.mois.put("janvier","01");
		 
		 String[] dateD = new String[2];
		 

		 if (dateDebut.equals("null")) { // param dateDebut = null
			 flower.setDateDebutdate(annee,"");
			 flower.setDateDebutd(annee,"");
		 } else {
			 dateD = dateDebut.split(" ");
			 flower.setDateDebutdate(annee,dateDebut);
			 flower.setDateDebutd(annee,mois.get(dateD[1].toLowerCase())+"-"+dateD[0]);
		 }
	 	 this.observedFlowerRepository.save(flower);
		 	 
	}
	 
	 //Modifie la date de fin floraison observée 
	 @RequestMapping(value = "/updateFind/{id}/{annee}", method = RequestMethod.PUT) 
	 public void updateFind(@PathVariable("id") String id, @PathVariable String annee, @RequestBody String dateFin){ 
	 	 
	 	 ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);
	 	 
	 	System.out.println("datF : "+dateFin);
	 	 
		 this.mois.put("decembre","12");
		 this.mois.put("novembre","11");
		 this.mois.put("octobre","10");
		 this.mois.put("septembre","09");
		 this.mois.put("août","08");
		 this.mois.put("juillet","07");
		 this.mois.put("juin","06");
		 this.mois.put("mai","05");
		 this.mois.put("avril","04");
		 this.mois.put("mars","03");
		 this.mois.put("fevrier","02");
		 this.mois.put("janvier","01");
		 
		 String[] dateF = new String[2];
		 

	 	if (dateFin.equals("null")) {
			 flower.setDateFindate(annee,"");
			 flower.setDateFind(annee,"");
		 } else {
			 dateF = dateFin.split(" ");
			 flower.setDateFindate(annee,dateFin);
			 flower.setDateFind(annee,mois.get(dateF[1].toLowerCase())+"-"+dateF[0]);
		 }
	 	 
	 	 this.observedFlowerRepository.save(flower);

	     
	 }
	 
	 //Modifie la Presence d'une fleur dans un rucher
	 @RequestMapping(value = "/updatePresence/{id}", method = RequestMethod.PUT) 
	 public void updatePresence(@PathVariable("id") String id, @RequestBody String presence){ 
		 ObservedFlower flower = this.observedFlowerRepository.findObservedFlowerById(id);

		 flower.setPresence(presence);
      		if (presence.equals("Faible")) {
      			flower.setPoid(0.2);
      		} else if (presence.equals("Moyen")) {
      			flower.setPoid(0.6);
      		} else {
      			flower.setPoid(1);
      		}


  			this.observedFlowerRepository.save(flower);
	 }
	 
	 
	 
	 //ajoute une plante à un rucher s'il elle n'existe pas encore 
	 @RequestMapping(value = "/add/{id}", method = RequestMethod.PUT) 
	 public void addFlower(@PathVariable("id") String id, @RequestBody OneObservedFlower flower){ 
		 List<String> flowers = getNamesFlowers(id);
		 ObservedFlower f = new ObservedFlower();
		 if (!(flowers.contains(flower.getNom()))) {
			 f.setNom(flower.getNom());
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
			 f.dateDebutd = new HashMap<String, String>();
			 f.setDateDebutd("2018","");
			 f.setDateDebutd("2019","");
			 f.setDateDebutd("2020","");
			 f.dateDebutdate = new HashMap<String, String>();
			 f.setDateDebutdate("2018","");
			 f.setDateDebutdate("2019","");
			 f.setDateDebutdate("2020","");
			 f.dateFind = new HashMap<String, String>();
			 f.setDateFind("2018","");
			 f.setDateFind("2019","");
			 f.setDateFind("2020","");
			 f.dateFindate = new HashMap<String, String>();
			 f.setDateFindate("2018","");
			 f.setDateFindate("2019","");
			 f.setDateFindate("2020","");
		 	 this.observedFlowerRepository.save(f);
		 }
	 }
	 
}
