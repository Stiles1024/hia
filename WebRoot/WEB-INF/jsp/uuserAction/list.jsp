<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>用户管理</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
    
</head>
<body>
 
<s:form
		action="uuser_list.action">
<div class="container-fluid">
	<div class="col-md-12">
		 <table class="table">
      	<caption><h2 class="text-success">用户管理</h2></caption>
      	<thead>
	      	<tr>
	          <th>用户名</th>
	          <th>操作</th>
	        </tr>
	      </thead>
	      <tbody>
		<s:iterator value="recordList" var="l1" status="sta">
			<tr>
			<td> <h4 class="text-primary"><a href="uuser_content.action?userId=<s:property value="userId" />">${username}</a></h4> </td>
			<td> <a href="uuser_editpre.action?userId=<s:property value="userId" />" style="color:#fff" class="btn btn-primary" role="button">修改</a> </td>
			<td> <a href="uuser_del.action?userId=<s:property value="userId" />" style="color:#fff" class="btn btn-primary" role="button">
				<s:if test="#l1.isdelete == false">删除</s:if><s:else>已删除</s:else>
			</a> </td> 
			<tr>
			
			</s:iterator>
			</tbody>
    </table>
     <a href="uuser_addpre.action" style="color:#fff" class="btn btn-primary" role="button">新增</a> 
	</div>
</div>	

</s:form>
<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>


</body>
</html>
