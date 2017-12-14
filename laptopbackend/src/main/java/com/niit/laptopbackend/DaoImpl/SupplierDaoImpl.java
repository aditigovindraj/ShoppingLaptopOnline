package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopbackend.Dao.SupplierDao;
import com.niit.laptopbackend.model.supplier;
@Repository("supplierDao")
@EnableTransactionManagement

public class SupplierDaoImpl implements SupplierDao 
{

	@Autowired
	SessionFactory sessionFactory;
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveupdate(supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}
	@Transactional
	public boolean delete(supplier supplier) {
		
	sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}
	@Transactional
	public supplier get(String sid) {
		String q1="from supplier where sid='"+sid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<supplier> list1=(List<supplier>) w.list();
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
	public List<supplier> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<supplier> supplier= (List<supplier>) sessionFactory.getCurrentSession().createCriteria(supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return supplier;
		

	}
	
	}



