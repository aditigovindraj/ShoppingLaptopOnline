package com.niit.laptopbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.CartDao;
import com.niit.laptopbackend.Dao.CartItemDao;
import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.Dao.UserDao;
import com.niit.laptopbackend.model.Cart;
import com.niit.laptopbackend.model.CartItem;
import com.niit.laptopbackend.model.Product;
import com.niit.laptopbackend.model.user;

public class CartTest 
{
	public static void main(String a[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		CartDao CartDao = (CartDao) context.getBean("CartDao");
		Cart Cart = (Cart) context.getBean("cart");
		CartItemDao CartItemDao = (CartItemDao) context.getBean("CartItemDao");
		CartItem CartItem = (CartItem) context.getBean("cartItem");
		ProductDao ProductDao = (ProductDao) context.getBean("ProductDao");
		Product Product = (Product) context.getBean("product");
		UserDao UserDao = (UserDao) context.getBean("userDao");
		user user = (user) context.getBean("user");
		
		if (CartDao.saveupdate(Cart) == true){ 
			System.out.println("saved");
		} else {
			System.out.println("sorry not saved");
		}
		
		user=UserDao.get("");
		Cart=user.getCart();
		if(Cart.getC_id()==null)
		{
			System.out.println("not data existing");
		}
		else
		{
		System.out.println("data existing");	
		}
		
		
		
//		Cart.setC_grandtotal(0.0);
//		Cart.setC_totalitems(67876);
//		CartDao.saveupdate(Cart);
	}


}
