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

import com.mellisphera.entities.InspApiary;

@Service
@Repository
public interface InspApiaryRepository extends MongoRepository<InspApiary ,String>{
	
	InspApiary findInspApiaryBy_id(String _id);

	List<InspApiary> findInspApiaryByApiaryId(String apiaryId);

    InspApiary findInspApiaryByApiaryIdAndDate(String apiaryId, Date date);

    List<InspApiary> findInspApiaryByApiaryIdAndDateBetween(String apiaryId, Date start, Date end, Sort sort);


}