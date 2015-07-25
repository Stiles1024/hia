<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>用户发布管理</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
    
</head>
<body>
 
	<h2><s:property value="%{username}" />的用户内容</h2>
    <hr>

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
      <s:iterator value="diaryList" var="l1" status="sta">
      	<tr>
					<td><a href="uuser_diaryshow.action?entityid=<s:property value="#l1.diaryId" />"><h4> <s:property value="#l1.diaryName" /> </h4></a> </td>
					<td> <a class="btn btn-default" href="uuser_diarydel.action?entityid=<s:property value="#l1.diaryId" />&userid=<s:property value="userId" />" role="button"> 
					<s:if test="#l1.isdelete == false">删除</s:if><s:else>已删除</s:else> 
					</a> </td>
					<td></td>
		</tr>
	</s:iterator>
      </tbody>
    </table>
    
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
      <s:iterator value="albumList" var="l1" status="sta">
        <tr>
          <td><a href="uuser_albumshow.action?entityid=<s:property value="#l1.albumId" />"><h4> <s:property value="#l1.albumName" /> </h4></a></td>
          <td><a class="btn btn-default" href="uuser_albumdel.action?entityid=<s:property value="#l1.albumId" />&userid=<s:property value="userId" />" role="button">
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
			
			<div class="form-group">
				<a class="btn btn-default" href="javascript:history.go(-1);" role="button">返回</a>
			</div>
	</div>
	</div>



</body>
</html>
