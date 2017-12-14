package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.CartItem;

public interface CartItemDao
{
	public boolean saveupdate(CartItem CartItem);
	public boolean delete(String c_id);
	public CartItem get(String ct_id);
	public List<CartItem> list();
   public CartItem getListall(String c_id,String p_id);
public List<CartItem>getCartItemByCart(String c_id);
public List<CartItem>getListByProduct(String p_id);
public List<CartItem> getlist(String c_id);

}
