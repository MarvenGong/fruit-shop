<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>404</title>
    <%@ include file="/public/head.jspf" %>
	<meta name="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv=refresh content=5;url=http://localhost:8080/shop />
	<style type="text/css">
		.m404 {margin:100px auto; vertical-align:middle; text-align:center}
	</style>
  </head>
  
  <body>
  	<jsp:include page="/public/head.jsp"></jsp:include>
  		<div class="m404"><a href="<%=basePath%>/index.jsp"><img src="images/404.png" width="409" height="177" alt="“真的很抱歉，我们搞丢了页面……”要不去网站首页看看？" border="0"></a></div>
  	<jsp:include page="/public/tail.jsp"></jsp:include>
  </body>
</html>
