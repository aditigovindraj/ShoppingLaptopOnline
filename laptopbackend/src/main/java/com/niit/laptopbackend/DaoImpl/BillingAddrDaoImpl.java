package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopbackend.Dao.BillingAddrDao;
import com.niit.laptopbackend.model.BillingAddr;


	@Repository("BillingAddrDao")
	@EnableTransactionManagement
	public class BillingAddrDaoImpl implements BillingAddrDao
	{
				
		@Autowired
		SessionFactory sessionFactory;
		public BillingAddrDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		@Transactional
		public boolean saveupdate(BillingAddr BillingAddr) {
			sessionFactory.getCurrentSession().saveOrUpdate(BillingAddr);
			return true;
		}
		@Transactional
		public boolean delete(String b_id) {
			BillingAddr bil=new BillingAddr();
		bil.setB_id(b_id);
		sessionFactory.getCurrentSession().delete(bil);
			return true;
		}
		@Transactional
		public BillingAddr get(String b_id) {
			String q1="from  BillingAddr where b_id='"+b_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<BillingAddr> list1=(List<BillingAddr>) w.list();
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
		public BillingAddr getByUser(String uid) {
			String q2="from  BillingAddr where uid='"+uid+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q2);
			@SuppressWarnings("unchecked")
			List<BillingAddr> list2=(List<BillingAddr>) w.list();
			if(list2==null ||list2.isEmpty())
			{
			return null;
			}
			else
			{
				return list2.get(0);
			}
		}

		@Transactional
		public List<BillingAddr> list() {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked")
			List<BillingAddr> BillingAddr= (List<BillingAddr>) sessionFactory.getCurrentSession().createCriteria(BillingAddr.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return BillingAddr;
			

		}
		}




