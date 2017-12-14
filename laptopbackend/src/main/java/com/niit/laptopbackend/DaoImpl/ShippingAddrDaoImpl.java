package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopbackend.Dao.ShippingAddrDao;
import com.niit.laptopbackend.model.ShippingAddr;


	@Repository("ShippingAddrDao")
	@EnableTransactionManagement
	public class ShippingAddrDaoImpl implements ShippingAddrDao
	{
				
		@Autowired
		SessionFactory sessionFactory;
		public ShippingAddrDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		@Transactional
		public boolean saveupdate(ShippingAddr ShippingAddr) {
			sessionFactory.getCurrentSession().saveOrUpdate(ShippingAddr);
			return true;
		}
		@Transactional
		public boolean delete(String s_id) {
			ShippingAddr bil=new ShippingAddr();
		bil.setS_id(s_id);
		sessionFactory.getCurrentSession().delete(bil);
			return true;
		}
		@Transactional
		public ShippingAddr get(String s_id) {
			String q1="from ShippingAddr where s_id='"+s_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<ShippingAddr> list1=(List<ShippingAddr>) w.list();
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
		public List<ShippingAddr> list() {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked")
			List<ShippingAddr> ShippingAddr= (List<ShippingAddr>) sessionFactory.getCurrentSession().createCriteria(ShippingAddr.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return ShippingAddr;
			

		}
		@Override
		public List<ShippingAddr> getAddrByUser(String uid) 
		{
			String q2="from ShippingAddr where uid='"+uid+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q2);
			@SuppressWarnings("unchecked")
			List<ShippingAddr> list2=(List<ShippingAddr>) w.list();
			if(list2==null ||list2.isEmpty())
			{
			return null;
			}
			else
			{
				return list2;
			}
		}
	}






