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
    private String icon;
    private Boolean alterable;
    private Boolean disable;
    private Float basicValueMet;
    private Float basicValueImp;
    private int priority;
    private Integer[] rangeValueMet;
    private Integer[] rangeValueImp;
    private int stepMet;
    private int stepImp;
    private String unitMet;
    private String unitImp;

    public AlertsCat(){}

    public AlertsCat(String _id, String icon, Boolean alterable, Boolean disable, Float basicValueMet, Float basicValueImp, int priority, Integer[] rangeValueMet, Integer[] rangeValueImp, int stepMet, int stepImp, String unitMet, String unitImp) {
        this._id = _id;
        this.icon = icon;
        this.alterable = alterable;
        this.disable = disable;
        this.basicValueMet = basicValueMet;
        this.basicValueImp = basicValueImp;
        this.priority = priority;
        this.rangeValueMet = rangeValueMet;
        this.rangeValueImp = rangeValueImp;
        this.stepMet = stepMet;
        this.stepImp = stepImp;
        this.unitMet = unitMet;
        this.unitImp = unitImp;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public Float getBasicValueMet() {
        return basicValueMet;
    }

    public void setBasicValueMet(Float basicValueMet) {
        this.basicValueMet = basicValueMet;
    }

    public Float getBasicValueImp() {
        return basicValueImp;
    }

    public void setBasicValueImp(Float basicValueImp) {
        this.basicValueImp = basicValueImp;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Integer[] getRangeValueMet() {
        return rangeValueMet;
    }

    public void setRangeValueMet(Integer[] rangeValueMet) {
        this.rangeValueMet = rangeValueMet;
    }

    public Integer[] getRangeValueImp() {
        return rangeValueImp;
    }

    public void setRangeValueImp(Integer[] rangeValueImp) {
        this.rangeValueImp = rangeValueImp;
    }

    public int getStepMet() {
        return stepMet;
    }

    public void setStepMet(int stepMet) {
        this.stepMet = stepMet;
    }

    public int getStepImp() {
        return stepImp;
    }

    public void setStepImp(int stepImp) {
        this.stepImp = stepImp;
    }

    public String getUnitMet() {
        return unitMet;
    }

    public void setUnitMet(String unitMet) {
        this.unitMet = unitMet;
    }

    public String getUnitImp() {
        return unitImp;
    }

    public void setUnitImp(String unitImp) {
        this.unitImp = unitImp;
    }
}
