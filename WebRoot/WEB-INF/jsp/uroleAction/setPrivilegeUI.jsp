<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
<title>配置权限</title>
    
	 <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/file.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />
	<script type="text/javascript">
		$(function(){
			// 指定事件处理函数
			$("[name=privilegeIds]").click(function(){
				
				// 当选中或取消一个权限时，也同时选中或取消所有的下级权限
				$(this).siblings("ul").find("input").attr("checked", this.checked);
				
				// 当选中一个权限时，也要选中所有的直接上级权限
				if(this.checked == true){
					$(this).parents("li").children("input").attr("checked", true);
				}
				
			});
		});
	</script>
</head>
<body>

<!-- 标题显示 -->
<caption><h2 class="text-success">设置权限</h2></caption>
<div class="breadcrumb">
        ${role.name} </div>

<!--显示表单内容-->
<div class="container-fluid">
					<div class="row">
						<div class="col-md-1">
						</div>
					<div class="col-md-11">
    <s:form action="urole_setPrivilege">
    	<s:hidden name="roleId" value="%{roleId}"></s:hidden>
        
     
        
        <!-- 表单内容显示 -->
        
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;">
								<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
								<input type="CHECKBOX" id="cbSelectAll" onClick="$('[type=checkbox]').attr('checked',this.checked)"/>
								<label for="cbSelectAll">全选</label>
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
							
							<!-- 显示树状结构内容 -->
								<ul id="tree">
								<s:iterator value="#application.topPrivilegeList">
									<li>
										<input type="checkbox" name="privilegeIds" value="${privilegeId}" id="cb_${privilegeId}" <s:property value="%{privilegeId in privilegeIds ? 'checked' : ''}"/> />
										<label for="cb_${privilegeId}"><span class="folder">${name}</span></label>
										<ul>
										<s:iterator value="children">
											<li>
												<input type="checkbox" name="privilegeIds" value="${privilegeId}" id="cb_${privilegeId}" <s:property value="%{privilegeId in privilegeIds ? 'checked' : ''}"/> />
												<label for="cb_${privilegeId}"><span class="folder">${name}</span></label>
												<ul>
												<s:iterator value="children">
													<li>
														<input type="checkbox" name="privilegeIds" value="${privilegeId}" id="cb_${privilegeId}" <s:property value="%{privilegeId in privilegeIds ? 'checked' : ''}"/> />
														<label for="cb_${privilegeId}"><span class="folder">${name}</span></label>
													</li>
												</s:iterator>
												</ul>
											</li>		
										</s:iterator>
										</ul>
									</li>
								</s:iterator>
								</ul>
							</td>
						</tr>
					</tbody>
                </table>
            </div>
  	<!-- 表单操作 -->
        <hr>
        <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default"  style="width: 55px; height: 30px;" >确定</button>
					<a class="btn btn-default" href="javascript:history.go(-1);" role="button" style="width: 55px; height: 30px;" >取消</a>
				</div>
			</div>
        
         <script type="text/javascript">
        	$("#tree").treeview();
        </script>
        
    </s:form>
</div>
</div>
</div>
<hr>
<div class="Description">
	说明：<br />
	1，选中一个权限时：<br />
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该选中 他的所有直系上级。<br />
	&nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br />
	2，取消选择一个权限时：<br />
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择 他的所有直系下级。<br />
	&nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并递归向上做这个操作。<br />

	3，全选/取消全选。<br />
	4，默认选中当前岗位已有的权限。<br />
</div>

</body>
</html>
