<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>success</title>
 	 <meta charset="UTF-8">
  </head>
  <body>
       <h2>操作成功。  </h2>
  </body>
</html>
