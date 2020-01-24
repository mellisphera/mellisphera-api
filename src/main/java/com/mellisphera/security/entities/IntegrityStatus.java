package com.mellisphera.security.entities;

import java.util.Arrays;

public class IntegrityStatus {

    private int code;
    private String args[];

    public IntegrityStatus(int code, Object obj, String[] args) {
        this.code = code;
        this.args = args;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
