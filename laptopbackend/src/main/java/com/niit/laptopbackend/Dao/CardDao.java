package com.niit.laptopbackend.Dao;

import java.util.List;

import com.niit.laptopbackend.model.Card;

public interface CardDao 
{
	public boolean saveupdate(Card Card);
	public boolean delete(String ccid);
	public Card get(String ccid);
	public List<Card> list();
	

}
