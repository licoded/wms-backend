package com.dhu.hualihushao.dao;

import com.dhu.hualihushao.entity.Buy;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BuyDao {

    public void add(Buy buy);
    public Buy getOne(Buy buy);
    public List<Buy> getAll(Buy buy);

}
