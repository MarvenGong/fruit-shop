<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	  <title>订单确认</title>
	  <%@include file="/public/head.jspf" %>	
	  <% response.setHeader("cache-control", "no-store");%>
	  <link href="${shop }/css/jquery-ui.css" rel="stylesheet"/>
	  <style type="text/css">
	  .error{color:red}
	  </style>
  </head>
  <body>
<%--   	<c:if test="${empty sessionScope.sorder}">
  			<!-- 如果购物车为空则跳转到首页 -->
  			<c:redirect url="/index.jsp" />
  	</c:if> --%>
  	 <div class="wrapper">
       <!-- 头部开始 -->
		<jsp:include page="/public/head.jsp" />
        <!-- 头部结束 -->
        <div class="section_container">
            <!-- 购物车 -->
            <ul class="breadcrumb">
                <li>
                    <a href="#">加入购物车</a>
                </li>
                <li class="active">
                    <a href="#">确认订单信息</a>
                </li>
                <li >
                    <a href="#">完成订单</a>
                </li>
            </ul>
            <!-- 确认订单信息 -->
            <div class="check-stup">
            	<!-- 商品确认 -->
                <div class="pro-check check ">
                    <h1>确认订单信息</h1>
	                <table class="data-table cart-table" cellpadding="0" cellspacing="0">
						<tr>
							<th class="align_center" width="10%">商品编号</th>
							<th class="align_left" width="35%" colspan="2">商品名称</th>
							<th class="align_center" width="10%">销售价格</th>
							<th class="align_center" width="20%">数量</th>
							<th class="align_center" width="15%">小计</th>
						</tr>
						<c:forEach items="${cartList}" var="sorder">
						<tr lang="${sorder.product.id}">
							<td class="align_center"><a href="#" class="edit">${sorder.product.id}</a>
							</td>
							<td width="80px"><img src="${shop}/images/${sorder.product.pic}" width="80"
								height="80" />
							</td>
							<td class="align_left"><a class="pr_name" href="${shop}/product_queryByid?id=${sorder.product.id}">${sorder.name}</a>
							</td>
							<td class="align_center vline">￥ ${sorder.price}</td>
							<td class="align_center vline">
								${sorder.number}	
							</td>
							<td class="align_center vline">￥${sorder.price*sorder.number}</td>
						</tr>
						</c:forEach>
					</table>
					
                    <div class="sum"> 
                        <div class="fr"><span>总计：</span><b>￥${totalPrice}</b></div>
                    </div>
                   
                </div>
                <!-- 订购人确认 -->
                <form action="forder_save.action" id="form-order-confirm" method="post">
                	<input type="hidden" name="price" value="${totalPrice}"/>
                	<input type="hidden" name="user" value="${sessionScope.userInfo.name}"/>
	                <div class="person-check check">
	                    <h1>订购人信息</h1>
	                    <div class="person-checkinner">
	                        <div>
	                        	<label>配送姓名:</label>
	                        	<input value="龚明华" type="text" name="name" />
	                        </div>
	                        <div>
	                        	<label>联系方式:</label>
	                        	<input value="15696544221" type="text" name="phone" />
	                        </div>
	                        <div>
	                        	<label>区域邮编:</label>
	                        	<input value="400251" type="text" name="post" />
	                        </div>
	                        <div>
	                        	<label>配送地址:</label>
	                        	<input value="重庆市渝中区大坪街道" type="text" name="address" />
	                        </div>
	                    </div>
	                </div>
	                <!-- 卖家留言 -->
	                <div class="person-check check">
	               		<h1>卖家留言</h1>
	                	<textarea style="margin: 5px;" name="remak" cols="120" rows="2">输入留言信息</textarea>
		                <div class="submit">
		                   	<input type="submit" class="sub-logo fr" style="margin: 0px;padding: 0px; border: 0px;" value="确认无误,购买" />
		                </div>
	                </div>
                </form>
           </div>
       </div>
       <!-- 确认订单信息结束 -->
       </div>
       <script type="text/javascript" src="${shop}/js/user/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${shop}/js/user/jquery.validate.min.js"></script> 
	<script type="text/javascript" src="${shop}/js/user/order-confirm.js"></script> 
  </body>
</html>
