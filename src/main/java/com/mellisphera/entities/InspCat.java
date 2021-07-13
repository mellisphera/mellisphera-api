package com.mellisphera.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "InspCat")
public class InspCat {
    @Id
    private String _id;
    private int code;
    private String name;
    private String img;
    private String type;
    private String[] applies;
    private String[] seasons;
    private boolean custom;
    private String customLabel;


    public InspCat(){}

    public InspCat(String _id, int code, String name, String img, String type, String applies[], String[] seasons, boolean custom, String customLabel){
        this._id = _id;
        this.code = code;
        this.name = name;
        this.img = img;
        this.type = type;
        this.applies = applies.clone();
        this.seasons = seasons.clone();
        this.custom = custom;
        this.customLabel = customLabel;
    }

    public InspCat(String _id, int code, String name, String img, String type, String applies[], String[] seasons){
        this._id = _id;
        this.code = code;
        this.name = name;
        this.img = img;
        this.type = type;
        this.applies = applies.clone();
        this.seasons = seasons.clone();
        this.custom = false;
        this.customLabel = null;
    }


    public InspCat( InspCat inspcat ){
        this._id = inspcat._id;
        this.code = inspcat.getCode();
        this.name = inspcat.getName();
        this.img = inspcat.getImg();
        this.type = inspcat.getType();
        this.applies = inspcat.getApplies().clone();
        this.seasons = inspcat.getSeasons().clone();
        this.custom = inspcat.getCustom();
        this.customLabel = inspcat.getCustomLabel();
    }

    public String get_id(){
        return this._id;
    }

    public int getCode(){
        return this.code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getImg(){
        return this.img;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String[] getApplies(){
        return this.applies;
    }

    public void setApplies(String[] applies){
        this.applies = applies.clone();
    }

    public String[] getSeasons(){
        return this.seasons;
    }

    public void setSeasons(String[] seasons){
        this.seasons = seasons.clone();
    }

    public boolean getCustom(){
        return this.custom;
    }

    public void setCustom(boolean custom){
        this.custom = custom;
    }

    public String getCustomLabel(){
        return this.customLabel;
    }

    public void setCustomLabel(String customLabel){
        this.customLabel = customLabel;
    }

}
