<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	
	<form action="${pageContext.request.contextPath }/containerServlet?method=showByListId" method="post">
		<span>请输入编号</span>	<span><input type="text" name="queryByListId" ></span>
		<input type="submit" value="查询"/>
	</form>


	
</div>
	<table align="center" border="1px">
	

            
            
    		<tr>
    		<th>编号</th>
    		<th>制造商</th>
    		<th>购买时间</th>
    		<th>购买价格</th>		
    		<th>长度</th>
    		<th>宽度</th>
    		<th>高度</th>
    		<th>是否被租赁</th>
    		<th>租赁人</th>
    		<th>租赁开始时间</th>
    		<th>租赁结束时间</th>
    		</tr>
    		
    		
    		
            <tr>
          
                <td>${container.listId}</td>
                <td>${container.maker}</td>
                <td>${container.buyTime}</td>
                <td>${container.buyPrice}</td>
                <td>${container.length}</td>
                <td>${container.width}</td>
                <td>${container.height}</td>
              <td>${container.mstatus==0?"未被租赁":"已被租赁"}</td> 
               <%--  <td>${container.mstatus}</td> --%>
             <!--    得到]物品的renter对象？ -->
                 <td>${container.renter.renterName}</td>
                 <td>${container.renter.renterBeginTime}</td>
                <td>${container.renter.renterEndTime}</td> 
  
           
            </tr>
     
    		
    	</table>
    	<table align="center">
    	<tr>
    	<td><h3 >${message}</h3></td>
    	</tr>
    	</table>
</body>
</html>