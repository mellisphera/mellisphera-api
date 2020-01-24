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
