package com.wa.pojo;

public class Consoled {
    private String ip;

    private String infectcnt;

    private String city;

    private String area;

    public Consoled(String ip, String infectcnt, String city, String area) {
        this.ip = ip;
        this.infectcnt = infectcnt;
        this.city = city;
        this.area = area;
    }

    public Consoled() {
        super();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getInfectcnt() {
        return infectcnt;
    }

    public void setInfectcnt(String infectcnt) {
        this.infectcnt = infectcnt == null ? null : infectcnt.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}