<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>分类设置</title>
   <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
</head>
<body>

<!-- 标题显示 --> 
<caption><h2 class="text-success">分类信息</h2></caption>
<hr>
<!--显示表单内容-->

    <s:form action="gattrrange_%{catRangeId==null ? 'add'  : 'edit' }">
    <s:hidden name="catRangeId" value="%{catRangeId}"></s:hidden>
     <s:hidden name="attrId" value="%{attrId}"></s:hidden>
        
        
        <!-- 表单内容显示 -->
       
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">属性分类</td>
                        <td>
                                ${attrName}
                            
                        </td>
                    </tr>
                    <tr><td>属性值</td>
                        <td><s:textfield name="value"  value="%{value}" cssclass="InputStyle"/> *</td>
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


<div class="Description">
	说明：<br />
	1，上级分类的列表是有层次结构的（树形）。<br/>
	2，如果是修改：上级分类列表中不能显示当前修改的分类及其子孙分类。因为不能选择自已或自已的子分类作为上级分类。<br />
</div>

</body>
</html>
