package com.example.app;

public class Rate {
    private String no, effectiveDate;
    private double mid;

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public String getNo() {
        return no;
    }

    public double getMid() {
        return mid;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }
}
