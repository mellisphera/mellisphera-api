package com.mellisphera.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Inspection")
public class Inspection{
    @Id
    private String _id;
    private String apiaryInspId;
    private String apiaryId;
    private String userId;
    private Date createDate;
    private Date opsDate;
    private String hiveId;
    private String type;
    private String[] tags;
    private String description;
    private InspTaskObs[] tasks;
    private InspTaskObs[] obs; 
    private String todo;
    

    public Inspection(){}

    public Inspection(
        String _id, String apiaryInspId, String apiaryId,
        String userId, Date createDate, Date opsDate,
        String hiveId, String type, String[] tags,
        String description, Object[] tasks, Object[] obs, String todo
    ){

        this._id = _id;
        this.apiaryInspId = apiaryInspId;
        this.apiaryId = apiaryId;
        this.userId = userId;
        this.createDate = createDate;
        this.opsDate = opsDate;
        this.hiveId = hiveId;
        this.type = type;
        this.tags = tags;
        this.description = description;
        this.tasks = (InspTaskObs[]) tasks;
        this.obs = (InspTaskObs[]) obs;
        this.todo = todo;
    }

    public Inspection( Inspection i ){
        this._id = i.get_id();
        this.apiaryInspId = i.getApiaryInspId();
        this.apiaryId = i.getApiaryId();
        this.userId = i.getUserId();
        this.createDate = i.getCreateDate();
        this.opsDate = i.getOpsDate();
        this.hiveId = i.getHiveId();
        this.type = i.getType();
        this.tags = i.getTags();
        this.description = i.getDescription();
        this.tasks = i.getTasks();
        this.obs = i.getObs();
        this.todo = i.getTodo();
    }

    public String get_id(){
        return this._id;
    }

    public void set_id(String _id){
        this._id = _id;
    }

    public String getApiaryInspId(){
        return this.apiaryInspId;
    }

    public void setApiaryInspId(String apiaryInspId){
        this.apiaryInspId = apiaryInspId;
    }

    public String getApiaryId(){
        return this.apiaryId;
    }

    public void setApiaryId(String apiaryId){
        this.apiaryId = apiaryId;
    }

    public String getUserId(){
        return this.userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public Date getCreateDate(){
        return this.createDate;
    }

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public Date getOpsDate(){
        return this.opsDate;
    }

    public void setOpsDate(Date opsDate){
        this.opsDate = opsDate;
    }

    public String getHiveId(){
        return this.hiveId;
    }

    public void setHiveId(String hiveId){
        this.hiveId = hiveId;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String[] getTags(){
        return this.tags;
    }

    public void setTags(String[] tags){
        this.tags = tags;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public InspTaskObs[] getTasks(){
        return this.tasks;
    }

    public void setTasks(InspTaskObs[] tasks){
        this.tasks = tasks;
    }

    public InspTaskObs[] getObs(){
        return this.obs;
    }

    public void setObs(InspTaskObs[] obs){
        this.obs = obs;
    }

    public String getTodo(){
        return this.todo;
    }

    public void setTodo(String todo){
        this.todo = todo;
    }
}
