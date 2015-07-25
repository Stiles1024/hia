<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
<title>品牌商品</title>
<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>

</head>
<body>
	<!--页面标题-->
			
<s:form	action="gbrand_listGoods?cateId=%{cateId}&attrnow=%{attrnow}&attradd=%{attradd}&attrdel=%{attrdel}&brandId=%{brandId}">
		
	<div class="container-fluid">
      <div class="col-md-4">
        <header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
          <div class="container">
          <div class="navbar-header">
              <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              </button>
              <caption><h2 class="text-success">品牌：${brandName}</h2></caption> 
            </div>
            <nav class="collapse navbar-collapse bs-navbar-collapse">
              <ul class="nav navbar-nav">
                 <li class="dropdown">                 
                  <a style="margin:12px 0 0 10px" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">类别选择 <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <s:iterator value="gcategoryList" var="l1">
                    <li <s:if test="%{#l1.catId==cateId.toString()}"> class="active" </s:if> >
                      <a href="gbrand_listGoods.action?cateId=<s:property value="#l1.catId" />&brandId=<s:property value="%{brandId}"/>">
                        <s:property value="#l1.catName" />
                      </a>
                    </li>
                    </s:iterator>
                  </ul>
                </li>
              </ul>              
            </nav>
          </div>
        </header>
      </div>
      <div class="col-md-12">
            <hr>
      </div>         
   	 </div>
        
        		
	  <!-- 扩展属性 -->
       <s:if test="%{#cat.isLeaf==1}">
        <div class="container-fluid">
          <s:iterator value="gattrList" var="l1" status="sta">
          <div class="col-md-12">
            <ul class="list-inline">
              <li class="text-muted"> <s:property value="#l1.attrName" /> </li>
              <s:iterator value="gattrrangeList[#sta.index]" var="l2">
              <s:iterator>
              <li class="text-primary">
                <a
                  href="gbrand_listGoods.action?cateId=<s:property value="%{cateId}" />&attrnow=${attrnow }&attradd=<s:property value="#l2.catRangeId"/>&brandId=<s:property value="%{brandId}"/>">
                  <s:property value="#l2.value" />
                </a>
              </li>
              </s:iterator>
              </s:iterator>
            </ul>
          </div>
          
          </s:iterator>
          
          <div class="col-md-12">
            <hr>
          </div>
          <!-- 已选选项 -->
          <div class="col-md-12">
            <ul class="list-inline">
              <li class="text-muted">已选选项：</li>
              <s:iterator value="al_gattrrangeList" var="l1" status="sta">
              <li class="text-muted"><a
                href="gbrand_listGoods.action?cateId=<s:property value="%{cateId}" />&attrnow=${attrnow }&attrdel=<s:property value="#l1.catRangeId"/>&brandId=<s:property value="%{brandId}"/>">
              <s:property value="#l1.value" /> </a>
            </li>
            </s:iterator>
          </ul>
        </div>
        <div class="col-md-12">
            <hr>
         </div>
      </div>
      </s:if>
	
	  <div class="container-fluid">
        <div class="row">         
          <s:iterator value="recordList" var="l1">
          <div class="col-md-3">
            <div class="thumbnail">
              <a href="ggoods_showUI.action?goodsId=<s:property value="#l1.goodsId" />"><img src="/muyin/goodsimg/<s:property value="#l1.imgSmall" />"
              alt="pic" width="200" height="200" /> </a>
              <div class="caption" contenteditable="false">
                <h3><s:property value="#l1.goodsName" /></h3>
                <p>
                  <s:property value="#l1.goodsBrief" />
                </p>
                <p>                 
                  <div class="btn-group">
                    <a class="btn btn-primary" style="color:#fff" href="ggoods_editpre.action?goodsId=<s:property value="#l1.goodsId" />&cateId=<s:property value="#l1.TGCategory.catId" />">修改</a>
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    管理 <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href="ggoods_briefcomment.action?goodsId=<s:property value="#l1.goodsId" />">短评管理</a></li>
                      <li><a href="ggoods_longcomment.action?goodsId=<s:property value="#l1.goodsId" />">长评管理</a></li>
                      <li><a href="ggoods_imglist.action?goodsId=<s:property value="#l1.goodsId" />">大图管理</a></li>
                      <li><a href="ggoods_del.action?goodsId=<s:property value="#l1.goodsId" />&cateId=<s:property value="%{cateId}" />"><s:if test="#l1.isDelete == 0">删除</s:if><s:else>已删除</s:else> </a></li>
                    </ul>
                  </div>
                </p>
              </div>
            </div>
          </div>
          </s:iterator>
        </div>
      </div>

		<!-- 返回 -->
		
	<a href="javascript:history.go(-1);" style="color:#fff" class="btn btn-primary" role="button" style="float:right;margin-right:60px">返回</a>
		
	
</s:form>
<!-- 分页 -->
	<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
</body>
</html>
