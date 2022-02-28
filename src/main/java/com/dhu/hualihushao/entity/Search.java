package com.dhu.hualihushao.entity;

import java.util.Date;

public class Search {

    //前端查询载体
    private String start;
    private String end;
    private Integer repository_id;

    public Search(){

    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(Integer repository_id) {
        this.repository_id = repository_id;
    }

    @Override
    public String toString() {
        return "Search{" +
                "start=" + start +
                ", end=" + end +
                ", repository_id=" + repository_id +
                '}';
    }
}
