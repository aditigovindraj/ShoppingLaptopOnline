package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.supplier;

public interface SupplierDao {
	
	
	public boolean saveupdate(supplier supplier);
	public boolean delete(supplier supplier);
	public supplier get(String sname);
	public List<supplier> list();
	}


