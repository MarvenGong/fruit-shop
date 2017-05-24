<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>小然水果商城</title>
	<%@ include file="/public/head.jspf" %>
	<link href="bootstrap-3.3.5-dist//css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="bootstrap-3.3.5-dist/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.5-dist/js/bootstrap.js"></script>
</head>

<body>
	<div class="wrapper">
		<!-- 头部开始 -->
		<jsp:include page="/public/head.jsp" />
        <!-- 头部结束 -->

        
            <!-- 右侧焦点图区域 -->
            <div id="main_content ">
                <!--  <div > <img src="images/lm_banner_1.jpg" /> </div> -->
                <div id="myCarousel" class="carousel slide">
				    <!-- 轮播（Carousel）指标 -->
				    <ol class="carousel-indicators">
				        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				        <li data-target="#myCarousel" data-slide-to="1"></li>
				        <li data-target="#myCarousel" data-slide-to="2"></li>
				    </ol>   
				    <!-- 轮播（Carousel）项目 -->
				    <div class="carousel-inner">
				        <div class="item active">
				            <img src="images/banner/lm.jpg" alt="First slide">
				        </div>
				        <div class="item">
				            <img src="images/banner/qyg.jpg" alt="Second slide">
				        </div>
				        <div class="item">
				            <img src="images/banner/ll.jpg" alt="Third slide">
				        </div>
				    </div>
				    <!-- 轮播（Carousel）导航 -->
				    <a class="carousel-control left" href="#myCarousel" 
				        data-slide="prev">&lsaquo;
				    </a>
				    <a class="carousel-control right" href="#myCarousel" 
				        data-slide="next">&rsaquo;
				    </a>
				</div>
            </div>
            
 
			<c:forEach items="${applicationScope.proList}" var="list">
            <!-- 产品列表 -->
            <div class="products_list products_slider clear">
                <h2 class="sub_title" >${list[0].cid.type}</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                	<c:forEach items="${list}" var="product">
                    <li> 
                    <a  href="${shop}/product_queryByid?id=${product.id}" class="product_image"><img src="images/${product.pic}" /></a>
                        <div class="product_info">
                            <h3><a href="#">${product.name}</a></h3>
                            <small>${product.remark}</small> 
                         </div>
                        <div class="price_info"> 
      		                   <a href="sorder_addsorder?product.id=${product.id}"><button><span><img src="images/cart.png"></img></span></button></a>
                           <button class="price_add" title="" type="button"><span class="pr_price">${product.price}</span></button>
                        </div>
                    </li>
                    </c:forEach>
                 </ul>
            </div>
           </c:forEach>
        <!--产品列表结束  --> 
        <!-- 导航栏结束 -->
        <!-- 尾部导入 -->
        <jsp:include page="/public/tail.jsp"></jsp:include>
     </div>
</body>

</html>
