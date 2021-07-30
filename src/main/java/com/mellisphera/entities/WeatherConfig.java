package com.mellisphera.entities;

public class WeatherConfig {

    private String ref;
    private boolean active;
    private String stationId;
    private String key;
    private String secret;

    public WeatherConfig(String ref, boolean active, String stationId, String key, String secret){
        this.ref = ref;
        this.active = active;
        this.stationId = stationId;
        this.key = key;
        this.secret = secret;
    }

    public String getRef(){
        return this.ref;
    }

    public void setRef(String ref){
        this.ref = ref;
    }

    public boolean getActive(){
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public String getStationId(){
        return this.stationId;
    }

    public void setStationId(String stationId){
        this.stationId = stationId;
    }

    public String getKey(){
        return this.key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getSecret(){
        return this.secret;
    }

    public void setSecret(String secret){
        this.secret = secret;
    }
}