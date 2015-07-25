<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>您已退出母婴后台</title>
<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/loginUI.css" />
	<%--<link href="${pageContext.request.contextPath}/style/blue/logout.css" rel="stylesheet" type="text/css" />
--%></head>

<body>

<div class="container">
	<div class="col-md-4">
	</div>
	<div class="col-md-4">
        <h2 class="form-signin-heading">操作</h2>
        
        <a class="btn btn-primary" style="color:#fff" href="uuser_loginUI.action">重新进入后台</a>
        <a class="btn btn-primary" style="color:#fff" href="javascript: window.close();">关闭当前窗口</a>
	</div>
	<div class="col-md-4">
	</div>
    </div> <!-- /container -->


	
</body>
</html>
