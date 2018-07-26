package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.entities.SoldDevice;

public interface SoldDeviceRepository extends MongoRepository<SoldDevice,String> {

}
