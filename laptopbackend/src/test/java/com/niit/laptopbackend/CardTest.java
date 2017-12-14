package com.niit.laptopbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopbackend.Dao.CardDao;
import com.niit.laptopbackend.model.Card;

public class CardTest 
{
	public static void main(String a[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		CardDao CardDao = (CardDao) context.getBean("CardDao");
		Card Card = (Card) context.getBean("card");
		
		
		
		Card.setCcid("hdh6");
		Card.setCcno("bgxyeu");
		Card.setCholdname("arjun");
		Card.setCexpirydate("7-12-2025");
		CardDao.saveupdate(Card);
	}



}
