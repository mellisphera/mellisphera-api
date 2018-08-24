package com.apiwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.DailyStockHoney;
import com.apiwatch.entities.Hive;
import com.apiwatch.entities.Post;
import com.apiwatch.repositories.ApiaryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RestController
@RequestMapping("/dailyStockMiel")
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
public class DailyStockHoneyController {

}
