package com.niit.laptopbackend;                  

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.CategoryDao;
import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.model.Product;
import com.niit.laptopbackend.model.category;

public class categorytest {
	public static void main(String a[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
		category category = (category) context.getBean("category");
		ProductDao ProductDao = (ProductDao) context.getBean("ProductDao");
		Product Product = (Product) context.getBean("product");
		
		
		category.setCid("hyt5");
		category.setCname("priya");
		categoryDao.saveupdate(category);

		// save and update
		//category.setCname("satish");

		//category.setCid("12");
		if (categoryDao.saveupdate(category) == true) {
			System.out.println("saved");
		} else {
			System.out.println("sorry not saved");
		}
		
		
//		List<category> list = categoryDao.list();
//		for (category c : list) {
//			System.out.println(c.getCid());
//			System.out.println(c.getCname());
//		}

		
//		 if(categoryDao.delete("12")==true)
//		 {
//		 System.out.println("delete is successful");
//		 }
//		 else
//		 {
//		 System.out.println("sorry");
//		 }
//		 
//		 
//		 
//		 category=categoryDao.get("12");
//
//		if (category == null) {
//			System.out.println("item is found");
//		} else {
//			System.out.println(category.getCid());
//			System.out.println(category.getCname());
//		}
//
//	
	}
}
