package com.dhu.hualihushao.entity;

public class Material {

    //数据库行
    private Integer material_id;
    private String  material_name;
    private Double  material_price;
    private String  material_supplier;

    public  Material(){

    }

    public  Material(Integer id){
        this.material_id=id;
    }

    public Integer getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public Double getMaterial_price() {
        return material_price;
    }

    public void setMaterial_price(Double material_price) {
        this.material_price = material_price;
    }

    public String getMaterial_supplier() {
        return material_supplier;
    }

    public void setMaterial_supplier(String material_supplier) {
        this.material_supplier = material_supplier;
    }

    @Override
    public String toString() {
        return "Material{" +
                "material_id=" + material_id +
                ", material_name='" + material_name + '\'' +
                ", material_price=" + material_price +
                ", material_supplier='" + material_supplier + '\'' +
                '}';
    }
}
