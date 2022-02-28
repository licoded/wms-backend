package com.dhu.hualihushao.service;

import com.dhu.hualihushao.dao.MaterialDao;
import com.dhu.hualihushao.entity.Material;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialSer {
    @Resource
    private MaterialDao materialDao;

    public List<Material> getAll(){
        try{
            System.out.println("Have got all Material");
            return materialDao.getAll();
        }catch (Exception e){
            return  null;
        }
    }

    public Material getOne(Material material){
        try{
            return materialDao.getOne(material);
        }catch (Exception e){
            return  null;
        }
    }

}
