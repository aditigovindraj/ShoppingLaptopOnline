package com.niit.laptopbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.BillingAddrDao;
import com.niit.laptopbackend.model.BillingAddr;

public class BillingAddrTest
{
	public static void main(String a[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		BillingAddrDao BillingAddrDao = (BillingAddrDao) context.getBean("BillingAddrDao");
		BillingAddr BillingAddr = (BillingAddr) context.getBean("billingAddr");
		
		
		
		BillingAddr.setB_no("a675h4");
		BillingAddr.setB_street("67876");
		BillingAddr.setB_locality("jkiugg");
		BillingAddr.setB_city("bluru");
		BillingAddr.setB_state("kar");
		BillingAddr.setB_pincode("560079");
		BillingAddrDao.saveupdate(BillingAddr);
	}

		


}
