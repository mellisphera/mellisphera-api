package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.SoldDevice;

public interface SoldDeviceRepository extends MongoRepository<SoldDevice,String> {

}
