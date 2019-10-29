package com.mellisphera.entities.bm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BmNoteCreate {


    @JsonProperty("code")
    private String code;

    @JsonProperty("payload")
    private BmNote bmNote;

    public BmNoteCreate(String code, BmNote bmNote) {
        this.code = code;
        this.bmNote = bmNote;
    }

    public BmNoteCreate() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BmNote getBmNote() {
        return bmNote;
    }

    public void setBmNote(BmNote bmNote) {
        this.bmNote = bmNote;
    }

}
