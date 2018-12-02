package com.yj.domain;

import java.util.Date;

public class Conditioner extends Materials {

	private static Double rentPrice=2.0;
	public static Double getRentPrice() {
		return rentPrice;
	}
	public Conditioner(Date buyTime, String maker, Double price, String listId, String power) {
		super(buyTime, maker, price, listId, power);
		// TODO Auto-generated constructor stub
	}

	

	
	


}
