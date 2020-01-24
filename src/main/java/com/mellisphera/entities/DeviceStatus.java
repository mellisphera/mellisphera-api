package com.mellisphera.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "DeviceStatus")
public class DeviceStatus {

    private String _id;
    private String userId;
    private String user;
    private String apiaryId;
    private String hiveId;
    private String color;
    private String code;
    private Date opsDate;
    private String sensorRef;

    public DeviceStatus(String _id, String userId, String user, String apiaryId, String hiveId, String color, String code, Date opsDate, String sensorRef) {
        this._id = _id;
        this.userId = userId;
        this.user = user;
        this.apiaryId = apiaryId;
        this.hiveId = hiveId;
        this.color = color;
        this.code = code;
        this.opsDate = opsDate;
        this.sensorRef = sensorRef;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getApiaryId() {
        return apiaryId;
    }

    public void setApiaryId(String apiaryId) {
        this.apiaryId = apiaryId;
    }

    public String getHiveId() {
        return hiveId;
    }

    public void setHiveId(String hiveId) {
        this.hiveId = hiveId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getOpsDate() {
        return opsDate;
    }

    public void setOpsDate(Date opsDate) {
        this.opsDate = opsDate;
    }

    public String getSensorRef() {
        return sensorRef;
    }

    public void setSensorRef(String sensorRef) {
        this.sensorRef = sensorRef;
    }
}
