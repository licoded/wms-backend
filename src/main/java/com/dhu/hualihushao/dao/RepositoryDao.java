package com.dhu.hualihushao.dao;

import com.dhu.hualihushao.entity.Repository;

import java.util.List;

public interface RepositoryDao {
    public Repository getOne(Repository repository);
    public List<Repository> getAll();
    public Repository getOneById(Integer id);
    public void add(Repository repository);
    public void deleteOneById(Integer id);
    public void update(Repository repository);
}
