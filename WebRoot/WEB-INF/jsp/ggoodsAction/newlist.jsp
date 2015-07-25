<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
<title>新品管理</title>
<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
	
</head>
<body>


	<s:form
		action="ggoods_newlist">
		<div class="container-fluid">
		<div class="col-md-12">
			<h2 class="text-success">新品管理</h2>
			<hr>
		</div>
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
                    </ul>
                  </div>
                </p>
              </div>
            </div>
          </div>
          </s:iterator>
        </div>
      </div>
	</s:form>

	<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>

</body>
</html>
