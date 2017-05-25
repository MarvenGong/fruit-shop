<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>购物车</title>
	<%@include file="/public/head.jspf"%>
	<style type="text/css">
	.align_center em{
	display: block;height: 26px;width: 26px;float: left;color: #7A7979;
	border-right: 1px solid #dbdbdb;text-align: center;cursor: pointer;} 
	.align_center .num{display: block;float: left;text-align: center;width: 52px;
	font-style: normal;font-size: 14px;line-height: 24px;border: 0;} 
	.align_center em.add{float: right;border-right: 0;border-left: 0px solid #dbdbdb;padding-right:60px;}
	.align_center em.jian{float: left;border-right: 0;border-left: 1px solid #dbdbdb;padding-left:56px;}
	</style>
	<script type="text/javascript">
		$(function(){
			//加的效果 
			$(".add").click(function(){
				 var n=$(this).prev().val(); 
				 var num=parseInt(n)+1; 
				 if(num==0){ return;} 
				 $(this).prev().val(num); 
				 var ss=Number($("#price").val())*num;
				 $("#total").text("￥"+ss+".0");
				 var _id=$(this).attr("data-id");
				  window.location.href="/shop/sorder_setNumber?id="+_id+"&number="+num;
			});
				
			  //减的效果
		   $(".jian").click(function(){ 
			   var n=$(this).next().val(); 
			   var num=parseInt(n)-1; 
			   if(num==0){ return} 
			   $(this).next().val(num); 
			   var ss=Number($("#price").val())*num;
				 $("#total").text("￥"+ss+".0");
				 var _id=$(this).attr("data-id");
				  window.location.href="/shop/sorder_setNumber?id="+_id+"&number="+num;
			});
			  
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
		   $(".js-btn-empty-cart").click(function(){
			  if(confirm("确定要清空购物车中的宝贝吗？")){
				  window.location.href="/shop/sorder_deleteAll";
			  } 
		   });
		   
		
		});
	</script>
<body>
	<div class="wrapper">
		<!-- 头部开始 -->
		<jsp:include page="/public/head.jsp" />
		<!-- 头部结束 -->
		<div class="section_container">
		<input type="hidden" id="price" value="${sessionScope.totalPrice}">
			<!-- 购物车 -->
			<div id="shopping_cart">
				<div class="message success">我的购物车${cartList.size() }</div>
				<table class="data-table cart-table" cellpadding="0" cellspacing="0">
					<tr>
						<th class="align_center" width="10%">商品编号</th>
						<th class="align_left" width="35%" colspan="2">商品名称</th>
						<th class="align_center" width="10%">销售价格</th>
						<th class="align_center" width="20%">数量</th>
						<th class="align_center" width="15%">小计</th>
						<th class="align_center" width="10%">删除</th>
					</tr>
					
					<c:forEach items="${cartList}" var = "sorder">
					
					<tr title="${sorder.product.id}">
						<td class="align_center" ><a href="#" class="edit">${sorder.product.id}</a>
						</td>
						<td width="80px"><img src="${shop}/images/${sorder.product.pic}" width="80"
							height="80" />
						</td>
						<td class="align_left"><a class="pr_name" href="#">${sorder.name}</a>
						</td>
						<td class="align_center vline">${sorder.price}
						</td>
						<td class="align_center vline">
							<em class="jian" data-id="${sorder.id }">-</em>
							<input readonly class="text" style="height: 20px;" title="${sorder.number}" value="${sorder.number}" readonly="readonly">		
							<em class="add" data-id="${sorder.id }">+</em>
						</td>
						<td class="align_center vline"><span class="price">￥${sorder.price/1*sorder.number/1}</span>
						</td>
						<td class="align_center vline"><a href="/shop/sorder_delete.action?id=${sorder.id}" class="remove"></a>
						</td>
					</tr>
					</c:forEach>
				</table>
				</div>
				<!-- 结算 -->
				<div class="totals">
					<table id="totals-table">
						<tbody>
							<tr>
								<td width="60%" colspan="1" class="align_left">运费</td>
								<td class="align_right" style=""><span class="price">￥0.00</span>
								</td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left total"><strong>总计</strong>
								</td>
								<td class="align_right" style=""><span class="total"><strong id="total">￥${totalPrice}</strong>
								</span>
								</td>
							</tr>
						</tbody>
					</table>
					</div>
					<div class="action_buttonbar">
						<c:if test="${cartList.size()!=0}">
						<a href="${shop}/sorder_confirmOrder">
						<button type="button" title="" class="checkout fr"
							style="background-color: #f38256;">
							<font>确认订单</font>
						</button>
						</a>
						<button type="button" title="" class="js-btn-empty-cart fr">
							<font><font>清空购物车</font>
							</font>
						</button>
						</c:if>
						<a href="${shop}/index.jsp">
						<button type="button" title="" class="continue fr">
							<font>
								 继续购物
							</font>
						</button>
						</a>
						<div style="clear:both"></div>
					</div>
				</div>
			<!-- 导航栏结束 -->
			<!-- 尾部引入 -->
			<jsp:include page="/public/tail.jsp"/>
	</div>
</body>
</html>
