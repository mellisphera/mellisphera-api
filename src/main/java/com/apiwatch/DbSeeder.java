package com.apiwatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apiwatch.controllers.FlowerAPIController;
import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.Flower;
import com.apiwatch.entities.FlowerAPI;
import com.apiwatch.entities.FlowerITSAP;
import com.apiwatch.entities.FlowerTest;
import com.apiwatch.entities.Hive;
import com.apiwatch.entities.ObservedFlower;
import com.apiwatch.entities.Record;
import com.apiwatch.entities.Sensor;
import com.apiwatch.entities.SoldDevice;
import com.apiwatch.entities.User;
import com.apiwatch.repositories.ApiaryRepository;
import com.apiwatch.repositories.DailyWeatherRepository;
import com.apiwatch.repositories.FleurTheoriqueRepository;
import com.apiwatch.repositories.FlowerTestRepository;
import com.apiwatch.repositories.HivesRepository;
import com.apiwatch.repositories.HourlyWeatherRepository;
import com.apiwatch.repositories.ObservedFlowerRepository;
import com.apiwatch.repositories.PostRepository;
import com.apiwatch.repositories.SensorRepository;
import com.apiwatch.repositories.SoldDeviceRepository;
import com.apiwatch.repositories.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner{
   
	@Autowired private UserRepository userRepository;
	@Autowired private FleurTheoriqueRepository fleurTheoriqueRepository;
	@Autowired private ApiaryRepository apiaryRepository;
	@Autowired private HivesRepository HivesRepository;
	@Autowired private SensorRepository SensorRepository;
	@Autowired private PostRepository PostsRepository;
	@Autowired private HourlyWeatherRepository HourlyWeatherRepository;
	@Autowired private DailyWeatherRepository DailyWeatherRepository;
	@Autowired private SoldDeviceRepository SoldDeviceRepository;
	@Autowired private FlowerTestRepository FlowerTestRepository;
	@Autowired private ObservedFlowerRepository ObservedFlowerRepository;
	@Autowired private FlowerAPIController fleurTheoController;

	
	//WeatherController wc;
	
    public DbSeeder() {
    }

    public DbSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
   

    @Override
    public void run(String... args) throws Exception {
    	/*
    	Cette partie du code est a commenter pour le déploiement en mode PRODUCTION
    	this.userRepository.deleteAll();
    	this.fleurTheoriqueRepository.deleteAll();
    	
    	this.HivesRepository.deleteAll();
    	this.SensorRepository.deleteAll();
    	this.SensorRepository.deleteAll();
    	this.PostsRepository.deleteAll();
    	this.HourlyWeatherRepository.deleteAll();
    	this.DailyWeatherRepository.deleteAll();
    	this.SoldDeviceRepository.deleteAll();
    	this.FlowerTestRepository.deleteAll();
    	this.ObservedFlowerRepository.deleteAll();
    	*/
    	this.fleurTheoriqueRepository.deleteAll();
    	this.DailyWeatherRepository.deleteAll();
    	this.HourlyWeatherRepository.deleteAll();
    	this.apiaryRepository.deleteAll();
    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    	
    	
    	
    	FlowerAPI result = fleurTheoController.getListFleur();
    	
    	//final List<Ruche> listeRuches= Arrays.asList(ruche1);
    	//rucher1.setListeRuches(Arrays.asList(ruche1));
		
    	SoldDevice sd1 = new SoldDevice();
    	sd1.setDateSold(new Date());
    	sd1.setSensorRef("43:10:DA");
    	sd1.setType("weight");
    	sd1.setSoldTo("jhe");
		
    	SoldDevice sd2 = new SoldDevice();
    	sd2.setDateSold(new Date());
    	sd2.setSensorRef("43:10:A2");
    	sd2.setType("T_HR");
    	sd2.setSoldTo("jcp");
    	
    	SoldDevice sd3 = new SoldDevice();
    	sd3.setDateSold(new Date());
    	sd3.setSensorRef("43:10:7E");
    	sd3.setType("weight");
    	sd3.setSoldTo("blg");
       	    	
      	SoldDevice sd4 = new SoldDevice();
      	sd4.setDateSold(new Date());
      	sd4.setSensorRef("43:0A:C7");
      	sd4.setType("weight");
      	sd4.setSoldTo("clo");

    	
    	Apiary ap1 = new Apiary();
    	ap1.setId("1");
    	ap1.setLatitude(11.3f);
    	ap1.setLongitude(11.3f);
    	ap1.setName("Mon 1er rucher");
    	ap1.setDescription("Le rucher qui se situe à Tunis");
    	ap1.setCodePostal("Tunis");
    	ap1.setUsername("jcp");
    	
    	Apiary ap2 = new Apiary();
    	
    	ap2.setId("2");
    	ap2.setLatitude(11.3f);
    	ap2.setLongitude(11.3f);
    	ap2.setName("Mon 2eme Rucher");
    	ap2.setDescription("Le rucher qui se situe à Pau");
    	ap2.setCodePostal("Pau");
    	ap2.setUsername("jcp");
    	
    	Apiary ap3 = new Apiary();
    	ap3.setId("3");
    	ap3.setLatitude(11.3f);
    	ap3.setLongitude(11.3f);
    	ap3.setName("Mon 3eme Rucher");
    	ap3.setDescription("Le rucher qui se situe à Toulouse");
    	ap3.setCodePostal("Toulouse");
    	ap3.setUsername("jcp");
    	
    	Apiary ap4 = new Apiary();
    	ap4.setId("18");
    	ap4.setLatitude(11.3f);
    	ap4.setLongitude(11.3f);
    	ap4.setName("Mon 2eme Rucher");
    	ap4.setDescription("Le rucher qui se situe à Toronto");
    	ap4.setCodePostal("Toronto");
    	ap4.setUsername("jhe");
    	/*
    	Hive h1 = new Hive();
    	h1.setId("1");
    	h1.setName("Ma premiere ruche");
    	h1.setDescription("C'est ma première ruche qui contient près de 1000 abeilles");
    	h1.setIdApiary("1");
    	h1.setUsername("jcp");
    	
    	Hive h2 = new Hive();
    	h2.setId("2");
    	h2.setName("Ruche 2");
    	h2.setDescription("C'est ma 2eme ruche qui contient près de 600 abeilles");
    	h2.setIdApiary("1");
    	h2.setUsername("jcp");
    
    	Hive h3 = new Hive();
    	h3.setName("Ruche dhay3a");
    	h3.setIdApiary(ap2.getId());
    	h3.setUsername("Ali chouereb");
    	
    	Sensor s1 = new Sensor();
    	s1.setId("1");
    	s1.setReference("43:10:DA");
    	s1.setType("weight");
    	s1.setDescription("Capteur de poids de la ruche 1");
    	s1.setIdHive("1");
    	s1.setIdApiary("1");
    	s1.setUsername("jcp");
    	
    	Sensor s2 = new Sensor();
    	s2.setReference("43:10:A2");
    	s2.setType("T_HR");
    	s2.setDescription("Capteur 2 temp");
    	s2.setIdHive("2");
    	s2.setIdApiary("1");
    	s2.setUsername("jcp");
    	
    	Sensor s3 = new Sensor();
    	s3.setReference("0X:12:DA");
    	s3.setType("weight");
    	s3.setDescription("Capteur 3");
    	s3.setIdHive("1");
    	s3.setIdApiary("1");
    	s3.setUsername("jcp");
 */   	
    	
    	User u1 = new User();
		u1.setUsername("blg");	
		u1.setPassword("apis123");
		u1.setCreatedAt(df.parse("12/03/2018 00:00"));
    	
    	User u2 = new User();
		u2.setUsername("blg");
		u2.setPassword("apis123");
		u2.setCreatedAt(df.parse("11/03/2018 00:00"));
		
		User u3 = new User();
		u3.setUsername("clo");
		u3.setPassword("apis123");
		u3.setCreatedAt(df.parse("09/03/2018 00:00"));
		
		User u4 = new User();
		u4.setUsername("jhe");
		u4.setPassword("apis123");
		Date u1Date = new Date();
		u4.setCreatedAt(u1Date);
	
		User u5 = new User();
		u5.setUsername("lpo");
		u5.setPassword("apis123");
		u5.setCreatedAt(df.parse("20/07/2018 00:00"));
		
		
		Flower f4 = new Flower();
		f4.setAutre("");
		f4.setButineur("Bourdons et abeilles");
		f4.setFamille("Malvacées");
		f4.setFlomax(31);
		f4.setFlomin(20);
		f4.setFlomind("05-14");
		f4.setFlomaxd("07-30");
		f4.setForme("oblate");
		f4.setFrancais("Tilleul commun");
		f4.setLatin("Tilia x europaea");
		f4.setIdplante(164);
		f4.setGenre("Tilia");
		f4.setPol_equ(33);
		f4.setPol_pol(24);
		f4.setRemarq("");
		f4.setRessource("Nectar");
		
		FlowerITSAP f4b = new FlowerITSAP();
		f4b.setPeriodemin(22);
		f4b.setPeriodemax(30);
		f4b.setPeriodemind("05-28");
		f4b.setPeriodemaxd("07-23");
		f4b.setIndice_confiance("3");
		f4b.setInteret_nectar("3");
		f4b.setInteret_pollen("2");
		
		FlowerTest f4T = new FlowerTest();
		f4T.setFlowerApi(f4);
		f4T.setFlowerIstap(f4b);
		f4T.setType("Arbres");
		f4T.setPhoto("https://kyle.sig.inra.fr/FLEURS/1150883980tilleul_5.jpg");
		
		
		Flower f5 = new Flower();
		f5.setAutre("");
		f5.setButineur("Abeilles");
		f5.setFamille("Rosacées");
		f5.setFlomax(21);
		f5.setFlomin(11);
		f5.setFlomind("03-12");
		f5.setFlomaxd("06-21");
		f5.setForme("oblate");
		f5.setFrancais("Cerisier");
		f5.setLatin("Prunus cerasus");
		f5.setIdplante(165);
		f5.setGenre("Prunus");
		f5.setPol_equ(32);
		f5.setPol_pol(28);
		f5.setRemarq("");
		f5.setRessource("Pollen");
		
		FlowerITSAP f5b = new FlowerITSAP();
		f5b.setPeriodemin(14);
		f5b.setPeriodemax(21);
		f5b.setPeriodemind("04-02");
		f5b.setPeriodemaxd("06-21");
		f5b.setIndice_confiance("3");
		f5b.setInteret_nectar("2");
		f5b.setInteret_pollen("3");
		
		FlowerTest f5T = new FlowerTest();
		f5T.setFlowerApi(f5);
		f5T.setType("Arbres");
		f5T.setFlowerIstap(f5b);
		f5T.setPhoto("https://kyle.sig.inra.fr/FLEURS/Cerisier4.jpg");

		Flower f6 = new Flower();
		f6.setAutre("");
		f6.setButineur("Abeilles");
		f6.setFamille("Brassicacées");
		f6.setFlomax(22);
		f6.setFlomin(10);
		f6.setFlomind("03-05");
		f6.setFlomaxd("05-28");
		f6.setForme("oblate");
		f6.setFrancais("Colza");
		f6.setLatin("Brassica napus");
		f6.setIdplante(18);
		f6.setGenre("Brassica");
		f6.setPol_equ(25);
		f6.setPol_pol(24);
		f6.setRemarq("Grande culture");
		f6.setRessource("Pollen et nectar");
		
		FlowerITSAP f6b = new FlowerITSAP();
		f6b.setPeriodemin(14);
		f6b.setPeriodemax(35);
		f6b.setPeriodemind("04-02");
		f6b.setPeriodemaxd("08-26");
		f6b.setIndice_confiance("3");
		f6b.setInteret_nectar("3");
		f6b.setInteret_pollen("3");
		
		FlowerTest f6T = new FlowerTest();
		f6T.setFlowerApi(f6);
		f6T.setType("Herbacées");
		f6T.setFlowerIstap(f6b);
		f6T.setPhoto("https://kyle.sig.inra.fr/FLEURS/colza4.jpg");
		
		
		Flower f7 = new Flower();
		f7.setAutre("");
		f7.setButineur("Tous hymenoptères");
		f7.setFamille("Boraginacées");
		f7.setFlomax(51);
		f7.setFlomin(12);
		f7.setFlomind("03-19");
		f7.setFlomaxd("12-17");
		f7.setForme("sphéroïdale");
		f7.setFrancais("Bourrache officinale");
		f7.setLatin("Borago officinalis");
		f7.setIdplante(109);
		f7.setGenre("Borago");
		f7.setPol_equ(39);
		f7.setPol_pol(38);
		f7.setRemarq("Médicinale");
		f7.setRessource("Nectar");
		
		FlowerITSAP f7b = new FlowerITSAP();
		f7b.setPeriodemin(14);
		f7b.setPeriodemax(39);
		f7b.setPeriodemind("04-02");
		f7b.setPeriodemaxd("09-24");
		f7b.setIndice_confiance("3");
		f7b.setInteret_nectar("3");
		f7b.setInteret_pollen("1");
		
		FlowerTest f7T = new FlowerTest();
		f7T.setFlowerApi(f7);
		f7T.setType("Herbacées");
		f7T.setFlowerIstap(f7b);
		f7T.setPhoto("https://kyle.sig.inra.fr/FLEURS/bourrache5.jpg");
		
		Flower f8 = new Flower();
		f8.setAutre("");
		f8.setButineur("Abeilles");
		f8.setFamille("Amaryllidacées");
		f8.setFlomax(21);
		f8.setFlomin(13);
		f8.setFlomind("03-26");
		f8.setFlomaxd("05-21");
		f8.setForme("oblate");
		f8.setFrancais("Ail des ours");
		f8.setLatin("Allium ursinum");
		f8.setIdplante(568);
		f8.setGenre("Allium");
		f8.setPol_equ(29);
		f8.setPol_pol(20);
		f8.setRemarq("");
		f8.setRessource("Réputé");
		
		FlowerITSAP f8b = new FlowerITSAP();
		f8b.setPeriodemin(18);
		f8b.setPeriodemax(26);
		f8b.setPeriodemind("04-30");
		f8b.setPeriodemaxd("06-25");
		f8b.setIndice_confiance("3");
		f8b.setInteret_nectar("3");
		f8b.setInteret_pollen("2");
		
		FlowerTest f8T = new FlowerTest();
		f8T.setFlowerApi(f8);
		f8T.setType("Bulbes");
		f8T.setFlowerIstap(f8b);
		f8T.setPhoto("https://kyle.sig.inra.fr/FLEURS/Allium_ursinum2213.jpg");
		
		Flower f9 = new Flower();
		f9.setAutre("");
		f9.setButineur("Pas d'observations d'insectes");
		f9.setFamille("Renonculacées");
		f9.setFlomax(21);
		f9.setFlomin(3);
		f9.setFlomind("01-15");
		f9.setFlomaxd("05-21");
		f9.setForme("oblate");
		f9.setFrancais("Hellébore noir");
		f9.setLatin("Helleborus niger");
		f9.setIdplante(198);
		f9.setGenre("Helleborus");
		f9.setPol_equ(27);
		f9.setPol_pol(23);
		f9.setRemarq("ornemental");
		f9.setRessource("Réputé");
		
		FlowerITSAP f9b = new FlowerITSAP();
		f9b.setPeriodemin(13);
		f9b.setPeriodemax(49);
		f9b.setPeriodemind("03-26");
		f9b.setPeriodemaxd("12-03");
		f9b.setIndice_confiance("2");
		f9b.setInteret_nectar("2");
		f9b.setInteret_pollen("2");
		
		FlowerTest f9T = new FlowerTest();
		f9T.setFlowerApi(f9);
		f9T.setType("Herbacées");
		f9T.setFlowerIstap(f8b);
		f9T.setPhoto("https://kyle.sig.inra.fr/FLEURS/Hellebore_Noire2.jpg");
		
		Flower f10 = new Flower();
		f10.setAutre("Epine blanche, Noble épine, Bois de mai");
		f10.setButineur("Tous hymenoptères");
		f10.setFamille("Rosacées");
		f10.setFlomax(24);
		f10.setFlomin(14);
		f10.setFlomind("04-01");
		f10.setFlomaxd("06-11");
		f10.setForme("sphéroïdale");
		f10.setFrancais("Aubépine à un style");
		f10.setLatin("Crataegus monogyna");
		f10.setIdplante(27);
		f10.setGenre("Crataegus");
		f10.setPol_equ(39);
		f10.setPol_pol(37);
		f10.setRemarq("Ornemental, porte greffe poirier, tonicardiaque");
		f10.setRessource("Pollen");
		
		FlowerITSAP f10b = new FlowerITSAP();
		f10b.setPeriodemin(14);
		f10b.setPeriodemax(21);
		f10b.setPeriodemind("04-02");
		f10b.setPeriodemaxd("05-21");
		f10b.setIndice_confiance("1");
		f10b.setInteret_nectar("2");
		f10b.setInteret_pollen("0");
		
		FlowerTest f10T = new FlowerTest();
		f10T.setFlowerApi(f10);
		f10T.setType("Arbustres");
		f10T.setFlowerIstap(f10b);
		f10T.setPhoto("https://kyle.sig.inra.fr/FLEURS/Aubepine6.jpg");
		
		Flower f11 = new Flower();
		f11.setAutre("Carouge, Cassie");
		f11.setButineur("Abeilles");
		f11.setFamille("Fabacées");
		f11.setFlomax(24);
		f11.setFlomin(16);
		f11.setFlomind("04-16");
		f11.setFlomaxd("06-11");
		f11.setForme("oblate");
		f11.setFrancais("Robinier faux-acacia");
		f11.setLatin("Robinia pseudoacacia");
		f11.setIdplante(24);
		f11.setGenre("Robinia");
		f11.setPol_equ(30);
		f11.setPol_pol(24);
		f11.setRemarq("");
		f11.setRessource("Nectar");
		
		FlowerITSAP f11b = new FlowerITSAP();
		f11b.setPeriodemin(18);
		f11b.setPeriodemax(26);
		f11b.setPeriodemind("04-30");
		f11b.setPeriodemaxd("06-25");
		f11b.setIndice_confiance("3");
		f11b.setInteret_nectar("3");
		f11b.setInteret_pollen("2");
		
		FlowerTest f11T = new FlowerTest();
		f11T.setFlowerApi(f11);
		f11T.setType("Arbres");
		f11T.setFlowerIstap(f11b);
		f11T.setPhoto("https://kyle.sig.inra.fr/FLEURS/Robinier_Faux_Acacia4.jpg");
		
		
		ObservedFlower fl1 = new ObservedFlower();
		fl1.setId("1");
		fl1.setNom(f5.getFrancais());
		fl1.setDateThDebut(f5.getFlomin());
		fl1.setDateThFin(f5.getFlomax());
		fl1.setDateThDebutd(f5.getFlomind());
		fl1.setDateThFind(f5.getFlomaxd());
		fl1.setPresence(" ");
		fl1.dateDebut = new HashMap<String, Integer>();
		fl1.setDateDebut("2018",5);
		fl1.setDateDebut("2019",0);
		fl1.setDateDebut("2020",0);
		fl1.dateFin = new HashMap<String, Integer>();
		fl1.setDateFin("2018",8);
		fl1.setDateFin("2019",0);
		fl1.setDateFin("2020",0);
		fl1.dateDebutd = new HashMap<String, String>();
		fl1.setDateDebutd("2018","02-02");
		fl1.setDateDebutd("2019","0");
		fl1.setDateDebutd("2020","0");
		fl1.dateFind = new HashMap<String, String>();
		fl1.setDateFind("2018","05-02");
		fl1.setDateFind("2019","0");
		fl1.setDateFind("2020","0");
		fl1.setUsername("jhe");
		fl1.setIdApiary("4");
		fl1.setPhoto(f5T.getPhoto());
		
	    
		//System.out.println(users);
		
		//Load the list of FleurTheoriques in the database
		for (Flower fth : result.getResult()) {
			this.fleurTheoriqueRepository.save(fth);
		}
	
		this.apiaryRepository.save(ap1);
		this.apiaryRepository.save(ap2);
		this.apiaryRepository.save(ap3);
		this.apiaryRepository.save(ap4);
	

		this.SoldDeviceRepository.save(sd1);
		this.SoldDeviceRepository.save(sd2);
		this.SoldDeviceRepository.save(sd3);
		this.SoldDeviceRepository.save(sd4);

	    /*	
		this.HivesRepository.save(h1);
		this.HivesRepository.save(h2);
		this.HivesRepository.save(h3);
		
		this.SensorRepository.save(s1);
		this.SensorRepository.save(s2);
		
		*/
		List<User> users = Arrays.asList(u1,u2,u3,u4);
	    this.userRepository.saveAll(users);

	 
	    this.FlowerTestRepository.save(f4T);
	    this.FlowerTestRepository.save(f5T);
	    this.FlowerTestRepository.save(f6T);
	    this.FlowerTestRepository.save(f7T);
	    this.FlowerTestRepository.save(f8T);
	    this.FlowerTestRepository.save(f9T);
	    this.FlowerTestRepository.save(f10T);
	    this.FlowerTestRepository.save(f11T);
	    
	   // this.ObservedFlowerRepository.save(fl1);
	  
    }
}
