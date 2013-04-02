<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String path=request.getContextPath();
  String basePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>房间列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		房间列表
		<table border="1">
			<tr>
				<td>
					id
				</td>
				<td>
					房间名
				</td>
				<td>
					密码
				</td>
				<td>
					人数
				</td>
				<td>
					状态
				</td>
			</tr>
			<c:forEach var="room" items="${list}" varStatus="status">
				<tr>
					<td>
						${room.id }
					</td>
					<td>
						${room.name }
					</td>
					<td>
						${room.password }
					</td>
					<td>
						${room.playerCount }/${room.totalCount }
					</td>
					<td>
						${room.status }
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
