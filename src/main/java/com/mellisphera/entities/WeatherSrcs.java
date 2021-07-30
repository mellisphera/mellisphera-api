package com.mellisphera.entities;

import java.util.Date;

import com.mellisphera.entities.WeatherConfig;
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
    private String source;
    private Date begin;
    private Date end;
    private WeatherConfig config;

    public WeatherSrcs(){}

    public WeatherSrcs(String _id, String apiaryId, String apiaryName, String userId, String userName, String source, Date begin, Date end, Object wg){
        this._id = _id;
        this.apiaryId = apiaryId;
        this.apiaryName = apiaryName;
        this.userId = userId;
        this.userName= userName;
        this.source = source;
        this.begin = begin;
        this.end = end;
        this.config = (WeatherConfig) wg;
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

    public String getSource(){
        return this.source;
    }

    public void setSource(String source){
        this.source = source;
    }

    public Date getBegin(){
        return this.begin;
    }

    public void setBegin(Date begin){
        this.begin = begin;
    }

    public Date getEnd(){
        return this.end;
    }

    public void setEnd(Date end){
        this.end = end;
    }

    public WeatherConfig getConfig(){
        return this.config;
    }

    public void setConfig(WeatherConfig wg){
        this.config = wg;
    }
}