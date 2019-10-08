package com.mellisphera.entities.bm;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BmData implements Serializable {

    @JsonAlias({"apiaries", "apiaryCreate"})
    private BmApiary[] apiaries;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("modified")
    private int modified;

    @JsonProperty("noteCreate")
    private BmNote[] bmNote;

    @JsonProperty("hiveCreate")
    private BmHive[] bmHive;


    public BmData(BmApiary[] apiaries) {
        this.apiaries = apiaries;
    }

    public BmData() {}

    public BmApiary[] getApiaries() {
        return apiaries;
    }

    public void setApiaries(BmApiary[] apiaries) {
        this.apiaries = apiaries;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getModified() {
        return modified;
    }

    public void setModified(int modified) {
        this.modified = modified;
    }

    public BmNote[] getBmNote() {
        return bmNote;
    }

    public void setBmNote(BmNote[] bmNote) {
        this.bmNote = bmNote;
    }

    public BmHive[] getBmHive() {
        return bmHive;
    }

    public void setBmHive(BmHive[] bmHive) {
        this.bmHive = bmHive;
    }

    @Override
    public String toString() {
        return "BmData{" +
                "apiaries=" + Arrays.toString(apiaries) +
                ", userId='" + userId + '\'' +
                ", modified=" + modified +
                ", bmNote=" + Arrays.toString(bmNote) +
                '}';
    }
}
