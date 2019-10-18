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