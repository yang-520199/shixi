package com.example.shixi.model;

import java.io.Serializable;

public class Pager implements Serializable {
    private int begin;
    private int end;
    private String selectArea;

    public String getSelectArea() {
        return selectArea;
    }

    public void setSelectArea(String selectArea) {
        this.selectArea = selectArea;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = (begin-1)*20+1;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
