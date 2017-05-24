$(function(){
	
			//自定义验证函数
			$.extend($.fn.validatebox.defaults.rules, {    
			    format: {    
			        validator: function(value,param){   
			        	var etc = value.substring(value.lastIndexOf('.')+1);
			        	var exx = param[0].split(',');
			        	for(var i=0;i<exx.length;i++){
			        		if(etc==exx[i]){
			        			return true;
			        		}
			        	}
			        	
			            return false;    
			        },    
			        message: '传入的类型为:{0}'  
			    }    
			});
			
    		$("input[name=name]").validatebox({
    			required:true,
    			missingMessage:'请输入类别名称'
    		});
    		
    	
    		$("input[name=price]").numberbox({
    			min:0,
    			precision:2,
    			prefix:'$',
    			required:true,
    			missingMessage:'请输入输入价格'
    		});
    		
    		$("input[name='fileImage.upload]'").validatebox({
    			required:true,
    			missingMessage:'请上传商品图片',
    			validType:'format["jpg,png,gif,jpeg"]'
    		});
    		
    		$("input[name='fileImage.upload]'").change(function(){
    			
    			this.validatebox('validate');
    		});
    		
    		$("textarea[name=remark]").validatebox({
    			required:true,
    			missingMessage:'请输入简单描述'
    		});
    		
    		$("textarea[name=xremark]").validatebox({
    			required:true,
    			missingMessage:'请输入详细描述'
    		});
    		
    		
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
    		
    		
    		
    		//关闭验证
    		$("#ff").form("disableValidation");
    		//提交
    		$("#submit").click(function(){
    		$("#ff").form("enableValidation");
    			//判断验证是否成功
    			if($("#ff").form("validate")){
		    		//调用submit方法
		    		$('#ff').form('submit', {
						url: "product_save.action",
						success: function(){
						//关闭Window
						parent.$("#win").window("close");
					  	parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg").datagrid("reload");
					  	
						}
					});
    		    }
    		});
    		$("#reset").click(function(){
    			this.form("reset");
    		});
    		
	});
    	
    