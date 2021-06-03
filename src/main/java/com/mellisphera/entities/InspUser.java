package com.mellisphera.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "InspUser")
public class InspUser {
    @Id
    private String _id;
    private String idUser;
    private InspConf[] inspConf;

    public InspUser(){}

    public InspUser(String _id, String idUser, Object[] inspConf){
        this._id = _id;
        this.idUser = idUser;
        this.inspConf = (InspConf[]) inspConf;
    }

    public String get_id(){
        return this._id;
    }

    public String getIdUser(){
        return this.idUser;
    }

    public void setIdUser(String idUser){
        this.idUser = idUser;
    }

    public InspConf[] getInspConf(){
        return this.inspConf;
    }

    public void setInspConf(InspConf[] inspConf){
        this.inspConf = inspConf;
    }

}
