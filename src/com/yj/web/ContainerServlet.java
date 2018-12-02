package com.yj.web;


import java.io.IOException;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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
import com.yj.utils.BeanUtilsEx;






public class ContainerServlet extends BaseServlet {
	ContainerServiceImpl service = new ContainerServiceImpl();

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setCharacterEncoding("utf-8");
		Map<String, String[]> map = request.getParameterMap();
		Container container = new Container();

		try {
			BeanUtilsEx.copyProperties(map, container);
			BeanUtils.populate(container, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		service.add(container);

	}

	public void showByListId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("查询showByListId");
		

		Container container = service.findContainerByListId(request.getParameter("queryByListId"));
		if(container==null) {
			String message="该物品不存在";
			request.setAttribute("message", message );
			request.getRequestDispatcher("/queryMaterialsByListId.jsp").forward(request, response);
			return;
		}
		String renterId = service.findRenterIdByListId(request.getParameter("queryByListId"));
	
		Renter renter2 = service.findRenterMessageByListId(request.getParameter("queryByListId"));
		Renter renter = service.findRenterByRenterId(renterId);
		renter.setBeginTime(renter2.getBeginTime());
		renter.setEndTime(renter2.getEndTime());
		System.out.println("renter"+renter);
		container.setRenter(renter);
		request.setAttribute("container", container);
	

		//转发
		request.getRequestDispatcher("/queryMaterialsByListId.jsp").forward(request, response);
	
	}

	public void showByRenterId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Renter renter = service.findRenterByRenterId(request.getParameter("renterId"));
		System.out.println("renterId:" + request.getParameter("renterId"));

		if (renter == null) {
			String message = "该租赁人不存在";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/queryMaterialsByRenter.jsp").forward(request, response);
			return;
		}
		System.out.println("进入findContainerByRenterId");
		List<Container> containerList = null;
		containerList = service.findContainerByRenterId(request.getParameter("renterId"));
		// 得到物品集合的每件物品的id
		for (Container container : containerList) {
			// 根据物品id封装物品信息
			Container container2 = service.findContainerByListId(container.getListId());
			Renter renter2 = service.findRenterByRenterId(container.getRenterId());
			container.setMaker(container2.getMaker());
			container.setBuyTime(container2.getBuyTime());
			container.setBuyPrice(container2.getBuyPrice());
			container.setLength(container2.getLength());
			container.setWidth(container2.getHeight());
			container.setHeight(container2.getHeight());
			container.setMstatus(container2.getMstatus());
			container.setRenter(renter2);

		}


		request.setAttribute("containerList", containerList);

		// 转发
		request.getRequestDispatcher("/queryMaterialsByRenter.jsp").forward(request, response);

	}

	public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Container> containerList = service.findAll();
		for (Container container : containerList) {
			// 根据物品id封装物品信息
			String listId = container.getListId();
			System.out.println("listid"+listId);
			// 根据container listId到mr表去查询租赁人信息以及押金 时间 封装
		 
			Renter renter = service.findRenterMessageByListId(listId);
			if(renter!=null) {
				//根据renterId获取renter 再封装 
				Renter renter2 = service.findRenterByRenterId(renter.getRenterId());
				
				//以下四条要单存，因为每个物品都有不同的开始和结束租赁时间以及押金
				container.setRenterDeposit(renter.getDeposit());
				container.setRenterBeginTime(renter.getBeginTime());
				container.setRenterEndTime(renter.getEndTime());
				container.setRenterId(renter.getRenterId());
				container.setRenter(renter2);

			}
			
		}
		
	/*	
		for (Container container : containerList) {
			System.out.println("********************************");
			System.out.println("物品编号" + container.getListId());
			System.out.println("物品制造商" + container.getMaker());
			System.out.println("物品价格" + container.getBuyPrice());
			System.out.println("物品购买时间" + container.getBuyTime());
			System.out.println("物品长" + container.getLength());
			System.out.println("物品宽" + container.getWidth());
			System.out.println("物品高" + container.getHeight());
			System.out.println("物品租赁人姓名" + container.getRenter().getRenterName());
			System.out.println("物品押金" + container.getRenterDeposit());
			System.out.println("物品状态" + container.getMstatus());
			

		}*/
		
		

		request.setAttribute("containerList", containerList);
	
		// 转发
		request.getRequestDispatcher("/queryAllMaterials.jsp").forward(request, response);

	}

}
