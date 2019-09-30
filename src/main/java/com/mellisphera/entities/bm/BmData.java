package com.mellisphera.entities.bm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BmData implements Serializable {
    @JsonProperty("apiaries")
    private BmApiary[] apiaries;
}
