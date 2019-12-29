package com.mellisphera.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Fitness")
public class Fitness {
    @Id
    private String _id;
    private String fitcode;
    private String fitcolor;
    private String userId;
    private Date date;
    private String hiveId;

    public Fitness(String _id, String fitcode, String fitcolor, String userId, Date date, String hiveId) {
        this._id = _id;
        this.fitcode = fitcode;
        this.fitcolor = fitcolor;
        this.userId = userId;
        this.date = date;
        this.hiveId = hiveId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFitcode() {
        return fitcode;
    }

    public void setFitcode(String fitcode) {
        this.fitcode = fitcode;
    }

    public String getFitcolor() {
        return fitcolor;
    }

    public void setFitcolor(String fitcolor) {
        this.fitcolor = fitcolor;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHiveId() {
        return hiveId;
    }

    public void setHiveId(String hiveId) {
        this.hiveId = hiveId;
    }
}
