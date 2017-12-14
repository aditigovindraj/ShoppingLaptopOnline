package com.niit.laptopbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopbackend.Dao.CategoryDao;
import com.niit.laptopbackend.model.category;

@Repository("categoryDao")
@EnableTransactionManagement
		

public class CategoryDaoImpl implements CategoryDao 
{
@Autowired
SessionFactory sessionFactory;
public CategoryDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
@Transactional
public boolean saveupdate(category category) {
	sessionFactory.getCurrentSession().saveOrUpdate(category);
	return true;
}
@Transactional
public boolean delete(category category) {

sessionFactory.getCurrentSession().delete(category);
	return true;
}
@Transactional
public category get(String cid) {
	String q1="from category where cid='"+cid+"'";
	Query w=sessionFactory.getCurrentSession().createQuery(q1);
	@SuppressWarnings("unchecked")
	List<category> list1=(List<category>) w.list();
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
public List<category> list() {
	// TODO Auto-generated method stub
	@SuppressWarnings("unchecked")
	List<category> category= (List<category>) sessionFactory.getCurrentSession().createCriteria(category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return category;
	

}
}



