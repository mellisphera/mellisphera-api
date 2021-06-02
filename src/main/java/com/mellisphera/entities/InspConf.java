package com.mellisphera.entities;

public class InspConf {
    private boolean enable;
    private InspCat inspCat;

    public InspConf(){}

    public InspConf(boolean enable, InspCat inspCat){
        this.enable = enable;
        this.inspCat = inspCat;
    }
    
    public boolean getEnable(){
        return this.enable;
    }

    public void setEnable(boolean enable){
        this.enable = enable;
    }

    public InspCat getInspCat(){
        return this.inspCat;
    }

    public void setInspCat(InspCat inspCat){
        this.inspCat = new InspCat(inspCat);
    }
}