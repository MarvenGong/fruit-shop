$(function(){
			//获得datagrid中的dg
			var dg = parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
			//用户展示
			$('#cc').combobox({    
				url:'account_queryAccount.action',  
				width:50,
				height:20,
				panelWidth:50,
				panelHeight:80,
				valueField:'id',    
				textField:'name',
				editable:false
			}); 
			//表单的回显
			var rows = dg.datagrid("getSelections");
			$('#ff').form('load',{
				id:rows[0].id,
				type:rows[0].type,
				hot:rows[0].hot,
				'account.id':rows[0].account.id
				
			});

			//******************验证***********************
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
						url: "category_update.action",
						success: function(){
						//关闭Window
						parent.$("#win").window("close");
					  	dg.datagrid("reload");
						}
					});
    		    }
    		});
    		
	});
    	
    