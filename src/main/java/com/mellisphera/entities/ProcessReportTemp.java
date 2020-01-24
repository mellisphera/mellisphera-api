/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



package com.mellisphera.entities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProcessReportTemp")
public class ProcessReportTemp {

	public String id;
	public String sentence;
	public List<String> ruche;
	public String[] idLHive;
	public String idHive;
	public String idApiary;
	public String type;
	public Date date;
	public String nluScore;
    public String username;

	
	public String getId() {
		return id;
	}
	
	
	public ProcessReportTemp(String id, String sentence, List<String> ruche, String[] idLHive, String idHive,
			String idApiary, String type, Date date) {
		super();
		this.id = id;
		this.sentence = sentence;
		this.ruche = ruche;
		this.idLHive = idLHive;
		this.idHive = idHive;
		this.idApiary = idApiary;
		this.type = type;
		this.date = date;
        // this.username = username;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public List<String> getRuche() {
		return ruche;
	}
	public void setRuche(List<String> ruche) {
		this.ruche = ruche;
	}
	public String[] getIdLHive() {
		return idLHive;
	}
	public void setIdLHive(String[] idLHive) {
		this.idLHive = idLHive;
	}
	public String getIdHive() {
		return idHive;
	}
	public void setIdHive(String idHive) {
		this.idHive = idHive;
	}
	public String getIdApiary() {
		return idApiary;
	}
	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	public String getNluScore() {
		return nluScore;
	}

        public String getUsername(){
            return username;
        }
        
        public void setUsername(String username){
            this.username = username;
        }
	public void setNluScore(String nluScore) {
		this.nluScore = nluScore;
	}
	
	

}
