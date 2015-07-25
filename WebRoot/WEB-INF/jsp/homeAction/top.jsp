<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <html>
    <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>TopMenu</title>
      <%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
      <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/top.css" />
    </head>
    <body>
      <!-- Docs master nav -->
      <header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
        <div class="container">
          <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand" id="brand">母婴</a>
          </div>
          <nav class="collapse navbar-collapse bs-navbar-collapse">
            <ul class="nav navbar-nav" id="nav">
              <li>
                <a href="#">代办事项</a>
              </li>
              <li>
                <a href="#">邮件</a>
              </li>
              <li>
                <a href="#">消息</a>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right" id="nav-right">
              <!--   <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${user.username } <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">我的消息</a></li>
                  <li><a href="#">修改资料</a></li>
                  <li><a href="${pageContext.request.contextPath}/uuser_logout.action">注销</a></li>
                </ul>
              </li>  -->
              <li><a href="">${user.username }</a></li>
              <li><a target="_parent" href="${pageContext.request.contextPath}/uuser_logout.action">退出</a></li>
              <li><a href="#">联系客服</a></li>
              <li><a href="javascript: window.parent.right.location.reload(true);">刷新</a></li>             
            </ul>
          </nav>
        </div>
        <hr>
      </header>
    </body>
  </html>