<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML >
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
    <title>销售额</title>
   <script type="text/javascript" src="${shop}/js/jscharts.js"></script>
    <script type="text/javascript">
    $(function(){
       $("#submit").click(function(){
       	  var colorArr=['#44A622','#A7B629','#CAD857','#E4DB7B','#ECDE49','#ECC049','#EC9649','#D97431','#D95531']; 
     	  $.post($("#sale").val(),{number:$("#number").val()},function(data){
     	   
			var myChart = new JSChart('chart_container', $("#type").val(), '');
			myChart.setDataArray(data);
			myChart.colorize(colorArr.slice(0,data.length));
			myChart.setSize(100*$("#number").val(), 300);
			myChart.setBarValues(false);
			myChart.setBarSpacingRatio(45);
			myChart.setBarOpacity(1);
			myChart.setBarBorderWidth(0);
			myChart.setTitle('Home broadband penetration');
			myChart.setTitleFontSize(10);
			myChart.setTitleColor('#607985');
			myChart.setAxisValuesColor('#607985');
			myChart.setAxisNameX('商品', true);
			myChart.setAxisNameY('销量', false);
			myChart.setGridOpacity(0.8);
			myChart.set3D(true);
			myChart.draw();
		 });
	   });
	});
		</script>
     
  </head>
  
  <body>
  	查询：
  	<select id="sale">
  		<option value="sorder_querySale.action">销售额</option>
  	</select>
  	数量：
  	<select id="number">
  		<option value="5">5</option>
  		<option value="7">7</option>
  		<option value="10">10</option>
  	</select>
  	展现方式：
  	 <select id="type">
  	 	<option value="" selected="selected">---请选择---</option>
  	 	<option value="line">线性图</option>
  	 	<option value="bar">柱状图</option>
  	 	<option value="pie">饼状图</option>
  	 </select>
  	 <input type="submit" id="submit" value="查询" />
      <div id="chart_container">Loading chart...</div>
		
  </body>
</html>
