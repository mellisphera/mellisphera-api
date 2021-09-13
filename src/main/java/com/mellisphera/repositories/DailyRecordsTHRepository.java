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

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.DailyRecordsTH;
import com.mellisphera.entities.Record;

@Service
@Repository
public interface DailyRecordsTHRepository extends MongoRepository<DailyRecordsTH ,String>{
	
	List<DailyRecordsTH> findDailyRecordsTHByHiveId(String hiveId);
	
	//DailyRecordsTH findDailyRecordsTHByrecordDate(Date date);
	List<DailyRecordsTH> findOneLastDailyRecordsTHByHiveId(String hiveId);
	
    List<DailyRecordsTH> findByHiveIdAndRecordDateBetween(String hiveId, Date start, Date end, Sort sort);
	List<DailyRecordsTH> findBySensorRefAndRecordDateBetween(String sensorRef, Date start, Date end, Sort sort);

}
