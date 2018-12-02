package com.yj.domain;

import java.util.Date;

public class Container  extends Materials{

	private static Double rentPrice=6.0;
	public static Double getRentPrice() {
		return rentPrice;
	}
	public Container(Date buyTime, String maker, Double price, String listId, Double length, Double width,
			Double height) {
		super(buyTime, maker, price, listId, length, width, height);
		// TODO Auto-generated constructor stub
	}
	public Container() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	



}
