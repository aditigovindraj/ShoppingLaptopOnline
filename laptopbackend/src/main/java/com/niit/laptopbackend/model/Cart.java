package com.niit.laptopbackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Cart
{
	private static final long SerialVersionUID=1l;
	@Id
	private String c_id;
 double c_grandtotal=0.0;
	private int c_totalitems=0;
	@OneToMany(mappedBy="cart")
	 List<CartItem> ca;

	
    public Cart()
	
	{
		this.c_id="C"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public List<CartItem> getCa() {
		return ca;
	}
	public void setCa(List<CartItem> ca) {
		this.ca = ca;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	
	public double getC_grandtotal() {
		return c_grandtotal;
	}
	public void setC_grandtotal(double c_grandtotal) {
		this.c_grandtotal = c_grandtotal;
	}
	public int getC_totalitems() {
		return c_totalitems;
	}
	public void setC_totalitems(int c_totalitems) {
		this.c_totalitems = c_totalitems;
	}
	
}
