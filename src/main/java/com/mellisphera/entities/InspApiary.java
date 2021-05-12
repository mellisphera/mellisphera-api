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

import java.io.File;
import java.util.Date;
import java.util.List;

//import InspTaskObs;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "InspApiary")
public class InspApiary {

    @Id
    private String _id;
    private Date date;
    private String apiaryId;
    private Object[] tasks;
    private Object[] obs;
    private String notes;
    private String todo;

    public InspApiary() {}

    public InspApiary(String _id, Date date, String apiaryId, Object[] tasks, Object[] obsv, String notes, String todo){
        this._id = _id;
        this.date = date;
        this.apiaryId = apiaryId;
        this.tasks = tasks.clone();
        this.obs = obsv.clone();
        this.notes = notes;
        this.todo = todo;
        System.out.println(tasks);
    }

    public String get_id(){
        return this._id;
    }

    public Date getDate(){
        return this.date;
    }

    public String getApiaryId(){
        return this.apiaryId;
    }

    public Object[] getTasks(){
        return this.tasks;
    }

    public Object[] getObs(){
        return this.obs;
    }

    public String getNotes(){
        return this.notes;
    }

    public String getTodo(){
        return this.todo;
    }

    public void set_id(String _id){
        this._id = _id;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setApiaryId(String apiaryId){
        this.apiaryId = apiaryId;
    }

    public void setTasks(Object[] tasks){
        this.tasks = tasks.clone();
    }

    public void setObs(Object[] obsv){
        this.obs = obsv.clone();
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

    public void setTodo(String todo){
        this.todo = todo;
    }

    /*@Override
	public String toString() {
        String res;
        res = "InspApiary{" +
              "_id='" + _id + '\'' +
              ", date='" + date + '\'' +
              ", apiaryId='" + apiaryId + '\'';

        res += ", tasks=[ ";
        for(InspTaskObs s : tasks){
            res += "'{ name: " + s.getName() + ", img: "+ s.getImg() + "}' ,";
        }
        res += " ]";
        res += ", obs=[ ";
        for(InspTaskObs s : obs){
            res += "'{ name: " + s.getName() + ", img: "+ s.getImg() + "}' ,";
        }
        res += " ]";
        res += ", notes='" + notes + '\'' +
               ", todo='" + todo + '\'' +
               '}';
		return res;
	}
*/
}