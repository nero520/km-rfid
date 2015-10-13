<?php
/*
Uploadify 后台处理 Demo
Author:POOY
Date:2012-12-26
uploadify 后台处理 ：http://www.pooy.net/uploadify-houtai.html
*/

//设置上传目录
$path = "uploads/";	

if (!empty($_FILES)) {
	
	//得到上传的临时文件流
	$tempFile = $_FILES['Filedata']['tmp_name'];
	
	//允许的文件后缀
	$fileTypes = array('jpg','jpeg','gif','png'); 
	
	//得到文件原名
	$fileName = iconv("UTF-8","GB2312",$_FILES["Filedata"]["name"]);
	$fileParts = pathinfo($_FILES['Filedata']['name']);
	
	//接受动态传值
	$files=$_POST['typeCode'];
	
	//最后保存服务器地址
	if(!is_dir($path))
	   mkdir($path);
	if (move_uploaded_file($tempFile, $path.$fileName)){
		echo $fileName."上传成功！";
	}else{
		echo $fileName."上传失败！";
	}
	
	
	
/* 	if (in_array($fileParts['extension'],$fileTypes)) {
		copy($tempFile,$targetFile);
		echo $_FILES['Filedata']['name'];//上传成功后返回给前端的数据
		file_put_contents($_POST['id'].'.txt','上传成功了！');
	} else {
		echo '不支持的文件类型';
	} */
}
?>