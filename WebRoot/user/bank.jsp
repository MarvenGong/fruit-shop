<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付银行页面</title>
	<%@ include file="/public/head.jspf" %>    
  </head>
  <body>
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
                <li >
                    <a href="#">确认订单信息</a>
                </li>
                <li class="active">
                    <a href="#">完成订单</a>
                </li>
            </ul>
            <!-- 确认订单信息 -->
            <div class="pay-step">
                <!-- 订购人确认 -->
                <div class="person-check check">
                    <h1>您的订单已经生成</h1>
                    <div class="person-checkinner">
                        <div><span>订单号</span>：<span>${forder.id}</span></div>
                        <div><span>收货人</span>：<span>${forder.name}</span></div>
                        <div><span>送货地址</span>：<span>${forder.address}</span></div>
                        <div><span>邮政编码</span>：<span>${forder.post}</span></div>
                        <div><span>支付金额</span>：<span>${forder.price}</span></div>
                    </div>
                </div>
                <div class="pay">
                    <div class="pay-inner">
                        <div class="fl">支付方式:</div>
                        <div class="fl yibao-logo">
                             <a href=""><img src="${shop}/images/yibao.jpg" width="110" height="35" alt="" /></a>
                        </div>
                        <div class="fr blue aa">世界一流的电子支付应用和服务提供商
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="red"href="">如何使用?</a>
                        </div>

                    </div>
                </div>
                <div class="select-bank">
                	 <form action="${shop}/send_usermanage_success.action" method="post">
                    <h1>请选择支付银行</h1>
                    <!--  {fn:indexOf(name,'.'))}  {fn:substring(zip, 6, -1)} -->
                    <div>
                        <ul>
                           <c:forEach items="${applicationScope.bankImage}" var="name">
	                            <li>
	                                <input type="radio" name="pd_FrpId" value="${fn:substring(name,0,fn:indexOf(name,'.'))}" />&nbsp;
	                                <img src="${shop}/images/bank/${name}" />
	                            </li>
                           </c:forEach>
                        </ul>
                    </div>
                    <div class="clear"></div>
                    <div class="reminder"><span>请确保您的银行卡已开通网银支付功能，否则没有办法完成支付&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <a href="">如何开通?</a></div>
                    <div class="pay-submit">
                    	<div class="pay-inner">
                    		<input type="button" style="width: 80px; height: 40px;" onclick="alert('支付成功');" value="确认支付" />
                    	</div>
            		</div>	
                    </form>
                </div>
            </div>
       </div>  
       <!-- 尾部引入 -->   
		<jsp:include page="/public/tail.jsp"></jsp:include>
    </div>
    
  </body>
</html>
