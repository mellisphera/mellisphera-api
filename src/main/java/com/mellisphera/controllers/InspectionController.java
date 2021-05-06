package com.mellisphera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Comparator;

import com.mellisphera.entities.Inspection;
import com.mellisphera.repositories.InspectionRepository;

@Service
@RestController
@RequestMapping("/inspection")
@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN') or hasRole('TEST')")
public class InspectionController {

    @Autowired private InspectionRepository inspectionRepository;

    public InspectionController(){}

    @GetMapping(value = "/_id/{_id}")
    public Inspection getInspectionById(@PathVariable String _id){
    	return this.inspectionRepository.findInspectionBy_id(_id);
    }

    @GetMapping(value = "/user/{userId}")
    public List<Inspection> getInspectionsByUser(@PathVariable String userId){
        List<Inspection> inspByApiary = this.inspectionRepository.findInspectionsByUserId(userId);
        inspByApiary.sort(Comparator.comparing(o -> o.getOpsDate()));
        return inspByApiary;
    }

    @GetMapping(value = "/apiaryinspid/{apiaryInspId}")
    public List<Inspection> getInspectionByApiaryInspId(@PathVariable String apiaryInspId){
    	return this.inspectionRepository.findInspectionByApiaryInspId(apiaryInspId);
    }

    @PostMapping(value = "/apiaryinspid/createbetween/{apiaryInspId}")
    public List<Inspection> getInspectionByApiaryInspIdAndCreateDateBetween(@PathVariable String apiaryInspId, @RequestBody Date[] createRange){
        Sort sort = new Sort(Direction.DESC, "timestamp");
    	return this.inspectionRepository.findInspectionByApiaryInspIdAndCreateDateBetween(apiaryInspId, createRange[0], createRange[1], sort);
    }

    @PostMapping(value = "/apiaryinspid/opsbetween/{apiaryInspId}")
    public List<Inspection> getInspectionByApiaryInspIdAndOpsDateBetween(@PathVariable String apiaryInspId, @RequestBody Date[] opsRange){
        Sort sort = new Sort(Direction.DESC, "timestamp");
    	return this.inspectionRepository.findInspectionByApiaryInspIdAndOpsDateBetween(apiaryInspId, opsRange[0], opsRange[1], sort);
    }

    @GetMapping(value = "/apiaryid/{apiaryId}")
    public List<Inspection> getInspectionByApiaryId(@PathVariable String apiaryId){
    	return this.inspectionRepository.findInspectionByApiaryId(apiaryId);
    }

    @PostMapping(value = "/apiaryid/create/{apiaryId}")
    public Inspection getInspectionByApiaryIdAndCreateDate(@PathVariable String apiaryId, @RequestBody Date createDate){
    	return this.inspectionRepository.findInspectionByApiaryIdAndCreateDate(apiaryId, createDate);
    }

    @PostMapping(value = "/apiaryid/createbetween/{apiaryId}")
    public List<Inspection> getInspectionByApiaryIdAndCreateDateBetween(@PathVariable String apiaryId, @RequestBody Date[] createDate){
    	Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.inspectionRepository.findInspectionByApiaryIdAndCreateDateBetween(apiaryId, createDate[0], createDate[1], sort);
    }

    @PostMapping(value = "/apiaryid/opsbetween/{apiaryId}")
    public List<Inspection> getInspectionByApiaryIdAndOpsDateBetween(@PathVariable String apiaryId, @RequestBody Date[] opsDate){
    	Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.inspectionRepository.findInspectionByApiaryIdAndOpsDateBetween(apiaryId, opsDate[0], opsDate[1], sort);
    }

    @GetMapping(value = "/createdate/{date}")
    public List<Inspection> getInspectionByCreateDate(@PathVariable Date date){
    	return this.inspectionRepository.findInspectionByCreateDate(date);
    }

    @PostMapping(value = "/createdate/between/")
    public List<Inspection> getInspectionByCreateDateBetween(@RequestBody Date[] createDate){
    	Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.inspectionRepository.findInspectionByCreateDateBetween(createDate[0], createDate[1], sort);
    }

    @GetMapping(value = "/opsdate/{date}")
    public List<Inspection> getInspectionByOpsDate(@PathVariable Date date){
    	return this.inspectionRepository.findInspectionByOpsDate(date);
    }

    @PostMapping(value = "/opsdate/between")
    public List<Inspection> getInspectionByOpsDateAndDateBetween(@RequestBody Date[] opsDate){
    	Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.inspectionRepository.findInspectionByOpsDateBetween(opsDate[0], opsDate[1], sort);
    }

    @GetMapping(value = "/hiveid/{hiveId}")
    public List<Inspection> getInspectionByHiveId(@PathVariable String hiveId){
    	return this.inspectionRepository.findInspectionByHiveId(hiveId);
    }

    @PostMapping(value = "/hiveid/createbetween/{hiveId}")
    public List<Inspection> getInspectionByHiveIdAndCreateDateBetween(@PathVariable String hiveId, @RequestBody Date[] createDate){
    	Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.inspectionRepository.findInspectionByHiveIdAndCreateDateBetween(hiveId, createDate[0], createDate[1], sort);
    }

    @PostMapping(value = "/hiveid/opsbetween/{hiveId}")
    public List<Inspection> getInspectionByHiveIdAndOpsDateBetween(@PathVariable String hiveId, @RequestBody Date[] opsDate){
    	Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.inspectionRepository.findInspectionByHiveIdAndOpsDateBetween(hiveId, opsDate[0], opsDate[1], sort);
    }

    @GetMapping(value = "/type/{type}")
    public List<Inspection> getInspectionByType(@PathVariable String type){
    	return this.inspectionRepository.findInspectionByType(type);
    }

    @PostMapping(value = "/type/createbetween/{type}")
    public List<Inspection> getInspectionByTypeAndCreateDateBetween(@PathVariable String type, @RequestBody Date[] createDate){
    	Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.inspectionRepository.findInspectionByTypeAndCreateDateBetween(type, createDate[0], createDate[1], sort);
    }

    @PostMapping(value = "/type/opsbetween/{types}")
    public List<Inspection> getInspectionByTypeAndOpsDateBetween(@PathVariable String type, @RequestBody Date[] opsDate){
    	Sort sort = new Sort(Direction.DESC, "timestamp");
        return this.inspectionRepository.findInspectionByTypeAndOpsDateBetween(type, opsDate[0], opsDate[1], sort);
    }

    @PostMapping("/insert/apiary")
    public Inspection insertApiaryInsp(@RequestBody Inspection inspApiary){
    	return this.inspectionRepository.insert(inspApiary);
    }

    @PostMapping("/insert/insp/hive")
    public Inspection insertHiveInsp(@RequestBody Inspection inspHive){
        Inspection apiInsp = this.inspectionRepository.findInspectionByApiaryIdAndCreateDate(inspHive.getApiaryId(), inspHive.getCreateDate());
        inspHive.setApiaryInspId(apiInsp.get_id());
    	return this.inspectionRepository.insert(inspHive);
    }

    @PostMapping("/insert/event/hive")
    public Inspection insertHiveEvent(@RequestBody Inspection eventHive){
    	return this.inspectionRepository.insert(eventHive);
    }

    @PutMapping("/update/{_id}")
    public Inspection updateInsp(@PathVariable String _id, @RequestBody Inspection inspection){
        Inspection i = this.inspectionRepository.findInspectionBy_id(_id);
        inspection.setApiaryInspId(i.getApiaryInspId());
        inspection.setObs(i.getObs());
        inspection.setTasks(i.getTasks());
        inspection.setTodo(i.getTodo());
        return this.inspectionRepository.save(inspection);
    }

    @PostMapping("/delete/hive")
    public void deleteInspHive(@RequestBody String[] inspIds){
        List<String> ids = Arrays.asList(inspIds);
    	this.inspectionRepository.deleteBy_idIn(ids);
    }

}
