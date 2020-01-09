package com.mellisphera.controllers;

import com.mellisphera.entities.DeviceStatus;
import com.mellisphera.repositories.DeviceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/deviceStatus")
public class DeviceStatusController {

    @Autowired private DeviceStatusRepository deviceStatusRepository;

    @GetMapping("/user/{userId}/{start}/{end}")
    public List<DeviceStatus> getByUserId(@PathVariable String userId, @PathVariable long start, @PathVariable long end) {
        return this.deviceStatusRepository.findByUserIdAndOpsDateBetween(userId, new Date(start), new Date(end));
    }
}
