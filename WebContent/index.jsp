<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body style="text-align:center">
		<h1>system</h1>
		<div width="100px" height="800px">
			<div>
				<font size="2" color="burlywood">信息录入</font>

				<a href="buyRecord.jsp" target="_blank">购入物品录入</a>
				<a href="rentRecord.jsp" target="_blank">租赁人录入</a>
			</div>
			<div>
				<font size="2" color="burlywood">物品查询</font>
				<a href="queryAllMaterials.jsp" target="_blank">查询所有物品</a>
				<a href="queryMaterialsByListId.jsp" target="_blank">根据编号查询物品</a>
				<a href="queryMaterialsByRenter.jsp" target="_blank">根据租赁人查询物品</a>
			</div>
			<div>
				<font size="2" color="burlywood">信息提示</font>
				<a href="warningMessage.jsp" target="_blank">信息提示</a>
			</div>
			<div>
				<font size="2" color="burlywood">费用结算</font>
				<a href="charge.jsp" target="_blank">费用结算</a>
			</div>

		</div>

	</body>

</html>