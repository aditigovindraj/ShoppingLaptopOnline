package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.Product;

public interface ProductDao {
	public boolean saveupdate(Product Product);
	public boolean delete(Product product);
	public Product get(String p_id);
	public List<Product>getProductByCategory(String cid);
	public List<Product>getProductBySupplier(String sid);
	
	public List<Product> list();

}
