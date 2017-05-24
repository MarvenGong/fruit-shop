package com.dzwz.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用户过滤器对用户登录实现过滤
 * @author zrui
 * @time 2015年9月9日13:42:14
 * @version v.0.1
 *
 */

@WebFilter(filterName="userFiter",urlPatterns="/user/*")
public class UserFiter implements Filter{

	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
      HttpServletRequest request = (HttpServletRequest)req;
      HttpServletResponse response = (HttpServletResponse)res; 
      if(request.getSession().getAttribute("userInfo")==null){
    	  String goURL = request.getServletPath();
    	  String param = request.getQueryString();
    	  if(param!=null){
    		  goURL = goURL+param;
    	  }
    	  //把客户的访问的地址保存在session中
    	  request.getSession().setAttribute("goURL", goURL);
    	  //重定向到登录页面
    	  response.sendRedirect(request.getContextPath()+"/ulogin.jsp");
      }else{
    	  chain.doFilter(req, res);
      }
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
