package com.dzwz.shop.util;

public interface MassageUtil {

	/**
	 * 邮件发送工具
	 * @param id
	 * @param Email
	 */
	public abstract void sendEmail(int id, String Email);

	/**
	 * 短息发送工具
	 * @param phone
	 * @param id
	 */
	public abstract void sendmessage(String phone, String info);

}