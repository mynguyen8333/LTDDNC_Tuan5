package com.example.myapplication;

public class Mucsic {
    private String tenbh,tencs,thoiluong;

    public Mucsic(String tenbh, String tencs, String thoiluong) {
        this.tenbh = tenbh;
        this.tencs = tencs;
        this.thoiluong = thoiluong;
    }

    public String getTenbh() {
        return tenbh;
    }

    public void setTenbh(String tenbh) {
        this.tenbh = tenbh;
    }

    public String getTencs() {
        return tencs;
    }

    public void setTencs(String tencs) {
        this.tencs = tencs;
    }

    public String getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(String thoiluong) {
        this.thoiluong = thoiluong;
    }
}
