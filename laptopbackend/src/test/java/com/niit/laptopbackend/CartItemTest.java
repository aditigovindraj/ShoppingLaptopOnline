package com.niit.laptopbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.CartItemDao;
import com.niit.laptopbackend.model.CartItem;

public class CartItemTest 
{
	public static void main(String a[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		CartItemDao CartItemDao = (CartItemDao) context.getBean("CartItemDao");
		CartItem CartItem = (CartItem) context.getBean("cartItem");
		
		
		
		
		CartItemDao.saveupdate(CartItem);
		if (CartItemDao.saveupdate(CartItem) == true) {
			System.out.println("saved");
		} else {
			System.out.println("sorry not saved");
		}
	}



}
