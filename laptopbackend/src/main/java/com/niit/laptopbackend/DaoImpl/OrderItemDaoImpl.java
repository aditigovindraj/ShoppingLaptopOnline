package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.niit.laptopbackend.Dao.OrderItemDao;
import com.niit.laptopbackend.model.OrderItem;

	@Repository("orderitemDao")
	@EnableTransactionManagement
	public class OrderItemDaoImpl implements OrderItemDao
	{
				
		@Autowired
		SessionFactory sessionFactory;
		public OrderItemDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		@Transactional
		public boolean saveupdate(OrderItem orderItem) {
			sessionFactory.getCurrentSession().saveOrUpdate(orderItem);
			return true;
		}
		@Transactional
		public boolean delete(OrderItem orderItem) {
//			CartItem bil=new CartItem();
//		bil.setCt_id(c_id);
		sessionFactory.getCurrentSession().delete(orderItem);
			return true;
		}
		@Transactional
		public OrderItem get(String OrderItem_id) {
			String q1="from OrderItem where OrderItem_id='"+OrderItem_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<OrderItem> list1=(List<OrderItem>) w.list();
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
		public List<OrderItem> getOrderItembyOrder(String Orderno) {
			String q2="from OrderItem where Orderno='"+Orderno+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q2);
			@SuppressWarnings("unchecked")
			List<OrderItem> list2=(List<OrderItem>) w.list();
			if(list2==null ||list2.isEmpty())
			{
			return null;
			}
			else
			{
				return list2;
			}
		}
		@Transactional
		public List<OrderItem> list() {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked")
			List<OrderItem> OrderItem= (List<OrderItem>) sessionFactory.getCurrentSession().createCriteria(OrderItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return OrderItem;
			

		}

}
