package com.yj.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.javafx.css.Combinator;
import com.sun.prism.Material;
import com.yj.domain.Container;
import com.yj.domain.Materials;
import com.yj.domain.Renter;
import com.yj.utils.DataSourceUtils;

public class ContainerDao {


	QueryRunner queryRunner = new QueryRunner();

	public void add(Container container) {

		String sql = "insert into container values (?,?,?,?,?,?,?,?)";
		try {
			Connection conn = DataSourceUtils.getConnection();
			Object[] parameter = { container.getListId(), container.getMaker(), container.getBuyTime(),
					container.getBuyPrice(), container.getLength(), container.getWidth(), container.getHeight(),
					container.getMstatus() };

			queryRunner.update(conn, sql, parameter);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Container findContainerByListId(String listId) {
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from container where listId =?";
		try {
			System.out.println("进入查询");
			Container container = runner.query(sql, new BeanHandler<>(Container.class), listId);
			System.out.println("结束查询,判断container对象");
			if(container==null) {
				System.out.println("container为空");
				
			}
			return container;
		} catch (SQLException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String findRenterIdByListId(String listId) {
				
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select renterId from mr where listId =?";
		try {
			Object renterId = runner.query(sql,new ScalarHandler(),listId);
			System.out.println("获取renterId"+renterId);
			return (String) renterId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public Renter findRenterByRenterId(String renterId) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from renter where renterId =?";
		try {
			System.out.println("进入查询");
			  Renter renter = runner.query(sql, new BeanHandler<Renter>(Renter.class), renterId);
			System.out.println("结束查询,判断renter对象");
			if(renter==null) {
				System.out.println("renter为空");
				
			}
			return renter;
		} catch (SQLException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Renter findRenterMessageByListId(String listId) {
		System.out.println("listid1------:" + listId);
		System.out.println("进入findRenterMessageByListId");
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from mr where listId =?";
		try {

			Renter renter = runner.query(sql, new BeanHandler<Renter>(Renter.class), listId);
			System.out.println("生成renter");

			
			if(renter!=null) {
				System.out.println("生成renter");

				System.out.println("begin" + renter.getRenterBeginTime());
				System.out.println("renterId" + renter.getRenterId());
				System.out.println("listid2------:" + listId);
				System.out.println("end" + renter.getRenterEndTime());
			}
			

			return renter;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public List<Container> findContainerByRenterId(String renterId) {
		System.out.println("进入findContainerByRenterId");
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	
		String sql = "select * from mr where renterId =?";
		try {
			

		List<Container> containerList = runner.query(sql,  new BeanListHandler<Container>(Container.class), renterId);
	/*	for (Container container : containerList) {
			System.out.println("开始时间："+container.getRenterBeginTime()+"结束时间:"+container.getRenterEndTime());
		}*/

		return  containerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Container> findAll() {
		System.out.println("进入findAll");
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	
		String sql = "select * from container";
		try {
			System.out.println("进入findAll");

		List<Container> containerList = runner.query(sql,  new BeanListHandler<Container>(Container.class));
	/*	for (Container container : containerList) {
			System.out.println("开始时间："+container.getRenterBeginTime()+"结束时间:"+container.getRenterEndTime());
		}*/
		System.out.println("结束findAll");
		return  containerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
