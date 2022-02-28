package com.dhu.hualihushao.dao;

import com.dhu.hualihushao.entity.Search;
import com.dhu.hualihushao.entity.Shop;

import java.util.List;

public interface ShopDao {
    public void add(Shop shop);
    public List<Shop> getAll(Search search);
}
