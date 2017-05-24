package com.dzwz.shop.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.google.gson.Gson;

public class ProductAction extends BaseAction<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 商品查询
	 * 
	 * @author zrui
	 * @time 2015年9月7日15:35:57
	 * @version v.0.1
	 */

	public String productManage() {

		resultMap = new HashMap<String, Object>();
		List<Product> list = productService.QueryJoinProduct(model.getName(),
				page, rows);
		System.out.println(list);
		resultMap.put("rows", list);
		resultMap.put("total",productService.totalCategory(model.getName()));
		return "jsonSuccess";
		/*try {
			resultMap = new HashMap<String, Object>();
			List<Product> list = productService.QueryJoinProduct(model.getName(),
					page, rows);
			System.out.println(list);
			resultMap.put("rows", list);
			resultMap.put("total", productService.totalCategory(model.getName()));
			System.out.println(list);
			Long total=Long.valueOf(productService.totalCategory(model.getName()));
			return responseData(Long.valueOf(2), list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonSuccessNew";*/
	}

	public String productManage1() {
		try {
			resultMap = new HashMap<String, Object>();
			List<Forder> list = productService.QueryJoinProduct1(model
					.getName(), page, rows);
			// resultMap.put("rows", list);
			// resultMap.put("total", productService.totalCategory1(model
			// .getName()));
			return responseData(Long.valueOf(productService.totalCategory1(model
					.getName())), list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonSuccessNew";
	}

	public static String responseData(Long resultTotal, List resultList) {
		String msg = "";
		  Gson gson = new Gson(); 
		HttpServletResponse response = ServletActionContext.getResponse();
		if (resultList != null && resultList.size() > 0 && resultTotal != null
				&& !"0".equals(resultTotal)) {
			net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray
					.fromObject(resultList);
			msg = "{\"total\":" + String.valueOf(resultTotal) + ",\"rows\":"
					+ jsonArray.toString() + "}";
		} else {
			msg = "{\"total\":" + "0" + ",\"rows\":" + "[]" + "}";
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.getWriter().print(msg);
		} catch (IOException e) {

		}
		return NONE;
	}

	/**
	 * 商品添加
	 * 
	 * @author zrui
	 * @throws Exception
	 * @time 2015年9月7日15:35:57
	 * @version v.0.1
	 */
	public void save() throws Exception {
		String filePath = ServletActionContext.getServletContext().getRealPath(
				"/images");

		String pic = fileUplaod.uploadFile(fileImage, filePath);
		model.setPic(pic);
		// 商品入库
		productService.save(model);
	}

	/**
	 * 类别删除
	 * 
	 * @author zrui
	 * @time 2015年8月27日17:14:05
	 * @version v.0.1
	 */
	public String deleteByids() {

		System.out.println(ids);
		productService.deleteByids(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/**
	 * 类别更新
	 * 
	 * @author zrui
	 * @time 2015年9月7日15:40:33
	 * @version v.0.1
	 */
	public void update() {
		System.out.println(model);
		productService.update(model);

	}

	/**
	 * 根据id 查询商品信息
	 * 
	 * @author zrui
	 * @time 2015年9月7日15:40:33
	 * @version v.0.1
	 * 
	 */
	public String queryByid() {
		request.put("product", productService.queryByid(model.getId()));
		return "detail";
	}

	// 搜索参数
	private String q;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * 
	 * 商品搜索
	 * 
	 * @author zrui
	 * @time 2015年10月20日17:38:17
	 * @version v0.1
	 * @return
	 */
	public String search() {
		if (page == 0) {
			page = 1;
		}
		// 根据商品名查询 及分页支持
		List<Product> productinfo;

		String productName = q;
		try {
			productName = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(productName);
		productinfo = productService.QueryJoinProduct(productName, page, 10);
		request.put("productinfo", productinfo);
		return "productinfo";

	}

}
