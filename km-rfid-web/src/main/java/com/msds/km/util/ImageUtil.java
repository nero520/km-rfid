package com.msds.km.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.msds.util.DateUtils;

public class ImageUtil {
	
//	private static final String BUCKET_NAME = "msttest";
//	private static final String OPERATOR_NAME = "mstest";
//	private static final String OPERATOR_PWD = "mstest123";
	private static final String BUCKET_NAME = "onlineshop";
	private static final String OPERATOR_NAME = "online";
	private static final String OPERATOR_PWD = "online123";
	 /** 
     * 检测与创建一级、二级文件夹、文件名 
            这里我通过传入的两个字符串来做一级文件夹和二级文件夹名称 
           通过此种办法我们可以做到根据用户的选择保存到相应的文件夹下 
            
     */ 
	  private static File creatFolder(String typeName,String brandName,String fileName,String url) {  
	         typeName = typeName.replaceAll("/", "");               //去掉"/"  
	         typeName = typeName.replaceAll(" ", "");               //替换半角空格  
	         typeName = typeName.replaceAll(" ", "");               //替换全角空格  
	          
	         brandName = brandName.replaceAll("/", "");             //去掉"/"  
	         brandName = brandName.replaceAll(" ", "");             //替换半角空格  
	         brandName = brandName.replaceAll(" ", "");             //替换全角空格  
	         
	         
	         File newFile = new File(url + typeName + "/"+brandName+"/"+format02(new Date()));
	         if(!newFile.exists()){
	        	 newFile.mkdirs();
	         }
	         
	         return new File(newFile,fileName);  
	    }
	  /* 通过传入页面读取到的文件，处理后保存到本地磁盘，并返回一个已经创建好的File 
	     * @param imgFile 从页面中读取到的文件 
	     * @param typeName  商品的分类名称 
	     * @param brandName 商品的品牌名称 
	     * @param fileTypes 允许的文件扩展名集合 
	     * @return 
	     */  
	    private static String getFile(MultipartFile imgFile,String typeName,String brandName,List fileTypes,String url) throws Exception {  
	    	
	        String fileName = imgFile.getOriginalFilename();  
	        //获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名  
	         String ext = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());  
	         //对扩展名进行小写转换  
	         ext = ext.toLowerCase();  
	         String id=UUID.randomUUID().toString().replace("-", "");
	         String finalPath = "/" +  typeName + "/"+brandName+"/"+format02(new Date())+"/"+id+"."+ext;
	         File file = null;  
	         if(fileTypes.contains(ext)) {                      //如果扩展名属于允许上传的类型，则创建文件  
	             file = creatFolder(typeName, brandName, id+"."+ext,url);  
	             try {
	                imgFile.transferTo(file);                   //保存上传的文件  
	            } catch (IllegalStateException e) {  
	                e.printStackTrace();  
	                throw e;
	            } catch (IOException e) {  
	                throw e;
	            }  
	         }  
	         //传送到又拍云 add by lizhe 2014-12-13
	         transformToUpYun(finalPath, file);
	         //传送结束
	         
	         return finalPath;
	    }
	    
		public static void transformToUpYun(String finalPath, File file) {
			UpYun upYun = new UpYun(BUCKET_NAME, OPERATOR_NAME, OPERATOR_PWD);
	         try {
	        	 upYun.setContentMD5(UpYun.md5(file));
	        	 upYun.writeFile(finalPath,file,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}  
	    /** 
	     * 上传图片文件,并保存到指定的路径当中 
	     * @throws Exception 
	     */  
	    public static String addImage(MultipartFile imgFile1,String path1,String path2,String url) throws Exception {  
	       
	         //定义一个数组，用于保存可上传的文件类型  
	         List fileTypes = new ArrayList();  
	         fileTypes.add("jpg");  
	         fileTypes.add("jpeg");  
	         fileTypes.add("bmp");  
	         fileTypes.add("gif");  
	         fileTypes.add("png");  
	         File file1 =null;
	         //保存第一张图片  
	         if(!(imgFile1.getOriginalFilename() ==null || "".equals(imgFile1.getOriginalFilename()))) {  
	        /*下面调用的方法，主要是用来检测上传的文件是否属于允许上传的类型范围内，及根据传入的路径名 
	         *自动创建文件夹和文件名，返回的File文件我们可以用来做其它的使用，如得到保存后的文件名路径等 
	         *这里我就先不做多的介绍。 
	         */  
	             return  getFile(imgFile1,path1,path2, fileTypes,url);
	         }  
	           
	         return "";
	    }  
	    /**
	     * 截取带斜杠图片名称：例子kangzong/ConditionPic/20141218/7dd0d8d0581e4562a2525f0f63d84ff2.jpg
	     * @param detailEntity
	     * @throws Exception 
	     */
	    public static String imageUrlCut(String str) throws Exception{
	    	String[] imageName=str.split("/");
	    	return imageName[imageName.length-1];
		}
	    
	  /*  public static String imageUrlCutBefore(String str){
	    	return str.substring(str.indexOf("com/")+3);
	    }
	    */
	    public static void main(String[] args) throws Exception {
	    	;
//	    	System.out.println(imageUrlCutBefore("http://msttest.b0.upaiyun.com/kangzong/ConditionPic/20141218/7dd0d8d0581e4562a2525f0f63d84ff2.jpg"));
		}
	    public static String format02(Date date) {
			return dateFormat2.format(date);
		}
		private static DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
}
