package com.mellisphera.entities.bm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BmNoteHive {

    @JsonProperty("noteId")
    private String nodeId;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("hiveId")
    private String hiveId;

    @JsonProperty("apiaryId")
    private String apiaryId;

    @JsonProperty("description")
    private String description;

    public BmNoteHive(String noteId, long timestamp, String hiveId, String apiaryId, String description) {
        this.nodeId = noteId;
        this.timestamp = timestamp;
        this.hiveId = hiveId;
        this.apiaryId = apiaryId;
        this.description = description;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
