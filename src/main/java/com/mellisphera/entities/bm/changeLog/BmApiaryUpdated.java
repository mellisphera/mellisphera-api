package com.mellisphera.entities.bm.changeLog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mellisphera.entities.bm.BmApiary;
import com.mellisphera.entities.bm.ChangeLogUpdate;

import java.io.Serializable;

public class BmApiaryUpdated implements ChangeLogUpdate<BmApiary, BmApiary>, Serializable {


    @JsonProperty("old")
    private BmApiary oldApiary;

    @JsonProperty("updated")
    private BmApiary updatedApiary;


    public BmApiaryUpdated() {}

    @Override
    public BmApiary getOldData() {
        return oldApiary;
    }

    @Override
    public BmApiary getUpdatedData() {
        return updatedApiary;
    }
}
