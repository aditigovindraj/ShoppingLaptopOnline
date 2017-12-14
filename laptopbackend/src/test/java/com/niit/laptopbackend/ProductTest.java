package com.niit.laptopbackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.CategoryDao;
import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.Dao.SupplierDao;
import com.niit.laptopbackend.model.Product;
import com.niit.laptopbackend.model.category;
import com.niit.laptopbackend.model.supplier;

public class ProductTest {
	public static void main(String a[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		
		
	
		ProductDao ProductDao = (ProductDao) context.getBean("ProductDao");
		Product Product = (Product) context.getBean("product");
		category category = (category) context.getBean("category");
		supplier supplier = (supplier) context.getBean("supplier");
		CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
		category=categoryDao.get("hyt5");
		SupplierDao supplierDao = (SupplierDao) context.getBean("supplierDao");
		supplier=supplierDao.get("SBF7B0A");
		
		
	
		Product.setP_name("satish");
		Product.setP_quantity("1");
		Product.setP_price(2599);
		Product.setP_description("good");
		Product.setCategory(category);
		Product.setSupplier(supplier);
		
		

		
		
//		// save and update
//		Product.setP_name("satish");
//
//		Product.setP_id("12");
if (ProductDao.saveupdate(Product) == true) {
			System.out.println("saved");	
			} else
			{
				System.out.println("sorry not saved");
		}
//		
//		
//		List<Product> list = ProductDao.list();
//		for (Product p : list) {
//			System.out.println(p.getP_id());
//			System.out.println(p.getP_name());
//		}
//
//		
//		 if(ProductDao.delete("12")==true)
//		 {
//		 System.out.println("delete is successful");
//		 }
//		 else
//		 {
//		 System.out.println("sorry");
//		 }
//		 
		 
		 
//		 Product=ProductDao.get("12");
//
//		if (Product == null) {
//			System.out.println("item is found");
//		} else {
//			System.out.println(Product.getP_id());
//			System.out.println(Product.getP_name());
//		}
	}

	private static void setP_name(String string) {
		// TODO Auto-generated method stub
		
	}
}




