package com.yj.web;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yj.domain.Container;
import com.yj.domain.Renter;
import com.yj.service.impl.record.ContainerServiceImpl;
import com.yj.service.impl.record.BuyRecordServiceImpl;
import com.yj.service.impl.record.ContainerServiceImpl;
import com.yj.service.impl.record.RentRecordServiceImpl;
import com.yj.utils.BeanUtilsEx;

public class AddRenterServlet extends BaseServlet {
	
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> map = request.getParameterMap();
		RentRecordServiceImpl service = new RentRecordServiceImpl();

		Renter renter = new Renter();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		// 1根据物品编号判断该物品是否已经被租赁
		// 2如果已被租赁，则不可再被租赁
		// 3如果没有被租赁,
		// 两种情况,
		// 第一种,租赁人以前未租赁物品，查询是否有renterID
		// 添加租赁人到renter表,同时添加租赁人和物品的关系到mr表
		// 第二种,租赁人是再次租赁
		// 不用添加租赁人到renter表，直接在mr表添加租赁人和物品的关系

		try {
			BeanUtilsEx.copyProperties(map, renter);
			BeanUtils.populate(renter, map);

			// 1根据物品编号判断该物品是否已经被租赁
			boolean flag = service.isMaterBeRentByListId(request.getParameter("listId"));
			// 根据编号查询物品

			Container container = new ContainerServiceImpl().findContainerByListId(request.getParameter("listId"));

			// 根据listID到renter查询该物品是否已经被租赁
			if (flag) {
			
				String message="物品已被其他人租赁";
				request.setAttribute("message", message );
				request.getRequestDispatcher("/rentRecord.jsp").forward(request, response);
				return;

			} else {
				System.out.println("未被租");
				boolean renterIdHas = service.isRenterIdHas(request.getParameter("renterId"));

				if (!renterIdHas) {
					renter.setMaterials(container);
					// 向renter表中插入一个renter
					// 向mr表中添加renterId,listId
					service.addRenterBoth(renter);
					// 同时将状态置1
					// service.setMStatus1ByListId(request.getParameter("listId"));
					// 根据renterId到renter表中判断renter是否新建添加成功
					String message="新建租赁人成功，并成功为其租赁物品";
					request.setAttribute("message", message );
					request.getRequestDispatcher("/rentRecord.jsp").forward(request, response);
					return;


				} else {
					// renter表中已经包含该renter，直接向mr表中添加记录
					// 重定向到用户已有页面
					response.sendRedirect(request.getContextPath() + "/renterHas.jsp");
					return;

				}

			}

			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addHas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> map = request.getParameterMap();
		RentRecordServiceImpl service = new RentRecordServiceImpl();

		Renter renter = new Renter();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Container container = new ContainerServiceImpl().findContainerByListId(request.getParameter("listId"));
		

	
		try {
			System.out.println("进入封装");
			BeanUtilsEx.copyProperties(map, renter);
			BeanUtils.populate(renter, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
		
			e.printStackTrace();
		}
		
		renter.setMaterials(container);

		service.addRenter2mr(renter);
		String message="租赁成功";
		request.setAttribute("message", message );
		System.out.println("成功存储");
		//此处是对他的造成影响的根本
		request.getRequestDispatcher("/rentHas.jsp").forward(request, response);
		System.out.println("成功转发");
		return;

	}

	
}
