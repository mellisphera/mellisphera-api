package com.mellisphera.entities.bm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BmNoteApiary {

    @JsonProperty("noteId")
    private String noteId;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tags")
    private String[] tags;

    @JsonProperty("apiaryId")
    private String apiaryId;

    public BmNoteApiary(String noteId, long timestamp, String apiaryId, String description, String[] tags) {
        this.noteId = noteId;
        this.timestamp = timestamp;
        this.apiaryId = apiaryId;
        this.description = description;
        this.tags = tags;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApiaryId() {
        return apiaryId;
    }

    public void setApiaryId(String apiaryId) {
        this.apiaryId = apiaryId;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
