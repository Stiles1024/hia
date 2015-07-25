<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>产品分类列表</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
	</head>
	<body>
		<h2>大图管理</h2>
		<hr>
		<div class="container-fluid">
			
      	  <div class="row">
      	  	  <s:iterator value="goodsimgList" var="l1" status="sta">
			  <div class="col-xs-6 col-md-3">
			    <a href="#" class="thumbnail">
			      <img src="/muyin/goodsimgbig/<s:property value="#l1.value" />" alt="pic" width="200" height="200">
			    </a>
			    <p>
                  
                  <div class="btn-group">
                    <a class="btn btn-primary" style="color:#fff" href="ggoods_imgdel.action?imgid=<s:property value="#l1.goodsImgId" />&goodsId=<s:property value="#l1.TGGoods.goodsId" />">删除</a>    
                  </div>
                </p>
			  </div>
			  
			  </s:iterator>
		  </div>
      </div>
      <hr>
      <h3>添加大图</h3>
      <hr>
      <s:form action="ggoods_addimg" method="post" enctype="multipart/form-data">
			<s:hidden name="goodsId" value="%{goodsId}"></s:hidden>
		<div class="row">
			<div class="col-md-6">
			<s:file name="loadFile" label="商品图片"/>
			</div>
			<div class="col-md-6">
			<input class="btn btn-default" type="submit" value="Submit">
			<a class="btn btn-default" href="javascript:history.go(-1);" role="button">取消</a>
			</div>
		</div>
	  </s:form>
		
	</body>
</html>