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
}
