$(function(){
    		$("input[name=type]").validatebox({
    			required:true,
    			missingMessage:'请输入类别名称'
    		});
    		//关闭验证
    		$("#ff").form("disableValidation");
    		//提交
    		$("#submit").click(function(){
    		$("#ff").form("enableValidation");
    			//判断验证是否成功
    			if($("#ff").form("validate")){
		    		//调用submit方法
		    		$('#ff').form('submit', {
						url: "category_save.action",
						success: function(){
						//关闭Window
						parent.$("#win").window("close");
						//刷新页面  获取 aindex--->iframe---->dg  dom---->jquery--->easyUI
						//var dg = parent.$("iframe[title='类别管理']").contents().find("#dg");
					  	parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");
					  	
						}
					});
    		    }
    		});
    		
	});
    	
    