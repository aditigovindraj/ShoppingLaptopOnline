package com.niit.laptopbackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component


public class user {
	
	@Id
	private String uid;
	private String uname;
	private String password;
	private String address;
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="b_id")
	private BillingAddr billingAddr;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="c_id")
	private Cart cart;
	
	
	
	@OneToMany(mappedBy="user")
	private List<ShippingAddr> shippingAddr;
	
public user()
	
	{
		this.uid="U"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
		public List<ShippingAddr> getShippingAddr() {
		return shippingAddr;
	}


	public void setShippingAddr(List<ShippingAddr> shippingAddr) {
		this.shippingAddr = shippingAddr;
	}


		public BillingAddr getBillingAddr()
		{
	       return billingAddr;
		}


public void setBillingAddr(BillingAddr billingAddr)
{
	this.billingAddr = billingAddr;
}





public Cart getCart()
{
	return cart;
}


public void setCart(Cart cart)
{
	this.cart = cart;
}





		public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
