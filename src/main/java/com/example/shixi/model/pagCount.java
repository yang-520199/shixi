package com.example.shixi.model;

public class pagCount {
    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount/20+1;
    }

    @Override
    public String toString() {
        return "pagCount{" +
                "pageCount=" + pageCount +
                '}';
    }
}
