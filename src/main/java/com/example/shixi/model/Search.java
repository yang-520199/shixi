package com.example.shixi.model;

import java.io.Serializable;

public class Search implements Serializable {
    private String selectArea;
    private String selectDate;
    private String selectKind;

    public String getSelectKind() {
        return selectKind;
    }

    public void setSelectKind(String selectKind) {
        this.selectKind = selectKind;
    }

    public String getSelectArea() {
        return selectArea;
    }

    public void setSelectArea(String selectArea) {
        this.selectArea = selectArea;
    }

    public String getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(String selectDate) {
        this.selectDate = selectDate;
    }

    @Override
    public String toString() {
        return "Search{" +
                "selectArea='" + selectArea + '\'' +
                ", selectDate='" + selectDate + '\'' +
                ", selectKind='" + selectKind + '\'' +
                '}';
    }
}
