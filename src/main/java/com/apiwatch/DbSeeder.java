package com.apiwatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.FlowerINRA;
import com.apiwatch.entities.FlowerAPI;
import com.apiwatch.entities.FlowerITSAP;
import com.apiwatch.entities.TheoricalFlower;
import com.apiwatch.entities.Hive;
import com.apiwatch.entities.ObservedFlower;
import com.apiwatch.entities.Record;
import com.apiwatch.entities.Sensor;
import com.apiwatch.entities.SoldDevices;
import com.apiwatch.entities.User;
import com.apiwatch.entities.DailyStockHoney;
import com.apiwatch.repositories.ApiaryRepository;
import com.apiwatch.repositories.DailyWeatherRepository;
import com.apiwatch.repositories.FlowerINRARepository;
import com.apiwatch.repositories.TheoricalFlowerRepository;
import com.apiwatch.repositories.HivesRepository;
import com.apiwatch.repositories.HourlyWeatherRepository;
import com.apiwatch.repositories.ObservedFlowerRepository;
import com.apiwatch.repositories.PostRepository;
import com.apiwatch.repositories.ProcessReportRepository;
import com.apiwatch.repositories.SensorRepository;
import com.apiwatch.repositories.SoldDevicesRepository;
import com.apiwatch.repositories.UserRepository;
import com.apiwatch.repositories.DailyStockHoneyRepository;

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
