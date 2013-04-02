<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path=request.getContextPath();
  String basePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>GAME MANAGER</title>
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
		<center>
			<a href="web/game/_login">登陆</a><br />
			<br />
			<a href="web/game/_register">注册</a><br />
			<br />
			<a href="web/game/userList">用户列表</a><br />
			<br />
			<a href="web/game/onlinePlayerList">在线玩家列表</a><br/>
			<br />
    		<a href="web/game/roomList">房间列表</a><br/>
		</center>
	</body>
</html>
