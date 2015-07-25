<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>导航菜单</title>
		<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/left.css" />
		<%--<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />--%>
		<%--<script type="text/javascript">
			/* 点击隐藏下列表和显示下列表 */
			function menuClick( menu ){
				$(menu).next().toggle();
			}
		
		</script>--%>
	</head>
	

	<body>
	<div class="container-fluid" id="bg-color">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="panel-group" id="panel-812110">
            <s:iterator value="#application.topPrivilegeList" status="sta">
		            		
                <div class="panel panel-default">
                
                    <div class="panel-heading" id="panel-head">
                         <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-812110" href="#panel-element-<s:property value="#sta.index" />">${name}</a>
                    </div>
                    
                    <div id="panel-element-<s:property value="#sta.index" />" class="panel-collapse collapse">
                    <s:iterator value="children">
									
                        <div class="panel-body" id="panel-body">
                             <a  target="right"  href="${pageContext.request.contextPath}${url}.action" class="text-muted"><p4>${name}</p4></a>
                        </div>
                     
                    </s:iterator>
                    </div>
                   
                </div>
               
                </s:iterator>
            </div>
        </div>
    </div>
</div>
	</body>

	
</html>