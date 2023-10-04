package com.ciq.enitity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String pname;
	private Double pcost;
	@Temporal(value = TemporalType.DATE)
	private Date mfd;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer pid, String pname, Double pcost, Date mfd) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.mfd = mfd;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPcost() {
		return pcost;
	}

	public void setPcost(Double pcost) {
		this.pcost = pcost;
	}

	public Date getMfd() {
		return mfd;
	}

	public void setMfd(Date mfd) {
		this.mfd = mfd;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pcost=" + pcost + ", mfd=" + mfd + "]";
	}

}
