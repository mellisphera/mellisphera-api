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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.mellisphera.entities.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
@Repository
public interface NoteRepository extends MongoRepository<Note,String> {

	List<Note> findNoteByApiaryId(String apiaryId);
	
	List<Note> findNoteByHiveId(String hiveId);

	List<Note> findByApiaryIdAndOpsDateBetween(String apiaryId, Date start, Date end);
	List<Note> findByUserId(String userId);
	List<Note> findByHiveIdAndOpsDateBetween(String hiveId, Date start, Date end);
}
