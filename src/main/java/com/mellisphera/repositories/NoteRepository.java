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

	List<Note> findByApiaryIdAndOpsDateBetween(String apiaryId, Timestamp start, Timestamp end);
	List<Note> findByIdUsername(String idUsername);
	List<Note> findByHiveIdAndOpsDateBetween(String hiveId, Timestamp start, Timestamp end);
}
