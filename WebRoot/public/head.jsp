<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="shop"></c:set>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="header">
	<div class="header_container">
		<!--头部开始-->
		<div class="top_bar clear">
			<!--头部小导航-->
			<div class="welcom fl">欢迎光临小然水果商城!</div>
			<ul class="top_links fr">
				<li class="highlight"><a href="index.jsp">首页</a></li>
				<li><a href="#">我的账户</a></li>
				<li><a href="/shop/sorder_list.action">购物车</a></li>
				<c:choose>
					<c:when test="${empty sessionScope.userInfo}">
						<li><a href="register.jsp">注册</a></li>
						<li><a href="ulogin.jsp">登录</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="user/orderInfo.jsp">${userInfo.name}</a></li>
						<li><a href="user_logout">退出</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${userInfo.name eq 'saler'}"> 
						<li><a href="send_main_admin">商品管理</a></li>
						<li><a href="sales.jsp">销售情况</a></li>
					 </c:when> 
				</c:choose>
				<c:choose>
					<c:when test="${userInfo.name eq 'admin'}"> 
					    <li><a href="send_admin_admin">后台管理</a></li>
						<li><a href="sales.jsp">销售情况</a></li>
					 </c:when> 
				</c:choose>
				
			</ul>
			<!--头部小导航结束-->
			<!-- logo -->
			<h1 class="logo clear fl">
				<a href="index.jsp"><img src="${shop}/images/logo.png" /></a>
			</h1>
			<!-- 购物车 -->
			<div class="minicart">
				<a class="minicart_link" href="/shop/sorder_list.action"> <span class="item">
						<b class="js-header-cart-number"></b> 件/
				</span> <span class="price"> <b class="js-header-cart-price"></b>
				</span>
				</a>
			</div>
			<!-- 购物车结束 -->
			<!-- 搜索框 -->
			<div class="header_search">
				<div class="form-search ">
					<form action="search" method="get">
					<input value="请输入商品名称" name="q" class="input-text" type="text" />
					<button type="submit" title="Search"></button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 导航栏 -->
<div class="navigation_container" style="width:100%;">
	<!---->
	<div class="nav">
		<ul class="primary_nav" style="padding-left:180px; ">
			<li class="active highlight"><a href="#">应季水果</a> <!--二级菜单-->
				<ul class="sub_menu">
					<li><a href="#">百香果</a>
						<ul>
							<li><a href="#">菠萝</a></li>
							<li><a href="#">草莓 </a></li>
							<li><a href="#">橙·柚·柑</a></li>
							<li><a href="#">瓜类</a></li>
							<li><a href="#">龙眼</a></li>
							<li><a href="#">芒果</a></li>
							<li><a href="#">鲜枣</a></li>
							<li><a href="#">椰子</a></li>
							<li><a href="#">柠檬</a></li>
							<li><a href="#">其他</a></li>
						</ul></li>

				</ul></li>
			<!--二级菜单结束-->

			<li><a href="#">进口水果</a> <!--二级菜单-->
				<ul class="sub_menu">
					<li><a href="#">蛇皮果</a>
						<ul>
							<li><a href="#">凤梨</a></li>
							<li><a href="#">蓝莓</a></li>
							<li><a href="#">奇异果</a></li>
							<li><a href="#">山竹</a></li>
							<li><a href="#">榴莲</a></li>
						</ul>
					</li>
				</ul> <!--二级菜单结束--></li>
<!--			<li><a href="#">儿童</a></li>
			<li><a href="#">时尚</a></li> -->
			<li><a href="#">越来越美 </a>
				<ul class="sub_menu">
					<li><a href="#">速冻水果 </a>
						<ul>
							<li><a href="#">水果色拉</a></li>
							<li><a href="#">VC乐园</a></li>
							<li><a href="#">花青素 </a></li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
<!-- 导航 栏结束 -->
<script>
	$.ajax({
		url:"/shop/sorder_ajaxList",
		data:{},
		dataType:"json",
		type:"get",
		success:function(res){
			console.log(res);
			$(".js-header-cart-number").text(res.cartLength);
			$(".js-header-cart-price").text("￥"+res.totalPrice);
		}
	})
</script>