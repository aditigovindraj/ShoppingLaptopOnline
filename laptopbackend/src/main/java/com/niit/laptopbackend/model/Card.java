package com.niit.laptopbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Card 
{
	private static final long SerialVersionUID=1l;
	@Id
	private String ccid;
	private String ccno;
	private String choldname;
	private String cexpirydate;
	
	
	
	
public Card()
	
	{
		this.ccid="C"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	

	
	
	
	public String getCcid() {
		return ccid;
	}
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}
	public String getCcno() {
		return ccno;
	}
	public void setCcno(String ccno) {
		this.ccno = ccno;
	}
	public String getCholdname() {
		return choldname;
	}
	public void setCholdname(String choldname) {
		this.choldname = choldname;
	}
	public String getCexpirydate() {
		return cexpirydate;
	}
	public void setCexpirydate(String cexpirydate) {
		this.cexpirydate = cexpirydate;
	}
}





	