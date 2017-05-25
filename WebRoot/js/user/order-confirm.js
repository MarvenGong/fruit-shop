		$(function() {
			/************************验证 start*******************************/
			$("#form-order-confirm").validate({
				debug:true,
				submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
                    form.submit();   //提交表单  
                   
                }, 
				rules:{
					phone:{
						required:true					
					},
					name:{
						required:true
					},
					post:{
						required:true,
					},
					address:{
						required:true,
					}
				 },
				 messages:{
				 	phone:{
				 		required:"电话不能为空"
				 	},
				 	name:{
				 		required:"请输入姓名",
				 	},
				 	post:{
				 		required:"请输入邮编",
				 	},
				 	address:{
				 		required:"请输入地址",
				 	}
				 }
				 
				});
			
	
		
		/****************************验证 end***************************/
		
		});