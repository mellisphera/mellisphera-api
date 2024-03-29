package com.mellisphera.controllers;

import com.mellisphera.entities.Fitness;
import com.mellisphera.entities.Sensor;
import com.mellisphera.repositories.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.mellisphera.entities.Hive;

@RestController
@RequestMapping("/fitness")
public class FitnessController {

    @Autowired private HiveController hiveController;
    @Autowired private FitnessRepository fitnessRepository;
    private final static String APIARY_DEMO = "SV6gUir5CX95dLKRHRTI";

    private MongoTemplate mongoTemplate;
    public FitnessController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/daily/{userId}/{start}/{end}")
    public List<Fitness> getDailyFintnessByUserId(@PathVariable String userId, @PathVariable long start, @PathVariable long end){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("date").gte(new Date(start)).lt(new Date(end))),
                Aggregation.match(new Criteria().orOperator(Criteria.where("userId").is(userId), Criteria.where("apiaryId").is(APIARY_DEMO)))
        );
        AggregationResults<Fitness> aggregationResults = this.mongoTemplate.aggregate(aggregation, "Fitness", Fitness.class);
        return aggregationResults.getMappedResults();
    }

    @PostMapping(value = "/daily/{hiveId}")
    public List<Fitness> getFitnessByHiveIdAndDateBetween(@PathVariable String hiveId, @RequestBody Date[] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.fitnessRepository.findByHiveIdAndDateBetween(hiveId, range[0], range[1], sort);
    }

    @PostMapping("/daily/apiary/{apiaryId}")
    public List<Fitness> getFitnessByApiaryId(@PathVariable String apiaryId, @RequestBody Date[] range){
        List<Hive> hives = this.hiveController.getAllUserHives(apiaryId);
		List<Fitness> dailyFitness = new ArrayList<>();
		for(Hive h : hives) {
                    try{
                    	List<Fitness> rec = this.getLastDailyRecord(h.get_id(), range);
                    	dailyFitness.add(rec.get(rec.size() - 1));
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                       // e.printStackTrace();
                    }
                    catch(IndexOutOfBoundsException err){
                        //err.printStackTrace();
                    }

		}
		
		return dailyFitness;
    }

    @PostMapping("/last/{hiveId}")
    public List<Fitness> getLastDailyRecord(@PathVariable String hiveId, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.fitnessRepository.findByHiveIdAndDateBetween(hiveId, range[0], range[1], sort);
	}
}
