package com.mellisphera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Comparator;

import com.mellisphera.entities.InspTaskObs;
import com.mellisphera.entities.Inspection;
import com.mellisphera.repositories.InspectionRepository;

import com.mellisphera.entities.bm.BmNote;
import com.mellisphera.entities.bm.BmNoteCreate;
import com.mellisphera.security.service.BmServiceImpl;

@Service
@RestController
@RequestMapping("/inspection")
@PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN') or hasRole('TEST')")
public class InspectionController {

    @Autowired private InspectionRepository inspectionRepository;
    @Autowired private BmServiceImpl bmService;

    @Value("${changelog.update}")
    private Boolean changeLogUpdate;

    public InspectionController(){}

    @GetMapping(value = "/_id/{_id}")
    public Inspection getInspectionById(@PathVariable String _id){
    	return this.inspectionRepository.findInspectionBy_id(_id);
    }

    @GetMapping(value = "/user/{userId}")
    public List<Inspection> getInspectionsByUser(@PathVariable String userId){
        List<Inspection> list = this.inspectionRepository.findInspectionsByUserId(userId);
        List<Inspection> inspByApiary = list.stream().filter(o -> o.getOpsDate() != null).collect(Collectors.toList());
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

    @PostMapping(value = "/filter/{apiaryId}")
    public List<Inspection> getInspectionsByFilters(@PathVariable String apiaryId, @RequestBody ObjectNode body){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        List<String> hiveIds = new ObjectMapper().convertValue(body.get("hiveIds"), ArrayList.class);
        List<String> opsRange = new ObjectMapper().convertValue(body.get("opsRange"), ArrayList.class);
        List<String> types = new ObjectMapper().convertValue(body.get("types"), ArrayList.class);
        List<String> pictos = new ObjectMapper().convertValue(body.get("pictos"), ArrayList.class);
        Boolean showEmpty = new ObjectMapper().convertValue(body.get("empty"),Boolean.class);

        Date start = Date.from( Instant.parse(opsRange.get(0)) );
        Date end = Date.from( Instant.parse(opsRange.get(1)) );
        
        return this.inspectionRepository.findInspectionByApiaryIdAndOpsDateBetween(apiaryId, start, end, sort)
                                        .stream()
                                        .filter(_insp -> hiveIds.contains(_insp.getHiveId()) || _insp.getHiveId() == null)
                                        .filter(_insp -> types.contains(_insp.getType()))
                                        .filter(_insp -> {
                                            boolean found = false;
                                            if(showEmpty && (_insp.getObs() == null || _insp.getObs().length == 0) ){
                                                return true;
                                            }
                                            if(_insp.getObs() != null && _insp.getObs().length > 0){
                                                for(InspTaskObs obs : _insp.getObs()){
                                                    if(pictos.contains(obs.getName())){
                                                        found = true;
                                                    }
                                                }
                                                return found;
                                            }
                                            return false;
                                        })
                                        .collect(Collectors.toList());
        
    }

    @PostMapping("/insert/apiary")
    public Inspection insertApiaryInsp(@RequestBody Inspection inspApiary){
        if(changeLogUpdate){
            this.bmService.postNote(new BmNote(
                    inspApiary.getDescription(),
                    new String[]{},
                    null,
                    inspApiary.getApiaryId(),
                    inspApiary.getOpsDate().getTime()/1000,
                    inspApiary.getType(),
                    inspApiary.getCreateDate().getTime() / 1000));
        }
    	return this.inspectionRepository.insert(inspApiary);
    }

    @PostMapping("/insert/insp/hive")
    public Inspection insertHiveInsp(@RequestBody Inspection inspHive){
        if(changeLogUpdate){
            this.bmService.postNote(new BmNote(
                    inspHive.getDescription(),
                    new String[]{},
                    inspHive.getHiveId(),
                    inspHive.getApiaryId(),
                    inspHive.getOpsDate().getTime()/1000,
                    inspHive.getType(),
                    inspHive.getCreateDate().getTime() / 1000));
        }
    	return this.inspectionRepository.insert(inspHive);
    }

    @PostMapping("/insert/event/hive")
    public Inspection insertHiveEvent(@RequestBody Inspection eventHive){
        if(changeLogUpdate){
            this.bmService.postNote(new BmNote(
                    eventHive.getDescription(),
                    new String[]{},
                    eventHive.getHiveId(),
                    eventHive.getApiaryId(),
                    eventHive.getOpsDate().getTime()/1000,
                    eventHive.getType(),
                    eventHive.getCreateDate().getTime() / 1000));
        }
    	return this.inspectionRepository.insert(eventHive);
    }

    @PutMapping("/update/{_id}")
    public Inspection updateInsp(@PathVariable String _id, @RequestBody Inspection inspection){
        Inspection i = this.inspectionRepository.findInspectionBy_id(_id);
        if(changeLogUpdate){
            this.bmService.putNote(new BmNote(
                inspection.get_id(),
                inspection.getDescription(),
                new String[]{},
                inspection.getHiveId(),
                inspection.getApiaryId(),
                inspection.getOpsDate().getTime()/1000,
                inspection.getType(),
                inspection.getCreateDate().getTime() / 1000));
        }
        return this.inspectionRepository.save(inspection);
    }

    @PostMapping("/delete/hive")
    public void deleteInspHive(@RequestBody String[] inspIds){
        List<String> ids = Arrays.asList(inspIds);
    	this.inspectionRepository.deleteBy_idIn(ids);
    }

}
