<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>新增用户</title>
<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
</head>
<body>
<div class="container">
	<h2>新增用户</h2>
	<hr>
	<s:form action="uuser_%{userId==null ? 'add'  : 'edit' }" name="regForm" method="post" enctype="multipart/form-data">
			<s:hidden name="userId" value="%{userId}"></s:hidden>
			<div class="row">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label" style="display:inline-block;margin-top:5px">用户名</label>
				<div class="col-sm-10" style="width:500px;margin-bottom:10px;float:left">
					<input type="text" class="form-control" id="firstname" onblur="checkUserNameAction()" 
					 name="username"  value="<s:property value="username" />">					
				</div>
				<span id="checkUserNameMsg" style="display:inline-block;margin-top:5px">
					<font color='blue'><B>您的用户名必须是唯一的</B></font>
                </span>
			</div>
			</div>
			<div class="row">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label" style="display:inline-block;margin-top:5px">用户密码</label>
				<div class="col-sm-10" style="width:500px;margin-bottom:10px">
					<input type="text" class="form-control" id="firstname1"
					 name="password"  value="<s:property value="password" />">
				</div>
			</div>
			</div>
			<div class="row">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label" style="display:inline-block;margin-top:5px">用户描述</label>
				<div class="col-sm-10" style="width:500px">
					<input type="text" class="form-control" id="firstname1"
					 name="userDesc"  value="<s:property value="userDesc" />">
				</div>
			</div>
			</div>
			 <hr>
			<div class="col-md-12">
		        <button type="submit" class="btn btn-default">Submit</button>
		        <a href="javascript:history.go(-1);" style="color:#fff" class="btn btn-primary" role="button">返回</a>
		      </div>
		    </div>
	</s:form>
</div>

<script>
function checkUserNameAction(){  
    /*  var nameField = document.regForm.userName.value;  
     if(nameField.length==0)  
         return false;  
     var url ="check?name=" + escape(nameField).replace(//+/g,"%2B").replace(/%/g,"%25");  
     checkUserNameMsg.innerHTML = "111";  
     createXml();  
     if(xmlHttp){  
         xmlHttp.open("GET",url,true);           //注册处理事件的url  
         xmlHttp.onreadystatechange = callback;  //注册回传函数  
         xmlHttp.send(null);                     //发送请求  
     }   */
     checkUserNameMsg.innerHTML = "正在验证...";  
     var nameField = document.regForm.username.value; 
      
      if(nameField.length==0)  
    	  checkUserNameMsg.innerHTML="<font color='red'><b>用户名不能为空</b></font>";
      else{
      $.ajax({
     type: "POST",
     url: "uuser_ajax.action",
     contentType: "application/json", //å¿é¡»æ
     dataType: "text", //è¡¨ç¤ºè¿åå¼ç±»åï¼ä¸å¿é¡»
    // data: JSON.stringify("{list:"+info+"}"), 
      data: nameField, //ç¸å½äº //data: "{'str1':'foovalue', 'str2':'barvalue'}",
     success: function (jsonResult) {
      checkUserNameMsg.innerHTML = jsonResult;  
  
     },
     error:function(e) {
			alert("cucouco");
			}
 });}
   //  alert("失去焦点");
}



</script>

</body>
</html>
