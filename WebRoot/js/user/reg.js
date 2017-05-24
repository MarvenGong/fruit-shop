		$(function() {
			/************************验证 start*******************************/
			$("#msform").validate({
				debug:true,
				
				rules:{
					phone:{
						required:true					
					},
					login:{
						required:true
					},
					name:{
						required:true
					},
					pwd:{
						required:true,
						rangelength:[6,12]
					},
					cpwd:{
						required:true,
						equalTo:'#pwd'
					},
					email:{
						email:true
					}
				 },
				 messages:{
				 	login:{
				 		required:"用户名不能为空"
				 	},
				 	name:{
				 		required:"请输入呢称",
				 	},
				 	pwd:{
				 		required:"请输入密码",
				 		rangelength:"密码长度应该为{0}到{1}位"
				 	},
				 	cpwd:{
				 		required:"请再次输入密码",
				 		equalTo:"输入的密码不相等"
				 	},
				 	email:{
				 		email:"请输入正确的邮箱"
				 	}
				 }
				 
				});
			
	
		
		/****************************验证 end***************************/
		
			//短信发送
			$(".send").click(function() {
		    var step = 59;
            var _res = setInterval(function()
            {   
                $(".send").attr("disabled", true);//设置disabled属性
                $(".send").val("重新发送"+step);
                step-=1;
                if(step <= 0){
                $(".send").removeAttr("disabled"); //移除disabled属性
                $(".send").val("获取验证码");
                clearInterval(_res);//清除setInterval
                }
            },1000);	
				$("p").fadeIn();
				var phone = $("#phone").val();
				/* $.post('user_SMS', {
					phone : phone
				}); */
			});
			$("#next-1").click(function() {
			//	console.log("aa");
				var code = $("#code").val();
				$.post('user_iScode',{code:code},function(data){
					if(data=="true"){
						$("#next-1").parent().hide();    //隐藏当前
						$("#next-1").parent().next().fadeIn("slow");    // 显示下一步
						$("#progressbar li").eq($("fieldset").index($("#next-1").parent().next())).addClass("active"); //添加class属性
					}
				},"text");
				
			});
			
		});