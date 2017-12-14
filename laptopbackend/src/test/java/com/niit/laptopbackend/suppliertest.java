package com.niit.laptopbackend;

import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.Dao.SupplierDao;
import com.niit.laptopbackend.model.Product;
import com.niit.laptopbackend.model.supplier;

public class suppliertest {
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		
		
		
		SupplierDao supplierDao = (SupplierDao) context.getBean("supplierDao");
		supplier supplier = (supplier) context.getBean("supplier");
		ProductDao ProductDao = (ProductDao) context.getBean("ProductDao");
		Product Product = (Product) context.getBean("product");
		
		
		
		
		supplier.setSname("adi");
		supplier.setAddress("mangalore");
		supplier.setContact("9980179268");
		supplierDao.saveupdate(supplier);
		

		
		
		// save and update
//		supplier.setSname("satish");
//
//		supplier.setSid("12");
		if(supplierDao.saveupdate(supplier)==true){
			System.out.println("saved");
		} else {
			System.out.println("sorry not saved");
		}
		 supplier=supplierDao.get("cd123");
		List<Product> lists= ProductDao.getProductBySupplier(supplier.getSid());
		if(lists==null||lists.isEmpty())
		{
			supplierDao.delete(supplier);
		}
		else
		{
			for(Product product:lists)
			{
				ProductDao.delete(Product);
				}
			supplierDao.delete(supplier);
		
		}
	}
}
//		
//		
//		List<supplier> list = supplierDao.list();
//		for (supplier s : list) {
//			System.out.println(s.getSid());
//			System.out.println(s.getSname());
//		}
//
//		
//		 if(supplierDao.delete("12")==true)
//		 {
//		 System.out.println("delete is successful");
//		 }
//		 else
//		 {
//		 System.out.println("sorry");
//		 }
//		 
//		 supplier=supplierDao.get("12");
//
//			if (supplier == null) {
//				System.out.println("item is found");
//			} else {
//		 
//




