package com.niit.laptopbackend.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.laptopbackend.Dao.AuthenticationDao;
import com.niit.laptopbackend.Dao.BillingAddrDao;
import com.niit.laptopbackend.Dao.CardDao;
import com.niit.laptopbackend.Dao.CartDao;
import com.niit.laptopbackend.Dao.CartItemDao;
import com.niit.laptopbackend.Dao.CategoryDao;
import com.niit.laptopbackend.Dao.PayDao;
import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.Dao.ShippingAddrDao;
import com.niit.laptopbackend.Dao.SupplierDao;
import com.niit.laptopbackend.Dao.UserDao;
import com.niit.laptopbackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.laptopbackend.DaoImpl.BillingAddrDaoImpl;
import com.niit.laptopbackend.DaoImpl.CardDaoImpl;
import com.niit.laptopbackend.DaoImpl.CartDaoImpl;
import com.niit.laptopbackend.DaoImpl.CartItemDaoImpl;
import com.niit.laptopbackend.DaoImpl.CategoryDaoImpl;
import com.niit.laptopbackend.DaoImpl.PayDaoImpl;
import com.niit.laptopbackend.DaoImpl.ProductDaoImpl;
import com.niit.laptopbackend.DaoImpl.ShippingAddrDaoImpl;
import com.niit.laptopbackend.DaoImpl.SupplierDaoImpl;
import com.niit.laptopbackend.DaoImpl.UserDaoImpl;
import com.niit.laptopbackend.model.BillingAddr;
import com.niit.laptopbackend.model.Card;
import com.niit.laptopbackend.model.Cart;
import com.niit.laptopbackend.model.CartItem;
import com.niit.laptopbackend.model.Pay;
import com.niit.laptopbackend.model.Product;
import com.niit.laptopbackend.model.ShippingAddr;
import com.niit.laptopbackend.model.category;
import com.niit.laptopbackend.model.supplier;
import com.niit.laptopbackend.model.user;
@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement

public class ApplicationContext
{
	@Bean("dataSource")  //create a object without new keyword
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
//		Properties connectionProperties=new Properties();
//		connectionProperties.setProperty("hibernate.connection.pool_size", "10");
//		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//		connectionProperties.setProperty("hibernate.show_sql", "true");
//		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect");
	return dataSource;
	}
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}
	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(supplier.class);
		sessionBuilder.addAnnotatedClass(user.class);
		sessionBuilder.addAnnotatedClass(BillingAddr.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(ShippingAddr.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Card.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
	   // sessionBuilder.buildMapping(net.viralpatel.hibernate.UserDetails2);
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	@Autowired
	@Bean(name="categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory)
	{
		return new CategoryDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory)
	{
		return new SupplierDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="ProductDao")	
	public ProductDao getProductDao(SessionFactory sessionFactory)
	{
		return new ProductDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="userDao")
	public UserDao getUserDao(SessionFactory sessionFactory)
	{
		return new UserDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="billingAddrDao")
	public BillingAddrDao getBillingAddrDao(SessionFactory sessionFactory)
	{
		return new BillingAddrDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory)
	{
		return new CartDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="shippingAddrDao")
	public ShippingAddrDao getShippingAddrDao(SessionFactory sessionFactory)
	{
		return new ShippingAddrDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="payDao")
	public PayDao getPayDao(SessionFactory sessionFactory)
	{
		return new PayDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="cardDao")
	public CardDao getCardDao(SessionFactory sessionFactory)
	{
		return new CardDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory)
	{
		return new AuthenticationDaoImpl(sessionFactory);
	}
	

}
