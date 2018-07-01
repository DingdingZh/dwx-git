package com.jsc.stationinfoweb.datamodel;

public class CellInfo extends CellInfoKey {
    private Integer mcc;

    private Float lat;

    private Float lon;

    private Integer acc;

    private Integer date;

    private String addr;

    private String province;

    private String city;

    private String district;

    private String township;

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Integer getAcc() {
        return acc;
    }

    public void setAcc(Integer acc) {
        this.acc = acc;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township == null ? null : township.trim();
    }
}