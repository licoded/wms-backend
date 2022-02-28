package com.dhu.hualihushao.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Buy {

    private Integer buy_id;
    private Integer repository_id;
    private Integer material_id;
    private Date buy_time;
    private String buy_timeStr;
    private Integer buy_numbers;

    //关联
    private Material material;
    private Repository repository;
    private String start;
    private String end;



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
        //总价
//    private Double total;
//
//    public Double getTotal() {
//        return total;
//    }
//
//    public void setTotal(Double total) {
//        this.total = total;
//    }

    public Buy() {
    }

//    public Buy(Integer buy_id, Integer repository_id, Integer material_id, Date buy_time, String buy_timeStr, Integer buy_numbers, Material material, Repository repository) {
//        this.buy_id = buy_id;
//        this.repository_id = repository_id;
//        this.material_id = material_id;
//        this.buy_time = buy_time;
//        this.buy_timeStr = buy_timeStr;
//        this.buy_numbers = buy_numbers;
//        this.material = material;
//        this.repository = repository;
//    }


    public Buy(Integer buy_id) {
        this.buy_id = buy_id;
    }

    public Integer getBuy_id() {
        return buy_id;
    }

    public void setBuy_id(Integer buy_id) {
        this.buy_id = buy_id;
    }

    public Integer getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(Integer repository_id) {
        this.repository_id = repository_id;
    }

    public Integer getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public Date getBuy_time() {
        return buy_time;
    }

    public void setBuy_time(Date buy_time) {
        this.buy_time = buy_time;
    }

    public String getBuy_timeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        return sdf.format(this.getBuy_time());

    }

    public void setBuy_timeStr(String buy_timeStr) {
        this.buy_timeStr = buy_timeStr;
    }

    public Integer getBuy_numbers() {
        return buy_numbers;
    }

    public void setBuy_numbers(Integer buy_numbers) {
        this.buy_numbers = buy_numbers;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

//    public Double getTotal() {
//        return total;
//    }
//
//    public void setTotal(Double total) {
//        this.total = total;
//    }



    @Override
    public String toString() {
        return "Buy{" +
                "buy_id=" + buy_id +
                ", repository_id=" + repository_id +
                ", material_id=" + material_id +
                ", buy_time=" + buy_time +
                ", buy_timeStr='" + buy_timeStr + '\'' +
                ", buy_numbers=" + buy_numbers +
                ", material=" + material +
                ", repository=" + repository +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
