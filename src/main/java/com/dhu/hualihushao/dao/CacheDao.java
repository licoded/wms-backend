package com.dhu.hualihushao.dao;

import com.dhu.hualihushao.entity.Cache;

import java.util.List;

public interface CacheDao {
    public void add(Cache cache);
//    public void delete(Cache cache);  //取消 将要删除项目 容量修改为0
    public void updateNumbers(Cache cache);
    public Cache getOne(Cache cache);
    public List<Cache> getAll(Cache cache);
}
