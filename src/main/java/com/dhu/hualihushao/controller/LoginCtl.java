package com.dhu.hualihushao.controller;

import com.dhu.hualihushao.entity.User;
import com.dhu.hualihushao.service.LoginSer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginCtl {
    @Resource
    private LoginSer loginSer;

    @RequestMapping("/")
    public String toLogin() {return "login.html";}
    @RequestMapping("index")
    public String toIndex() {return "main.html";}

    @RequestMapping("login")
    @ResponseBody
    public Map login(User user, HttpSession session){
        Map map = new HashMap<String,Object>();
        User u = loginSer.login(user);
        if(u!=null){
            map.put("state",1);
            int res=u.getUser_repository();
            session.setAttribute("sysUser",u);
            session.setAttribute("u_res",res);
        }else
            map.put("state",0);
        return map;
    }
}
