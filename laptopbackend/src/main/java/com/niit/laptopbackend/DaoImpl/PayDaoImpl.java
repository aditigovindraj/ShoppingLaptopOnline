package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopbackend.Dao.PayDao;
import com.niit.laptopbackend.model.Pay;



	@Repository("PayDao")
	@EnableTransactionManagement
			

	public class PayDaoImpl implements PayDao 
	{
	@Autowired
	SessionFactory sessionFactory;
	public PayDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveupdate(Pay Pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(Pay);
		return true;
	}
	@Transactional
	public boolean delete(String pid) {
	Pay cat=new Pay();
	cat.setPid(pid);
	sessionFactory.getCurrentSession().delete(cat);
		return true;
	}
	@Transactional
	public Pay get(String pid) {
		String q1="from Pay where pid='"+pid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Pay> list1=(List<Pay>) w.list();
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
	public List<Pay> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Pay> Pay= (List<Pay>) sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Pay;
		

	}
	}




