<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE>
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
    <link href="${shop}/css/login.css" rel="stylesheet" type="text/css" />
<script src="${shop}//js/user/login.js" type="text/javascript"></script>
</head>
<body>
<div class="main-login">
	<h2 class="login-logo">
		后台管理系统
	</h2>
	<div class="login-content">	
    <form action="" method="post" id="login-form" name="login-form">
    <div class="login-info">
	<span class="user">&nbsp;</span>
	<input name="username" id="username" type="text" onblur="checkUsername()" value="" class="login-input"/>
	</div>
    <div class="login-info">
	<span class="pwd">&nbsp;</span>
	<input name="password" id="password" type="password" onblur="checkPassword()" value="" class="login-input"/>
	</div>
    <div class="login-oper">
	<input name="" type="checkbox" value="" checked="checked" />记住密码
	</div>
    <div class="login-oper">
	<input name="" type="submit" value="登 录" class="login-btn"/>
	<input name="" type="submit" value="重 置" class="login-reset"/>
	</div>
    </form>
    </div>
</div>   
</body>

</html>
    
