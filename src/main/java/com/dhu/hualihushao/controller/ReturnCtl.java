package com.dhu.hualihushao.controller;

import com.dhu.hualihushao.entity.Buy;
import com.dhu.hualihushao.entity.PageQueryBean;
import com.dhu.hualihushao.entity.Return;
import com.dhu.hualihushao.service.ReturnSer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("return")
public class ReturnCtl {

    @Resource
    ReturnSer returnSer;

    @RequestMapping("add")
    public Map add(Return ret){
        System.out.println(ret);
        Map map = new HashMap<String,Object>();
        System.out.println(ret);  //查看新添加的buy信息
        if(returnSer.add(ret)){
            map.put("state",1);
        }else{
            map.put("state",0);
        }
        return map;
    }

    @RequestMapping("getList")
    public PageQueryBean getList(Return ret){
        PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println(ret);
        List<Return> list = returnSer.getAll(ret);
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

}
