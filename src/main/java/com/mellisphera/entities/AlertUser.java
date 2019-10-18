package com.mellisphera.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "AlertUser")
public class AlertUser {

    @Id
    private String _id;
    private String userId;
    /* Key: alertId, value: Conf */
    private Map<String , AlertConf> alertConf;

    public AlertUser(String _id, String userId, Map<String , AlertConf> alertConf) {
        this._id = _id;
        this.userId = userId;
        this.alertConf = alertConf;
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

    public Map<String , AlertConf>getAlertConf() {
        return alertConf;
    }

    public void setAlertConf(Map<String , AlertConf> alertConf) {
        this.alertConf = alertConf;
    }
}
