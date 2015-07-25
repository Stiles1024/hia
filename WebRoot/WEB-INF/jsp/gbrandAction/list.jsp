<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>商品品牌表</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
    
</head>
<body>
<div class="container-fluid">
	<div class="col-md-12">
    <table class="table">
    <caption><h2 class="text-success">品牌管理</h2></caption>      
        <!-- 表头-->
        <thead>
            <tr>
            	<th width="150px" style="text-align:center">品牌名称</th>
				<th width="150px" style="text-align:center">品牌描述</th>
				<th width="200px" style="text-align:center">品牌LOGO</th>
				<th width="200px" style="text-align:center">品牌链接</th>
				<th width="100px" style="text-align:center">品牌排序</th>
				<th style="text-align:center">相关操作</th>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody>
        	<s:iterator value="%{recordList}" var="l1">
			<tr style="text-align:center;vertical-align:middle">		
					<td><h4 class="text-primary"><s:a action="gbrand_listGoods?brandId=%{brandId}">${brandName}</s:a></h4></td>
					
					<td><h4 class="text-primary">${brandBrief}</h4></td>								
					
					<td><img BORDER="0" WIDTH="100" HEIGHT="40" src="/muyin/goodslogo/<s:property value="#l1.logo" />"alt="pic" /></td>
					
					<td><h4 class="text-primary">${sitUrl}</h4></td>
					
					<td><h4 class="text-primary">${sortOrder}</h4></td>					
				<td>					
					<a href="gbrand_delete.action?brandId=<s:property value="%{brandId}"/>" style="color:#fff" class="btn btn-primary" role="button">
						<s:if test="#l1.isDelete == false">删除</s:if><s:else>已删除</s:else>
					</a>
					
					<a href="gbrand_editUI.action?brandId=<s:property value="%{brandId}" />" style="color:#fff" class="btn btn-primary" role="button">修改</a>				
				</td>						
			</tr>			
			</s:iterator>
        </tbody>
    </table>
    <a href="gbrand_addUI.action" class="btn btn-primary" role="button" style="float:right;margin-right:30px;color:#ffffff">新增</a>
 </div>   
</div>

<!-- 分页 -->
<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>	
<s:form action="gbrand_list"></s:form>
</body>
</html>
