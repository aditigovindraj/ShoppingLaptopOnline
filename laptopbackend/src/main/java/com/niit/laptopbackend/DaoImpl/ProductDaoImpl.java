
package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.model.Product;



	@Repository("ProductDao")
	@EnableTransactionManagement
	public class ProductDaoImpl implements ProductDao  
	{
				
		@Autowired
		SessionFactory sessionFactory;
		public ProductDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		@Transactional
		public boolean saveupdate(Product Product) {
			sessionFactory.getCurrentSession().saveOrUpdate(Product);
			return true;
		}
		@Transactional
		public boolean delete(Product product) {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		@Transactional
		public Product get(String p_id) {
			String q1="from Product where p_id='"+p_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<Product> list1=(List<Product>) w.list();
			if(list1==null ||list1.isEmpty())
			{
			return null;
			}
			else
			{
				return list1.get(0);
			}
		}

//		@Transactional
//		public List<Product> list() {
//			// TODO Auto-generated method stub
//			@SuppressWarnings("unchecked")
//			List<Product> Product= (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//			return Product;
//			
//
//		}
		
	
	@Transactional
	public List<Product> getProductByCategory(String cid) {
		String q1="from Product where cid='"+cid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Product> list1=(List<Product>) w.list();
		if(list1==null ||list1.isEmpty())
		{
		return null;
		}
		else
		{
			return list1;
		}
	}
	@Transactional
	public List<Product> getProductBySupplier(String sid) {
		String q2="from Product where sid='"+sid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<Product> list1=(List<Product>) w.list();
		if(list1==null ||list1.isEmpty())
		{
		return null;
		}
		else
		{
			return list1;
		}
	}
//	@Override
//	public List<Product> list() {
//		// TODO Auto-generated method stub
//		return null;
	@Transactional
	public List<Product> list() {
		List<Product> product= (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return product;
	}
	}
//	
//	}
//	@Override
//	public List<Product> getProductBySupplier(String sid) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public List<Product> getProductByCategory(String cid) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public List<Product> list() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	}
//
//		
	







