//package com.dhu.hualihushao.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//
//@Configuration
//public class DruidConfig {
//
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }
//
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
//
//        //后台需要有人登陆，账号密码配置
//        HashMap<String, String> initParameters = new HashMap<>();
//        //增加配置 登陆key是固定的
//        initParameters.put("loginUsername","admin");
//        initParameters.put("loginPassword","123456");
//
//        initParameters.put("allow","localhost"); //为空就是谁都可以访问
//
//        bean.setInitParameters(initParameters); //设置初始化参数
//        return bean;
//    }
//
//    //filter
//    //@Bean
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//
//        bean.setFilter(new WebStatFilter());
//
//        //可以过滤哪些请求
//        HashMap<String, String> initParameters = new HashMap<>();
//        initParameters.put("exclusions","*.js,*.css,/druid/*"); //这些东西不进行统计
//        bean.setInitParameters(initParameters);
//
//        return bean;
//    }
//
//}
