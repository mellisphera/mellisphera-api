package com.mellisphera.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "WeatherSrcs")
public class WeatherSrcs {

    @Id
    private String _id;
    private String apiaryId;
    private String apiaryName;
    private String userId;
    private String userName;
    private String sourceId;
    private String sourceType;
    private Date start;
    private Date end;
    private String stationId;
    private String APIKey;
    private String APISecret;

    public WeatherSrcs(){}

    public WeatherSrcs(String _id, String apiaryId, String apiaryName, String userId, String userName, String sourceId, String sourceType, Date start, Date end, String stationId, String APIKey, String APISecret){
        this._id = _id;
        this.apiaryId = apiaryId;
        this.apiaryName = apiaryName;
        this.userId = userId;
        this.userName= userName;
        this.sourceId = sourceId;
        this.sourceType = sourceType;
        this.start = start;
        this.end = end;
        this.stationId = stationId;
        this.APIKey = APIKey;
        this.APISecret = APISecret;
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

    public String getApiaryName(){
        return this.apiaryName;
    }

    public void setApiaryName(String apiaryName){
        this.apiaryName = apiaryName;
    }

    public String getUserId(){
        return this.userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getSourceId(){
        return this.sourceId;
    }

    public void setSourceId(String sourceId){
        this.sourceId = sourceId;
    }

    public String getSourceType(){
        return this.sourceType;
    }

    public void setSourceType(String sourceType){
        this.sourceType = sourceType;
    }

    public Date getStart(){
        return this.start;
    }

    public void setStart(Date start){
        this.start = start;
    }

    public Date getEnd(){
        return this.end;
    }

    public void setEnd(Date end){
        this.end = end;
    }

    public String getStationId(){
        return this.stationId;
    }

    public void setStationId(String stationId){
        this.stationId = stationId;
    }

    public String getAPIKey(){
        return this.APIKey;
    }

    public void setAPIKey(String APIKey){
        this.APIKey = APIKey;
    }

    public String getAPISecret(){
        return this.APISecret;
    }

    public void setAPISecret(String APISecret){
        this.APISecret = APISecret;
    }
}