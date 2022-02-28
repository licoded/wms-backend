package com.dhu.hualihushao.dao;

import com.dhu.hualihushao.entity.User;

import java.util.List;

public interface UserDao {
    public void add(User u);
    public void delete(User u);
    public void updatePwd(User u);
    public void updateChmod(User u);
    public void updateMoney(User u);      //转账
    public void update(User u);
    public User getOne(User u);
    public List<User> getAll(User u);
    public List<User> getAllByRepositoryId(Integer id);
}
