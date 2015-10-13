var form = new mini.Form("#editform");
var provinceComp=mini.get("provinceComp");
var cityComp = mini.get("cityComp");
var areaComp = mini.get("areaComp");

function SetData(data) {
	if (data.action == "edit") {
		data = mini.clone(data);
		$.ajax({
			url : ctx+"/company/getId.action?id=" + data.id,
			cache : false,
			success : function(text) {
				
				var provinceId=text.province;
				var cityId=text.city;
				$("#iconimage").attr("src",text.doorPic);
				cityComp = mini.get("cityComp");

			    var url = ctx+"/area/getCityComboboxList.action?provinceId=" + provinceId;
			    cityComp.setUrl(url);
			    cityComp.select(0);
				
			    areaComp = mini.get("areaComp");
			   
			    var url = ctx+"/area/getAreaComboboxList.action?cityId=" + cityId;
			    areaComp.setUrl(url);
			    areaComp.select(0);
			    
			    form.setData(text);
				form.setChanged(false);
				
			}
		});
	}else if(data.action =="passwordEdit"){
		data = mini.clone(data);
		$.ajax({
			url : ctx+"/company/getId.action?id=" + data.id,
			cache : false,
			success : function(text) {
			    form.setData(text);
				form.setChanged(false);
			}
		});
	}
}
function cancelRow() {
	CloseWindow("close");
}

function telephoneV(e){
	if (e.isValid) {
        var pattern = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
        if ( !pattern.test(e.value)) {
            e.errorText = "电话号码格式错误";
            e.isValid = false;
        }
    }
}

function usernameV (e){
	if (e.isValid) {
		if (e.isValid) {
	        var pattern = /^((00|\+)86)?1[3-8]\d{9}$/;
	        if ( !pattern.test(e.value)) {
	            e.errorText = "用户名必须是手机号";
	            e.isValid = false;
	        }
	    }
    }
}

function contactsPhoneV(e){
	if (e.isValid) {
        var pattern = /^((00|\+)86)?1[3-8]\d{9}$/;
        if ( !pattern.test(e.value)) {
            e.errorText = "手机号格式错误";
            e.isValid = false;
        }
    }
}

function aercV(e){
	if (e.isValid) {
		if (e.value == 0 ) {
			error($("#areaComp"));
			return;
		}else{
			errorRemove($("#areaComp"));
		}
	}
}

function doorPicV(){
	var door= mini.get("#upload_file").getValue();
		if (door == "" ) {
			$("#upload_file").after("<span class=\"mini-errorIcon\" title=\"不能为空\" data-placement=\"right\" stype=\"\"></span>");
			return;
		}/*else{
			errorRemove($("#areaComp"));
	}*/
}


function contactsV(e){
	if (e.isValid) {
        var pattern = /^[a-zA-Z\u4e00-\u9fa5]{1}[a-zA-Z0-9\u4e00-\u9fa5]{1,9}$/;
        if ( !pattern.test(e.value)) {
            e.errorText = "开头不能是数字，不能输入特殊符号，长度必须是两位及以上";
            e.isValid = false;
        }
    }
}

function iamgeV(){
	
}

function updateRow() {
	var o = form.getData();
	var str=0;
	if(o.province=='' || o.city=='' || o.area == ''){
		str=1;
	}
	if(o.doorPic==""){
		$("#upload_file").parent().addClass('mini-error');
		$("#upload_file").after("<span class=\"mini-errorIcon\" title=\"不能为空\" data-placement=\"right\" style=\"left:350px;right:auto;top:auto;bottom:13px;\"></span>");
		str=1;
	}
	
	
	form.validate();
	if (form.isValid() == false)
		return;
	
	
	if(str==1){
		return;
	}
	
	
	var json = mini.encode(o);
	$.ajax({
		url : ctx+"/company/save.action",
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : json,
		success : function(text) {
			if(text=='success'){
				CloseWindow("success");
			}else if(text=='defeated'){
				showMsg("用户名已存在", 'success');
			}else{
				showMsg("其它错误", 'success');
			}
			
		},
		error : function(text, textStatus, errorThrown) {
			CloseWindow(text.responseText);
		}
	});
}

function passwordValid (e){
	if (e.isValid) {
		if(e.value.length<8){
			mini.alert("密码必须大于或等于8位数");
            e.isValid = false;
		}
    }
}

function passwordValid1 (e){
	if (e.isValid) {
		var provinceId = mini.get("password").getValue();
		if(e.value.length<6){
			mini.alert("密码必须大于或等于8位数");
            e.isValid = false;
            return;
		}
        if (provinceId!="" && provinceId!=e.value) {
       		mini.alert("第一次与第二次密码不相同");
            e.isValid = false;
        }
    }
}
function updatePassword() {
	form.validate();
	if (form.isValid() == false)
		return;
	var o = form.getData();
	
	if(o.id==''){
		 mini.alert("其它错误！");
		return;
	}
	
	o={"id":o.id,"password":o.password}
	var json = mini.encode(o);
	$.ajax({
		url : ctx+"/company/updatePassword.action",
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : json,
		success : function(text) {
			if(text=="success"){
				setTimeout("CloseWindow('success')",500);
			}else if(text == "defeated"){
				setTimeout("CloseWindow('密码修改失败')",500);
			}
		},
		error : function(text, textStatus, errorThrown) {
			CloseWindow(text.responseText);
		}
	});
}
function CloseWindow(action) {
	if (action == "close" && form.isChanged()) {
		if (confirm("确定要取消数据修改？")) {
			return false;
		}
	}
	if (window.CloseOwnerWindow) {
		return window.CloseOwnerWindow(action);
	} else {
		window.close();
	}
}

function onProvinceChanged() {
	cityComp = mini.get("cityComp");
	areaComp = mini.get("areaComp");
	 
    var provinceId = mini.get("provinceComp").getValue();
    var url = ctx+"/area/getCityComboboxList.action?provinceId=" + provinceId;
    cityComp.setValue("");
    cityComp.setUrl(url);
    cityComp.select(0);
    
    var cityId = mini.get("cityComp").getValue();
    var url = ctx+"/area/getAreaComboboxList.action?cityId=" + cityId;
    areaComp.setValue("");
    areaComp.setUrl(url);
    areaComp.select(0);
    
}
function onCityChanged() {
	areaComp = mini.get("areaComp");
    var cityId = mini.get("cityComp").getValue();
    var url = ctx+"/area/getAreaComboboxList.action?cityId=" + cityId;
    areaComp.setValue("");
    areaComp.setUrl(url);
    areaComp.select(0);
}


var filectrl=$("#upload_file");
	filectrl.uploadify({
		    'buttonText' : '添加图片',
		    'multi': false,//是否能选择多个文件
		    'height' : 30,//上传按钮的高
		    'width' : 120,//上传按钮的宽
		    'swf' : ctx+'/js/uploadify3.1/uploadify.swf',//[必须设置]swf的路径
		    'uploader' : ctx+'/uploads/common.action',//[必须设置]上传文件触发的url
		    'auto': true,
		    'fileObjName'   : 'file',
		    'method'   : 'get',
		    'fileTypeExts'  : '*.bmp;*.gif;*.jpg;*.png',//可选图片格式
		    'formData'      : {'dirName':'model'},  
		    'onUploadSuccess' : function(file, data, response) {
		    	$("#upload_file").parent().removeClass('mini-error');;
		    	$("#upload_file").append("");
		    	if(response==true){//如果服务器返回200表示成功
		    		var data = data.substr(1,data.length-2);
		    		$("#iconimage").attr("src",ctx+data+"?"+Math.random());//重新生成缩略图
		    		
	    			$("#iconimage").show();
	    			
	    			mini.get("icon_path").setValue(data);
	    		}else{
	    			showMsg("上传失败","danger");
	    		}
	    }
	});

	$("#serviceName").removeAttr("checked"); 
function error(id){
	id.parent().addClass('mini-required mini-error');
	id.append("<span class=\"mini-errorIcon\" title=\"不能为空\" data-placement=\"right\" stype=\"\"></span>");
}
function errorRemove(id){
	id.parent().removeClass('mini-error');
	id.append("");
}
