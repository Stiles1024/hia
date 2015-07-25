<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>用户发布管理</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
    
</head>
<body>
 
<s:form action="usyslog_list.action">
	<table class="table">
      <caption><h2>系统日志</h2></caption>
      <thead>
        <tr>
          <th style="text-align:center">操作用户</th>
          <th style="text-align:center;width:400px">操作事项</th>
          <th style="text-align:center">操作时间</th>
          <th style="text-align:center">IP地址</th>
          <th style="text-align:center">相关操作</th>
        </tr>
      </thead>
      <tbody>
      	<s:iterator value="recordList" var="l1" status="sta">
				<tr style="text-align:center">
					<td><h5>${TUUser.username}</h5></td>							
					<td><h5>${content}</h5></td>
					<td><h5>${posttime}</h5></td>
					<td><h5>${ipAddr}</h5></td>
					<td>														 
						
						<a class="btn btn-default" href="usyslog_delete.action?syslogId=<s:property value="syslogId" />" role="button" onClick="return window.confirm('您确定要删除该系统日志吗？')">删除</a>						 							
					</td>
				</tr>						
			</s:iterator>
        
      </tbody>
    </table>
	
</s:form>
<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>




</body>
</html>
