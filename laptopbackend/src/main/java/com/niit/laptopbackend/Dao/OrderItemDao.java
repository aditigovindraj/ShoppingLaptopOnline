package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.OrderItem;

public interface OrderItemDao
{
	public boolean saveupdate(OrderItem orderItem);
	public boolean delete(OrderItem orderItem);
	public OrderItem get(String OrderItem_id);
	public List<OrderItem> getOrderItembyOrder(String orderno);
	public List<OrderItem> list();

}
