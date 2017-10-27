package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class Cust implements Serializable {
	private int id;
	private String productid;
	private String xinghao;
	private String pihao;
	private String parame1;
	private String parame1p;
	private String parame2;
	private String parame2p;
	private Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getXinghao() {
		return xinghao;
	}
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	public String getPihao() {
		return pihao;
	}
	public void setPihao(String pihao) {
		this.pihao = pihao;
	}
	public String getParame1() {
		return parame1;
	}
	public void setParame1(String parame1) {
		this.parame1 = parame1;
	}
	public String getParame1p() {
		return parame1p;
	}
	public void setParame1p(String parame1p) {
		this.parame1p = parame1p;
	}
	public String getParame2() {
		return parame2;
	}
	public void setParame2(String parame2) {
		this.parame2 = parame2;
	}
	public String getParame2p() {
		return parame2p;
	}
	public void setParame2p(String parame2p) {
		this.parame2p = parame2p;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date datetime) {
		this.time = datetime;
	}
}
