package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.Pay;

public interface PayDao 
{
	public boolean saveupdate(Pay Pay);
	public boolean delete(String pid);
	public Pay get(String pid);
	public List<Pay> list();
	

}
