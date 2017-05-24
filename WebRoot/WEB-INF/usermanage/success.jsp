<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>成功</title>
 	 <meta charset="UTF-8">
  </head>
  <body>
       <h2>支付成功。 </h2>
  </body>
</html>
