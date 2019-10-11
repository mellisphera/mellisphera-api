package com.mellisphera.entities.bm.changeLog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mellisphera.entities.bm.BmDevice;
import com.mellisphera.entities.bm.ChangeLogUpdate;

public class BmSensorUpdated implements ChangeLogUpdate<BmDevice, BmDevice> {

    @JsonProperty("old")
    private BmDevice oldDevice;

    @JsonProperty("updated")
    private BmDevice deviceUpdated;

    public BmSensorUpdated() {}

    @Override
    public BmDevice getOldData() {
        return oldDevice;
    }

    @Override
    public BmDevice getUpdatedData() {
        return deviceUpdated;
    }

}
