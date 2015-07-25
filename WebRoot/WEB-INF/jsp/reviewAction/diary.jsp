<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>用户发布管理</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
    
</head>
<body>
 
<h2>用户日记审阅</h2>




<hr>
	<s:form
		action="uuser_content_diary.action">
		<table class="table">
      <caption><h3>日记</h3></caption>
      <thead>
      	<tr>
          <th>日记名</th>
          <th>操作</th>
          <%--<th>&nbsp;</th>
        --%>
        </tr>
      </thead>
      <tbody>
      <s:iterator value="recordList" var="l1" status="sta">
      	<tr>
					<td><a href="uuser_diaryshow.action?entityid=<s:property value="#l1.diaryId" />"><h4> <s:property value="#l1.diaryName" /> </h4></a> </td>
					<td> <a class="btn btn-default" href="uuser_diarydel.action?entityid=<s:property value="#l1.diaryId" />" role="button"> 
					<s:if test="#l1.isdelete == false">删除</s:if><s:else>已删除</s:else> 
					</a> </td>
					<td></td>
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
