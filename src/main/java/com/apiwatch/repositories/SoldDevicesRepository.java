package com.apiwatch.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.entities.SoldDevices;

public interface SoldDevicesRepository extends MongoRepository<SoldDevices,String> {

	List<SoldDevices> findSoldDevicesBySensorRef(String sensorRef);
        
        List<SoldDevices> findSoldDevicesBySoldTo(String soldTo);
	
}
