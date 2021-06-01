package com.mellisphera.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "InspUser")
public class InspUser {
    @Id
    private String _id;
    private String idUser;
    private InspCat[] inspConf;

    private InspUser(String idUser, Object[] inspConf){
        this.idUser = idUser;
        this.inspConf = (InspCat[]) inspConf;
    }

    private String get_id(){
        return this._id;
    }

    private String getIdUser(){
        return this.idUser;
    }

    private void setIdUser(String idUser){
        this.idUser = idUser;
    }

    private InspCat[] getInspCat(){
        return this.inspConf;
    }

    private void setInspCat(Object[] inspConf){
        this.inspConf = (InspCat[]) inspConf;
    }

}
