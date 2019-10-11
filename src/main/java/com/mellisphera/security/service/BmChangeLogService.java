package com.mellisphera.security.service;

import com.mellisphera.entities.Hive;
import com.mellisphera.entities.bm.BmApiary;
import com.mellisphera.entities.bm.BmDevice;
import com.mellisphera.entities.bm.BmHive;
import com.mellisphera.entities.bm.BmNote;
import com.mellisphera.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public void saveApiaryFromBmApiary(BmApiary[] bmApiary, String username) {
        Arrays.stream(bmApiary).map(_apiary -> this.bmToMellispheraData.getNewApiary(_apiary, username)).collect(Collectors.toList()).forEach(_newApiary -> {
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
            if (noteExist) {
                this.noteRepository.save(_newNote);
            } else {
                this.noteRepository.insert(_newNote);
            }
        });
    }

}
