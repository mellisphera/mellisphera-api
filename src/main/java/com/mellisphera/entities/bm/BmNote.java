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
    private long opsDate;
    @JsonProperty("type")
    private String type;
    @JsonProperty("createDate")
    private long createDate;

    public BmNote()  {}
    public BmNote(String noteId, String description, String[] tags, String hiveId, String apiaryId, long opsDate, String type, long createDate) {
        this.noteId = noteId;
        this.description = description;
        this.tags = tags;
        this.hiveId = hiveId;
        this.apiaryId = apiaryId;
        this.opsDate = opsDate;
        this.type = type;
        this.createDate = createDate;
    }
    public BmNote(String description, String[] tags, String hiveId, String apiaryId, long opsDate, String type, long createDate) {
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

    public long getOpsDate() {
        return opsDate;
    }

    public void setOpsDate(long opsDate) {
        this.opsDate = opsDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
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
