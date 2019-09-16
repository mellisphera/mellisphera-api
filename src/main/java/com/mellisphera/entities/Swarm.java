package com.mellisphera.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "SwarmDb")
public class Swarm {

    /*
    *     "_id" : ObjectId("5d4820b299a003e5d48fadff"),
    "date" : ISODate("2019-04-20T12:04:32.000Z"),
    "weight_fall" : 1.143,
    "t_ext" : 16.833,
    "var_temp" : 1.722,
    "probability" : 0.1,
    "info" : {
        "user" : "lpo",
        "apiary" : "Guindalos",
        "hive" : "R5",
        "sensorRefT" : "42:15:B9",
        "sensorRefW" : "43:11:06"
    },
    "sys" : {
        "city" : "Gelos",
        "lat" : 43.285,
        "lon" : -0.371
    }
    * */

    @Id
    private String _id;
    private Date date;
    private float weight_fall;
    private float t_ext;
    private float var_temp;
    private float probability;
    private Object info;
    private Sys sys;


    public Swarm(String _id,
                 Date date,
                 float weight_fall,
                 float t_ext,
                 float var_temp,
                 float probability,
                 Object info,
                 Sys sys) {

        this.date = date;
        this.weight_fall = weight_fall;
        this.t_ext = t_ext;
        this.var_temp = var_temp;
        this.probability = probability;
        this.info = info;
        this.sys = sys;



    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getWeight_fall() {
        return weight_fall;
    }

    public void setWeight_fall(float weight_fall) {
        this.weight_fall = weight_fall;
    }

    public float getT_ext() {
        return t_ext;
    }

    public void setT_ext(float t_ext) {
        this.t_ext = t_ext;
    }

    public float getVar_temp() {
        return var_temp;
    }

    public void setVar_temp(float var_temp) {
        this.var_temp = var_temp;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }




    public class Sys{

        private String city;
        private float lat;
        private float lon;

        Sys(String city, float lat, float lon) {
            this.city = city;
            this.lat = lat;
            this.lon = lon;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public float getLat() {
            return lat;
        }

        public void setLat(float lat) {
            this.lat = lat;
        }

        public float getLon() {
            return lon;
        }

        public void setLon(float lon) {
            this.lon = lon;
        }
    }

}
