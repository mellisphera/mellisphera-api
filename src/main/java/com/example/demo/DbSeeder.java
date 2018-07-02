package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.controllers.FlowerAPIController;
import com.example.demo.entities.Record;
import com.example.demo.entities.Apiary;
import com.example.demo.entities.ObservedFlower;
import com.example.demo.entities.Flower;
import com.example.demo.entities.Hive;
import com.example.demo.entities.FlowerAPI;
import com.example.demo.entities.User;
import com.example.demo.entities.Sensor;
import com.example.demo.entities.SoldDevice;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.ApiaryRepository;
import com.example.demo.repositories.FleurTheoriqueRepository;
import com.example.demo.repositories.HivesRepository;
import com.example.demo.repositories.HourlyWeatherRepository;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.SensorRepository;
import com.example.demo.repositories.DailyWeatherRepository;
import com.example.demo.repositories.SoldDeviceRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
	
	@Autowired private FlowerAPIController fleurTheoController;
	
	
	//WeatherController wc;
	
    public DbSeeder() {
    }

    public DbSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
   

    @Override
    public void run(String... args) throws Exception {
    	
    	this.userRepository.deleteAll();
    	this.fleurTheoriqueRepository.deleteAll();
    	this.apiaryRepository.deleteAll();
    	this.HivesRepository.deleteAll();
    	this.SensorRepository.deleteAll();
    	this.SensorRepository.deleteAll();
    	this.PostsRepository.deleteAll();
    	this.HourlyWeatherRepository.deleteAll();
    	this.DailyWeatherRepository.deleteAll();
    	this.SoldDeviceRepository.deleteAll();
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
    	ap4.setId("4");
    	ap4.setLatitude(11.3f);
    	ap4.setLongitude(11.3f);
    	ap4.setName("Mon 2eme Rucher");
    	ap4.setDescription("Le rucher qui se situe à Toronto");
    	ap4.setCodePostal("Toronto");
    	ap4.setUsername("jhe");
    	
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
		
		List<User> users = Arrays.asList(u1,u2,u3,u4);
		
		System.out.println(users);
		
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

		
		this.HivesRepository.save(h1);
		this.HivesRepository.save(h2);
		this.HivesRepository.save(h3);
		
		this.SensorRepository.save(s1);
		this.SensorRepository.save(s2);
		//this.SensorRepository.save(s3);
		
	    this.userRepository.saveAll(users);
	   
    }
}
