package com.mellisphera.entities;

public class WeatherStation {

    private boolean activated;
    private String stationId;
    private String key;
    private String secret;

    public WeatherStation(){}

    public WeatherStation(boolean activated, String stationId, String key, String secret){
        this.activated = activated;
        this.stationId = stationId;
        this.key = key;
        this.secret = secret;
    }

    public WeatherStation(WeatherStation ws){
        this.activated = ws.getActivated();
        this.stationId = ws.getStationId();
        this.key = ws.getKey();
        this.secret = ws.getSecret();
    }

    public boolean getActivated(){
        return this.activated;
    }

    public void setActivated(boolean active){
        this.activated = active;
    }

    public String getStationId(){
        return this.stationId;
    }

    public void setStationId(String id){
        this.stationId = id;
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
