<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>用户信息</title>
   	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
<script type="text/javascript">

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
            checkUserNameMsg.innerHTML = "正在验证";  
            var nameField = document.regForm.username.value; 
             
             if(nameField.length==0)  
                return false;  
             $.ajax({
            type: "POST",
            url: "sysuser_ajax.action",
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
        });
          //  alert("失去焦点");
}

	
	</script>	

<!-- 标题显示 -->
<caption><h2 class="text-success">用户信息</h2></caption>

<!--显示表单内容-->


    <s:form action="sysuser_%{userId == null ? 'add' : 'edit'}" name="regForm">
    	<s:hidden name="userId"></s:hidden>
        
      
        
        <!-- 表单内容显示 -->
       
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td>登录名</td>
                        <td><s:textfield name="username"   onblur="checkUserNameAction()"  cssClass="InputStyle"/> *
								 <span id="checkUserNameMsg">
											<font color='blue'><B>您的用户名必须是唯一的</B></font>
                   				</span>
						</td>
                    </tr>
                    <tr><td>密码</td>
                        <td><s:textfield name="password"  value="" cssClass="InputStyle"/></td>
                    </tr>
					<tr><td>联系电话</td>
                        <td><s:textfield name="phonenum" cssClass="InputStyle"/></td>
                    </tr>
                    <tr><td>E-mail</td>
                        <td><s:textfield name="email" cssClass="InputStyle"/></td>
                    </tr>
                    <tr><td>备注</td>
                        <td><s:textarea name="userDesc" cssClass="TextareaStyle"></s:textarea></td>
                    </tr>
                </table>
            </div>
       
        
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位设置 </div> 
        </div>
        
        <!-- 表单内容显示 -->

            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
						<td width="100">岗位</td>
                        <td>
                        	<s:select name="roleIds" cssClass="SelectStyle"
                        		multiple="true" size="10" 
                        		list="#roleList" listKey="roleId" listValue="name"
                        	/>
							按住Ctrl键可以多选或取消选择
                        </td>
                    </tr>
                </table>
            </div>
	
		
        <!-- 表单操作 -->
         <hr>
        <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">添加</button>
					<a class="btn btn-default" href="javascript:history.go(-1);" role="button">取消</a>
				</div>
			</div>
    </s:form>


<div class="Description">
	说明：<br />
	1，用户的登录名要唯一，在填写时要同时检测是否可用。<br />
	2，新建用户后，密码被初始化为"1234"。<br />
	3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br />
	4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
	5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
	6，修改用户信息时，登录名不可修改。
</div>

</body>
</html>
