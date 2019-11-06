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



package com.mellisphera.security.service;

import com.mellisphera.entities.Hive;
import com.mellisphera.entities.Note;
import com.mellisphera.entities.Swarm;
import com.mellisphera.entities.bm.BmApiary;
import com.mellisphera.entities.bm.BmDevice;
import com.mellisphera.entities.bm.BmHive;
import com.mellisphera.entities.bm.BmNote;
import com.mellisphera.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class BmChangeLogService {

    @Autowired private BmDataToMellispheraData bmToMellispheraData;

    @Autowired private ApiaryRepository apiaryRepository;
    @Autowired private HivesRepository hiveRepository;
    @Autowired private SensorRepository sensorRepository;
    @Autowired private NoteRepository noteRepository;
    @Autowired private UserRepository userRepository;

    public BmChangeLogService() {}

    public void saveApiaryFromBmApiary(BmApiary[] bmApiary, String username, String countryCode) {
        Arrays.stream(bmApiary).map(_apiary -> this.bmToMellispheraData.getNewApiary(_apiary, username, countryCode)).collect(Collectors.toList()).forEach(_newApiary -> {
            boolean apiaryExist = this.apiaryRepository.findById(_newApiary.get_id()).isPresent();
            if (apiaryExist) {
                this.apiaryRepository.save(_newApiary);
            } else {
                this.apiaryRepository.insert(_newApiary);
            }
        });
    }
    public void saveHiveFromBmHive(BmHive[] bmHive, String username, String userId) {
        Arrays.stream(bmHive).map(_hive -> this.bmToMellispheraData.getNewHive(_hive, username, userId)).collect(Collectors.toList()).forEach(_newHive -> {
            boolean hiveExist = this.hiveRepository.findById(_newHive.get_id()).isPresent();
            if (hiveExist) {
                this.hiveRepository.save(_newHive);
            } else {
                this.hiveRepository.insert(_newHive);
            }
        });
    }


    public void saveSensorFronBmDevice(BmDevice[] bmDevices, String userId) {
        Arrays.stream(bmDevices).map(_sensor ->this.bmToMellispheraData.getNewSensorFromChangeLog(_sensor, userId)).collect(Collectors.toList()).forEach(_newSensor -> {
            boolean hiveExist = this.sensorRepository.findById(_newSensor.get_id()).isPresent();
            if (hiveExist) {
                this.sensorRepository.save(_newSensor);
            } else {
                this.sensorRepository.insert(_newSensor);
            }
        });
    }


    public void saveNoteFromBmNote(BmNote[] bmNote) {
        Arrays.stream(bmNote).map(_note -> this.bmToMellispheraData.getNewNote(_note)).collect(Collectors.toList()).forEach(_newNote -> {
            boolean noteExist = this.noteRepository.findById(_newNote.get_id()).isPresent();
            Note note = null;
            note = this.noteRepository.findByOpsDate(_newNote.getOpsDate());
            System.out.println(note);
            if (noteExist || note != null) {
                note = _newNote;
                this.noteRepository.save(note);
            } else {
                this.noteRepository.insert(_newNote);
            }
        });
    }

    private Date convertTimestampToDate(long time){
        return new Date(time*1000);
    }


}
