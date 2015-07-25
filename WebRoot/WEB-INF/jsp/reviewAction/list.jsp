<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>用户发布管理</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
    
</head>
<body>
 
<div class="container-fluid">
	<div class="col-md-12">
		 <table class="table">
      	<caption><h2 class="text-success">用户内容管理</h2></caption>
      	<thead>
	      	<tr>
	          <th>名称</th>
	          <th>操作</th>
	        </tr>
	      </thead>
	      <tbody>
			<tr>
			<td> <h4 class="text-primary"><a href="uuser_content_diary.action">日记 </a></h4> </td>
			<td> <h4 class="text-primary"> &nbsp; </h4> </td>
			<!--   <td> <a href="winfo_editUI.action?infoId=<s:property value="infoId" />" class="btn btn-primary" role="button">修改</a> </td>  -->

			<tr>
			
			<tr>
			<td> <h4 class="text-primary"><a href="uuser_content_album.action">相册 </a></h4> </td>
			<!--   <td> <a href="winfo_editUI.action?infoId=<s:property value="infoId" />" class="btn btn-primary" role="button">修改</a> </td>  -->

			<tr>
			
			</tbody>
    </table>
     <a href="winfo_addUI.action" style="color:#fff" class="btn btn-primary" role="button">新增</a> 
	</div>
</div>	



</body>
</html>
