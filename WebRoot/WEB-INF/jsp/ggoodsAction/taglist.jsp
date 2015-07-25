<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>标签管理</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
	</head>
	<body>
		<h2>标签管理</h2>
		<hr>
		<div class="container-fluid">
			
      	  <div class="row">
      	  	  <s:iterator value="tagList" var="l1" status="sta">
      	  	  	<s:property value="#l1.tagName" /> 
      	  	  	<div class="btn-group">
                    <a class="btn btn-primary" style="color:#fff" href="ggoods_goodtagdel.action?tagname=<s:property value="#l1.tagName" />&goodsId=<s:property value="goodsId" />">删除</a>    
                 </div>
                 <hr>
			  </s:iterator>
		  </div>
      </div>
      <hr>
      <h3>添加标签</h3>
      <hr>
      <s:form action="ggoods_addtags" method="post" enctype="multipart/form-data">
			<s:hidden name="goodsId" value="%{goodsId}"></s:hidden>
		<div class="row">
			<div class="col-md-6">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">标签名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="firstname"
					 name="tagname">
				</div>
			</div>
			</div>
			<div class="col-md-6">
			<input class="btn btn-default" type="submit" value="Submit">
			<a class="btn btn-default" href="javascript:history.go(-1);" role="button">取消</a>
			</div>
		</div>
	  </s:form>
		
	</body>
</html>