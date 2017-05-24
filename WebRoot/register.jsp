<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>注册</title>
    <%@ include file="/public/head.jspf" %>
    <!-- <link href="css/normalize.css" rel="stylesheet"/> -->
	<link href="css/jquery-ui.css" rel="stylesheet"/>
	<style type="text/css">
	.reg{
		width:890px;
		margin: 0 auto;
	}
	#progressbar {
		margin-bottom: 30px;
		overflow: hidden;
		counter-reset: step;
}
	#progressbar li{
		list-style: none;
		text-transform: uppercase;
		font-size: 14px;
		color:#999;
		width: 33.33%;
		float: left;
		position: relative;
	}
	#progressbar .active{
       color: #3e3e3e;
  	  border-bottom: 2px solid #ff4700;
	}
	#msform fieldset{
		border: 0 none;
		width:500px;
		margin: 0 auto;
		
	}
	#msform input{
	padding: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
	margin-bottom: 10px;
	width: 60%;
	box-sizing: border-box;
	font-family: montserrat;
	color: #2C3E50;
	font-size: 13px;
	}
	
	form label{
			color: red;
			padding-left: 20px;
			background-repeat: no-repeat;
		}
	
	
	#msform #phone{
		width: 70%;
	}
	#msform #code{
		width: 30%;
	}

	#msform .action-button {
	width: 100px;
	background: #27AE60;
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 5px;
}
	#msform #fie-2{
		display: none;
	}
	#msform #fie-3{
		display: none;
	}
	</style>
  </head>
  <body>
    <div class="wrapper">
     <!-- 引入头部文件 -->
     <jsp:include page="/public/head.jsp"></jsp:include>
     <div class="reg">
       <form id="msform" action="http://www.baidu.com" method="post">
       <ul id="progressbar">
		<li class="active">第一步:用户信息</li>
		<li>第三步：注册成功</li>
	</ul>
	   <fieldset id="fie-1">
			<p>用户名:</p><input type="text" name="login" placeholder="user name" /> 
		
			<p>昵称:</p><input type="text" name="name" placeholder="user name" /> 
		
			<p>密码:</p><input type="password" name="pwd" id="pwd" placeholder="Password" /> 
			
			<p>再次输入密码:</p><input type="password" name="cpwd" placeholder="Confirm Password" />
		
			<p>邮箱:</p><input type="email" name="email" placeholder="Email" />
			
			<input type="submit" name="next" class="next action-button" id="next-2" value="注册" />
	   </fieldset>
	   <fieldset id="fie-2">
		<input type="text" name="phone" placeholder="手机" />
		<input type="button" name="previous" class="previous action-button" value="Previous" />
		<input type="button" name="next" class="next action-button" onclick="window.location.href='success.jsp'" value="注册" />
	   </fieldset>
	   </form>
	</div>
	<script type="text/javascript" src="js/user/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/user/jquery.validate.min.js"></script> 
	<script type="text/javascript" src="js/user/reg.js"></script> 
     <!-- 引入尾部文件 -->
     <jsp:include page="/public/tail.jsp"></jsp:include>
     </div>
  </body>
</html>
