package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.BillingAddr;



public interface BillingAddrDao
{
	public boolean saveupdate(BillingAddr BillingAddr);
	public boolean delete(String b_id);
	public BillingAddr get(String b_id);
	public List<BillingAddr> list();
	public BillingAddr getByUser(String uid);


}
