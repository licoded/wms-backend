package com.dhu.hualihushao.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Return {

    private Integer return_id;
    private Integer cache_id;
    private Integer return_numbers;
    private Date return_time;

    private String return_timeStr;

    //关联
    private Cache cache;
    private Material material;
    private  String start;
    private  String end;
    private  Integer repository_id;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(Integer repository_id) {
        this.repository_id = repository_id;
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

    public String getReturn_timeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        return sdf.format(this.getReturn_time());
    }

    public void setReturn_timeStr(String return_timeStr) {
        this.return_timeStr = return_timeStr;
    }

    public Return() {
    }

    public Return(Integer return_id) {
        this.return_id = return_id;
    }

    public Integer getReturn_id() {
        return return_id;
    }

    public void setReturn_id(Integer return_id) {
        this.return_id = return_id;
    }

    public Integer getCache_id() {
        return cache_id;
    }

    public void setCache_id(Integer cache_id) {
        this.cache_id = cache_id;
    }

    public Integer getReturn_numbers() {
        return return_numbers;
    }

    public void setReturn_numbers(Integer return_numbers) {
        this.return_numbers = return_numbers;
    }

    public Date getReturn_time() {
        return return_time;
    }

    public void setReturn_time(Date return_time) {
        this.return_time = return_time;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    @Override
    public String toString() {
        return "Return{" +
                "return_id=" + return_id +
                ", cache_id=" + cache_id +
                ", return_numbers=" + return_numbers +
                ", return_time=" + return_time +
                ", return_timeStr='" + return_timeStr + '\'' +
                ", cache=" + cache +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", repository_id=" + repository_id +
                '}';
    }
}
