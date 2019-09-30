package com.mellisphera.entities.log;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "Log")
public class LogEvents {

    @Id
    private String _id;
    private Date date;
    private String userId = null;
    private String email;
    private LogType logType;
    private Object args = null;

    public LogEvents(String _id, Date date, String userId, String email, LogType logType, Object args) {
        this._id = _id;
        this.date = date;
        this.email = email;
        this.logType = logType;
        this.args = args;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public Object getArgs() {
        return args;
    }

    public void setArgs(Object args) {
        this.args = args;
    }
}
