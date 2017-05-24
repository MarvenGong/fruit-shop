<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML ">
<html>
<head>
	<title>登录</title>
	<meta charset="utf-8">
	<%@include file="/public/head.jspf"%>
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
	</style>
<body>
	<div class="wrapper">
		<!-- 头部开始 -->
		<jsp:include page="/public/head.jsp" />
		<!-- 头部结束 -->
		<div class="section_container">
			<!-- 购物车 -->
			<div id="dd" class="action_buttonbar" style="text-align:center;">
				<form method="post" action="${shop}/user_login.action">
					<div>
						<label for="login">账号:&nbsp;</label> 
						<input type="text" name="login" />
					</div>
					<div>
						<label for="pass">密码:&nbsp</label> 
						<input type="password" name="pwd" />
					</div>
					<div>
						${requestScope.error}  
					</div>
					<div>
						<input type="submit" value="登陆" style="width:60px;height:30px" />
						<input type="button" value="注册" onclick="window.open('${shop}/index.jsp','_self')" style="width:60px;height:30px" />
					</div>
			   </form>
			   <div style="clear:both"></div>
			</div>
		</div>
		<!-- 尾部引入 -->
		<jsp:include page="/public/tail.jsp" />
	</div>
</body>
</html>
