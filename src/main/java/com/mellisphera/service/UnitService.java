package com.mellisphera.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class UnitService {


    DecimalFormat decimalFormat;

    UnitService() {
        this.decimalFormat = new DecimalFormat("0.#");
    }

    public String convertTempFromUsePref(double temp, Unit unit) {
        if (unit.equals(Unit.METRIC)) {
            return decimalFormat.format(temp);
        } else {
            return decimalFormat.format(temp * 9 / 5 + 32);
        }
    }

    public String convertWeightFromUserPref(double weight, Unit unit) {
        if (unit.equals(Unit.METRIC)) {
            return decimalFormat.format(weight);
        } else {
            return decimalFormat.format(weight * 2.2046);
        }
    }

    public String convertRain(double rain, Unit unit) {
        if (unit.equals(Unit.METRIC)) {
            return decimalFormat.format(rain);
        } else {
            return decimalFormat.format(rain * 25.4);
        }
    }

    public String convertWind(double wind, Unit unit) {
        if (unit.equals(Unit.METRIC)) {
            return decimalFormat.format(wind * 3.6);
        } else {
            return decimalFormat.format(wind * 2.276);
        }
    }

}
