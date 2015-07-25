<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>事件设置</title>
   <%@  include file="/WEB-INF/jsp/public/commons.jspf"  %>
   
   
      <!-- 样式文件 -->
<link rel="stylesheet" href="./umeditor/themes/default/css/umeditor.css">
<!-- 引用jquery -->
<script src="./umeditor/third-party/jquery.min.js"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="./umeditor/umeditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="./umeditor/umeditor.js"></script>
<!-- 语言包文件 -->
<script type="text/javascript" src="./umeditor/lang/zh-cn/zh-cn.js"></script>


<!-- 实例化编辑器代码 -->
<script type="text/javascript">
    $(function(){
        window.um = UM.getEditor('container', {
            /* 传入配置参数,可配参数列表看umeditor.config.js */
            toolbar: ['source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsizelink unlink | emotion image video  | map| horizontal print preview fullscreen']
        });
        //um.setContent('${context}');
    });
</script>
   
</head>
<body>
<s:if test='%{eventId==null}'>
<h2>增加事件</h2>
</s:if>
<s:else>
<h2>事件修改</h2>
</s:else>
<hr>
<s:form action="uevent_%{eventId==null ? 'add'  : 'edit' }">
    <s:hidden name="eventId" value="%{eventId}"></s:hidden>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">事件内容</label>
      <div class="col-sm-10">
         <script id="container" name="context" value= "%{context}" type="text/plain" style="width:600px;height:200px;">
			<s:if test='%{eventId!=null}'>
				${context}
			</s:if>
		</script>
      </div>
   </div>
   <div class="row"> 
   	<hr>
   </div>
   <div class="row">
			<hr>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">添加</button>
					<a class="btn btn-default" href="javascript:history.go(-1);" role="button">返回</a>
				</div>
			</div>
	</div>
</s:form>
   


</body>
</html>
