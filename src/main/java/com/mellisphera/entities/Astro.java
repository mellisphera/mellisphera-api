package com.mellisphera.entities;

import java.util.Date;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Astro")
public class Astro {

	/*{
    "_id" : ObjectId("5d14e6fdead598b6dd490d47"),
    "date" : ISODate("2018-01-01T00:00:00.000Z"),
    "moon" : {
        "phase_name" : "WAXING_GIBBOUS",
        "ascendant" : 1
    },
    "sys" : {
        "dawn" : ISODate("2018-01-01T12:20:32.000Z"),
        "dusk" : ISODate("2018-01-01T22:37:11.000Z"),
        "noon" : ISODate("2018-01-01T17:28:51.000Z"),
        "sunrise" : ISODate("2018-01-01T12:51:47.000Z"),
        "sunset" : ISODate("2018-01-01T22:05:56.000Z"),
        "city" : "Chagrin Falls"
    },
    "apiary" : "DSOhio",
    "_idApiary" : ObjectId("5cdc38ffdc7d27578d9c8447"),
    "_class" : "<class 'fonctions4DailyAstro.Astronomy'>"
}
	 * */
	
	private String _id;
	private Date date;
	private Map<String, Object> moon;
	private Map<String, Object> sys;
	private String apiary;
	private String _idApiary;
	
	public Astro(String _id, Date date, Map<String, Object> moon, Map<String, Object> sys, String apiary,
			String _idApiary) {
		this._id = _id;
		this.date = date;
		this.moon = moon;
		this.sys = sys;
		this.apiary = apiary;
		this._idApiary = _idApiary;
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

	public Map<String, Object> getMoon() {
		return moon;
	}

	public void setMoon(Map<String, Object> moon) {
		this.moon = moon;
	}

	public Map<String, Object> getSys() {
		return sys;
	}

	public void setSys(Map<String, Object> sys) {
		this.sys = sys;
	}

	public String getApiary() {
		return apiary;
	}

	public void setApiary(String apiary) {
		this.apiary = apiary;
	}

	public String get_idApiary() {
		return _idApiary;
	}

	public void set_idApiary(String _idApiary) {
		this._idApiary = _idApiary;
	}
	
	
	
	
	
}
