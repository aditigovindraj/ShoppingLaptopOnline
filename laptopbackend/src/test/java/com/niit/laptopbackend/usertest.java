package com.niit.laptopbackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.UserDao;
import com.niit.laptopbackend.model.BillingAddr;
import com.niit.laptopbackend.model.Cart;
import com.niit.laptopbackend.model.user;

public class usertest {
	public static void main(String a [])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		UserDao UserDao = (UserDao) context.getBean("userDao");
		user user = (user) context.getBean("user");
		Cart cart = (Cart) context.getBean("cart");
		BillingAddr billingAddr = (BillingAddr) context.getBean("billingAddr");
		
		user.setUname("sindhu");
		user.setPassword("1");
		user.setAddress("2599");
		user.setEmail("good");
		user.setCart(cart);
		user.setBillingAddr(billingAddr);

		// save and update
		//user.setUname("satish");

		//user.setUid("12");
		if (UserDao.saveupdate(user) == true){ 
			System.out.println("saved");
		} else {
			System.out.println("sorry not saved");
		}
//		
//		
//		List<user> list = UserDao.list();
//		for (user u : list) {
//			System.out.println(u.getUid());
//			System.out.println(u.getUname());
//		}
//
//		
//		 if(UserDao.delete("12")==true)
//		 {
//		 System.out.println("delete is successful");
//		 }
//		 else
//		 {
//		 System.out.println("sorry");
//		 }
		 
		 
		 
//		 user=UserDao.get("12");
//
//		if (user == null) {
//			System.out.println("item is found");
//		} else {
//			System.out.println(user.getUid());
//			System.out.println(user.getUname());
//		}

	
	}



		
	}


