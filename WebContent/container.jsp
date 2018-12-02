<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>

	<body style="text-align:center">

		<div >

			<!--n购买时间[yyyy-mm-dd]--制造商--购买价格[xx]--编号[xx]--长度[xx]--宽度[xx]--高度[xx]");-->
			<!---->
		<form id="containerRecord"  action="${pageContext.request.contextPath }/containerServlet?method=add" method="post" style="margin-top: 5px;">
		
		<div>
				<input type="text" id="buyTime" name="buyTime"
					placeholder="购买时间">

			</div>
			<div>
				<input type="text" id="maker" name="maker"
					placeholder="制造商">

			</div>
			<div>
				<input type="text" id="buyPrice" name="buyPrice"
					placeholder="购买价格">

			</div>
			<div>
				<input type="text" id="listId" name="listId"
					placeholder="编号">

			</div>
			<div>
				<input type="text" id="length" name="length"
					placeholder="长度">

			</div>
			<div>
				<input type="text" id="width" name="width"
					placeholder="宽度">

			</div>
			<div>
				<input type="text" id="height" name="height"
					placeholder="高度">

			</div>

			
		
			<div>
				<input type="submit" width="100" value="录入" name="submit">
			</div>


	

		</form>
		</div>
	</body>

</html>