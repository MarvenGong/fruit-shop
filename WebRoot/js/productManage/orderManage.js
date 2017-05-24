$(function(){
	$('#dg').datagrid({
		url : 'product1_productManage1.action',
		fitColumns:true,			//自动适应宽度
		nowrap:true,
		striped:true, 				//显示斑马线	
		pagination:true,			//打开分页
		pageSize:5,					//初始化页面大小
		idField:'id',					//指定id为标识字段 在更新.删除时使用,如果 在翻页的时候记下来
		queryParams:{      //传递初始化参数
			name:''
		},
		pageList:[5,10,15],
		frozenColumns:[[
			{field:'xyz',checkbox:true},
			{field : 'id',title:'编号',width : 100}
		]],
		columns : [ [ {
			field : 'name',
			title : '名称',
			width : 100
		}, {
			field : 'phone',
			title : '联系方式',
			width : 100
		}, {
			field : 'address',
			title : '地址',
			width : 100
		}, {
			field : 'remak',
			title : '留言',
			width : 100
		}, {
			field : 'price',
			title : '价格',
			width : 100,
			align : 'right'
		}, {
			field : 'number',
			title : '数量',
			width : 100,
			align : 'right'
		}
		] ]
	});
	//将普通的文本框转化为搜索文本框
	$('#query').searchbox({
		//触发当前事件
		searcher:function(value,name){
			//获取查询关键字,通过dg加载
			$('#dg').datagrid('load',{
				type: value
			});
		}, 
		prompt:'女装'     //缺省值
		}); 
	
	
});