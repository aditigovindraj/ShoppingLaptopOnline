package com.niit.laptopbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.PayDao;
import com.niit.laptopbackend.model.Pay;

public class PayTest
{
	public static void main(String a[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		PayDao PayDao = (PayDao) context.getBean("PayDao");
		Pay Pay = (Pay) context.getBean("pay");
		
		
		
		Pay.setPid("7878");
		Pay.setPmethod("savings");
		Pay.setPstatus("current");
		PayDao.saveupdate(Pay);
	}


}
