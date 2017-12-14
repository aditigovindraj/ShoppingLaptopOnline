package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.category;

public interface CategoryDao 
{
public boolean saveupdate(category category);
public boolean delete(category category);
public category get(String cid);
public List<category> list();

}
