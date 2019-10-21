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



package com.mellisphera.entities;

public class AlertConf {

    private Boolean enable;
    private Integer[] value;
    private Boolean alterable;

    public AlertConf(Boolean enable, Integer[] value, Boolean alterable) {
        this.enable = enable;
        this.value = value;
        this.alterable = alterable;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer[] getValue() {
        return value;
    }

    public void setValue(Integer[] value) {
        this.value = value;
    }

    public Boolean getAlterable() {
        return alterable;
    }

    public void setAlterable(Boolean alterable) {
        this.alterable = alterable;
    }
}