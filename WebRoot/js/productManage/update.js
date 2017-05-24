$(function(){
			//获得datagrid中的dg
			var dg = parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg");
			//类型展示
			$('#cc').combobox({    
				url:'category_quercategory.action',  
				width:100,
				height:20,
				panelWidth:100,
				panelHeight:120,
				valueField:'id',    
				textField:'type',
				editable:false,
				required:true,
    			missingMessage:'请选择类别'
			});
    		
			
			//表单的回显
			var rows = dg.datagrid("getSelections");
			$('#ff').form('load',{
				id:rows[0].id,
				name:rows[0].name,
				price:rows[0].price,
				remark:rows[0].remark,
				xremark:rows[0].xremark,
				'cid.id':rows[0].cid.id
				
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
    	
    