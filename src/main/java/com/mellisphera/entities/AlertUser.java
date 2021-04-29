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



package com.mellisphera.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "AlertUser")
public class AlertUser {

    @Id
    private String _id;
    private String userId;
    private String [] availableFrequency;
    private int dayFrequency;
    private String[] email;
    private Boolean emailEnable;
    private String frequency;
    /* Key: alertId, value: Conf */
    private Map<String , AlertConf> alertConf;
    private Date lastSend;

    public AlertUser(){}

    public AlertUser(String userId, String[] availableFrequency, int dayFrequency, String[] email, Boolean emailEnable, String frequency, Map<String, AlertConf> alertConf, Date lastSend) {
        this._id = _id;
        this.userId = userId;
        this.availableFrequency = availableFrequency;
        this.dayFrequency = dayFrequency;
        this.email = email;
        this.emailEnable = emailEnable;
        this.frequency = frequency;
        this.alertConf = alertConf;
        this.lastSend = lastSend;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getAvailableFrequency() {
        return availableFrequency;
    }

    public void setAvailableFrequency(String[] availableFrequency) {
        this.availableFrequency = availableFrequency;
    }

    public int getDayFrequency() {
        return dayFrequency;
    }

    public void setDayFrequency(int dayFrequency) {
        this.dayFrequency = dayFrequency;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public Boolean getEmailEnable() {
        return emailEnable;
    }

    public void setEmailEnable(Boolean emailEnable) {
        this.emailEnable = emailEnable;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Map<String, AlertConf> getAlertConf() {
        return alertConf;
    }

    public void setAlertConf(Map<String, AlertConf> alertConf) {
        this.alertConf = alertConf;
    }

    public Date getLastSend(){
        return this.lastSend;
    }

    public void setLastSend(Date date){
        this.lastSend = date;
    }
}
