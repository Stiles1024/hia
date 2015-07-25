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
            var nameField = document.login.phonenum.value; 
             
             if(nameField.length==0)  
                return false;  
             
             $.ajax({
            type: "POST",
            url: "uuser_ajaxLogin.action",
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
			
			<div class="left-side">
				<form name="login" method="post" action="uuser_login.action">
					<input type="hidden" name="registerPreUrl"  value="${registerPreUrl}">
					<div class="item-tips">
						
						手机号或者邮箱<input type="text" name="phonenum" id="phonenum" class="basic-input" maxlength="60"  value="${phonenum}" onblur="checkUserNameAction()" >
						<span id="checkUserNameMsg">
											<font color='blue'><B><c:if test="${loginFlag==0}">
																					<span style="color: red">账号不存在</span> 
																				</c:if>
																		</B></font>
                   		</span>
					</div>
					<div class="item-tips">
						<label>密码</label>
						<input type="password" name="password" id="register-password" class="basic-input" maxlength="20">
						<c:if test="${loginFlag==1}">
							<div  style="color: red">密码错误</div>
						</c:if>
					</div>
					
					<!-- <div class="item-tips">
						<label></label>
						<input type="text" name="phonenum" id="register-phone" class="basic-input" maxlength="60" onblur="checkUserNameAction()" >
					<span id="checkUserNameMsg">
											<font color='blue'><B>一个手机号一个账户</B></font>
                   				</span>
					</div> -->
				
					<div class="item-tips">
						<label>验证码</label>
						<input type="text" name="registr-code" id="register-code" class="basic-input small" maxlength="10">
						<input type="submit" value="获取验证码" class="get-code-btn" id="get-code">
					
					</div>
						<input type="submit" value="登入">
					
				</form>
			</div>
			<div class="right-side">
				<ul class="sidenav">
					<li>
						>&nbsp;还没有hia账号？<a href="uuser_register.action?registerPreUrl=gbrand_show?brandId=15">立即注册</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="footer">
			
		</div>
	</body>
</html>