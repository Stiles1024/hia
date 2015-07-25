<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<title>brand-index</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/brand-indexNew.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/head.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/hia.js"></script>


</head>

<body>
	<div class="web-bar"><!-- 第一块 -->
		<div class="web-bar-one">
			<!-- 头像 登录前-->
			<div class="user-iconinfo" id="login">
				<input type="button" value="登录"  onclick="login()"><span>●</span><a href="uuser_registerUI.action?registerPreUrl=gbrand_brandIndex?brandId=${brandId}">注册</a>
			</div>
			<div class="user-login" id="user-login">
				<form method="" action="">
					<fieldset>
						<div class="item-name">
							<input type="text" name="form_email" id="form_email" class="inp" placeholder="邮箱/手机号" >
						</div>
						<div class="item-password">
							<input type="password" name="form_password" id="form_password" class="inp" placeholder="密码" >
							<div class="opt">
								<a href="forget-password.html">忘记密码</a>
							</div>
						</div>
						<div class="item-remember">
							<label class="form_remember">
								<input type="checkbox" name="remember" id="form_remember">记住我
							</label>
						</div>
						<div class="item-submit">
							<input type="submit" value="登录" class="bn-submit">
							<input type="button" value="取消" class="bn-submit" onclick="cancel()" title="暂时先不登录">
						</div>
					</fieldset>
				</form>
			</div> 
				<!--<div class="user-iconinfo" onmouseover="document.getElementById('user-fullinfo').style.display='block'" onmouseout=			                         "document.getElementById('user-fullinfo').style.display=''">
						<div class="user-pic">
							<a href="#"><img src="${pageContext.request.contextPath}/style/img/hiapic/头像.jpg"></a>
						</div>
						<div class="user-fullinfo" id="user-fullinfo">
							<div class="empty"><i class="hia-icon">&#xea1c;</i></div>
							<ul>
								<li class="user-name"><a href="#">我的主页</a></li>
								<li class="user-home"><a href="#">我的心愿单</a></li>
								<li class="user-home"><a href="#">我的消息</a></li>
								<li class="user-home"><a href="#">账号设置</a></li>
								<li class="user-out"><a href="#">退出</a></li>
							</ul>
						</div>
					</div>-->
					<p><a href="#">Poster</a></p>
					<p><a href="#">Pocket</a></p> 
				</div>
			</div>
			<div class="web-icon"><!-- 第二块 -->
				<div class="icon-pic"><!-- hia图标 -->
					<a href="#"><img src="${pageContext.request.contextPath}/style/img/hiapic/hia.gif"></a>
				</div>
				<div class="nav-bar"><!-- 导航栏 -->
					<ul>
						<li><a href="#"><i class="hia-icon" style="font-size:14px">&#xe902;</i>&nbsp;首页</a></li>
						<li><a href="#"><i class="hia-icon" style="font-size:15px">&#xe9ce;</i>&nbsp;发现</a></li>
						<li><a href="#"><i class="hia-icon" style="font-size:13px">&#xe935;</i>&nbsp;品牌</a></li>
					</ul>
				</div>
				<div class="nav-search"><!-- 搜索框 -->
					<form name="" method="" action="">
						<input type="text" name="" class="basic-btn"/>
						<p><img src="${pageContext.request.contextPath}/style/img/hiapic/search.png" style="width:15px; margin-left:5px;"/></p>
					</form>
				</div>
			</div>
	<div class="brand-main">
		<div class="brand-bar">
			<div class="bar-name">
				时尚 · 品牌
				<div class="bar-line"></div>
				<div class="bar-empty"></div>
			</div>
		</div>
		<div class="brand-content">
			<div class="content-left">
				<img src="${pageContext.request.contextPath}/style/img/hiapic/Screen Shot 2015-05-22 at 3.42.58 PM.png">
			</div>
			<div class="content-right">
				<div class="content-right-one">
				<c:if test="${FListCH.size()!=0}">
					<p><a href="#">#</a></p>
						<ul>
						<c:forEach items="${FListCH}" var="item" varStatus="status">
							<li><a href="gbrand_show.action?brandId=${item.brandId}">${item.brandName}</a></li>
						</c:forEach>
						</ul>
					</c:if>
					<c:if test="${FListNum.size()!=0}">
						<p><a href="#">123</a></p>
						
							<ul>
						<c:forEach items="${FListNum}" var="item" varStatus="status">
							<li><a href="gbrand_show.action?brandId=${item.brandId}">${item.brandName}</a></li>
						</c:forEach>
						</ul>
					</c:if>
					<c:forEach items="${mapF}" var="item" varStatus="status">
						<p><a href="#">${item.key}</a></p>
						<ul>
							<c:forEach  items="${item.value}" var="list" >
								<li><a href="gbrand_show.action?brandId=${list.brandId}">${list.getBrandName()}</a></li>
							</c:forEach>
						</ul>
					</c:forEach>

				</div>
				<div class="content-right-two">
					
				</div>
				<div class="content-right-three">
					
				</div>
			</div>
		</div>

		<div class="brand-bar">
			<div class="bar-name">
				美妆 · 品牌
				<div class="bar-line"></div>
				<div class="bar-empty"></div>
			</div>
		</div>
		<div class="brand-content">
			<div class="content-left">
				<img src="${pageContext.request.contextPath}/style/img/hiapic/Screen Shot 2015-05-22 at 3.42.58 PM.png">
			</div>
			<div class="content-right">
				<div class="content-right-one">
					<c:if test="${BListCH.size()!=0}">
						<p><a href="#">#</a></p>
						<c:forEach items="${BListCH}" var="item" varStatus="status">
							<li><a href="gbrand_show.action?brandId=${item.brandId}">${item.brandName}</a></li>
						</c:forEach>
					</c:if>
					<c:if test="${BListNum.size()!=0}">
						<p><a href="#">123</a></p>
						<c:forEach items="${BListNum}" var="item" varStatus="status">
							<li><a href="gbrand_show.action?brandId=${item.brandId}">${item.brandName}</a></li>
						</c:forEach>
					</c:if>
					
					<c:forEach items="${mapB}" var="item" varStatus="status">
						<p><a href="#">${item.key}</a></p>
						<ul>
							<c:forEach  items="${item.value}" var="list" >
								<li><a href="gbrand_show.action?brandId=${list.brandId}">${list.getBrandName()}</a></li>
							</c:forEach>
						</ul>
					</c:forEach>
						
					
				</div>
				<div class="content-right-two">
					
				</div>
				<div class="content-right-three">
					
				</div>
			</div>
		</div>

		<div class="brand-bar">
			<div class="bar-name">
				家居 · 品牌
				<div class="bar-line"></div>
				<div class="bar-empty"></div>
			</div>
		</div>
		<div class="brand-content">
			<div class="content-left">
				<img src="${pageContext.request.contextPath}/style/img/hiapic/Screen Shot 2015-05-22 at 3.42.58 PM.png">
			</div>
			<div class="content-right">
				<div class="content-right-one">
					<c:if test="${HListCH.size()!=0}">
						<p><a href="#">#</a></p>
						<c:forEach items="${HListCH}" var="item" varStatus="status">
							<li><a href="gbrand_show?brandId=${item.brandId}">${item.brandName}</a></li>
						</c:forEach>
					</c:if>
					<c:if test="${HListNum.size()!=0}">
						<p><a href="#">123</a></p>
						<c:forEach items="${HListNum}" var="item" varStatus="status">
							<li><a href="gbrand_show?brandId=${item.brandId}">${item.brandName}</a></li>
						</c:forEach>
					</c:if>
					
					<c:forEach items="${mapH}" var="item" varStatus="status">
						<p><a href="#">${item.key}</a></p>
						<ul>
							<c:forEach  items="${item.value}" var="list" >
								<li><a href="gbrand_show?brandId=${list.brandId}">${list.getBrandName()}</a></li>
							</c:forEach>
						</ul>
					</c:forEach>
				
				</div>
				<div class="content-right-two">
					
				</div>
				<div class="content-right-three">
					
				</div>
			</div>
		</div>
	</div>		
</body>
</html>