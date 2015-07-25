<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>导航菜单</title>
		<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
		<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
		<script type="text/javascript">
			/* 点击隐藏下列表和显示下列表 */
			function menuClick( menu ){
				$(menu).next().toggle();
			}
		
		</script>
	</head>

	<body style="margin: 0">
	
		<div id="Menu">

			<ul id="MenuUl">
			
				<%-- 显示一级菜单   --%>
				 <s:iterator value="#application.topPrivilegeList">
					<s:if test="#session.user.hasPrivilegeByName(name)">
					<li class="level1">
						<div onClick="menuClick(this);" class="level1Style">
						
							<img src="style/images/MenuIcon/${1}.gif" class="Icon" />
							${name}
						</div>
						<ul style="" class="MenuLevel2" id="aa">
						<!-- 	显示二级菜单 -->
							<s:iterator value="children">
								<s:if test="#session.user.hasPrivilegeByName(name)">
								<li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}${url}.action"> ${name}</a>
									</div> 
								</li>
								</s:if>
							</s:iterator>  
						</ul> 
					</li>
					</s:if>
				</s:iterator> 
				<%-- <li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}/gcategory_list.action"> 产品分类管理</a>
									</div>
								</li>
								
				<li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}/ggoods_list.action"> 产品管理</a>
									</div>
								</li>
				<li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}/sforum_list.action"> 论坛</a>
									</div>
								</li>
				<li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}/sforumManage_list.action"> 论坛管理</a>
									</div>
								</li>
				<li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}/gbrand_list.action"> 品牌管理</a>
									</div>
								</li>
				<li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}/uuser_list.action"> 用户管理</a>
									</div>
								</li>
								
				<li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}/uuser_contents.action"> 内容管理</a>
									</div>
								</li>
								
				<li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}/ggoods_newlist.action"> 新品管理</a>
									</div>
								</li>
					<li class="level2">
									<div class="level2Style">
										<img src="style/images/MenuIcon/menu_arrow_single.gif" />
										<a target="right" href="${pageContext.request.contextPath}/stheme_list.action"> 主题推荐管理</a>
									</div>
								</li> --%>
				
			</ul>

		</div>
	
	</body>
</html>