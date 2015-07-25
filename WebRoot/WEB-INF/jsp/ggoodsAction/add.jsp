<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>分类设置</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
		<!-- 样式文件 -->
		<link rel="stylesheet" href="./umeditor/themes/default/css/umeditor.css">
		<!-- 引用jquery -->
		<script src="./umeditor/third-party/jquery.min.js"></script>
		<!-- 配置文件 -->
		<script type="text/javascript" src="./umeditor/umeditor.config.js"></script>
		<!-- 编辑器源码文件 -->
		<script type="text/javascript" src="./umeditor/umeditor.js"></script>
		<script type="text/javascript" charset="utf-8" src="./umeditor/umeditor.min.js"></script>
		<!-- 语言包文件 -->
		<script type="text/javascript" src="./umeditor/lang/zh-cn/zh-cn.js"></script>
		<!-- 实例化编辑器代码 -->
		<script type="text/javascript">
		$(function(){
		window.um = UM.getEditor('container', {
		/* 传入配置参数,可配参数列表看umeditor.config.js */
		toolbar: ['source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsizelink unlink | emotion image video  | map| horizontal print preview fullscreen']
		});
		um.setContent('${goodsDesc}');
		});
		</script>
		
	</head>
	<body>
		<h2>添加商品</h2>
		<hr>
		<div class="container-fluid">
			<s:form action="ggoods_%{goodsId==null ? 'add'  : 'edit' }" method="post" enctype="multipart/form-data">
			<s:hidden name="goodsId" value="%{goodsId}"></s:hidden>
			<s:hidden name="cateId" value="%{cateId}"></s:hidden>
			<div class="row">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">添加图片</label>
				<div class="col-sm-10">
					<s:file name="loadFile" label="商品图片"/>
				</div>
			</div>
			</div>
			<div class="row">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">商品名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="firstname"
					 name="goodsName"  value="<s:property value="goodsName" />">
				</div>
			</div>
			</div>
			<div class="row">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">简单描述</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="firstname"
					placeholder="请输入简单描述" name="goodsBrief"  value="<s:property value="goodsBrief" />">
				</div>
			</div>
			</div>
			<div class="row">
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">货号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastname"
					placeholder="请输入货号" name="goodsSn"  value="<s:property value="goodsSn" />">
				</div>
			</div>
			</div>
			<div class="row">
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">关键字</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastname"
					placeholder="请输入关键字" name="keyword"  value="<s:property value="keyword" />">
				</div>
			</div>
			</div>
			<div class="row">
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">参考价格</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastname"
					placeholder="请输入参考价格" name="price"  value="<s:property value="price" />">
				</div>
			</div>
			</div>
			<div class="row">
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">是否新品</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastname"
					placeholder="请输入true/false" name="isNew"  value="<s:property value="isNew" />">
				</div>
			</div>
			</div>
			<!-- 显示扩展分类 -->
			
			<s:iterator value="gattrList" var="l1" status="sta">
			<div class="row">
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label"><s:property value="#l1.attrName" /></label>
				<div class="col-sm-10">
					<select class="form-control input-sm" name="goodsattrList[<s:property value="#sta.index" />].TGAttrRange.catRangeId">
						<s:iterator value="gattrrangeList[#sta.index]" var="l2">
						<s:iterator id="l3">
						<option  <s:if test="%{#l3.catRangeId==goodsattrList[#sta.index].TGAttrRange.catRangeId}">selected</s:if> value="<s:property value="#l2.catRangeId" />" />
							<s:property value="#l2.value" />
							
							 <%--<s:iterator value="goodsattrList" var="l6">
							 	<s:property value="s#l6.TGAttrRange.catRangeId"/> =
							 </s:iterator>
							--%>
							<%--<s:property value="goodsattrList[#sta.index].TGAttrRange.catRangeId" />--%>
						</option>
						</s:iterator>
						</s:iterator>
					</select>
				</div>
			</div>
			</div>
			
			</s:iterator>
			<div class="row">
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">品牌</label>
				<div class="col-sm-10">
					<select class="form-control input-sm" name="brandId">
						<s:iterator value="brandList" var="l1">
						<option value="<s:property value="brandId" />"/>
							<s:property value="#l1.brandName" />
						</option>
						</s:iterator>
					</select>
				</div>
			</div>
			</div>
			<div class="row">
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">详细描述</label>
				<div class="col-sm-10">
					<script id="container" name="goodsDesc"  value="%{goodsDesc}" type="text/plain" style="width:600px;height:200px;"></script>
				</div>
			</div>
			</div>
			<div class="row">
			<hr>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">添加</button>
					<a class="btn btn-default" href="javascript:history.go(-1);" role="button">取消</a>
				</div>
			</div>
			</div>
			
			</s:form>
		</div>
		
		
	</body>
</html>