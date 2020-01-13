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



package com.mellisphera.entities.bm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DeviceLocation implements Serializable {

    @JsonProperty("deviceLocationId")
    private String deviceLocationId;

    @JsonProperty("deviceId")
    private String deviceId;

    @JsonProperty("hiveId")
    private String hiveId;

    @JsonProperty("hivePositionId")
    private String hivePositionId;

    @JsonProperty("start")
    private long start;

    public DeviceLocation(String deviceLocationId, String deviceId, String hiveId, String hivePositionId, long start) {
        this.deviceLocationId = deviceLocationId;
        this.deviceId = deviceId;
        this.hiveId = hiveId;
        this.hivePositionId = hivePositionId;
        this.start = start;
    }

    public  DeviceLocation() {}

    public String getDeviceLocationId() {
        return deviceLocationId;
    }

    public void setDeviceLocationId(String deviceLocationId) {
        this.deviceLocationId = deviceLocationId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getHiveId() {
        return hiveId;
    }

    public void setHiveId(String hiveId) {
        this.hiveId = hiveId;
    }

    public String getHivePositionId() {
        return hivePositionId;
    }

    public void setHivePositionId(String hivePositionId) {
        this.hivePositionId = hivePositionId;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "DeviceLocation{" +
                "deviceLocationId='" + deviceLocationId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", hiveId='" + hiveId + '\'' +
                ", hivePositionId='" + hivePositionId + '\'' +
                ", start=" + start +
                '}';
    }
}
