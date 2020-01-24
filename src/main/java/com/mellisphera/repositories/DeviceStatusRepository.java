package com.mellisphera.repositories;

import com.mellisphera.entities.DeviceStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface DeviceStatusRepository extends MongoRepository<DeviceStatus, String> {

    public List<DeviceStatus> findByUserIdAndOpsDateBetween(String userId, Date start, Date end);
}
