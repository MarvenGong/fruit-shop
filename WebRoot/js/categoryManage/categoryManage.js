$(function(){
	$('#dg').datagrid({
		url : 'category_CategoryManage.action',
		fitColumns:true,			//自动适应宽度
		nowrap:true,
		striped:true, 				//显示斑马线	
		pagination:true,			//打开分页
		pageSize:5,					//初始化页面大小
		idField:'id',					//指定id为标识字段 在更新.删除时使用,如果 在翻页的时候记下来
		queryParams:{      //传递初始化参数
			type:''
		},
		pageList:[5,10,15],
		toolbar: [{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
				//parent 父级
				parent.$('#win').window({    
				    title:'添加类别',
				    //引入插入页面
					content:'<iframe src="send_category_save.action" frameborder="0"  width="100%" height="100%"></iframe>'
				}); 
				}
		},'-',{
			iconCls: 'icon-edit',
			text:'编辑',
			handler: function(){
			
				//判断是否选中行记录
				var rows = $('#dg').datagrid("getSelections");
				//rows返回所有被选中的行，当没有记录被选中的时候将返回一个空数组
				if(rows.length!=1){
					//提示信息
					$.messager.show({
						title:'提示信息',
						msg:'请选择一条数据',
						timeout:2000,      //弹出时间
						showType:'slide',  //弹出方式
					});
				}else{
					//parent 父级
					parent.$('#win').window({    
					    title:'编辑类别',
					    //引入插入页面
						content:'<iframe src="send_category_update.action" frameborder="0"  width="100%" height="100%"></iframe>'
					}); 
					
				}
			
				}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除',
			handler: function(){
				//判断是否选中行记录
				var rows = $('#dg').datagrid("getSelections");
				//rows返回所有被选中的行，当没有记录被选中的时候将返回一个空数组
				if(rows.length==0){
					//提示信息
					$.messager.show({
						title:'提示信息',
						msg:'至少选择一条数据',
						timeout:2000,      //弹出时间
						showType:'slide',  //弹出方式
					});
				}else{
					//执行删除逻辑
					$.messager.confirm('确认对话框', '您想要删除记录吗？', function(r){
						if (r){
						    //1.得到内容id
							var ids =  "";
							for(var i=0;i<rows.length;i++){
								ids = ids+rows[i].id+",";
							}
							//2.拼接id的值
							ids = ids.substring(0, ids.lastIndexOf(","));
						    //3.发送ajax请求
							$.post("category_deleteByids.action",{ids:ids},function(result){
								$('#dg').datagrid("unselectAll");
								if(result=="true"){
									$('#dg').datagrid("reload");
								}else{
									//提示信息
									$.messager.show({
										title:'删除失败',
										msg:'请用户注意操作',
										timeout:2000,      //弹出时间
										showType:'slide',  //弹出方式
									});
								}
							});
						}
					});
				}
				}
		
		},'-',{
			iconCls: 'icon-help',
			handler: function(){
				alert('帮助按钮');
				}
		},'-',{
			text:"<input id='query' name='search' />",
			
		}],
		frozenColumns:[[
			{field:'xyz',checkbox:true},
			{field : 'id',title:'编号',width : 100}
		]],
		columns : [ [ {
			field : 'type',
			title : '类型',
			width : 100
		}, {
			field : 'hot',
			title : '热点',
			width : 100,
			formatter: function(value,row,index){
				if(value==false){
					return "<input type='checkbox'/>";
				}else{
					return "<input type='checkbox' checked/>";
				}
			},
			align : 'right'
		}, {
			field : 'account',
			title : '所属用户',
			width : 100,
			formatter: function(value,row,index){
				if (row.account!=null){
				  return row.account.name;
				} else {
					return value;
				}
			  }
			}
		] ]
	});
	//将普通的文本框转化为搜索文本框
	$('#query').searchbox({
		//触发当前事件
		searcher:function(value,name){
			alert(value)
			//获取查询关键字,通过dg加载
			$('#dg').datagrid('load',{
				type: value
			});
		}, 
		prompt:'女装'     //缺省值
		}); 
	
	
});