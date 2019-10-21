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

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.Hive;
import com.mellisphera.entities.Note;
import com.mellisphera.entities.Sensor;
import com.mellisphera.entities.bm.*;
import com.mellisphera.repositories.HivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BmDataToMellispheraData {

    @Autowired
    private HivesRepository hiveRepository;

    public BmDataToMellispheraData() {}

    public Note getNewNote(BmNote bmNote) {
        return new Note(bmNote.getNoteId(),
                this.convertTimestampToDate(bmNote.getCreateDate()),
                bmNote.getType(),
                bmNote.getTags(),
                bmNote.getDescription(),
                bmNote.getHiveId(),
                bmNote.getApiaryId(),
                this.checkObsHiveOrApiary(bmNote),
                this.convertTimestampToDate(bmNote.getOpsDate()),
                bmNote.getApiaryId());
    }

    public Hive getNewHive(BmHive bmHive, String username, String userId) {
        Hive newHive = new Hive();
        newHive.set_id(bmHive.getHiveId());
        newHive.setHivePosY(0);
        newHive.setHivePosX(0);
        newHive.setApiaryId(bmHive.getApiaryId());
        newHive.setUserId(userId);
        newHive.setCreateDate(this.convertTimestampToDate(bmHive.getCreateDate()));
        newHive.setHidden(bmHive.getHidden());
        newHive.setDataLastReceived(this.convertTimestampToDate(bmHive.getDataLastReceived()));
        newHive.setName(bmHive.getName());
        newHive.setUsername(username);
        newHive.setName(bmHive.getName());
        return newHive;
    }

    private String checkObsHiveOrApiary(BmNote note) {
        if (note.getHiveId() != null) {
            return "HiveObs";
        } else {
            return "ApiaryObs";
        }
    }

    public Sensor getNewSensorFromFirstConnection(BmSensor bmSensor, String userId, BmHive bmHive) {
        System.out.println(bmSensor.getDevice());
        Sensor sensor = new Sensor();
        sensor.set_id(bmSensor.getDevice().getDeviceId());
        sensor.setHiveId(bmHive.getHiveId());
        sensor.setCreateDate(this.convertTimestampToDate(bmSensor.getDevice().getCreateDate()));
        sensor.setDataLastReceived(this.convertTimestampToDate(bmSensor.getDevice().getDataLastReceived()));
        sensor.setSensorRef(bmSensor.getDevice().getDeviceAddress());
        sensor.setModel(bmSensor.getDevice().getModel());
        sensor.setName(bmSensor.getDevice().getName());
        sensor.setUserId(userId);
        sensor.setHiveName(bmHive.getName());
        sensor.setDeviceLocation(null);
        sensor.setApiaryId(bmHive.getApiaryId());
        sensor.setType(this.getTypeByRef(bmSensor.getDevice().getDeviceAddress()));

        return sensor;
    }

    public Sensor getNewSensorFromChangeLog(BmDevice bmDevice, String userId) {
        Hive hive = this.hiveRepository.findById(bmDevice.getCurrentLocation().getHiveId()).get();
        System.out.println(bmDevice.getDeviceId());
        Sensor sensor = new Sensor();
        sensor.set_id(bmDevice.getDeviceId());
        sensor.setHiveId(hive.get_id());
        sensor.setCreateDate(this.convertTimestampToDate(bmDevice.getCreateDate()));
        sensor.setDataLastReceived(this.convertTimestampToDate(bmDevice.getDataLastReceived()));
        sensor.setSensorRef(bmDevice.getDeviceAddress());
        sensor.setModel(bmDevice.getModel());
        sensor.setName(bmDevice.getName());
        sensor.setUserId(userId);
        sensor.setHiveName(hive.getName());
        sensor.setDeviceLocation(
                new DeviceLocation(bmDevice.getCurrentLocation().getDeviceLocationId(),
                        bmDevice.getDeviceId(),
                        hive.get_id(),
                        bmDevice.getCurrentLocation().getHivePositionId(),
                        bmDevice.getCurrentLocation().getStart()));
        sensor.setApiaryId(hive.getApiaryId());
        sensor.setType(this.getTypeByRef(bmDevice.getDeviceAddress()));
        return sensor;
    }

    private String getTypeByRef(String ref) {
        String prefix = ref.split(":")[0];
        if (prefix.equals("41")) {
            return "T2";
        } else if (prefix.equals("42")) {
            return "T_HR";
        } else if (prefix.equals("43")) {
            return "WEIGHT";
        } else {
            return "ALIEN";
        }
    }


    public Apiary getNewApiary(BmApiary bmApiary, String username) {
        Apiary newApiary = new Apiary();
        newApiary.set_id(bmApiary.getApiaryId());
        newApiary.setZipCode(bmApiary.getZipCode());
        newApiary.setName(bmApiary.getName());
        newApiary.setUserId(bmApiary.getUserId());
        newApiary.setCreateDate(this.convertTimestampToDate(bmApiary.getCreateDate()));
        newApiary.setDataLastReceived(this.convertTimestampToDate(bmApiary.getDataLastReceived()));
        newApiary.setPrivateApiary(bmApiary.getPrivateApiary());
        newApiary.setCountryCode(bmApiary.getCountryCode());
        newApiary.setUsername(username);
        newApiary.setPhoto("./assets/imageClient/testAccount.png");
        return newApiary;
    }

    public Date convertTimestampToDate(long time){
        return new Date(time*1000);
    }


}
