package com.dhu.hualihushao.dao;

import com.dhu.hualihushao.entity.Material;

import java.util.List;

public interface MaterialDao {

    //查询
    public Material getOne(Material material);
    public List<Material> getAll();
    public void Add(Material material);
}
