package com.msds.km.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.msds.km.base.BaseController;
import com.msds.km.util.ImageUtil;
 
/**
 * 
 * <br>
 * <b>功能：</b>UploadController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-08-04 13:43:30 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/uploads") 
public class UploadController extends BaseController{
	
	private final static Logger log= Logger.getLogger(UploadController.class);
	
	/**
	 * 异步上传
	 * @param response
	 * @param request
	 * @param file
	 * @throws Exception
	 */
	@RequestMapping(value="/common")
	public @ResponseBody String  commonUpload(String dirName,HttpServletRequest request, HttpServletResponse response) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String contextPath=request.getSession().getServletContext().getRealPath("/");
		String sep = System.getProperty("file.separator");
//		String [] paths = contextPath.split("\\");
//		String basePath = contextPath.substring(0, contextPath.lastIndexOf(sep));
//		String basePath = "";
//		int i = 0;
//		int beginIndex = 0;
		if(contextPath.endsWith(sep)){
			contextPath = contextPath.substring(0,contextPath.length()-1);
		}
		String basePath = contextPath.substring(0, contextPath.lastIndexOf(sep));
//		if(!contextPath.endsWith(sep)){
//			contextPath = contextPath.substring(0,contextPath.length());
//			for(;contextPath.indexOf(sep) != -1;){
//				String oneString = contextPath.substring(beginIndex,contextPath.indexOf(sep));
//				contextPath = contextPath.substring(contextPath.indexOf(sep) + sep.length());
//				System.out.println(oneString);
//				basePath += contextPath + sep;
//			}
//		}
		
		String date = format02(new Date());
		String baseDir ="upload" + sep + "img";
		if(dirName == null || dirName.equals("")){
			dirName = "test";
		}
		String filePath=baseDir + sep + dirName+sep+date;//给商品配置文件夹
		
		File dirPath = new File(basePath+sep+filePath);
		//创建图片文件夹
        if (!dirPath.exists()) {
        	dirPath.mkdirs();
        }
        
        File copyFilePath = new File(contextPath+sep+filePath);
		//创建图片文件夹
        if (!copyFilePath.exists()) {
        	copyFilePath.mkdirs();
        }
        String newPath = "";
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
        	MultipartFile mf = entity.getValue();    
        	//保存图片信息
        	String id=UUID.randomUUID().toString().replace("-", "");
        	String fileName = mf.getOriginalFilename();//文件名
            String suffix=fileName.substring(fileName.lastIndexOf("."));//文件后缀
        	newPath=filePath+sep+id+suffix;//新文件路径并重新命名文件
        	
        	String allPath = basePath+sep+newPath;
            File uploadFile = new File(allPath);
            FileCopyUtils.copy(mf.getBytes(), uploadFile);
            
            String allPath1 = contextPath+sep+newPath;
            File copyFile = new File(allPath1);
            FileCopyUtils.copy(mf.getBytes(), copyFile);//copy备份，后期可删除
        }
		return "/" + (newPath.replace("\\", "/"));
	}
	
	/**
	 * 异步上传到upyun
	 * @param response
	 * @param request
	 * @param file
	 * @throws Exception
	 */
	@RequestMapping(value="/upyun")
	public @ResponseBody String  upyun(String dirName,HttpServletRequest request, HttpServletResponse response) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String contextPath=request.getSession().getServletContext().getRealPath("/");
		String sep = System.getProperty("file.separator");
		if(contextPath.endsWith(sep)){
			contextPath = contextPath.substring(0,contextPath.length()-1);
		}
		String basePath = contextPath.substring(0, contextPath.lastIndexOf(sep));
		String date =format02(new Date());
		String baseDir ="upload" + sep + "img";
		if(dirName == null || dirName.equals("")){
			dirName = "test";
		}
		String filePath=baseDir + sep + dirName+sep+date;//给商品配置文件夹
		
		File dirPath = new File(basePath+sep+filePath);
		//创建图片文件夹
        if (!dirPath.exists()) {
        	dirPath.mkdirs();
        }
        
        File copyFilePath = new File(contextPath+sep+filePath);
		//创建图片文件夹
        if (!copyFilePath.exists()) {
        	copyFilePath.mkdirs();
        }
        String newPath = "";
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
        	MultipartFile mf = entity.getValue();    
        	//保存图片信息
        	String id=UUID.randomUUID().toString().replace("-", "");
        	String fileName = mf.getOriginalFilename();//文件名
            String suffix=fileName.substring(fileName.lastIndexOf("."));//文件后缀
        	newPath=filePath+sep+id+suffix;//新文件路径并重新命名文件
        	
        	String allPath = basePath+sep+newPath;
            File uploadFile = new File(allPath);
            FileCopyUtils.copy(mf.getBytes(), uploadFile);
            ImageUtil.transformToUpYun(newPath.replace("\\", "/"), uploadFile);
            
        }
		return "/" + (newPath.replace("\\", "/"));
	}
	
	
	/**
	 * 异步上传
	 * @param response
	 * @param request
	 * @param file
	 * @throws Exception
	 */
	@RequestMapping(value="/ckeditor")
	public void  ckeditorUpload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String contextPath=request.getSession().getServletContext().getRealPath("/");
		String sep = System.getProperty("file.separator");
//		String [] paths = contextPath.split("\\");
//		String basePath = contextPath.substring(0, contextPath.lastIndexOf(sep));
//		String basePath = "";
//		int i = 0;
//		int beginIndex = 0;
		if(contextPath.endsWith(sep)){
			contextPath = contextPath.substring(0,contextPath.length()-1);
		}
		String basePath = contextPath.substring(0, contextPath.lastIndexOf(sep));
//		if(!contextPath.endsWith(sep)){
//			contextPath = contextPath.substring(0,contextPath.length());
//			for(;contextPath.indexOf(sep) != -1;){
//				String oneString = contextPath.substring(beginIndex,contextPath.indexOf(sep));
//				contextPath = contextPath.substring(contextPath.indexOf(sep) + sep.length());
//				System.out.println(oneString);
//				basePath += contextPath + sep;
//			}
//		}
		
		String date = format02(new Date());
		String dirName = "";
		if(dirName == null || dirName.equals("")){
			dirName = "upload" + sep + "img" + sep + "ck";
		}
		String filePath=dirName+sep+date;//给图片配置文件夹
		
		File dirPath = new File(basePath+sep+filePath);
		//创建图片文件夹
        if (!dirPath.exists()) {
        	dirPath.mkdirs();
        }
        
        File copyFilePath = new File(contextPath+sep+filePath);
		//创建图片文件夹
        if (!copyFilePath.exists()) {
        	copyFilePath.mkdirs();
        }
        String newPath = "";
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
        	MultipartFile mf = entity.getValue();    
        	//保存图片信息
        	String id=UUID.randomUUID().toString().replace("-", "");
        	String fileName = mf.getOriginalFilename();//文件名
            String suffix=fileName.substring(fileName.lastIndexOf("."));//文件后缀
        	newPath=filePath+sep+id+suffix;//新文件路径并重新命名文件
        	
        	String allPath = basePath+sep+newPath;
            File uploadFile = new File(allPath);
            FileCopyUtils.copy(mf.getBytes(), uploadFile);
            
            String allPath1 = contextPath+sep+newPath;
            File copyFile = new File(allPath1);
            FileCopyUtils.copy(mf.getBytes(), copyFile);//copy备份，后期可删除
        }
        PrintWriter out = response.getWriter(); 
        String finalPathString = "/" + (newPath.replace("\\", "/"));
        String callback =request.getParameter("CKEditorFuncNum"); 

        out.println("<script type='text/javascript'>");
        finalPathString = StringUtils.replace(finalPathString, "//", "/");  
        out.println("window.parent.CKEDITOR.tools.callFunction("+ callback + ",'"+ finalPathString + "','')"); 

        out.println("</script>");
		return;
	}
	
	public static String format02(Date date) {
		return dateFormat2.format(date);
	}
	private static DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
}
