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

import java.util.List;
import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.mellisphera.entities.InspHive;

@Service
@Repository
public interface InspHiveRepository  extends MongoRepository<InspHive ,String>{
	
	InspHive findInspHiveBy_id(String _id);

    List<InspHive> findInspHiveByInspId(String inspId);

    List<InspHive> findInspHiveByApiaryId(String apiaryId);

    List<InspHive> findInspHiveByApiaryIdAndDate(String apiaryId, Date date);

    List<InspHive> findInspHiveByApiaryIdAndDateBetween(String apiaryId, Date start, Date end, Sort sort);

    List<InspHive> findInspHiveByHiveId(String hiveId);

    List<InspHive> findInspHiveByHiveIdAndDate(String hiveId, Date date);

    List<InspHive> findInspHiveByHiveIdAndDateBetween(String hiveId, Date start, Date end, Sort sort);

}