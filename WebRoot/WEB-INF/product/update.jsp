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
    <script type="text/javascript" src="${shop}/js/productManage/update.js"></script>
  </head>
  <body>
  <form title="编辑商品" id="ff" method="post" enctype="multipart/form-data">
	<div>
		<label>商品名称:</label> <input type="text" name="name" />
	</div>
	<div>
		<label>商品价格:</label> <input type="text" name="price" />
	</div>
	<div>
		<label>图片上传:</label> <input type="file" name="fileImage.upload" />
	</div>
	<div>
		<label>所属类别：</label> 
		<input id="cc" name="cid.id" />
		
	</div>
	<div>
		<label>加入推荐:</label> 推荐:<input type="radio" name="commend"
			checked="checked" value="true" />  不推荐:<input type="radio"
			name="commend" value="false" /> 
	</div>
	<div>
		<label>是否有效:</label>
		上架:<input type="radio" name="open" checked="checked"value="true" />
		下架:<input type="radio" name="open" value="false" />
				
	</div>
	<div>
		<label>简单描述:</label>
		<textarea name="remark" cols="40" rows="4"></textarea>
	</div>
	<div>
		<label>详细描述:</label>
		<textarea name="xremark" cols="40" rows="8"></textarea>
	</div>
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">编辑</a> 
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
</form>

</body>
</html>
