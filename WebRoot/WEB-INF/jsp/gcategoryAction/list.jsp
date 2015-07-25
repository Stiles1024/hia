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
			
		</div>

<div class="container-fluid">
 <div class="col-md-12">
		 <table class="table">
       
        <!-- 表头-->
         <thead>
	      	<tr>
	          <th>分类名称</th>
	          <th>上级分类名称</th>
	          <th>分类说明</th>
	           <th>相关操作</th>
	        </tr>
	      </thead>

		<!--显示数据列表-->
        <tbody>
        	<s:iterator value="%{#gcategoryList}">
			<tr >
		
					<td><s:a action="gcategory_list?parentId=%{catId}" >${catName}&nbsp;</s:a>
					</td>
					<td>
                		</td>
				
					<td>${catDesc}&nbsp;</td>
				<td>
					
					<s:a action="gcategory_delete?catId=%{catId}&parentId=%{#parent.catId}"   onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" >删除</s:a>
					
					<s:a action="gcategory_editUI?catId=%{catId}&parentId=%{#parent.catId}" >修改</s:a>
				
				</td>
			
				
			</tr>
			
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    
   			<s:if test="#judge==true">
   				  <a href="gcategory_addUI.action?parentId=${parentId}" style="color:#fff" class="btn btn-primary" role="button">新增</a> 
            
           </s:if>
           <a href="gcategory_list.action?parentId=${parent.parent.catId}" style="color:#fff" class="btn btn-primary" role="button">返回上一级</a> 
             
        </div>
    </div>


<!--说明-->	
<div > 
	<h3>说明：</h3><br />
	1，列表页面只显示一层的（同级的）分类数据，默认显示最顶级的分类列表。<br />
	2，点击分类名称，可以查看此分类相应的下级分类列表。<br />
	3，删除分类时，同时删除此分类的所有下级分类。
</div>

</body>
</html>
