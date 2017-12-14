package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopbackend.Dao.UserDao;
import com.niit.laptopbackend.model.BillingAddr;
import com.niit.laptopbackend.model.Cart;
import com.niit.laptopbackend.model.user;
@Repository("UserDao")
@EnableTransactionManagement

public class UserDaoImpl implements UserDao 
{
			
		@Autowired
		SessionFactory sessionFactory;
		public UserDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional
		public boolean saveupdate(user User) {
			Cart cart=new Cart();
			User.setCart(cart);
			BillingAddr bill= new BillingAddr();
			User.setBillingAddr(bill);
			sessionFactory.getCurrentSession().save(User);
			sessionFactory.getCurrentSession().save(User.getCart());
			sessionFactory.getCurrentSession().save(User.getBillingAddr());
			return true;
		}
		
		@Transactional
		public boolean delete(String uid) {
			user sup=new user();
		sup.setUid(uid);
		sessionFactory.getCurrentSession().delete(sup);
			return true;
		}
		
		@Transactional
		public user get(String uid) {
			String q1="from user where uid='"+uid+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<user> list1=(List<user>) w.list();
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
		public List<user> list() {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked")
			List<user> user= (List<user>) sessionFactory.getCurrentSession().createCriteria(user.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return user;
		}

		@Transactional	
public user isvalid(String email,String password)
{
	String q2="from user where email='"+email+"'and password='"+password+"'";
	Query w=sessionFactory.getCurrentSession().createQuery(q2);
	@SuppressWarnings("unchecked")
	List<user> list2=(List<user>) w.list();
	if(list2==null ||list2.isEmpty())
	{
	return null;
	}
	else
	{
		return list2.get(0);
	}	
}
		public user email(String email)
		{
			String q3="from user where email='"+email+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q3);
			@SuppressWarnings("unchecked")
			List<user> list3=(List<user>) w.list();
			if(list3==null ||list3.isEmpty())
			{
			return null;
			}
			else
			{
				return list3.get(0);
			}	
		}
		
}


