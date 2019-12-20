package com.mellisphera.security.service;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.bm.BmApiary;
import com.mellisphera.entities.bm.BmHive;
import com.mellisphera.entities.bm.BmSensor;
import com.mellisphera.repositories.ApiaryRepository;
import com.mellisphera.repositories.HivesRepository;
import com.mellisphera.repositories.SensorRepository;
import com.mellisphera.security.entities.IntegrityStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckDataImpl implements  CheckDataService{

    @Autowired private ApiaryRepository apiaryRepository;
    @Autowired private HivesRepository hiveRepository;
    @Autowired private SensorRepository sensorRepository;
    final private static int CORRECT = 200;
    final private static int NOT_FOUND = 404;
    final private static int INCORRECT_FIELD = 500;


    @Override
    public IntegrityStatus checkApiary(BmApiary bmApiary) {
        if (this.apiaryRepository.existsById(bmApiary.getApiaryId())) {
            Apiary msApiary = this.apiaryRepository.findById(bmApiary.getApiaryId()).get();
            String[] err;
            return new IntegrityStatus(400, new String[]{});

        } else {
            return new IntegrityStatus(400, new String[]{});
        }
    }

    @Override
    public IntegrityStatus checkHive(BmHive bmHive) {
        if (this.hiveRepository.existsById(bmHive.getHiveId())) {
            return new IntegrityStatus(400, new String[]{});

        } else {
            return new IntegrityStatus(400, new String[]{});
        }
    }

    @Override
    public IntegrityStatus checkSensor(BmSensor bmSensor) {
        if (this.sensorRepository.existsById(bmSensor.getDevice().getDeviceId())) {
            return new IntegrityStatus(400, new String[]{});

        } else {
            return new IntegrityStatus(400, new String[]{});
        }
    }
}
