package com.dzwz.shop.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.stereotype.Component;

/**
 * 服务信息发送工具类
 * 
 * @param args
 */
@Component("massgeUtil")
public class MassgeUtilImpl implements MassageUtil {
	
	
	/* (non-Javadoc)
	 * @see com.dzwz.shop.util.MassageUtil#sendEmail(int, java.lang.String)
	 */
	@Override
	public void sendEmail(int id,String Email) {
		Transport transport= null;
		Properties prop =null;
		Session session =null;
	try {
		//登录邮件客户端
	    prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		//创建session 会话
		session = Session.getDefaultInstance(prop);
		session.setDebug(true);
		//创建邮件对象
		Message message = new  MimeMessage(session);
		//****************写信******************************
			//主题
			message.setSubject("订单支付成功邮件！！");
			//正文
			message.setContent("订单"+id+"已经支付成功", "text/html;charset=utf-8");
			//发件人地址
			message.setFrom(new InternetAddress("soft03_test@sina.com"));
			//设置收件人地址 和连接服务器的认证信息
		    transport = session.getTransport();
			//设置连接服务器的认证信息
			transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
			//设置收件人地址
			transport.sendMessage(message, new Address[]{new InternetAddress(Email)});
		} catch (MessagingException e) {
			e.printStackTrace();
		}finally{
			try {
				transport.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	
	/* (non-Javadoc)
	 * @see com.dzwz.shop.util.MassageUtil#sendmessage(java.lang.String, java.lang.String)
	 */
		
		@Override
		public void  sendmessage(String phone,String info){
			//状态码
			int statusCode = 0;
			HttpClient client = new HttpClient();
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");     //设置编码格式utf-8
			PostMethod post = new PostMethod("http://yunpian.com/v1/sms/send.json");
			//设置传递参数
			post.setParameter("apikey", "f7943d2b861f2afd1f6a57285612141f");
			post.setParameter("mobile", phone);
			post.setParameter("text", info);
			try {
				//提交请求
				statusCode = client.executeMethod(post);
				System.out.println("statusCode:"+statusCode);
				//获取服务器传回信息
				String result = post.getResponseBodyAsString();
				System.out.println("短息发送结果信息："+result);
				
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
			post.releaseConnection();
			}
			}
		
		
		
		public static void main(String[] args) {
			//状态码
			int statusCode = 0;
			HttpClient client = new HttpClient();
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			PostMethod post = new PostMethod("http://yunpian.com/v1/sms/send.json"); 
			//设置传递参数
		//	post.addParameter("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
			post.setParameter("apikey", "f7943d2b861f2afd1f6a57285612141f");
			post.setParameter("mobile", "13101008846");
			post.setParameter("text", "【睿购商城】欢迎使用睿购，您的手机验证码是123456。本条信息无需回复");
			try {
				//提交请求
				statusCode = client.executeMethod(post);
				System.out.println("statusCode:"+statusCode);
				//获取服务器换回信息
				String result = post.getResponseBodyAsString();
				System.out.println("短息发送结果信息："+result);
				
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
			post.releaseConnection();
			}
		}
}
