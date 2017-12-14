package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.Cart;

public interface CartDao
{
	public boolean saveupdate(Cart Cart);
	public boolean delete(String c_id);
	public Cart get(String c_id);
	public List<Cart> list();

}
