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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AlertsCat")
public class AlertsCat {

    @Id
    private String _id;
    private String type;
    private Boolean alterable;
    private Boolean disable;
    private Float basicValue;
    private int priority;
    private Integer[] rangeValue;
    private String unite;

    public AlertsCat(){}
    public AlertsCat(String _id, String type, Boolean alterable, Boolean disable, Float basicValue, int priority, Integer[] rangeValue, String unite) {
        this._id = _id;
        this.type = type;
        this.alterable = alterable;
        this.disable = disable;
        this.basicValue = basicValue;
        this.priority = priority;
        this.rangeValue = rangeValue;
        this.unite = unite;
    }

    public AlertsCat(String type, Boolean alterable, Boolean disable, Float basicValue, int priority, Integer[] rangeValue, String unite) {
        this.type = type;
        this.alterable = alterable;
        this.disable = disable;
        this.basicValue = basicValue;
        this.priority = priority;
        this.rangeValue = rangeValue;
        this.unite = unite;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAlterable() {
        return alterable;
    }

    public void setAlterable(Boolean alterable) {
        this.alterable = alterable;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Float getBasicValue() {
        return basicValue;
    }

    public void setBasicValue(Float basicValue) {
        this.basicValue = basicValue;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Integer[] getRangeValue() {
        return rangeValue;
    }

    public void setRangeValue(Integer[] rangeValue) {
        this.rangeValue = rangeValue;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
