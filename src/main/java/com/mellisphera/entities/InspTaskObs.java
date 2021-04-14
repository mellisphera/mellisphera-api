package com.mellisphera.entities;

public class InspTaskObs {
    private String name;
    private String img;

     public InspTaskObs(){}

     public InspTaskObs(String n, String i){
         this.name = n;
         this.img = i;
     }

     public String getName(){
         return this.name;
     }

     public String getImg(){
         return this.img;
     }

     public void setName(String n){
         this.name = n;
     }

     public void setImg(String i){
         this.img = i;
     }
}
