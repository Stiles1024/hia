<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>产品分类列表</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
	</head>
	<body>
		<h2>post管理</h2>
		<hr>
		<div class="container-fluid">
			
      	  <div class="row">
      	  	  <s:iterator value="postimgList" var="l1" status="sta">
			  <div class="col-xs-6 col-md-3">
			    <a href="#" class="thumbnail">
			      <img src="/muyin/goodspostimg/<s:property value="#l1.value" />" alt="pic" width="200" height="200">
			    </a>
			    <p>
                  
                  <div class="btn-group">
                    <a class="btn btn-primary" style="color:#fff" href="ggoods_postimgdel.action?imgid=<s:property value="#l1.imgId" />&goodsId=<s:property value="#l1.TGGoods.goodsId" />">删除</a>    
                  </div>
                </p>
			  </div>
			  
			  </s:iterator>
		  </div>
      </div>
      <hr>
      <h3>添加postimg</h3>
      <hr>
      <s:form action="ggoods_addpostimg" method="post" enctype="multipart/form-data">
			<s:hidden name="goodsId" value="%{goodsId}"></s:hidden>
		<div class="row">
			<div class="col-md-6">
			<s:file name="loadFile" label="商品post图片"/>
			</div>
			<div class="col-md-6">
			<input class="btn btn-default" type="submit" value="Submit">
			<a class="btn btn-default" href="javascript:history.go(-1);" role="button">取消</a>
			</div>
		</div>
	  </s:form>
		
	</body>
</html>