package com.yj.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public abstract  class Materials {
	
	private Date buyTime;
	private String maker;
	private Double buyPrice;
	private String listId;
	private String renterId;
	private Renter renter;
	private Double length;
	private Double width;
	private Double height;
	private String power;
	private Date renterBeginTime;
	private Date renterEndTime;
	private Double renterDeposit;
	private boolean status=false;//未被租
	private int mstatus=0;//未被租
	private static  Double rentPrice;
	public Double getRenterDeposit() {
		return renterDeposit;
	}
	public void setRenterDeposit(Double renterDeposit) {
		this.renterDeposit = renterDeposit;
	}
	public String getRenterId() {
		return renterId;
	}
	public void setRenterId(String renterId) {
		this.renterId = renterId;
	}
	public Date getRenterBeginTime() {
		return renterBeginTime;
	}
	public void setRenterBeginTime(Date renterBeginTime) {
		this.renterBeginTime = renterBeginTime;
	}
	public Date getRenterEndTime() {
		return renterEndTime;
	}
	public void setRenterEndTime(Date renterEndTime) {
		this.renterEndTime = renterEndTime;
	}

	

	
	public int getMstatus() {
		return mstatus;
	}
	public void setMstatus(int mstatus) {
		this.mstatus = mstatus;
	}
	public static void setRentPrice(Double rentPrice) {
		Materials.rentPrice = rentPrice;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public static Double getRentPrice() {
		return rentPrice;
	}

	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Renter getRenter() {
		return renter;
	}
	public void setRenter(Renter renter) {
		this.renter = renter;
	}
	public Materials() {
		super();
	}
	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	
	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}
	public Materials(Date buyTime, String maker, Double buyPrice, String listId, Double length, Double width,
			Double height) {
		super();
		this.buyTime = buyTime;
		this.maker = maker;
		this.buyPrice = buyPrice;
		this.listId = listId;
		this.length = length;
		this.width = width;
		this.height = height;
	}
	public Materials(Date buyTime, String maker, Double buyPrice, String listId, Double length, Double width) {
		super();
		this.buyTime = buyTime;
		this.maker = maker;
		this.buyPrice = buyPrice;
		this.listId = listId;
		this.length = length;
		this.width = width;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public Materials(Date buyTime, String maker, Double buyPrice, String listId, String power) {
		super();
		this.buyTime = buyTime;
		this.maker = maker;
		this.buyPrice = buyPrice;
		this.listId = listId;
		this.power = power;
	}
	
	
	



	
	
	
	


}
