<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>岗位设置</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
</head>
<body> 

<!-- 标题显示 -->
<caption><h2 class="text-success">岗位设置</h2></caption>

<!--显示表单内容-->

    <s:form action="urole_%{roleId==null  ?  'add' : 'edit' }">
    <s:hidden name="roleId" value="%{roleId}"></s:hidden>
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">岗位名称</td>
                        
                        <td><s:textfield name="name" cssclass="InputStyle" /> *</td>
                    </tr>
                    <tr>
                        <td>岗位说明</td>
                        <td><s:textarea name="description" cssclass="TextareaStyle"/></td>
                    </tr>
                </table>
            </div>
      
        
        <!-- 表单操作 -->
        <hr>
        <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">添加</button>
					<a class="btn btn-default" href="javascript:history.go(-1);" role="button">取消</a>
				</div>
			</div>
    </s:form>
</div>

</body>
</html>
