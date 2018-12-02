package com.yj.domain;

import java.util.Date;

public class Bed extends Materials{

	private static Double rentPrice=1.0;
	public static Double getRentPrice() {
		return rentPrice;
	}
	public Bed(Date buyTime, String maker, Double price, String listId, Double length, Double width) {
		super(buyTime, maker, price, listId, length, width);
		// TODO Auto-generated constructor stub
	}



}
