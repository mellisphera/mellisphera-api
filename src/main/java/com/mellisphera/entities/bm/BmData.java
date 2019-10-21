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

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mellisphera.entities.bm.changeLog.BmApiaryUpdated;
import com.mellisphera.entities.bm.changeLog.BmHiveUpdated;
import com.mellisphera.entities.bm.changeLog.BmNoteUpdated;
import com.mellisphera.entities.bm.changeLog.BmSensorUpdated;

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

    /* For Change Log */

    // Upated
    @JsonProperty("apiaryUpdate")
    private BmApiaryUpdated[] apiaryUpdate;

    @JsonProperty("hiveUpdate")
    private BmHiveUpdated[] hiveUpdate;

    @JsonProperty("deviceUpdate")
    private BmSensorUpdated[] deviceUpdate;

    @JsonProperty("noteUpdate")
    private BmNoteUpdated[] noteUpdate;

    // Create
    @JsonProperty("deviceCreate")
    private BmDevice[] devicesCreate;

    @JsonProperty("noteCreate")
    private BmNote[] bmNoteCreate;

    @JsonProperty("hiveCreate")
    private BmHive[] bmHiveCreate;


    // Deleted
    @JsonProperty("hiveDelete")
    private String[] hiveDelete;

    @JsonProperty("apiaryDelete")
    private String[] apiaryDelete;

    @JsonProperty("deviceDelete")
    private String[] deviceDelete;

    @JsonProperty("noteDelete")
    private String[] noteDelete;

    public BmData(BmApiary[] apiaries) {
        this.apiaries = apiaries;
    }

    public BmData() {}

    public BmApiaryUpdated[] getApiaryUpdate() {
        return apiaryUpdate;
    }

    public void setApiaryUpdate(BmApiaryUpdated[] apiaryUpdate) {
        this.apiaryUpdate = apiaryUpdate;
    }

    public BmHiveUpdated[] getHiveUpdate() {
        return hiveUpdate;
    }

    public void setHiveUpdate(BmHiveUpdated[] hiveUpdate) {
        this.hiveUpdate = hiveUpdate;
    }

    public BmSensorUpdated[] getDeviceUpdate() {
        return deviceUpdate;
    }

    public void setDeviceUpdate(BmSensorUpdated[] deviceUpdate) {
        this.deviceUpdate = deviceUpdate;
    }

    public BmNoteUpdated[] getNoteUpdate() {
        return noteUpdate;
    }

    public String[] getHiveDelete() {
        return hiveDelete;
    }

    public String[] getDeviceDelete() {
        return deviceDelete;
    }

    public void setDeviceDelete(String[] deviceDelete) {
        this.deviceDelete = deviceDelete;
    }

    public void setHiveDelete(String[] hiveDelete) {
        this.hiveDelete = hiveDelete;
    }

    public String[] getApiaryDelete() {
        return apiaryDelete;
    }

    public void setApiaryDelete(String[] apiaryDelete) {
        this.apiaryDelete = apiaryDelete;
    }

    public String[] getNoteDelete() {
        return noteDelete;
    }

    public void setNoteDelete(String[] noteDelete) {
        this.noteDelete = noteDelete;
    }

    public void setNoteUpdate(BmNoteUpdated[] noteUpdate) {
        this.noteUpdate = noteUpdate;
    }

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

    public BmDevice[] getDevicesCreate() {
        return devicesCreate;
    }

    public void setDevicesCreate(BmDevice[] devicesCreate) {
        this.devicesCreate = devicesCreate;
    }

    public BmNote[] getBmNoteCreate() {
        return bmNoteCreate;
    }

    public void setBmNoteCreate(BmNote[] bmNoteCreate) {
        this.bmNoteCreate = bmNoteCreate;
    }

    public BmHive[] getBmHiveCreate() {
        return bmHiveCreate;
    }

    public void setBmHiveCreate(BmHive[] bmHiveCreate) {
        this.bmHiveCreate = bmHiveCreate;
    }

    @Override
    public String toString() {
        return "BmData{" +
                "apiaries=" + Arrays.toString(apiaries) +
                ", userId='" + userId + '\'' +
                ", modified=" + modified +
                ", apiaryUpdate=" + apiaryUpdate +
                ", hiveUpdate=" + hiveUpdate +
                ", deviceUpdate=" + deviceUpdate +
                ", devicesCreate=" + Arrays.toString(devicesCreate) +
                ", bmNoteCreate=" + Arrays.toString(bmNoteCreate) +
                ", bmHiveCreate=" + Arrays.toString(bmHiveCreate) +
                '}';
    }
}
