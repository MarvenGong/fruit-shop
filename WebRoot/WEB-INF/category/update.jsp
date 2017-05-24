<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
    <title>更新</title>
    <style type="text/css">
    	form{
    		margin: 5px;
    	}
    </style>
    <script type="text/javascript" src="${shop}/js/categoryManage/update.js"></script>
  </head>
  <body>
  <form id="ff" method="post">   
    <div>   
        <label for="name">类别名称:</label>   
        <input  type="text" name="type" />   
    </div>   
    <div>   
        <label for="hot">是否为热点:</label>   
       <input type="radio" name="hot" checked="checked" value="true" /> 是
       <input type="radio"name="hot" value="false" /> 否
    </div> 
    <div>   
        <label for="name">所属用户:</label>   
        <input  type="text" name="account.id" id="cc" />   
    </div> 
    <input type="hidden" name="id" />
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">更新</a> 
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
  </form>  
    	
  </body>
</html>
