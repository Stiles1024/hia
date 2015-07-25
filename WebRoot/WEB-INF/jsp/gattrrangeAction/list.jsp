<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>产品分类列表</title>
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
    
</head>
<body>
 
<caption><h2 class="text-success">产品分类管理</h2></caption>

<div class="breadcrumb">
	<s:iterator value="%{#contentList}">
			
			
		 <s:a action="gcategory_list?parentId=%{catId}">${catName}</s:a> 
		 <font class="MenuPoint"> &gt; </font>
	</s:iterator>
			 <s:a action="gattrrange_list?attrId=%{#gattribute.attrId}">${gattribute.attrName}</s:a> 
		 <font class="MenuPoint"> &gt; </font>
		</div>


<div class="container-fluid">
 <div class="col-md-12">
		 <table class="table">
       
        <!-- 表头-->
         <thead>
	      	<tr>
	          <th>属性值</th>
	          <th>所属分类</th>
	           <th>相关操作</th>
	        </tr>
	      </thead>

		<!--显示数据列表-->
        <tbody>
        	<s:iterator value="%{#gattrrangeList}">
			<tr >
			<td>${value}&nbsp;
					</td>
					
					<td>${gattribute.attrName}&nbsp;</td>
				
					<%-- <td>${catDesc}&nbsp;</td> --%>
				<td>
					
					 <s:a action="gattrrange_delete?catRangeId=%{catRangeId}&attrId=%{attrId}"   onClick="return window.confirm('您确定要删除吗？')" >删除</s:a>
					
					<s:a action="gattrrange_editUI?attrId=%{attrId}&catRangeId=%{catRangeId}" >修改</s:a>
				</td>
			</tr>
			
			</s:iterator>
        </tbody>
    </table>
  
    <!-- 其他功能超链接 -->
    
   			<a href="gattrrange_addUI.action?attrId=${attrId}" style="color:#fff" class="btn btn-primary" role="button">新增</a> 
            
      		<a href="gattribute_list.action?catId=${catId}" style="color:#fff" class="btn btn-primary" role="button">返回上一级</a> 
             
        </div>
    
</div>

<!--说明-->	
<div id="Description"> 
	说明：<br />
	1，列表页面只显示一层的（同级的）分类数据，默认显示最顶级的分类列表。<br />
	2，点击分类名称，可以查看此分类相应的下级分类列表。<br />
	3，删除分类时，同时删除此分类的所有下级分类。
</div>

</body>
</html>
