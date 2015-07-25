<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
		<title>品牌产品</title>
		<link rel="stylesheet" type="text/css" href="style/product-particular.css">
		<link rel="stylesheet" type="text/css" href="style/reset.css">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/head.css">
		<script type="text/javascript" src="script/hia.js"></script>
		
	</head>
	<body>
				<script type="text/javascript">
	function Ajax(){  
        
            
          nullExist.innerHTML ="";
  		 	var nameColl =document.collection.collName.value; 
  		 	nameColl+="_"+${model.goodsId};
  		 	var temp="_"+${model.goodsId};
  		 	
           if(nameColl==temp)
            {
            nullExist.innerHTML ="名称不能为空";
            return false;  
            }
             $.ajax({
            type: "POST",
            url: "ggoods_ajaxCollection.action",
            contentType: "application/json", //
            dataType: "text", //
         	
             data: encodeURI(nameColl),  //传递中文编码
            success: function (jsonResult) {
           
            if(jsonResult==("")){
            	 nullExist.innerHTML ="该collection已存在";
            	
            }
            else{
	            var nameid=jsonResult.split("_");
	            var name=nameid[0];
	            var id=nameid[1];
	            var select = document.getElementById("Select");
	          	 select.options.add(new Option(name, id));
         		}
         	
            },
            error:function(e) {
				alert("cucouco");
				}
        });
}

	</script>	
	
	
	
	
		<div class="web-bar"><!-- 第一块 -->
		
		
			<div class="web-bar-one">
				<!-- 头像 登录前-->
				<c:if test="${sessionScope.user==null}">
				<div class="user-iconinfo" id="login">
					<input type="button" value="登录"  onclick="login()"><span>●</span><a href="uuser_registerUI.action?registerPreUrl=ggoods_show?goodsId=${goodsId}">注册</a>
				</div>
				<div class="user-login" id="user-login">
					<form method="post" action="uuser_login.action?registerPreUrl=ggoods_show?goodsId=${goodsId}">
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
								<li class="user-out"><a href="uuser_logout.action?registerPreUrl=ggoods_show?goodsId=${goodsId}">退出</a></li>
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
		<!-- 主体部分开始 -->
		<div class="nav-product"><!-- 产品导航栏 -->
	
			<a href="gbrand_show.action?brandId=${model.TGBrand.brandId}">${model.TGBrand.brandName}</a>&nbsp;/
			<a href="gbrand_show.action?brandId=${model.TGBrand.brandId}&cateId=${model.TGCategory.catId}">${model.TGCategory.catName}</a>&nbsp;
		</div>
		<div class="product-show"><!-- 产品展示区 -->
			<div class="product-left"><!-- 左边小图片区 -->
			
				<c:forEach items="${urls}" var="item">
	
					<img   src="${item}">
				</c:forEach>
				
			</div>
			<div class="product-middle"><!-- 中间大图片区 -->
				<img src="${model.imgSmall}">
			</div>
			<div class="product-right"><!-- 右边信息区 -->
				<div class="basic-info"><!-- 产品基本信息 -->
					<p><strong>${model.TGBrand.brandName}</strong></p>
					<p>产品名：${model.goodsName}</p>
					<p>货号：${model.goodsSn}</p>
					<p>价格：${model.nPrice }</p>
					<p>原价：${model.oPrice }</p>
				</div>
				<div class="product-introduce"><!-- 产品简介 -->
					<div class="intro">
						产品简介
						<p class="line"></p>
					</div>
					${model.goodsDesc}
				</div>
				<div class="btn-function"><!-- 功能按钮 -->
					<a href="${model.gUrl}">去官网购买</a>
				 <c:if test="${sessionScope.user==null}">
				 	<a href="uuser_loginUI.action?registerPreUrl=ggoods_show?goodsId=${model.goodsId}">+愿望单</a>
				 </c:if>
				 <c:if test="${sessionScope.user!=null}">
						<c:if test="${is_dreamed==false}">
						<a href="ggoods_dream.action?goodsId=${model.goodsId}">+愿望单</a>
						</c:if>
						<c:if test="${is_dreamed==true}">
						<a href="ggoods_Nodream.action?goodsId=${model.goodsId}">-愿望单</a>
						</c:if>
					</c:if>
					<a href="#">分享至</a>
					<%@include file="share.jsp" %>
				
				</div>
				<div class="ds-thread" data-thread-key="请将此处替换成文章在你的站点中的ID" data-title="请替换成文章的标题" data-url="请替换成文章的网址"></div>

	<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
		 <form action="ggoods_collection.action"  name="collection">
		 <input type="hidden" value="${model.goodsId}" name="goodsId">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="myModalLabel">添加到Pocket</h4>
        </div>
        <div class="modal-body">
       
        选择collection
         	<select name="collectionId" class="textarea" id="Select">
         		<c:forEach items="${collectionList}" var="item">
  				<option value="${item.collId}" >${item.name}</option>
  				</c:forEach>
				</select>
		<div>
          + 创建新的Collection
          </div>
          <div>
          <input type="text"  value="" style="background-color: blue" name="collName"><span onclick="Ajax()">创建</span>
          </div>
          <span id="nullExist"></span>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">确定</button>
        </div>
	</form>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->

  <div class="bs-example bs-example-padded-bottom">
  <c:if test="${sessionScope.user==null}">
    <a href="uuser_loginUI.action?registerPreUrl=ggoods_show?goodsId=${model.goodsId}"><button type="button" class="btn btn-primary btn-lg" data-toggle="modal"  style="color: white;background-color: grey ">
      +pocket
    </button></a>
    </c:if>
    <c:if test="${sessionScope.user!=null}">
    	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"  style="color: white;background-color: grey ">
      +pocket
    </button>
    </c:if>
  </div>
				
				
				
				
				
				
			</div>
		</div>
		<div>
		<div id="uyan_frame"></div>
<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js"></script>
			<form action="ggoods_evaluate.action" method="post" enctype="multipart/form-data" >
        	上传人名:<input type="text" name="name" /><br/>      
          	上传文件:<input type="file" name="file" /><br/>
          	<input type="text" name="comment" /><br/>
          	<input type="submit" name="submit" value="提交" />
      </form>
		</div>
		<div class="similar-product"><!-- 同品牌相似产品 -->
			<p  style="font-weight:600">同品牌相似产品</p>
			<div>
				<a href="#"><img   src="style/img/hiapic/similar-P.jpg"></a>
				<a href="#"><img   src="style/img/hiapic/similar-P.jpg"></a>
				<a href="#"><img   src="style/img/hiapic/similar-P.jpg"></a>
				<a href="#"><img   src="style/img/hiapic/similar-P.jpg"></a>
				<a href="#"><img   src="style/img/hiapic/similar-P.jpg"></a>
				<a href="#"><img   src="style/img/hiapic/similar-P.jpg"></a>
				<a href="#"><img   src="style/img/hiapic/similar-P.jpg"></a>
			</div>
		</div>
		<div class="relative-poster"><!-- 相关poster -->
			<div class="nav-poster">
				<p class="related" style="font-weight:600">相关Poster</p>
				<p class="more"><a href="#">更多></a></p>
			</div>
			<div class="poster-pic">
				<a href="#"><img  src="style/img/hiapic/similar-Po.png""></a>
				<a href="#"><img  src="style/img/hiapic/similar-Po.png""></a>
				<a href="#"><img  src="style/img/hiapic/similar-Po.png""></a>
				<a href="#"><img  src="style/img/hiapic/similar-Po.png""></a>
			</div>
		</div>
		<div class="relative-collection"><!-- 相关集合 -->
			<p style="font-weight:600">相关Collection</p>
			<ul>
				<li>- <a href="#">hoodie大集合</a></li>
				<li>- <a href="#">Can`t let go and it doesn`t Matter how I tried</a></li>
				<li>- <a href="#">#秋#</a></li>
				<li>- <a href="#">百搭基本款</a></li>
				<li>- <a href="#">深蓝</a></li>
			</ul>
		</div>
		<div class="relative-look"><!-- 买家Look -->
			<div class="nav-look">
				<p class="related">买家LOOK</p>
				<p class="add"><a href="#"><i class="hia-icon" style="font-size:13px">&#xe906;</i> 添加我的买家LOOK</a></p>
			</div>
			<div class="look-pic">
				<div class="particular-pic"><!-- 具体一张LOOK图片 -->
					<a href="#"><img  src="style/img/hiapic/similar-look.jpg"></a>
					<div class="status-bar">
						<p class="like"><a href="#"><i class="hia-icon" style="font-size:15px">&#xe600;</i></a><span>13</span></p>
						<p class="comment"><a href="#"><i class="hia-icon" style="font-size:15px">&#xe601;</i></a><span>800</span></p>
					</div>
				</div>
				
			</div>
		</div>
	</body>
</html>