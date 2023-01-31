package com.example.madrissasabak;

import androidx.annotation.NonNull;

public class Record {
    private Integer stdRollNo;
    private String stdName;
    private String date;
    private Integer sabak;
    private Integer sabki;
    private Integer manzil;

    public Record(Integer stdRollNo,String name, String date, Integer sabak, Integer sabki, Integer manzil) {
        this.stdRollNo = stdRollNo;
        this.date = date;
        this.stdName = name;
        this.sabak = sabak;
        this.sabki = sabki;
        this.manzil = manzil;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public Integer getstdRollNo() {
        return this.stdRollNo;
    }

    public void setstdRollNo(Integer stdRollNo) {
        this.stdRollNo = stdRollNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSabak() {
        return sabak;
    }

    public void setSabak(Integer sabak) {
        this.sabak = sabak;
    }

    public Integer getSabki() {
        return sabki;
    }

    public void setSabki(Integer sabki) {
        this.sabki = sabki;
    }

    public Integer getManzil() {
        return manzil;
    }

    public void setManzil(Integer manzil) {
        this.manzil = manzil;
    }

    @NonNull
    public String toString()
    {
        return getstdRollNo().toString();
    }
}
