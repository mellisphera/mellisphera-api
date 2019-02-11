package com.apiwatch.security.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoIp implements Serializable {
    /**
     * {
     * "ip": "87.100.21.93",
     * "city": "Tarsacq",
     * "region": "Nouvelle-Aquitaine",
     * "region_code": "NAQ",
     * "country": "FR",
     * "country_name": "France",
     * "continent_code": "EU",
     * "in_eu": true,
     * "postal": "64360",
     * "latitude": 43.35,
     * "longitude": -0.5333,
     * "timezone": "Europe/Paris",
     * "utc_offset": "+0100",
     * "country_calling_code": "+33",
     * "currency": "EUR",
     * "languages": "fr-FR,frp,br,co,ca,eu,oc",
     * "asn": "AS35632",
     * "org": "Iris 64"
     * }
     */
    @JsonProperty("ip")
    private String ip;

    @JsonProperty("city")
    private String city;

    @JsonProperty("region")
    private String region;

    @JsonProperty("region_code")
    private String regionCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("continent_code")
    private String continentCode;

    @JsonProperty("in_eu")
    private boolean inEu;

    @JsonProperty("postal")
    private String codePostal;

    @JsonProperty("latitude")
    private Float latitude;

    @JsonProperty("longitude")
    private Float longitude;

    @JsonProperty("timezone")
    private String timeZone;

    @JsonProperty("utc_offset")
    private String utcOffset;

    @JsonProperty("country_calling_code")
    private String countryCallingCode;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("languages")
    private String languages;

    @JsonProperty("org")
    private String asn;

    public GeoIp() {
    }

    public GeoIp(String ip, String city, String region, String regionCode, String country, String countryName, String continentCode, boolean inEu, String codePostal, Float latitude, Float longitude, String timeZone, String utcOffset, String countryCallingCode, String currency, String languages, String asn) {
        this.ip = ip;
        this.city = city;
        this.region = region;
        this.regionCode = regionCode;
        this.country = country;
        this.countryName = countryName;
        this.continentCode = continentCode;
        this.inEu = inEu;
        this.codePostal = codePostal;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeZone = timeZone;
        this.utcOffset = utcOffset;
        this.countryCallingCode = countryCallingCode;
        this.currency = currency;
        this.languages = languages;
        this.asn = asn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public boolean isInEu() {
        return inEu;
    }

    public void setInEu(boolean inEu) {
        this.inEu = inEu;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getCountryCallingCode() {
        return countryCallingCode;
    }

    public void setCountryCallingCode(String countryCallingCode) {
        this.countryCallingCode = countryCallingCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getAsn() {
        return asn;
    }

    public void setAsn(String asn) {
        this.asn = asn;
    }


    @Override
    public String toString() {
        return "GeoIp{" +
                "ip='" + ip + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", country='" + country + '\'' +
                ", countryName='" + countryName + '\'' +
                ", continentCode='" + continentCode + '\'' +
                ", inEu=" + inEu +
                ", codePostal='" + codePostal + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timeZone='" + timeZone + '\'' +
                ", utcOffset='" + utcOffset + '\'' +
                ", countryCallingCode='" + countryCallingCode + '\'' +
                ", currency='" + currency + '\'' +
                ", languages='" + languages + '\'' +
                ", asn='" + asn + '\'' +
                '}';
    }
}


