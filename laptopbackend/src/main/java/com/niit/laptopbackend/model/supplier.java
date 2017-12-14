package com.niit.laptopbackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component


public class supplier {
	private static final long SerialVersionUID=1l;
	@Id
	private String sid;
	private String sname;
	private String address;
	private String contact;
	
	
	
	@OneToMany(mappedBy="supplier")
	private List<Product> product;
	
		
	
	
    public supplier()
	
	{
		this.sid="S"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
		
	
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}




	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSid() {
		return sid;
	}


	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
	