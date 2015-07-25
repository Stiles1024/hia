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
  		<caption><h2 class="text-success">站内用户管理</h2></caption>
       
        <!-- 表头-->
        <thead>
	      	<tr>
	          <th>姓名</th>
	          <th>岗位</th>
	          <th>备注</th>
	          <th>相关操作</th>
	        </tr>
	      </thead>
        
        <!--显示数据列表-->
       	 <tbody>
         <s:iterator value="%{recordList}" var="l1" >
            <tr >
           
                
                <td>${username}&nbsp;</td>
               
                <td>
                	<s:iterator value="roles">
                		${name}
                	</s:iterator>
               
                <td>${description}&nbsp;</td>
                <td> <a href="sysuser_editUI.action?userId=<s:property value="userId" />" style="color:#fff" class="btn btn-primary" role="button">修改</a> 
			 <a href="sysuser_delete.action?userId=<s:property value="userId" />" style="color:#fff" class="btn btn-primary" role="button">删除</a> </td> 
         
            </tr>
                   </s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    
        <s:if test="#session.user.hasPrivilegeByName('添加用户')"> 
          <a href="sysuser_addUI.action" style="color:#fff" class="btn btn-primary" role="button">新增</a> 
            
        </s:if> 
      
</div>
</div>
<!-- 分页 -->
<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
		<s:form action="sysuser_list"></s:form>
</body>
</html>
