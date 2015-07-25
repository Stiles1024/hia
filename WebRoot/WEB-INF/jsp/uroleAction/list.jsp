<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>岗位列表</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
</head>
<body>
 
<div class="container-fluid">
 <div class="col-md-12">
		 <table class="table">
  		<caption><h2 class="text-success">岗位管理</h2></caption>
    
        <!-- 表头-->
        <thead>
	      	<tr>
	          <th>岗位名称</th>
	          <th>岗位说明</th>
	          <th>相关操作</th>
	        </tr>
	      </thead>

		<!--显示数据列表-->
        
          <s:iterator value="%{#roleList}">
          <tbody >
			<tr >
				<td>${name}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td>
				 <s:if test="#session.user.hasPrivilegeByName('删除岗位')"> 
					<s:a action="urole_delete?roleId=%{roleId}" onclick="return confirm('确定要删除吗？')">删除</s:a>
				</s:if> 
				 <s:if test="#session.user.hasPrivilegeByName('修改岗位')"> 
					<s:a action="urole_editUI?roleId=%{roleId}" >修改</s:a>
					 </s:if>
					 <s:if test="#session.user.hasPrivilegeByName('设置权限')">
						<s:a action="urole_setPrivilegeUI?roleId=%{roleId}">设置权限</s:a>
			 	</s:if> 
				</td>
			</tr>
			</s:iterator>
        </tbody>
    </table> 
    
    <!-- 其他功能超链接 -->
    
        <s:if test="#session.user.hasPrivilegeByName('添加岗位')">
        	<a href="urole_addUI.action" style="color:#fff" class="btn btn-primary" role="button">新增</a> 
           
       </s:if> 
        </div>
    </div>

</body>
</html>
