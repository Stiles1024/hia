<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>相册</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
	</head>
	<body>
		<h2>相册名：${albumName}</h2>
		<hr>
		<div class="container-fluid">
			
      	  <div class="row">
      	  	  <s:iterator value="photoList" var="l1" status="sta">
			  <div class="col-xs-6 col-md-3">
			    <a href="#" class="thumbnail">
			      <img src="/muyin/useralbum/<s:property value="#l1.img" />" alt="pic" width="200" height="200">
			    </a>
			    <p>
                  
                  <div class="btn-group">
                    <a class="btn btn-primary" style="color:#fff" href="uuser_photodel.action?entityid=<s:property value="#l1.photoId" />&userid=<s:property value="#l1.TUAlbum.TUUser.userId" />">
                    <s:if test="#l1.isdelete == false">删除</s:if><s:else>已删除</s:else>
                    </a>
                  </div>
                </p>
			  </div>
			  
			  </s:iterator>
		  </div>
      </div>
      <hr>
      <div class="container-fluid">
	<div class="row">
			
			<div class="form-group">
				<a class="btn btn-default" href="javascript:history.go(-1);" role="button">返回</a>
			</div>
	</div>
	</div>
		
	</body>
</html>