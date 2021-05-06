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

import com.mellisphera.entities.AlertSent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Sort;

public interface AlertSentRepository extends MongoRepository<AlertSent, String>{
	
	public List<AlertSent> findByApiaryId(String apiaryId);
	
	public List<AlertSent> findByHiveId(String hiveid);
	
	public List<AlertSent> findByHiveIdAndOpsDateBetween(String hiveId, Date start, Date end, Sort sort);

	public List<AlertSent> findByApiaryIdAndOpsDateBetween(String apiaryId, Date start, Date end, Sort sort);

	void deleteBy_idIn(List<String> ids);
}
