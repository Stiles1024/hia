<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>事件管理</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
	</head>
	<body>
<h2>事件管理</h2>
<hr>
		<s:form
		action="uevent_list">
		<s:iterator value="recordList" var="l1">
		<div class="media">
		  <div class="media-left media-middle">
		    <a href="uuser_content.action?userId=<s:property value="#l1.TUUser.userId" />">
		      <img class="media-object" src="<s:property value="#l1.TUUser.img" />" alt="<s:property value="#l1.TUUser.username" />" height="100" width="100">
		    </a>
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading"><a href="uuser_content.action?userId=<s:property value="#l1.TUUser.userId" />"><s:property value="#l1.TUUser.username" /> </a></h4>
		    <p>${context}</p>
		    <a class="btn btn-default" href="uevent_del.action?eventId=<s:property value="#l1.eventId" />" role="button">删除</a>
		    <a class="btn btn-default" href="uevent_editUI.action?eventId=<s:property value="#l1.eventId" />" role="button">修改</a>
		  </div>
		</div>
		</s:iterator>
		<div class="container-fluid">
		<div class="row">
			<hr>
			<div class="form-group">
				<a class="btn btn-default" href="uevent_addUI.action" role="button">新增</a>
			</div>
		</div>
		</div>
		
		</s:form>
		<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
		
	</body>
</html>