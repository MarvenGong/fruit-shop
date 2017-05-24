<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>销售情况</title>
	<%@include file="/public/head.jspf"%>
	<script type="text/javascript">
		$(function(){
		    //更改数量
			$(".text").change(function(){
			 var number = this.value;
			 if(parseInt(number)==number && !isNaN(number) && number>0){
			   var productid = $(this).parents("tr:first").attr("title");
			   $.post('sorder_updatesorder.action',{id:productid,number:number},function(total){
						$("#total").html(total);
			   },"text");
			   var price = $(this).parent().prev().html()*number;
			   $(this).parent().next().html(price.toFixed(2));
			  }else{
			  	this.value = $(this).arrt("title");
			  }
			});
		   //删除
		   $(".remove").click(function(){
		   		 var tr = $(this).parents("tr:first");
		   		 var productid = tr.attr("title");
		   		 $.post('sorder_removeSorder.action',{id:productid},function(price){
		   		 	console.log($(this).parents("tr:first"));
		   		 	tr.html("");
		   		 	$("#total").html(price);
		   		 },"text");
		   		console.log("aa");
		   });
		   
		
		});
	</script>
<body>
	<div class="wrapper">
		<!-- 头部开始 -->
		<jsp:include page="/public/head.jsp" />
		<!-- 头部结束 -->
		<div class="section_container">
		
			<!-- 购物车 -->
			<div id="shopping_cart">
				<div class="message success">销售情况</div>
					<table>
						<tr>
							<td>销售类型</td>
							<td>销售数量</td>
						</tr>
						<tr>
							<td>芒果</td>
							<td>2</td>
						</tr>
						<tr>
							<td>百香果</td>
							<td>2</td>
						</tr>
						<tr>
							<td>库尔勒香梨</td>
							<td>30</td>
						</tr>
						<tr>
							<td>西瓜</td>
							<td>5</td>
						</tr>	
					</table>
				</div>
				<!-- 结算 -->
				</div>
			<!-- 导航栏结束 -->
			<!-- 尾部引入 -->
			<jsp:include page="/public/tail.jsp"/>
	</div>
</body>
</html>
