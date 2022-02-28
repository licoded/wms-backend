package com.dhu.hualihushao.controller;

import com.dhu.hualihushao.entity.Cache;
import com.dhu.hualihushao.entity.Material;
import com.dhu.hualihushao.entity.PageQueryBean;
import com.dhu.hualihushao.entity.Shop;
import com.dhu.hualihushao.service.MaterialSer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("material")
public class MaterialCtl {
    @Resource
    private MaterialSer materialSer;

    @RequestMapping("writeModifyId")
    public Map writeModifyId(Integer id, HttpSession session){
        Map map = new HashMap<String,Object>();
        session.setAttribute("modifyId",id);
        System.out.println(id);
        return  map;
    }
    @RequestMapping("review")
    public Map review(HttpSession session){
        Map map = new HashMap<String,Object>();
        Integer modifyId = (int)session.getAttribute("modifyId");
        Material material = materialSer.getOne(new Material(modifyId));
        if(material!=null){
            System.out.println(material);
            map.put("material",material);
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return  map;
    }
    @RequestMapping("getList")
    public PageQueryBean getList(){
        PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println("Getting all Materials");
        List<Material> list = materialSer.getAll();
        System.out.println(list);
        if(list!=null&&list.size()>0){
            pageQueryBean.setTotalRows(list.size());
            pageQueryBean.setItems(list);
        }else{
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);
        }
        System.out.println(pageQueryBean);
        return pageQueryBean;
    }

    @RequestMapping("getOne")
    public Material getOne(Material material){
        return materialSer.getOne(material);
    }
}
