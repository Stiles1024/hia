<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>相册管理</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
    
</head>
<body>
 
 <h2>相册管理</h2>
 <hr>
 	<s:form
		action="uuser_content_album.action">
 <table class="table">
      <caption><h3>相册</h3></caption>
      <thead>
        <tr>
          <th>相册名</th>
          <th>操作</th>
          <th>&nbsp;</th>
        </tr>
      </thead>
      <tbody>
      <s:iterator value="recordList" var="l1" status="sta">
        <tr>
          <td><a href="uuser_albumshow.action?entityid=<s:property value="#l1.albumId" />"><h4> <s:property value="#l1.albumName" /></h4> </a></td>
          <td><a class="btn btn-default" href="uuser_albumdel.action?entityid=<s:property value="#l1.albumId" />" role="button">
          	<s:if test="#l1.isdelete == false">删除</s:if><s:else>已删除</s:else> 
          </a></td>
          <%--<td><a class="btn btn-default" href="#" role="button">修改</a></td>
        --%>
        </tr>
      </s:iterator>
      </tbody>
    </table>
    <div class="container-fluid">
	<div class="row">
			<hr>
			<div class="form-group">
				<a class="btn btn-default" href="javascript:history.go(-1);" role="button">返回</a>
			</div>
	</div>
	</div>


</s:form>
<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>



</body>
</html>
