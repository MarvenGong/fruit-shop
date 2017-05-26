<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>后台管理</title>
    <%@ include file="/public/head.jspf" %>
    <style type="text/css">
		*{margin:0;padding: 0}
		#menu{
			width:200px;
			
		}
		 ul{
			list-style: none;
		}
		 li{
			border-bottom:1px solid #fff;
		}
		 ul li a{
			display: block;
			padding:5px;
			background:#008792;
			text-decoration: none;
			color: #fff;
		}
		#menu ul li a:hover{
			background:#00a6ac;
		}
		
	</style>
	
	
  </head>
  
  <body class="easyui-layout"> 
	
    <div data-options="region:'north',title:'小然水果商城',split:true" style="height:80px;"></div>   
    <div data-options="region:'west',title:'菜单管理',split:true" style="width:150px;">
	  <div id="aa" class="easyui-accordion" data-options="fit:true">
	    <div id="menu" title="后台管理"> 
 			<ul>
							<li><a href="#" title="send_product_manage.action">商品管理</a></li>
							<li><a href="#" title="send_category_manage.action">类别管理</a></li>
 			  				<!-- <li><a href="#" title="send_usermanage_saler.action">卖家管理</a></li> -->
 			  				<!-- <li><a href="#" title="send_usermanage_buyer.action">买家管理</a></li> -->
 			  				<li><a href="#" title="send_usermanage_order.action">订单管理</a></li>
 		    </ul>
		</div>
	
	  </div>
	</div>   
    <div data-options="region:'center',title:'操作页面'" style="padding:5px;background:#eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">   
	    	<div title="Home" style="padding:20px;">   
 				此处显示以后信息
			</div> 
			
		</div>
	</div>
	
   <div id="win" data-options="closable:true,modal:true" style="width: 500px;height: 500px"></div>
	
   <script type="text/javascript">
		$(function() {
			$("a[title]").click(function() {
				var text = $(this).text();
				var href = $(this).attr("title");
				if ($("#tt").tabs("exists", text)) { //判断面板是否存在
					//有着显示到这个面板，没有则创建一个
					$("#tt").tabs("select", text);
				} else {
					$("#tt").tabs("add", {
						title:text,	
						content:'<iframe title='+ text +' src='+ href +' frameborder="0"  width="100%" height="100%"></iframe>',
				  		closable:true
				   });		
				}
			});
		});
	</script>
	
</body>
</html>
