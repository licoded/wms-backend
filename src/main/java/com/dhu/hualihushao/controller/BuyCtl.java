package com.dhu.hualihushao.controller;

import com.dhu.hualihushao.entity.Buy;
import com.dhu.hualihushao.entity.Cache;
import com.dhu.hualihushao.entity.PageQueryBean;
import com.dhu.hualihushao.service.BuySer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("buy")
public class BuyCtl {

    @Resource
    BuySer buySer;

    @RequestMapping("add")
    public Map add(Buy buy){
        Map map = new HashMap<String,Object>();
        System.out.println(buy);  //查看新添加的buy信息
        if(buySer.add(buy)){
            map.put("state",1);
        }else{
            map.put("state",0);
        }
        return map;
    }

//    @RequestMapping("review")
//    public Map review(Integer id, HttpSession session){
//        Map map = new HashMap<String,Object>();
//        Integer modifyId = (int)session.getAttribute("modifyId");
//        Buy buy = buySer.getOne(new Buy(modifyId));
//        if(buy!=null){
//            System.out.println(buy);
//            map.put("cache",buy);
//            map.put("state",1);
//        }else {
//            map.put("state",0);
//        }
//        return  map;
//    }
    @RequestMapping("getList")
    public PageQueryBean getList(Buy buy){
//        // 如果day<=27 加一天 start
//        String tmp = buy.getEnd();
//        Integer tmpInt = new Integer(tmp.substring(8,10));
//        if(tmpInt <= 27){
//            tmpInt++;
//        }
//        String tmp2 = tmp.substring(0,8) + tmpInt.toString();
//        System.out.println("lalllaaaalaallaa:  "+ tmp2);
//        buy.setEnd(tmp2);
//        // end
        PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println(buy);
        List<Buy> list = buySer.getAll(buy);
        System.out.println("这是getlist的"+list);
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

    @RequestMapping("getTotal")
    public Double getTotal(Buy buy){
        // PageQueryBean pageQueryBean = new PageQueryBean();
        System.out.println(buy);
        List<Buy> list = buySer.getAll(buy);
        System.out.println("这是gettotal"+list);

        double tmp = 0;
        if(list!=null&&list.size()>0){
            for (int i=0; i<list.size(); i++){
                Buy buy1 = (Buy)list.get(i);
                tmp += buy1.getBuy_numbers() * buy1.getMaterial().getMaterial_price();
            }

        }else{

        }
        System.out.println(tmp);
        return tmp;
    }



}
