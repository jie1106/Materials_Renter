package com.yj.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yj.domain.Renter;
import com.yj.utils.CommonsUtils;
import com.yj.utils.DataSourceUtils;



public class RentRecordDao {

	
	//表中没有该renter时
	public void addRenterBoth(Renter renter) {
		

		
		QueryRunner runner = new QueryRunner();
	
		String sql = "insert into renter values (?,?,?)";
		String sql2 ="insert into mr values (?,?,?,?,?,?)";
		String sql3 = "update container set mstatus=? where listId=?";

		Object[] params = {1, renter.getMaterials().getListId() };

		try {
			Connection conn = DataSourceUtils.getConnection();
			Object[] parameter = {renter.getRenterId(),renter.getRenterName(),renter.getRenterCompany()};
		
			runner.update(conn,sql,parameter);
			
		//同时要生成mrId,绑定renterId和listId,renterId和listID是一对多的关系
			
			Object[] p2= {CommonsUtils.getUUID(),renter.getRenterId(),renter.getListId(),renter.getDeposit(),renter.getBeginTime(),renter.getEndTime()};
			System.out.println("进行UUID插入");
			runner.update(conn,sql2,p2);
			System.out.println("uuid插入结束");
			
			//同时将状态位置1
			runner.update(conn,sql3, params);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	public boolean isRenterHas(String renterId) {
	
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from renter where renterId =?";
		  try {
			Renter renter = runner.query(sql, new BeanHandler<>(Renter.class), renterId);
			if(renter!=null) {
				return true;//代表存在
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
		
	
	}


	public boolean isMaterBeRentByListId(String listId) {

		String sql = "select * from mr";
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		try {
			// 将查询的结果的每一行存入到一个map中，键为列名，值为各列值；然后再将map存入list中；
			List<Map<String, Object>> map = runner.query(sql, new MapListHandler());
			// System.out.println(map);
			// System.out.println(m.get(listId));
			for (Map<String, Object> m : map) {

				System.out.println(m);
				for (Entry<String, Object> mm : m.entrySet()) {
					if (mm.getKey().equals("listId")) {
						System.out.println("value:"+mm.getValue());
						if (mm.getValue().equals(listId)) {
							System.out.println("相同");
							return true;
						}
					}
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

	public boolean isRenterIdHas(String renterId) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from renter";
		//调用方法query，传递结果集实现类ColumnListHandler
		//实现类构造方法，使用字符串的列名
		List<Object> list=null;
		try {
			list = runner.query(sql,new ColumnListHandler("renterId") );
			if(list.contains(renterId)) {
				System.out.println("已经包含该renter");
			return true;
			}/*else {
				System.out.println("不包含");
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		return false;
		// TODO Auto-generated method stub
		
	}

	public void addRenter2mr(Renter renter) {
		// TODO Auto-generated method stub

		QueryRunner runner = new QueryRunner();
		String sql ="insert into mr values (?,?,?,?,?,?)";
		String sql3 = "update container set mstatus=? where listId=?";
		Object[] params = {1, renter.getMaterials().getListId() };

		
		try {
			Connection conn = DataSourceUtils.getConnection();

			// 同时要生成mrId,绑定renterId和listId,renterId和listID是一对多的关系

			Object[] p2= {CommonsUtils.getUUID(),renter.getRenterId(),renter.getListId(),renter.getDeposit(),renter.getBeginTime(),renter.getEndTime()};
			System.out.println("进行UUID插入,添加mr记录");
			runner.update(conn, sql, p2);
			System.out.println("uuid插入结束，记录添加结束");
			//同时将状态位置1
			runner.update(conn,sql3, params);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void setMStatus1ByListId(String listId) {
	
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "update container set mstatus=? where listId=?";

		Object[] params = {1, listId };

		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
	}

	

}
