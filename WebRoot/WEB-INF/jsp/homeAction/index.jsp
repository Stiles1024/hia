<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>muyin</title>
		<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
		<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.cookie.js"></script>
	</head>
	<frameset rows="50,10,*,10" framespacing=0 border=0 frameborder="0">
	<frame noresize name="TopMenu" scrolling="no" src="${pageContext.request.contextPath}/home_top.action">
	<frame src="${pageContext.request.contextPath}/home_bottom.action">
<frameset cols="180,7,*,1" id="resize">
	<frame noresize name="menu" scrolling="yes" src="${pageContext.request.contextPath}/home_left.action">
	<frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/home_bottom.action">
	<frame noresize name="right" scrolling="yes" src="${pageContext.request.contextPath}/home_right.action">
	<frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/home_bottom.action">
	</frameset>
	<frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/home_bottom.action">
	</frameset>
	<noframes><body>
	</body>
</noframes></html>