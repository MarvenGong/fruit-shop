package com.dzwz.shop.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

/**
 * 实现文件上传逻辑
 * @author zrui
 * @time 2015年9月5日10:47:35
 * @version v.0.1
 *
 */

public class FileUploadUtil implements FileUpload {
	
	
	//1.通过文件名获取拓展名
	private String getFileExt(String fileName){
		return FilenameUtils.getExtension(fileName);
	}
	
	//2.UUID随机数,作为新的文件名
	
	public String newFileName(String fileName){
		String ext = getFileExt(fileName);
		
		return UUID.randomUUID().toString()+ "." +ext;
	}
	
	//3.实现上传,返回新的文件名称
	
	@Override
	public String uploadFile(FileImage fileImage,String filePath){
		 //获取文件名	
		String pic = newFileName(fileImage.getFilename());
		
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));
			return pic;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			fileImage.getFile().delete();
		}
	}
	
	//获得银行图标文件
	public String[] getBankImage(String bankPath){
		return new File(bankPath).list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				//文件后缀名过滤
				return name.endsWith(".gif");
			}
		});
	}
	
}
