package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.Order;

public interface OrderDao 
{
	public boolean saveupdate(Order order);
	public boolean delete(Order order);
	public Order get(String orderno);
	public List<Order> list();

}
