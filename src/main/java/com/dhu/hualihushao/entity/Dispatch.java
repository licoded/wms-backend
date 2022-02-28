package com.dhu.hualihushao.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Dispatch {
    private  Integer dispatch_id;
    private  Integer repository_id_0;
    private  Integer repository_id_1;
    private  Integer cache_id;
    private  Integer dispatch_num;
    private  Date dispatch_time;

    //关联库存
    private Cache cache;

    //标识起始时间
    private String start;
    private String end;
    private String dispatch_timeStr;

    public Dispatch(){
    }

    public Integer getDispatch_id() {
        return dispatch_id;
    }

    public void setDispatch_id(Integer dispatch_id) {
        this.dispatch_id = dispatch_id;
    }

    public Integer getRepository_id_0() {
        return repository_id_0;
    }

    public void setRepository_id_0(Integer repository_id_0) {
        this.repository_id_0 = repository_id_0;
    }

    public Integer getRepository_id_1() {
        return repository_id_1;
    }

    public void setRepository_id_1(Integer repository_id_1) {
        this.repository_id_1 = repository_id_1;
    }

    public Integer getCache_id() {
        return cache_id;
    }

    public void setCache_id(Integer cache_id) {
        this.cache_id = cache_id;
    }

    public Integer getDispatch_num() {
        return dispatch_num;
    }

    public void setDispatch_num(Integer dispatch_num) {
        this.dispatch_num = dispatch_num;
    }

    public Date getDispatch_time() {
        return dispatch_time;
    }

    public void setDispatch_time(Date dispatch_time) {
        this.dispatch_time = dispatch_time;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
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

    public String getDispatch_timeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(this.getDispatch_time());
    }

    public void setDispatch_timeStr(String dispatch_timeStr) {
        this.dispatch_timeStr = dispatch_timeStr;
    }

    @Override
    public String toString() {
        return "Dispatch{" +
                "dispatch_id=" + dispatch_id +
                ", repository_id_0=" + repository_id_0 +
                ", repository_id_1=" + repository_id_1 +
                ", cache_id=" + cache_id +
                ", dispatch_num=" + dispatch_num +
                ", dispatch_time=" + dispatch_time +
                ", cache=" + cache +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", dispatch_timeStr='" + dispatch_timeStr + '\'' +
                '}';
    }
}
