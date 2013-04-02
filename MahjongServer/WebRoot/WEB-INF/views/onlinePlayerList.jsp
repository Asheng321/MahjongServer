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

		<title>在线玩家列表</title>

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
		在线玩家列表
		<table border="1">
			<tr>
				<td>
					id
				</td>
				<td>
					用户名
				</td>
				<td>
					房间ID
				</td>
				<td>
					状态
				</td>
				<td>
					位置
				</td>
				<td>
					麻将数据
				</td>
			</tr>
			<c:forEach var="player" items="${list}" varStatus="status">
				<tr>
					<td>
						${player.id }
					</td>
					<td>
						${player.user.username }
					</td>
					<td>
						${player.roomId }
					</td>
					<td>
						${player.status }
					</td>
					<td>
						${player.position }
					</td>
					<td>
						${player.mjData }
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
