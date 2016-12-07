package com.company;

/**
 * Created by ryankielty on 11/29/16.
 */
public class Country {

    String countryName;
    String countryAbbreviation;

    public Country(String countryName, String countryAbbreviation) {
        this.countryName = countryName;
        this.countryAbbreviation = countryAbbreviation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }
}
