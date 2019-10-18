package com.mellisphera.controllers;

import com.mellisphera.entities.AlertUser;
import com.mellisphera.entities.AlertConf;
import com.mellisphera.repositories.AlertUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alertsConf")
public class AlertConfController {

    @Autowired private AlertUserRepository alertUserRepository;

    @GetMapping("/{userId}")
    public AlertUser getConfByUser(@PathVariable String userId) {
        return this.alertUserRepository.findByUserId(userId);
    }

    @PutMapping("/update/{userId}/{alertId}")
    public String updateConf(@PathVariable String userId, @PathVariable String alertId, @RequestBody AlertConf alert) {
        AlertUser alertUser = this.alertUserRepository.findByUserId(userId);
        alertUser.getAlertConf().put(alertId, alert);
        this.alertUserRepository.save(alertUser);
        return alertId + "updated";
    }
}
