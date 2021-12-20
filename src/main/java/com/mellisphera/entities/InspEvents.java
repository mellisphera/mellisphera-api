package com.mellisphera.entities;

public class InspEvents {
    private String name;
    private String img;

     public InspEvents(){}

     public InspEvents(String n, String i){
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
