<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>消息管理</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
	</head>
	<body>
<h2>消息管理</h2>
<hr>
		<s:form
		action="umessage_list">
		<s:iterator value="recordList" var="l1">
		<div class="media">
		  <div class="media-left media-middle">
		    <a href="uuser_content.action?userId=<s:property value="#l1.TUUserBySendId.userId" />">
		      <img class="media-object" src="<s:property value="#l1.TUUserBySendId.img" />" alt="<s:property value="#l1.TUUserBySendId.username" />" height="100" width="100">
		    </a>
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading"><a href="uuser_content.action?userId=<s:property value="#l1.TUUserBySendId.userId" />"><s:property value="#l1.TUUserBySendId.username" /> </a></h4>
		    <p>${content}</p>
		    <a class="btn btn-default" href="umessage_del.action?messageId=<s:property value="#l1.messageId" />" role="button">删除</a>
		    <a class="btn btn-default" href="umessage_editUI.action?messageId=<s:property value="#l1.messageId" />" role="button">修改</a>
		  </div>
		</div>
		</s:iterator>
		<div class="container-fluid">
		<div class="row">
			<hr>
			<div class="form-group">
				<a class="btn btn-default" href="umessage_addUI.action" role="button">新增</a>
			</div>
		</div>
		</div>
		
		</s:form>
		<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
		
	</body>
</html>