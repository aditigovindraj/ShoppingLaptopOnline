package com.niit.laptopbackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Order 
{
	private String orderno;
	private double grandtotal=0.0;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="b_id")
	private BillingAddr billingAddr;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="s_id")
	private ShippingAddr shippingAddr;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="pid")
	private Pay pay;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="uid")
	private user user;
	
	@OneToMany(mappedBy="order" ,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItem> orderitem;
	
	public Order()
	{
		this.orderno="ORDR"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	
	
	
	public BillingAddr getBillingAddr() {
		return billingAddr;
	}





	public void setBillingAddr(BillingAddr billingAddr) {
		this.billingAddr = billingAddr;
	}





	public ShippingAddr getShippingAddr() {
		return shippingAddr;
	}





	public void setShippingAddr(ShippingAddr shippingAddr) {
		this.shippingAddr = shippingAddr;
	}





	public Pay getPay() {
		return pay;
	}





	public void setPay(Pay pay) {
		this.pay = pay;
	}





	public user getUser() {
		return user;
	}





	public void setUser(user user) {
		this.user = user;
	}





	public List<OrderItem> getOrderitem() {
		return orderitem;
	}





	public void setOrderitem(List<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}





	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}





	public double getGrandtotal() {
		return grandtotal;
	}





	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	
	
}
