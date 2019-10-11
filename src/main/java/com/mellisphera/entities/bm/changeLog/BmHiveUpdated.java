package com.mellisphera.entities.bm.changeLog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mellisphera.entities.bm.BmHive;
import com.mellisphera.entities.bm.ChangeLogUpdate;

public class BmHiveUpdated implements ChangeLogUpdate<BmHive, BmHive> {

    @JsonProperty("old")
    private BmHive oldHive;

    @JsonProperty("updated")
    private BmHive hiveUpdated;

    @Override
    public BmHive getOldData() {
        return oldHive;
    }

    @Override
    public BmHive getUpdatedData() {
        return hiveUpdated;
    }

    public BmHiveUpdated() {}
}
