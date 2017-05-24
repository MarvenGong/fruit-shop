package com.dzwz.shop.util;

public interface FileUpload {
	
	//文件上传
	public abstract String uploadFile(FileImage fileName,String filepath);
	
	//获得银行图标文件
	public String[] getBankImage(String bankPath);

}