/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 


package com.mellisphera.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import com.mellisphera.entities.Inspection;


@Service
@Repository
public interface InspectionRepository extends MongoRepository<Inspection ,String>{

    Inspection findInspectionBy_id(String _id);

    List<Inspection> findInspectionsByUserId(String userId);

    List<Inspection> findInspectionByApiaryInspId(String apiaryInspId);

    List<Inspection> findInspectionByApiaryInspIdAndCreateDateBetween(String apiaryInspId, Date create_start, Date create_end, Sort sort);

    List<Inspection> findInspectionByApiaryInspIdAndOpsDateBetween(String apiaryInspId, Date ops_start, Date ops_end, Sort sort);

    List<Inspection> findInspectionByApiaryId(String apiaryId);

    Inspection findInspectionByApiaryIdAndCreateDate(String apiaryId, Date create_date);

    List<Inspection> findInspectionByApiaryIdAndCreateDateBetween(String apiaryId, Date create_start, Date create_end, Sort sort);

    List<Inspection> findInspectionByApiaryIdAndOpsDateBetween(String apiaryId, Date ops_start, Date ops_end, Sort sort);

    List<Inspection> findInspectionByCreateDate(Date createDate);

    List<Inspection> findInspectionByCreateDateBetween(Date create_start, Date create_end, Sort sort);

    List<Inspection> findInspectionByOpsDate(Date opsDate);
    
    List<Inspection> findInspectionByOpsDateBetween(Date ops_start, Date ops_end, Sort sort);

    List<Inspection> findInspectionByHiveId(String hiveId);

    List<Inspection> findInspectionByHiveIdAndCreateDate(String hiveId, Date create_date);

    List<Inspection> findInspectionByHiveIdAndCreateDateBetween(String hiveId, Date create_start, Date create_end, Sort sort);

    List<Inspection> findInspectionByHiveIdAndOpsDateBetween(String hiveId, Date ops_start, Date ops_end, Sort sort);

    List<Inspection> findInspectionByType(String type);

    List<Inspection> findInspectionByTypeAndCreateDateBetween(String type, Date create_start, Date create_end, Sort sort);

    List<Inspection> findInspectionByTypeAndOpsDateBetween(String type, Date ops_start, Date ops_end, Sort sort);
    
    void deleteBy_idIn(List<String> ids);
}
