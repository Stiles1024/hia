<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>产品分类列表</title>
		<%@  include file="/WEB-INF/jsp/public/commons.jspf"%>
		
	</head>
	<body>
	 <h2>产品展示</h2>
 <hr>
 
 
 <div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-10 column">
                    <div class="row clearfix">
                        <div class="col-md-4 column">
                            <div class="carousel slide" id="carousel-952220">
                                <ol class="carousel-indicators">
                                	<s:iterator value="imgList" var="l1" status="sta">
                                		<s:if test="#sta.index == 0">
                                		<li class="active" data-slide-to="0" data-target="#carousel-952220">
                                    	</li>
                                    	</s:if>
                                    	<s:else>
                                    	<li data-slide-to="<s:property value="#sta.index" />" data-target="#carousel-952220">
                                    	</li>
                                    	</s:else>
                                	</s:iterator>
                                    <%--<li class="active" data-slide-to="0" data-target="#carousel-952220">
                                    </li>
                                    <li data-slide-to="1" data-target="#carousel-952220">
                                    </li>
                                    <li data-slide-to="2" data-target="#carousel-952220">
                                    </li>
                                    <li data-slide-to="3" data-target="#carousel-952220">
                                    </li>
                                    
                                --%></ol>
                                <div class="carousel-inner">
                                <s:iterator value="imgList" var="l1" status="sta">
                                	<s:if test="#sta.index == 0">
                                		<div class="item active">
                                		<img style="margin:0 auto" alt="" src="/muyin/goodsimgbig/<s:property value="#l1.value" />" />
                                		</div>
                                	</s:if>
                                	<s:else>
                                		<div class="item">
                                		<img style="margin:0 auto" alt="" src="/muyin/goodsimgbig/<s:property value="#l1.value" />" />
                                		</div>
                                	</s:else>
                                </s:iterator>
                                   
                                    
                                </div> <a class="left carousel-control" href="#carousel-952220" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-952220" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                            </div>
                        </div>
                        <div class="col-md-8 column">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <h4>产品名:${goodsName }</h4>
                                        </div>
                                    </div>
                                    <div class="row clearfix">
                                        <div class="col-md-6 column">
                                            品牌:${TGBrand.brandName }
                                        </div>
                                        <div class="col-md-6 column">
                                            适龄:10岁
                                        </div>
                                    </div>
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            简单描述：${goodsBrief }
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-2 column">
                    <h3>9.4</h3>
                    <h5>综合评分(999人)</h5>
                </div>
            </div>
        </div>
        <div class="col-md-12 column">
        	<hr>
        	<h3>详细描述</h3>
        	${goodsDesc }
        </div>
    </div>
</div>
 


 <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

	</body>
</html>