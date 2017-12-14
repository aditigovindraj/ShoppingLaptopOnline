package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.user;


public interface UserDao 
{
	public boolean saveupdate(user user);
	public boolean delete(String uid);
	public user get(String uname);
	public List<user> list();
	public user isvalid(String email, String password);
	public user email(String email);
}	


