package com.mellisphera.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ForecastIndex")
public class ForecastIndex {

    @Id
    private String _id;
    private String apiaryId;
    private Date date;
    private float flightIdx;
    private float nectarIdx;
    private String origin;

    public ForecastIndex(){}

    public ForecastIndex(String _id, String apiaryId, Date date, float flightIdx, float nectarIdx, String origin){
        this._id = _id;
        this.apiaryId = apiaryId;
        this.date = date;
        this.flightIdx = flightIdx;
        this.nectarIdx = nectarIdx;
        this.origin = origin;
    }

    public String get_id(){
        return this._id;
    }

    public void set_id(String id){
        this._id = id;
    }

    public String getApiaryId(){
        return this.apiaryId;
    }

    public void setApiaryId(String apiaryId){
        this.apiaryId = apiaryId;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public float getFlightIdx(){
        return this.flightIdx;
    }

    public void setFlightIdx(float flightIdx){
        this.flightIdx = flightIdx;
    }

    public float getNectarIdx(){
        return this.nectarIdx;
    }

    public void setNectarIdx(float nectarIdx){
        this.nectarIdx = nectarIdx;
    }

    public String getOrigin(){
        return this.origin;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }
}