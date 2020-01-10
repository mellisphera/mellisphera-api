package com.mellisphera.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="HubReferences")
public class HubReferences {

    @Id
    private String _id;
    private int hub;
    private String user;
    private Date lastUpload;
    private int working;
    private String userId;
    private String apiaryId;

    public HubReferences(String _id, int hub, String user, Date lastUpload, int working, String userId, String apiaryId) {
        this._id = _id;
        this.hub = hub;
        this.user = user;
        this.lastUpload = lastUpload;
        this.working = working;
        this.userId = userId;
        this.apiaryId = apiaryId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getHub() {
        return hub;
    }

    public void setHub(int hub) {
        this.hub = hub;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getLastUpload() {
        return lastUpload;
    }

    public void setLastUpload(Date lastUpload) {
        this.lastUpload = lastUpload;
    }

    public int getWorking() {
        return working;
    }

    public void setWorking(int working) {
        this.working = working;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApiaryId() {
        return apiaryId;
    }

    public void setApiaryId(String apiaryId) {
        this.apiaryId = apiaryId;
    }
}
