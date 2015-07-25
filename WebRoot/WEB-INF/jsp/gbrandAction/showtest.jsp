<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
    <%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>发现</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/brand-2.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/head.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/calendar.css">

   
    
<script type="text/javascript" src="${pageContext.request.contextPath}/script/hia.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/calendar.js"></script>


</head>
<body >
	<div class="web-bar"><!-- 第一块 -->
		<div class="web-bar-one">
			<!-- 头像 登录前-->
			
			<c:if test="${sessionScope.user==null}">
				<div class="user-iconinfo" id="login">
					<input type="button" value="登录"  onclick="login()"><span>●</span><a href="uuser_registerUI.action?registerPreUrl=gbrand_show?brandId=${brandId}-cateId=${cateId}-attrnow=${attrnow}">注册</a>
				</div>
				<div class="user-login" id="user-login">
					<form method="post" action="uuser_login.action?registerPreUrl=gbrand_show?brandId=${brandId}-cateId=${cateId}-attrnow=${attrnow}">
						<fieldset>
							<div class="item-name">
								<input type="text" name="phonenum" id="form_email" class="inp" placeholder="邮箱/手机号" >
							</div>
							<div class="item-password">
								<input type="password" name="password" id="form_password" class="inp" placeholder="密码" >
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
				</c:if>
				<c:if test="${sessionScope.user!=null}">
				<div class="user-iconinfo" onmouseover="document.getElementById('user-fullinfo').style.display='block'" onmouseout=			                         "document.getElementById('user-fullinfo').style.display=''">
					
						<div class="user-pic">
							<a href="#"><img src="img/hiapic/头像.jpg"></a>
							
						</div>
						<div class="fl">欢迎：${sessionScope.user.username}</div>
						<div class="user-fullinfo" id="user-fullinfo">
							<div class="empty"><i class="hia-icon">&#xea1c;</i></div>
							<ul>
								<li class="user-name"><a href="#">我的主页</a></li>
								<li class="user-home"><a href="#">我的心愿单</a></li>
								<li class="user-home"><a href="#">我的消息</a></li>
								<li class="user-home"><a href="#">账号设置</a></li>
								<li class="user-out"><a href="uuser_logout.action?registerPreUrl=gbrand_show?brandId=${brandId}-cateId=${cateId}-attrnow=${attrnow}">退出</a></li>
							</ul>
						</div>
				</div>
				
			</c:if>
					<p><a href="#">Poster</a></p>
					<p><a href="#">Pocket</a></p> 
				</div>
			</div>
			<div class="web-icon"><!-- 第二块 -->
				<div class="icon-pic"><!-- hia图标 -->
					<a href="#"><img src="style/img/hiapic/hia.gif"></a>
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
						
						<p><img src="style/img/hiapic/search.png" style="width:15px; margin-left:5px;"></p>
					</form>
				</div>
			</div>

	<div class="content-main">
	
		<div class="brand-show ">
			<div class="brand-logo fl">
				<a><img  src="${pageContext.request.contextPath}/style/img/hiapic/brand-zara.png"  alt=""/></a>
			</div>
			<div class="content fl">
				<div class="name"><h1>ZARA</h1></div>
				<div class="linkAdd">
					<a href="#">官网：http://www.zara.cn/cn/</a>
				</div>
			</div>
			<div class="focus fr">
			<c:if test="${sessionScope.user==null}">
				<a href="uuser_loginUIUI.action?registerPreUrl=gbrand_show?brandId=${brandId}-cateId=${cateId}-attrnow=${attrnow}"  style="background-color: #999999; color:#FFFFFF; padding:5px 5px;" >+关注</a>
			</c:if>
			<c:if test="${sessionScope.user!=null}">
					<c:if test="${is_focused}">
							<a href="gbrand_NofocusBrand.action?brandId=${brandId}&focusPreUrl=gbrand_show?brandId=${brandId}-cateId=${cateId}-attrnow=${attrnow}"  style="background-color: #999999; color:#FFFFFF; padding:5px 5px;" >-已关注</a>
					</c:if>
					<c:if test="${!is_focused}">
							<a href="gbrand_focusBrand.action?brandId=${brandId}&focusPreUrl=gbrand_show?brandId=${brandId}-cateId=${cateId}-attrnow=${attrnow}"  style="background-color: #999999; color:#FFFFFF; padding:5px 5px;" >+关注</a>
					</c:if>
			</c:if>
			</div>
		</div>
		<div class="brand-bar fl">
			<ul>
						<a  href="#" ><li style="border-bottom:1px solid">产品</li></a>
						
						<li class="inli">|</li>
						<a  href="#"><li >折扣信息</li></a>

						<li class="inli">|</li>
						<a  href="#"><li>查找店铺</li></a>

						<li class="inli">|</li>
						<a  href="gbrand_introduce.action?brandId=${model.brandId}"><li >关于品牌</li></a>

					</ul>
		</div>
		<form   action="ggoods_show?cateId=${cateId}&attrnow=${attrnow}&attradd=${attradd}&attrdel=${attrdel}">
		<div class="product fl">
			<div  class="left-bar fl">
				<div classs="fl">
				<button  onclick="timeOn()" >按上新时间</button>
				<script language="javascript">
					 var a=1;
					function timeOn(){
						
						if(a%2==0)
						{
							document.getElementById('time').style.display = "none";
						}
						else{
						
						 document.getElementById('time').style.display = "";
						}
						a++;
					}
					
						
				</script>
				<div class="time" id="time" style="margin-top:10px; margin-left:20px; display:none">
					<div class="line fl">
						<table style="height:35px;border-color:000000;border-left-style:solid;border-width:1px;margin-left:3px;"><tr><td valign=                         "top"	 ></td></tr></table>
						
						
					</div>
					<div class="line-time fl">
						<div class="Ptime" id="Ptime">2015.05.05
							<div class="po"><span>●</span></div>
						</div>
					
					</div>
					<div class="line fl">
						<table style="height:35px;border-color:000000;border-left-style:solid;border-width:1px;margin-left:3px;"><tr><td valign=                         "top"	 ></td></tr></table>
						
						
					</div>
					<div class="line-time fl">
						<div class="Ptime" id="Ptime" >2015.05.05
							<div class="po"><span>●</span></div>
						</div>
					
					</div>
					<div class="line fl">
						<table style="height:35px;border-color:000000;border-left-style:solid;border-width:1px;margin-left:3px;"><tr><td valign=                         "top"	 ></td></tr></table>
						
						
					</div>
					<div class="line-time fl">
						<div class="Ptime" id="Ptime" >2015.05.05
							<div class="po"><span>●</span></div>
						</div>
					
					</div>
					<!--<div class="btn-group">
						  <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true"                                aria-expanded="false">
							Small button <span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu">
							<li></li>
						  </ul>
                     </div>-->
					
					
					
				</div>
				</div>
				<div class="middle-catg fl" style="margin-top:30px;">
					<div class="">
						<c:if test="${mapF.size()!=0}">
							  <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true"                          aria-expanded="false">
								时尚 <span class="caret"></span>
							  </button>
							  <c:forEach items="${mapF}" var="item" varStatus="status">
							  <c:if test="${item.value.size()==0}">					 
									<p><a style="color: green;" href="gbrand_show.action?brandId=${brandId}&&cateId=${item.key.catId}&&attrnow=${attrnow}">${item.key.catName}</a></p>
								</c:if>	
								<c:if test="${item.value.size()!=0}">
									<p>${item.key.catName}</p>
								</c:if>
								<ul>
									<c:forEach  items="${item.value}" var="list" >
										
										<li >
											<a style="color: red;" href="gbrand_show.action?brandId=${brandId}&&cateId=${list.catId}&&attrnow=${attrnow}">${list.catName}</a>
										</li>  		
									</c:forEach>
								</ul>
							</c:forEach>
						</c:if>
						</div>
						
						<div class="">
						<c:if test="${mapB.size()!=0}">
							  <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true"                          aria-expanded="false">
								美妆 <span class="caret"></span>
							  </button>
							  <c:forEach items="${mapB}" var="item" varStatus="status">
							  <c:if test="${item.value.size()==0}">					 
									<p><a style="color: green;" href="gbrand_show.action?brandId=${brandId}&&cateId=${item.key.catId}&&attrnow=${attrnow}">${item.key.catName}</a></p>
								</c:if>	
								<c:if test="${item.value.size()!=0}">
									<p>${item.key.catName}</p>
								</c:if>
								<ul>
									<c:forEach  items="${item.value}" var="list" >
										
										<li >
											<a style="color: red;" href="gbrand_show.action?brandId=${brandId}&&cateId=${list.catId}&&attrnow=${attrnow}">${list.catName}</a>
										</li>  		
									</c:forEach>
								</ul>
							</c:forEach>
						</c:if>
						</div>
						
						
						<div class="">
						<c:if test="${mapH.size()!=0}">
							  <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true"                          aria-expanded="false">
								家居 <span class="caret"></span>
							  </button>
							  <c:forEach items="${mapH}" var="item" varStatus="status">
							  <c:if test="${item.value.size()==0}">					 
									<p><a style="color: green;" href="gbrand_show.action?brandId=${brandId}&&cateId=${item.key.catId}&&attrnow=${attrnow}">${item.key.catName}</a></p>
								</c:if>	
								<c:if test="${item.value.size()!=0}">
									<p>${item.key.catName}</p>
								</c:if>
								<ul>
									<c:forEach  items="${item.value}" var="list" >
										
										<li >
											<a style="color: red;" href="gbrand_show.action?brandId=${brandId}&&cateId=${list.catId}&&attrnow=${attrnow}">${list.catName}</a>
										</li>  		
									</c:forEach>
								</ul>
							</c:forEach>
						</c:if>
						</div>
						
						
						<c:if test="${selectedCate.catName!=null}">
						<div style="color: red">
							已选分类：<a href="gbrand_show.action?brandId=${brandId}&&attrnow=${attrnow}">${selectedCate.catName}</a>
						</div>
						</c:if>
						<div class="right-style fl" style="margin-top:30px;">
									<div class="btn-group">	
													   <c:forEach items="${mapAttr}" var="item" varStatus="status">
															<p ><a style="color: red"href="#">${item.key.attrName}</a></p>
															<ul>
																<c:forEach  items="${item.value}" var="list" >
																	<li><a href="gbrand_show.action?brandId=${brandId}&&cateId=${cateId}&&attradd=${list}&&attrnow=${attrnow}">${list}</a></li>  
																</c:forEach>
															</ul>
														</c:forEach>
												<div  style="background-color: red">
																<c:if test="${selectRangeList.size()!=0&&selectRangeList!=null}">
																已选扩展属性选项：
																<c:forEach items="${selectRangeList}" var="item" >
																	
														              <li class="text-muted"><a
														                href="gbrand_show.action?brandId=${brandId}&cateId=${cateId}&attrnow=${attrnow }&attrdel=${item}">
														              ${item} </a>
														            </li>
				            									</c:forEach>
				            									</c:if>
            									</div>
									</div>
						</div>   
					</div>	
					</div>
			<div class="product-show fl ">
				<c:forEach items="${recordList}" var="item">
					<div class="coll fl">
					
					<div class="productor fl" >
						${item.goodsName}
						<a href="ggoods_show.action?goodsId=${item.goodsId}"><img src="${item.imgSmall}" /></a>
					</div>
					
				</div>
				
				</c:forEach>	
			</div>	
			</div>
			</form>
			  <%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
		</div>
</body>
</html>