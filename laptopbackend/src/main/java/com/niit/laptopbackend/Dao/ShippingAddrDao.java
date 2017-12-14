package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.ShippingAddr;

public interface ShippingAddrDao 
{
	
	public boolean saveupdate(ShippingAddr shippingAddr);
	public boolean delete(String s_id);
	public ShippingAddr get(String s_id);
	public List<ShippingAddr> list();
	public List<ShippingAddr> getAddrByUser(String uid);

}
