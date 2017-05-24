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
                <li>
                    <a href="#">热卖</a>
                </li>
                <li class="active">
                    <a href="#">${product.name}</a>
                </li>
            </ul>
            <!-- 产品详情 -->
            <div id="product_detail">
                <!--详情左侧-->
                <div class="product_leftcol fl">
                    <div id="jingdong">
                        <div class="datu">
                            <img src="${shop}/images/${product.pic}" />
                            <div id="fangdajing"></div>
                        </div>
                        <div class="xiaotu">
                            <div class="leftbut"></div>
                            <div class="tu">
                                <ul>
                                    <li>
                                        <img src="${shop}/images/${product.pic}" />
                                    </li>
                                    <li>
                                        <img src="${shop}/images/${product.pic}" />
                                    </li>
                                    
                                </ul>
                            </div>
                            <div class="rightbut"></div>
                        </div>
                    </div>
                </div>
                <!--详情左侧结束-->
                <!--详情右侧-->
                <div class="product_rightcol fr">
                    <div id="name">
                        <h1>${product.name}</h1> <strong>${product.xremark}</strong>
                    </div>
                    <ul id="summary">
                        <li id="summary-market">
                            <div class="dt">参&nbsp;考&nbsp;价：</div>
                            <div class="dd"> <del id="page_maprice">￥${product.price+10}</del>
                            </div>
                        </li>
                        <li id="summary-price">
                            <div class="dt">折&nbsp;后&nbsp;价：</div>
                            <div class="dd"> <strong class="p-price" id="jd-price">￥${product.price}</strong>
                            </div>
                        </li>
                    </ul>
                    <ul id="choose" >
                        <li id="choose-amount">
                            <div class="dt">购买数量：</div>
                            <div class="dd">
								 <input value="1" size="2" >
                            </div>
                        </li>
                    </ul>
                    <div class="add_to_buttons">
                        	<a href="${shop}/sorder_addsorder?product.id=${product.id}" ><button class="add_cart">加入购物车</button></a>
                    </div>
                </div>
                <!--详情右侧结束--> </div>
            <!--产品详情结束-->
           
            <!--产品列表结束  -->
            <!-- 导航栏结束 -->
     		<!-- 引入尾部 -->
     		<jsp:include page="/public/tail.jsp"></jsp:include>
          </div>
        </div>
	</body>
</html>
