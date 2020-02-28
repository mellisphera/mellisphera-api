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



package com.mellisphera.controllers;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mellisphera.entities.Note;
import com.mellisphera.entities.bm.BmNote;
import com.mellisphera.entities.bm.BmNoteCreate;
import com.mellisphera.entities.bm.changeLog.BmNoteUpdated;
import com.mellisphera.repositories.NoteRepository;
import com.mellisphera.security.service.BmServiceImpl;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RestController
@RequestMapping("/report")
public class NoteController {
    public static Log log = LogFactory.getLog(NoteController.class);

	@Autowired
    private NoteRepository noteRepository;
	@Autowired private BmServiceImpl bmService;
	
    public NoteController() {
	    }



    @PreAuthorize("hasRole('ADMIN') or hasRole('STANDARD') or hasRole('PREMIUM')")
    @PostMapping("/insert")
    public Note insert(@RequestBody Note observation){
        String value = "";
        try{
            byte ptext[] = observation.getDescription().getBytes();
            value = new String(ptext, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //
            System.out.println("erreur d'encodage");
            value = observation.getDescription();
        }
        System.out.println(value);
        BmNoteCreate createNote = this.bmService.postNote(new BmNote(
                value,
                new String[]{},
                observation.getHiveId(),
                observation.getApiaryId(),
                observation.getOpsDate().getTime()/1000,
                observation.getType(),
                observation.getCreateDate().getTime() / 1000));

        observation.set_id(createNote.getBmNote().getNoteId());
        return this.noteRepository.insert(observation);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Note> getAll(){
        return this.noteRepository.findAll();
    }
    
    @RequestMapping(value = "/apiary/{idApiary}", method = RequestMethod.POST, produces={"application/json"})
    public List<Note> getReportsApiray(@PathVariable("idApiary") String idApiary, @RequestBody Timestamp[] range){
        List<Note> reports = this.noteRepository.findByApiaryIdAndOpsDateBetween(idApiary, range[0], range[1]).stream().filter(_note -> _note.getType().equals("apiary")).collect(Collectors.toList());
        Collections.reverse(reports);
        return reports;
    }
    
    @GetMapping("/user/{userId}")
    public List<Note> getReportsByUser(@PathVariable String userId) {
        List<Note> noteByApiary = this.noteRepository.findByUserId(userId);
        noteByApiary.sort(Comparator.comparing(o -> o.getOpsDate()));
        return noteByApiary;
    }
    
    @RequestMapping(value = "/hive/{idHive}", method = RequestMethod.POST, produces={"application/json"})
    public List<Note> getReportsHive(@PathVariable("idHive") String idHive, @RequestBody Date[] range){
        List<Note> reportsL = this.noteRepository.findByHiveIdAndOpsDateBetween(idHive, range[0], range[1]);
        return reportsL;
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('STANDARD') or hasRole('PREMIUM')")
    @DeleteMapping("/{id}")
	 public void delete(@PathVariable("id") String id){
	    this.noteRepository.deleteById(id);
	 }

    @PreAuthorize("hasRole('ADMIN') or hasRole('STANDARD') or hasRole('PREMIUM')")
    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String id, @RequestBody Note note){
        try{
            this.bmService.putNote(new BmNote(
                    note.get_id(),
                    note.getDescription(),
                    new String[]{},
                    note.getHiveId(),
                    note.getApiaryId(),
                    note.getOpsDate().getTime()/1000,
                    note.getType(),
                    note.getCreateDate().getTime() / 1000));
        }
        catch (HttpClientErrorException e) {
            log.debug("Note not found bm");
        } finally {
            this.noteRepository.save(note);
        }
    }
   
	
}
