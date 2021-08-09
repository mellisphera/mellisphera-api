package com.mellisphera.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CurrentIndex")
public class CurrentIndex {

    @Id
    private String _id;
    private String apiaryId;
    private Date date;
    private float flightIdx;
    private float nectarIdx;
    private String sensorType;
    private String sensorRef;
    private String origin;

    public CurrentIndex(){}

    public CurrentIndex(String _id, String apiaryId, Date date, float flightIdx, float nectarIdx, String sensorType, String sensorRef, String origin){
        this._id = _id;
        this.apiaryId = apiaryId;
        this.date = date;
        this.flightIdx = flightIdx;
        this.nectarIdx = nectarIdx;
        this.sensorType = sensorType;
        this.sensorRef = sensorRef;
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

    public String getSensorType(){
        return this.sensorType;
    }

    public void setSensorType(String sensorType){
        this.sensorType = sensorType;
    }

    public String getSensorRef(){
        return this.sensorRef;
    }

    public void setSensorRef(String sensorRef){
        this.sensorRef = sensorRef;
    }

    public String getOrigin(){
        return this.origin;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }
}