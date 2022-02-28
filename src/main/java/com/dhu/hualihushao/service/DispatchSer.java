package com.dhu.hualihushao.service;

import com.dhu.hualihushao.dao.DispatchDao;
import com.dhu.hualihushao.entity.Dispatch;
import com.dhu.hualihushao.entity.Search;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DispatchSer {
    @Resource
    private DispatchDao dispatchDao;

    public boolean add(Dispatch dispatch){
        try{
            Date data = new Date();
            System.out.println(data);
            dispatch.setDispatch_time(data);
            dispatchDao.add(dispatch);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    public List<Dispatch> getAll(Dispatch dispatch){
        try{
            return dispatchDao.getAll(dispatch);
        }catch (Exception e){
            return null;
        }
    }

    public List<Dispatch> getIn(Search dispatch){
        try{
            return dispatchDao.getIn(dispatch);
        }catch (Exception e){
            return null;
        }
    }

    public List<Dispatch> getOut(Search dispatch){
        try{
            return dispatchDao.getOut(dispatch);
        }catch (Exception e){
            return null;
        }
    }
}
