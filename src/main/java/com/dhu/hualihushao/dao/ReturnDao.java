package com.dhu.hualihushao.dao;


import com.dhu.hualihushao.entity.Buy;
import com.dhu.hualihushao.entity.Return;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReturnDao {

    public void add(Return ret);
    public Return getOne(Return ret);
    public List<Return> getAll(Return ret);


}
