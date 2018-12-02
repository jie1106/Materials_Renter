<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div align="center">
		<form id="rentHas"
			action="${pageContext.request.contextPath }/addRenterServlet?method=addHas"
			method="post" style="margin-top: 5px;">


			<div>
				<span><h3>
						已有该租赁人，请输入物品编号
						<h3></span>
			</div>
			<div>
				<input type="text" id="renterId" name="renterId" placeholder="租赁人编号">

			</div>

			<div>
				<input type="text" id="renterDeposit" name="renterDeposit"
					placeholder="押金">

			</div>
			<div>
				<input type="text" id="renterBeginTime" name="renterBeginTime"
					placeholder="出租日期">

			</div>
			<div>
				<input type="text" id="renterEndTime" name="renterEndTime"
					placeholder="归还日期">

			</div>
			<div>
				<input type="text" id="listId" name="listId" placeholder="物品编号">

			</div>


			<div>
				<input type="submit" width="100" value="录入" name="submit">
			</div>


		</form>
	</div>
	<table align="center">
		<tr>
			<td><h3>${message}</h3></td>
		</tr>
	</table>
</body>
</html>