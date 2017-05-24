<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    <title>个人信息</title>
    <%@include file="/public/head.jspf"%>
    <style type="text/css">
    	.user{}
    
    </style>
  </head>
  <body>
  <div class="wrapper">
  <!-- 头部导航信息  start -->
  <jsp:include page="/public/head.jsp"></jsp:include>
  <!-- 头部导航信息 end -->
  <div class="main">
  	<div class="user">
  	
  	
  	</div>
  	<div class="order">
  	
  	</div>
  </div>
  <!-- 尾部信息 start -->
  <jsp:include page="/public/tail.jsp"></jsp:include>
  <!-- 尾部信息 end -->
  </div>
  </body>
</html>
