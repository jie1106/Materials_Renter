package com.yj.service.impl.record;

import java.util.List;

import com.yj.dao.ContainerDao;
import com.yj.domain.Container;
import com.yj.domain.Renter;

public class ContainerServiceImpl {
	ContainerDao dao=new ContainerDao();
	
	
	public void add(Container container) {
	
	dao.add(container);
		
	}
	//根据物品编号查询物品对象
	public Container findContainerByListId(String listId) {
		ContainerDao dao = new ContainerDao();
		return dao.findContainerByListId(listId);
	}
	public String findRenterIdByListId(String listId) {
		return new ContainerDao().findRenterIdByListId(listId);
		
		
	}
	public Renter findRenterByRenterId(String renterId) {
		return new ContainerDao().findRenterByRenterId(renterId);
		// TODO Auto-generated method stub
		
	}
	public Renter findRenterMessageByListId(String listId) {
		return new ContainerDao().findRenterMessageByListId(listId);
	}
	public List<Container> findContainerByRenterId(String renterId) {
		return new ContainerDao().findContainerByRenterId(renterId);
	
		
	}
	public List<Container> findAll() {
		return new ContainerDao().findAll();
		
		
	}
	
	
}
