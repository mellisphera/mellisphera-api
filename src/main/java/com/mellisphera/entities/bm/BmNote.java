package com.mellisphera.entities.bm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Date;

public class BmNote {

    @JsonProperty("noteId")
    private String noteId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("tags")
    private String[] tags;
    @JsonProperty("hiveId")
    private String hiveId;
    @JsonProperty("apiaryId")
    private String apiaryId;
    @JsonProperty("opsDate")
    private int opsDate;
    @JsonProperty("type ")
    private String type;
    @JsonProperty("createDate")
    private int createDate;

    public BmNote()  {}
    public BmNote(String noteId, String description, String[] tags, String hiveId, String apiaryId, int opsDate, String type, int createDate) {
        this.noteId = noteId;
        this.description = description;
        this.tags = tags;
        this.hiveId = hiveId;
        this.apiaryId = apiaryId;
        this.opsDate = opsDate;
        this.type = type;
        this.createDate = createDate;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getHiveId() {
        return hiveId;
    }

    public void setHiveId(String hiveId) {
        this.hiveId = hiveId;
    }

    public String getApiaryId() {
        return apiaryId;
    }

    public void setApiaryId(String apiaryId) {
        this.apiaryId = apiaryId;
    }

    public int getOpsDate() {
        return opsDate;
    }

    public void setOpsDate(int opsDate) {
        this.opsDate = opsDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCreateDate() {
        return createDate;
    }

    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "BmNote{" +
                "noteId='" + noteId + '\'' +
                ", description='" + description + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", hiveId='" + hiveId + '\'' +
                ", apiaryId='" + apiaryId + '\'' +
                ", opsDate=" + opsDate +
                ", type='" + type + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
