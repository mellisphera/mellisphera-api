package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.SoldDevices;

public interface SoldDevicesRepository extends MongoRepository<SoldDevices,String> {

	List<SoldDevices> findSoldDevicesBySensorRef(String sensorRef);
        
        List<SoldDevices> findSoldDevicesBySoldTo(String soldTo);
	
}
