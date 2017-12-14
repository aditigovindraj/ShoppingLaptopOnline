package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.Authentication;

public interface AuthenticationDao 
{
	public boolean saveupdate(Authentication authentication);
	public boolean delete(Authentication authentication);
	public Authentication get(String roleId);
	public List<Authentication> list();

}
