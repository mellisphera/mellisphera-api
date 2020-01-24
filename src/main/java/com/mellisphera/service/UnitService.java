package com.mellisphera.service;

import org.springframework.stereotype.Service;

@Service
public class UnitService {


    public double convertTempFromUsePref(double temp, Unit unit) {
        if (unit.equals(Unit.METRIC)) {
            return (double)(Math.round(temp * 10) / 10);
        } else {
            return (double)((Math.round(temp * 10) / 10) * 9 / 5 + 32);
        }
    }

    public double convertWeightFromUserPref(double weight, Unit unit) {
        if (unit.equals(Unit.METRIC)) {
            return (double)(Math.round(weight * 10) / 10);
        } else {
            return (double)((Math.round(weight * 10) / 10) * 2.2046);
        }
    }

    public double convertRain(double rain, Unit unit) {
        if (unit.equals(Unit.METRIC)) {
            return (double)(Math.round(rain * 10) / 10);
        } else {
            return (double)((Math.round(rain * 10) / 10) * 25.4);
        }
    }

    public double convertWind(double wind, Unit unit) {
        if (unit.equals(Unit.METRIC)) {
            return (double)(Math.round(wind * 10) / 10) * 3.6;
        } else {
            return (Math.round(wind * 10) / 10) * 2.276;
        }
    }

}
