package com.niit.laptopbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component


public class Pay 
{
	private static final long SerialVersionUID=1l;
	@Id
	private String pid;
	private String pmethod;
	private String pstatus;
	
	
	
public Pay()
	
	{
		this.pid="P"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	

	
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPmethod() {
		return pmethod;
	}
	public void setPmethod(String pmethod) {
		this.pmethod = pmethod;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	

	
}

