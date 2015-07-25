<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<head>
		<title>hia首页</title>
		<style type="text/css">
			*{
				margin: 0;
				padding: 0;
				font-family:'Helvetica Neue',Roboto,'Open Sans','Noto Sans','Source Han Sans SC','WenQuanYi Microhei','Hiragino Sans GB','Microsoft Yahei','Droid Sans Fallback',sans-serif;;font-style:normal;font-weight:normal;
			}
			.brand_head {
				margin:0 auto;
				width: 1080px;
			}
			.brand_head .brand_icon {
				float: left;
				height: 100px;
				width: 100px;
			}
			.brand_head .brand_follow {
				float: right;
				height: 30px;
				padding-top: 20px;
			}
			.brand_head .brand_head_main {
				padding-top: 20px;
			}

			/*第二块开始*/
			.nav-bar2{
				width: 800px;
				height: 40px;
				line-height: 40px;
				text-align: center;
				margin: 0 auto;
				position: relative;
				padding-top: 20px;
			}
			.nav-bar2 img{
				z-index: 1;
			}
			.nav-bar2 a{
				margin-right: 50px;
				margin-left: 50px;
				text-decoration: none;
				color: #000;
				font-size: 20px;
			}
			.nav-bar2 a:hover{
				/*color: #C00;*/
				font-weight: bold;
				text-decoration: underline;
			}
			.brand_main {
				margin:0 auto;
				width: 1080px;
				/*font-family:Microsoft YaHei; */
				
				padding-top: 50px;
				letter-spacing: 2px;

			}
			.brand_main h2{
				color: black;
			}
			
			
		</style>
		<link type="text/css" rel="stylesheet" href="style/head.css">
		<link type="text/css" rel="stylesheet" href="style/brand-2.css">
		<link type="text/css" rel="stylesheet" href="style/reset.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/script/hia.js"></script>
	</head>
<body >
	<div class="web-bar"><!-- 第一块 -->
		<div class="web-bar-one">
			<!-- 头像 登录前-->
			
			<c:if test="${sessionScope.user==null}">
			
				<div class="user-iconinfo" id="login">
					<input type="button" value="登录"  onclick="login()"><span>●</span><a href="uuser_registerUI.action?registerPreUrl=gbrand_introduce?brandId=${brandId}">注册</a>
				</div>
				<div class="user-login" id="user-login">
					<form method="post" action="uuser_login.action?registerPreUrl=gbrand_introduce?brandId=${brandId}">
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
							<a href="#"><img src="${sessionScope.user.img}"></a>
							
						</div>
						<div class="fl">欢迎：${sessionScope.user.username}</div>
						<div class="user-fullinfo" id="user-fullinfo">
							<div class="empty"><i class="hia-icon">&#xea1c;</i></div>
							<ul>
								<li class="user-name"><a href="#">我的主页</a></li>
								<li class="user-home"><a href="#">我的心愿单</a></li>
								<li class="user-home"><a href="#">我的消息</a></li>
								<li class="user-home"><a href="#">账号设置</a></li>
								<li class="user-out"><a href="uuser_logout.action?registerPreUrl=gbrand_introduce?brandId=${brandId}">退出</a></li>
							</ul>
						</div>
				</div>
				
			</c:if>
					<p><a href="#">Poster</a></p>
					<p><a href="upocket_show.action?authorId=${sessionScope.user.userId}">Pocket</a></p> 
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
				<a href="uuser_loginUI.action?registerPreUrl=gbrand_introduce?brandId=${brandId}"  style="background-color: #999999; color:#FFFFFF; padding:5px 5px;" >+关注</a>
			</c:if>
			<c:if test="${sessionScope.user!=null}">
					<c:if test="${is_focused}">
							<a href="gbrand_NofocusBrand.action?brandId=${brandId}&focusPreUrl=gbrand_introduce?brandId=${brandId}"  style="background-color: #999999; color:#FFFFFF; padding:5px 5px;" >-已关注</a>
					</c:if>
					<c:if test="${!is_focused}">
							<a href="gbrand_focusBrand.action?brandId=${brandId}&focusPreUrl=gbrand_introduce?brandId=${brandId}"  style="background-color: #999999; color:#FFFFFF; padding:5px 5px;" >+关注</a>
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
		<div class="brand_main fl">
			<h2>品牌简介</h2><br>
			<p style="margin-left:50px; line-height:200%;text-indent:30px; font-size:12px;">
  ZARA是西班牙Inditex集团( 股票代码ITX) 旗下的⼀个⼦公司，它既是服装品牌，也是专营ZARA 品牌服装的连锁零售品牌。1975年设⽴于⻄班⽛的
ZARA ⾪属于Inditex 集团为全球排名第三、⻄班⽛排名第⼀的服装商，在世界各地56个国家内，设⽴超过两千多家的服装连锁店。ZARA 深受全球时尚⻘年
的喜爱，设计师品牌的优异设计价格却更为低廉，简单来说就是让平民拥抱High Fashion 。 
 Inditex是⻄班⽛排名第⼀，超越了美国的GAP、瑞典的HM成为全球排名第⼀的服装零售集团。截⾄2013年10⽉31⽇它在全球86个国家和地区开设
了6249家专卖店，旗下共有8 个服装零售品牌，ZARA 是其中最有名的品牌。在全球86个国家拥有1808家专卖店（⾃营专卖店占90%，其余为合资和特许专
卖店）。尽管ZARA 品牌的专卖店只占Inditex 公司所有分店数的三分之⼀，但是其销售额却占总销售额的66%左右。 
  ZARA 第⼀家⻔店于1975年在⻄班⽛拉科鲁尼亚（LA Coruña ）开设，⺫前已拥有1,900多家店遍布世界87个市场主要城市的商业中⼼。ZARA 在国际
上的成功清楚地表明时装⽂化⽆国界。凭借⼀⽀拥有200 多名专业⼈⼠的创作团队，ZARA 的设计过程紧跟⼤众⼝味。
			</p><br>
			<h2>联系方式</h2>
			<pre style="margin-left:50px; margin-top:15px">公司电话：021 6161 1398                    周一到周五：9:30 - 18:30</pre>
			<pre style="margin-left:50px; margin-top:15px">官网电话：400 821 6002                      周一到周五：9:00 - 22:00	</pre>
		</div>
	</div>
		
	</body>
</html>