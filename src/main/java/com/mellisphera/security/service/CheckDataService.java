package com.mellisphera.security.service;


import com.mellisphera.entities.bm.BmApiary;
import com.mellisphera.entities.bm.BmHive;
import com.mellisphera.entities.bm.BmSensor;
import com.mellisphera.security.entities.IntegrityStatus;

public interface CheckDataService {


    IntegrityStatus checkApiary(BmApiary bmApiary);

    IntegrityStatus checkHive(BmHive bmHive);

    IntegrityStatus checkSensor(BmSensor bmSensor);

}
