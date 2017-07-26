package com.wa.pojo;

public class Country {
    private String countryIp;

    private String infectNum;

    private String city;

    public Country(String countryIp, String infectNum, String city) {
        this.countryIp = countryIp;
        this.infectNum = infectNum;
        this.city = city;
    }

    public Country() {
        super();
    }

    public String getCountryIp() {
        return countryIp;
    }

    public void setCountryIp(String countryIp) {
        this.countryIp = countryIp == null ? null : countryIp.trim();
    }

    public String getInfectNum() {
        return infectNum;
    }

    public void setInfectNum(String infectNum) {
        this.infectNum = infectNum == null ? null : infectNum.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }
}