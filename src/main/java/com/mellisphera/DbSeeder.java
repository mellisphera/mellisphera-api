package com.mellisphera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.DailyStockHoney;
import com.mellisphera.entities.FlowerAPI;
import com.mellisphera.entities.FlowerINRA;
import com.mellisphera.entities.FlowerITSAP;
import com.mellisphera.entities.Hive;
import com.mellisphera.entities.ObservedFlower;
import com.mellisphera.entities.Record;
import com.mellisphera.entities.Sensor;
import com.mellisphera.entities.SoldDevices;
import com.mellisphera.entities.TheoricalFlower;
import com.mellisphera.entities.User;
import com.mellisphera.repositories.ApiaryRepository;
import com.mellisphera.repositories.DailyStockHoneyRepository;
import com.mellisphera.repositories.FlowerINRARepository;
import com.mellisphera.repositories.HivesRepository;
import com.mellisphera.repositories.ObservedFlowerRepository;
import com.mellisphera.repositories.PostRepository;
import com.mellisphera.repositories.ProcessReportRepository;
import com.mellisphera.repositories.SensorRepository;
import com.mellisphera.repositories.SoldDevicesRepository;
import com.mellisphera.repositories.TheoricalFlowerRepository;
import com.mellisphera.repositories.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
	}
}
