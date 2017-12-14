package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopbackend.Dao.CartItemDao;
import com.niit.laptopbackend.model.CartItem;


	@Repository("CartItemDao")
	@EnableTransactionManagement
	public class CartItemDaoImpl implements CartItemDao
	{
				
		@Autowired
		SessionFactory sessionFactory;
		public CartItemDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		@Transactional
		public boolean saveupdate(CartItem CartItem) {
			sessionFactory.getCurrentSession().saveOrUpdate(CartItem);
			return true;
		}
		@Transactional
		public boolean delete(String c_id) {
			CartItem bil=new CartItem();
		bil.setCt_id(c_id);
		sessionFactory.getCurrentSession().delete(bil);
			return true;
		}
		@Transactional
		public CartItem get(String ct_id) {
			String q1="from CartItem where ct_id='"+ct_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<CartItem> list1=(List<CartItem>) w.list();
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
		public List<CartItem> list() {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked")
			List<CartItem> CartItem= (List<CartItem>) sessionFactory.getCurrentSession().createCriteria(CartItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return CartItem;
			

		}

		
		@Transactional
		public CartItem getListall(String c_id,String p_id) {
			String q3="from CartItem where c_id='"+c_id+"'and p_id='"+p_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q3);
			@SuppressWarnings("unchecked")
			List<CartItem> list3=(List<CartItem>) w.list();
			if(list3==null ||list3.isEmpty())
			{
			return null;
			}
			else
			{
				return list3.get(0);
			}
		}
		@Override
		public List<CartItem> getCartItemByCart(String c_id) {
			String q2="from CartItem where c_id='"+c_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q2);
			@SuppressWarnings("unchecked")
			List<CartItem> list2=(List<CartItem>) w.list();
			if(list2==null ||list2.isEmpty())
			{
			return null;
			}
			else
			{
				return list2;
			}
		}
		@Override
		public List<CartItem> getlist(String c_id) {
			String q4="from CartItem where c_id='"+c_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q4);
			@SuppressWarnings("unchecked")
			List<CartItem> list4=(List<CartItem>) w.list();
			if(list4==null ||list4.isEmpty())
			{
			return null;
			}
			else
			{
				return list4;
			}
		}
		@Override
		public List<CartItem> getListByProduct(String p_id) 
		{
			String q5="from Product where p_id='"+p_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q5);
			@SuppressWarnings("unchecked")
			List<CartItem> list5=(List<CartItem>) w.list();
			if(list5==null ||list5.isEmpty())
			{
			return null;
			}
			else
			{
				return list5;
			}
		}

	}
	

				