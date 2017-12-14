package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopbackend.Dao.CardDao;
import com.niit.laptopbackend.model.Card;


	@Repository("CardDao")
	@EnableTransactionManagement
			

	public class CardDaoImpl implements CardDao 
	{
	@Autowired
	SessionFactory sessionFactory;
	public CardDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveupdate(Card Card) {
		sessionFactory.getCurrentSession().saveOrUpdate(Card);
		return true;
	}
	@Transactional
	public boolean delete(String ccid) {
		Card cat=new Card();
	cat.setCcid(ccid);
	sessionFactory.getCurrentSession().delete(cat);
		return true;
	}
	@Transactional
	public Card get(String ccid) {
		String q1="from Card where ccid='"+ccid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list1=(List<Card>) w.list();
		if(list1==null ||list1.isEmpty())
		{
		return null;
		}
		else
		{
			return list1.get(0);
		}
	}

	@Transactional
	public List<Card> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Card> Card=(List<Card>) sessionFactory.getCurrentSession().createCriteria(Card.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Card;
		

	}
	}




