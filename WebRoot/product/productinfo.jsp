<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<title>${product.name}</title>
	<link rel="stylesheet" href="${shop}/css/detail.css" />
</head>
<body>
    <div class="wrapper">
        <!-- 头部开始 -->
        <jsp:include page="/public/head.jsp"></jsp:include>
        <!-- 头部结束 -->
        <!--导航栏结束-->
        <div class="section_container">
            <!-- 面包屑 -->
            <ul class="breadcrumb">
                <li>
                    <a href="#">首页</a>
                </li>
                <li class="active">
                    <a href="#">${product.name}</a>
                </li>
            </ul>
            <!-- 产品列表 -->
            <div class="products_list products_slider clear">
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                  <c:choose>
					<c:when test="${empty requestScope.productinfo}">
						抱歉未找到想要的商品
					</c:when>
					<c:otherwise>
	                   <c:forEach items="${requestScope.productinfo}" var="product">
	                  	<li>
	                        <a  href="${shop}/product_queryByid?id=${product.id}" class="product_image">
	                            <img src="${shop}/images/${product.pic}" />
	                        </a>
	                        <div class="product_info">
	                            <h3>
	                                <a href="#">${product.name}</a>
	                            </h3>
	                            <small>${product.remark}</small>
	                        </div>
	                        <div class="price_info">
	                        <a href="sorder_addsorder?product.id=${product.id}">
	                        	<button>
	                        	  <span class="pr_add">添加购物车</span>
	                      	    </button>
	                        </a>
	                        <button class="price_add" title="" type="button">
	                            <span class="pr_price">${product.price}</span>
	                        </button>
	                        </div>
	                    </li>
	                  </c:forEach>
                 </c:otherwise>
			</c:choose>
                   
                </ul>
            </div>
            <!--产品列表结束  -->
            <!-- 导航栏结束 -->
     		<!-- 引入尾部 -->
     		<jsp:include page="/public/tail.jsp"></jsp:include>
          </div>
        </div>
	</body>
</html>
