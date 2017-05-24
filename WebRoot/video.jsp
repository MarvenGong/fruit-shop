<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>视频</title>
	<%@include file="/public/head.jspf"%>
	<link rel="stylesheet" type="text/css" href="${shop}/bootstrap-3.3.5-dist/fileInput/fileinput.min.css">
	<script type="text/javascript" src="${shop}/bootstrap-3.3.5-dist/fileInput/fileinput.min.js"></script>
	<script type="text/javascript" src="${shop}/bootstrap-3.3.5-dist/fileInput/zh.js"></script>
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
				<div class="message success">视频</div>
					<label class="control-label">选择文件</label>
					<input class="easyui-filebox" name="file1" data-options="prompt:'选择文件...'" style="width:100%">
					<div class="action_buttonbar">
						<a href="${shop}/user/confirm.jsp">
						<button type="button" title="" class="checkout fr"
							style="background-color: #f38256;">
							<font>上传</font>
						</button>
						</a>
						<div style="clear:both"></div>
					</div>
				</div>
				<!-- 结算 -->
				</div>
			<!-- 导航栏结束 -->
			<!-- 尾部引入 -->
			<jsp:include page="/public/tail.jsp"/>
	</div>
</body>
</html>
