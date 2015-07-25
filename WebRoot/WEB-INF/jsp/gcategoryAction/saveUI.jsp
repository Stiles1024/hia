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

<!--显示表单内容-->

    <s:form action="gcategory_%{catId==null ? 'add'  : 'edit' }">
    <s:hidden name="catId" value="%{catId}"></s:hidden>
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">上级分类</td>
                        <td><s:select name="parentId"  value="%{parentId}" cssclass="SelectStyle"
                        			list="#gcategoryList"  listKey="catId"  listValue="catName"
                        			headerKey="" headerValue="==请选择分类=="
                        		/>
                                
                            
                        </td>
                      
                    </tr>
                  <!-- 显示错误 -->
							
                		 <font color="red"><s:actionerror/></font>
				
                    <tr><td>分类名称</td>
                        <td><s:textfield name="catName"  value="%{catName}" cssclass="InputStyle"/> *</td>
                    </tr>
                    <tr><td>职能说明</td>
                        <td><s:textarea name="catDesc"  value="%{catDesc}" cssclass="TextareaStyle"></s:textarea></td>
                    </tr>
                    
                    
                     <tr><td>isLeaf</td>
                        <td><%-- <s:textfield name="isShow"  value="%{isLeaf}" cssclass="InputStyle"/> * --%>
                       <select name="isLeaf">
  								 <option value="0">不作为叶子节点
   								 <option value="1">作为叶子节点
   								
  						</select>
                    
                        </td>
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

<div class="Description">
	说明：<br />
	1，上级分类的列表是有层次结构的（树形）。<br/>
	2，如果是修改：上级分类列表中不能显示当前修改的分类及其子孙分类。因为不能选择自已或自已的子分类作为上级分类。<br />
</div>

</body>
</html>
