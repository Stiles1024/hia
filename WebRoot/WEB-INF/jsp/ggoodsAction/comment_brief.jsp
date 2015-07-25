<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>短评管理</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
	</head>
	<body>
<h2>短评管理</h2>
<hr>
		<s:form
		action="ggoods_briefcomment?goodsId=%{goodsId}">
		<s:iterator value="recordList" var="l1">
		<div class="media">
		  <div class="media-left media-middle">
		    <a href="uuser_content.action?userId=<s:property value="#l1.TUUser.userId" />">
		      <img class="media-object" src="<s:property value="#l1.TUUser.img" />" alt="..." height="100" width="100">
		    </a>
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading"><a href="uuser_content.action?userId=<s:property value="#l1.TUUser.userId" />"><s:property value="#l1.TUUser.username" /> </a></h4>
		    <p><s:property value="#l1.content" /></p>
		    <a class="btn btn-default" href="gcommentbrief_del.action?commentId=<s:property value="#l1.commentId" />&goodsId=<s:property value="#l1.TGGoods.goodsId" />" role="button">删除</a>
		  </div>
		</div>
		</s:iterator>
		
		</s:form>
		<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
		
	</body>
</html>