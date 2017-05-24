<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>测试页面</title>
	<%@ include  file="/public/head.jspf" %>
	<style type="text/css">
		*{margin:0;padding: 0}
		#menu{
			width:200px;
			
		}
		#menu ul{
			list-style: none;
		}
		#menu li{
			border-bottom:1px solid #fff;
		}
		#menu ul li a{
			display: block;
			padding:5px;
			background:#008792;
			text-decoration: none;
		}
		#menu ul li a:hover{
			background:#00a6ac;
		}
		
	</style>
  </head>
  
  <body>
    <a href="${shop}/send_main_admin.action">后台管理</a>
    <hr />
    <br>
    <a href="${shop}/send_category_save.action">save页面</a>
    <hr />
    <br>
    <a href="${shop}/send_category_update.action">update页面</a>
 	<div id="menu">
 		<ul>
 			<li><a href="#">类别管理</a></li>
 			<li><a href="#">商品管理</a></li>
 		</ul>
 	</div>
 	
 	
 	<c:forEach items="${requestScope.productinfo}" var="product">
 		<h3>${product.name}</h3>
 	</c:forEach>
 
  </body>
</html>
