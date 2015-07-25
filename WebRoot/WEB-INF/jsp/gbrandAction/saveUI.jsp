<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>品牌设置</title>
   <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
   <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/button.css" />
</head>
<body>

<!-- 标题显示 -->  
<!--显示表单内容-->
<div class="container-fluid">
	<div class="col-md-12">
	<caption><h2 class="text-success">品牌信息</h2></caption> 
    <s:form action="gbrand_%{brandId==null ? 'add'  : 'edit' }" method="post" enctype="multipart/form-data">
    <s:hidden name="brandId" value="%{brandId}"></s:hidden>
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">                                   
                     <tr><td>品牌LOGO</td>
                     	<td><s:file name="loadFile" label="品牌LOGO"/></td>
                        <%--<td><s:textfield name="logo"  value="%{logo}" cssclass="InputStyle"/> *</td>--%>
                     </tr>                      
                    <tr><td>品牌名称</td>
                        <td><s:textfield name="brandName"  value="%{brandName}" cssclass="InputStyle"/> *</td>
                    </tr>
                    <tr><td>品牌描述</td>
                        <td><s:textarea name="brandBrief"  value="%{brandBrief}" cssclass="TextareaStyle"></s:textarea></td>
                    </tr>              
                    <tr><td>品牌链接</td>
                        <td><s:textfield name="sitUrl"  value="%{sitUrl}" cssclass="InputStyle"/> *</td>
                    </tr>
                    <tr><td>品牌排序</td>
                        <td><s:textfield name="sortOrder"  value="%{sortOrder}" cssclass="InputStyle"/> *</td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <%--<input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            --%>
            <button type="submit" class="btn btn-primary">保存</button>
            <a href="javascript:history.go(-1);" class="btn btn-primary" role="button" >返回</a>
        </div>
    </s:form>
</div>
</div>
</body>
</html>
