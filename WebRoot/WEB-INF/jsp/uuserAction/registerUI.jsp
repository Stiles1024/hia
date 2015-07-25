<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
    
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<head>
	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
		<title>register</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/register.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/reset.css">
		<script type="text/javascript" src="js/register.js"></script>
	</head>
	<body>
	<script type="text/javascript">

function checkUserNameAction(){  
        
            checkUserNameMsg.innerHTML = "正在验证";  
            var nameField = document.register.phonenum.value; 
             
             if(nameField.length==0)  
                return false;  
             
             $.ajax({
            type: "POST",
            url: "uuser_ajaxRegister.action",
            contentType: "application/json", //
            dataType: "text", //
         
             data: nameField, 
            success: function (jsonResult) {
             checkUserNameMsg.innerHTML = jsonResult;  
         
            },
            error:function(e) {
				alert("cucouco");
				}
        });
   
}

	</script>	
	
	
	
		<div class="header">
	
			<a href="#"><img src="style/img/hiapic/hia.gif"></a>
		</div>
		<div class="wrapper">
			<h1 style="font-family:宋体">欢迎加入hia</h1>
			<div class="left-side">
				<form name="register" method="" action="uuser_register.action">
					<input type="hidden" name="registerPreUrl"  value="${registerPreUrl}">
					<div class="item-tips">
						<label>邮箱</label>
						<input type="text" name="email" id="email" class="basic-input" maxlength="60"  >
					</div>
					<div class="item-tips">
						<label>密码</label>
						<input type="password" name="password" id="register-password" class="basic-input" maxlength="20">
					</div>
					<div class="item-tips">
						<label>昵称</label>
						<input type="text" name="username" id="register-name" class="basic-input" maxlength="15">
					</div>
					<div class="item-tips">
						<label>手机号</label>
						<input type="text" name="phonenum" id="register-phone" class="basic-input" maxlength="60" onblur="checkUserNameAction()" >
					<span id="checkUserNameMsg">
											<font color='blue'><B>一个手机号一个账户</B></font>
                   				</span>
					</div>
					<div class="suggestion">
						<span class="tips">用手机接收注册验证码</span>
					</div>
					<div class="item-tips">
						<label>验证码</label>
						<input type="text" name="registr-code" id="register-code" class="basic-input small" maxlength="10">
						<input type="submit" value="获取验证码" class="get-code-btn" id="get-code">
					</div>
					<div class="item-tips">
						<p class="agreement">
							<label class="agreement-label" for="agreement">
								<input type="checkbox" id="agreement" name="agreement">我已经认真阅读并同意hia的《<a href="#" target="_blank">使用协议</a>》。
							</label>
						</p>
					</div>
					<div class="item-submit">
						<label>&nbsp;</label>
						<input type="submit" name="register" value="注册" id="button" class="btn-submit disabled" title="阅读并同意hia的《使用协议》方可注册">
					</div>
				</form>
			</div>
			<div class="right-side">
				<ul class="sidenav">
					<li>
						>&nbsp;已经拥有hia账号？<a href="hia.html">直接登录</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="footer">
			
		</div>
	</body>
</html>