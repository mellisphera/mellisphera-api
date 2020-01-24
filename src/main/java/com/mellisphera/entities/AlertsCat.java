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
    private String nameFr;
    private String nameEn;
    private String nameEs;
    private Boolean alterable;
    private Boolean disable;
    private Float basicValueMet;
    private Float basicValueImp;
    private int priority;
    private Integer[] rangeValueMet;
    private Integer[] rangeValueImp;
    private float stepMet;
    private float stepImp;
    private String unitMet;
    private String unitImp;
    private String period;
    private String category;

    public AlertsCat() {}

    public AlertsCat(String _id, String icon, String nameFr, String nameEn, Boolean alterable,
                     Boolean disable, Float basicValueMet, Float basicValueImp, int priority, Integer[] rangeValueMet,
                     Integer[] rangeValueImp, float stepMet, float stepImp, String unitMet, String unitImp, String period, String nameEs, String category) {
        this._id = _id;
        this.icon = icon;
        this.nameFr = nameFr;
        this.nameEn = nameEn;
        this.nameEs = nameEs;
        this.alterable = alterable;
        this.disable = disable;
        this.basicValueMet = basicValueMet;
        this.basicValueImp = basicValueImp;
        this.priority = priority;
        this.rangeValueMet = rangeValueMet;
        this.rangeValueImp = rangeValueImp;
        this.period = period;
        this.stepMet = stepMet;
        this.stepImp = stepImp;
        this.category = category;
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

    public String getNameFr() {
        return nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Boolean getAlterable() {
        return alterable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public float getStepMet() {
        return stepMet;
    }

    public void setStepMet(float stepMet) {
        this.stepMet = stepMet;
    }

    public float getStepImp() {
        return stepImp;
    }

    public void setStepImp(float stepImp) {
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getNameEs() {
        return nameEs;
    }

    public void setNameEs(String nameEs) {
        this.nameEs = nameEs;
    }
}
