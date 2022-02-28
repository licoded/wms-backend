package com.dhu.hualihushao.dao;

import com.dhu.hualihushao.entity.Dispatch;
import com.dhu.hualihushao.entity.Search;

import java.util.List;

public interface DispatchDao {
    //添加记录
    public void add(Dispatch dispatch);

    //获取规定时间内的所有调拨记录
    public List<Dispatch> getAll(Dispatch dispatch);
    public List<Dispatch> getIn(Search search);
    public List<Dispatch> getOut(Search search);
}
