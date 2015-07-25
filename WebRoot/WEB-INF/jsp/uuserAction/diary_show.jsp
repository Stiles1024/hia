<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>diary</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
	</head>
	<body>
		<h2>日记名：${diaryName}</h2>
		<hr>
		<div class="container-fluid">
			
      	  <div class="row">
      	  		${content }	  	  
		  </div>
      </div>
      <div class="container-fluid">
	<div class="row">
			
			<div class="form-group">
				<a class="btn btn-default" href="javascript:history.go(-1);" role="button">返回</a>
			</div>
	</div>
	</div>
		
	</body>
</html>