package com.yj.domain;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;



public class Renter {
	private String renterName;
	private String renterPhone;
	private String renterCompany;
	private Double renterDeposit;
	private Date renterBeginTime;
	private Date renterEndTime;
	private Materials materials;

	private String ListId;
	
	private List<Materials> renterList=new ArrayList<Materials>();
	
	private Double renterTotalCharge;
	
	private String renterId;

	public String getRenterId() {
		return renterId;
	}



	public void setRenterId(String renterId) {
		this.renterId = renterId;
	}


	
	public String getRenterName() {
		return renterName;
	}



	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}



	public String getRenterPhone() {
		return renterPhone;
	}



	public void setRenterPhone(String renterPhone) {
		this.renterPhone = renterPhone;
	}



	public String getRenterCompany() {
		return renterCompany;
	}



	public void setRenterCompany(String renterCompany) {
		this.renterCompany = renterCompany;
	}



	public Double getRenterDeposit() {
		return renterDeposit;
	}



	public void setRenterDeposit(Double renterDeposit) {
		this.renterDeposit = renterDeposit;
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




	public Double getRenterTotalCharge() {
		return renterTotalCharge;
	}



	


	public String getListId() {
		return ListId;
	}



	public void setListId(String listId) {
		ListId = listId;
	}



	public void setRenterTotalCharge(Double renterTotalCharge) {
		this.renterTotalCharge = renterTotalCharge;
	}


	public Double getTotalCharge() {

		Integer days = (int) ((this.getEndTime().getTime() - this.getBeginTime().getTime()) / (1000 * 3600 * 24));

		List<Materials> renterList2 = this.getRenterList();
		for (Materials materials : renterList2) {

			this.renterTotalCharge += (materials.getRentPrice()) * days;
		}
		return this.renterTotalCharge;
	}



	public Renter() {
		super();
		// TODO Auto-generated constructor stub
	}



	public List<Materials> getRenterList() {
		return renterList;
	}

	public String getPhone() {
		return renterPhone;
	}

	public void setPhone(String renterPhone) {
		this.renterPhone = renterPhone;
	}

	public void setRenterList(List<Materials> renterList) {
		this.renterList = renterList;
	}
	public String getName() {
		return renterName;
	}
	public void setName(String renterName) {
		this.renterName = renterName;
	}
	
	public String getCompany() {
		return renterCompany;
	}
	public void setCompany(String renterCompany) {
		this.renterCompany = renterCompany;
	}
	public Double getDeposit() {
		return renterDeposit;
	}
	public void setDeposit(Double renterDeposit) {
		this.renterDeposit = renterDeposit;
	}
	public Date getBeginTime() {
		return renterBeginTime;
	}
	public void setBeginTime(Date renterBeginTime) {
		this.renterBeginTime = renterBeginTime;
	}
	public Date getEndTime() {
		return renterEndTime;
	}
	public void setEndTime(Date renterEndTime) {
		this.renterEndTime = renterEndTime;
	}
	public Materials getMaterials() {
		return materials;
	}
	public void setMaterials(Materials materials) {
		this.materials = materials;
	}
	
	
	public Renter(String renterName, String  renterPhone, String renterCompany, Double renterDeposit, Date renterBeginTime, Date renterEndTime) {
		super();
		this.renterName = renterName;
		this.renterPhone = renterPhone;
		this.renterCompany = renterCompany;
		this.renterDeposit = renterDeposit;
		this.renterBeginTime = renterBeginTime;
		this.renterEndTime = renterEndTime;
	}
	
	

}
