package com.niit.laptopbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.ShippingAddrDao;
import com.niit.laptopbackend.Dao.UserDao;
import com.niit.laptopbackend.model.ShippingAddr;
import com.niit.laptopbackend.model.user;

public class ShippingAddrTest
{
	public static void main(String a[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		ShippingAddrDao ShippingAddrDao = (ShippingAddrDao) context.getBean("ShippingAddrDao");
		ShippingAddr ShippingAddr = (ShippingAddr) context.getBean("shippingAddr");
		UserDao UserDao = (UserDao) context.getBean("userDao");
		user user = (user) context.getBean("user");
		user=UserDao.get("UFE43E0");
		
		
		
		
		ShippingAddr.setS_no("jkiu4");
		ShippingAddr.setS_street("66");
		ShippingAddr.setS_locality("bjui");
		ShippingAddr.setS_city("mluru");
		ShippingAddr.setS_state("kar");
		ShippingAddr.setS_pincode("560040");
		ShippingAddr.setUser(user);
		ShippingAddrDao.saveupdate(ShippingAddr);
		// save and update
		//ShippingAddr.setCname("satish");

				//ShippingAddr.setCid("12");
				if (ShippingAddrDao.saveupdate(ShippingAddr) == true) {
					System.out.println("saved");
				} else {
					System.out.println("sorry not saved");
				}

		
	}

}
