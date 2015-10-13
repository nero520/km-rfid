//重置表单数据,formId为#+id
function resetSearch(formId) {
	form = new mini.Form(formId);
	form.reset();
}

//提示信息
function msg(message){
	baseMsg("success",message);
}
function error(message){
	baseMsg("warning",message);
}

function baseMsg(type,message){
	var icon = null;
	var title = null;
	if(type=="success"){
		title = "提示";
		icon = "info";
	}else if(type=="warning"){
		title = "错误";
		icon = "warning";
	}
	mini.showMessageBox(
	{
		title: title,    
		message: message,
		buttons: ["ok"],    
		iconCls: "mini-messagebox-"+icon,
		html: '',   
		callback: function(action){
		}
	});
}
//数据验证    begin
function onEnglishValidation(e) {
	if (e.isValid) {
		if (isEnglish(e.value) == false) {
			e.errorText = "必须输入英文";
			e.isValid = false;
		}
	}
}
function onEnglishAndNumberValidation(e) {
	if (e.isValid) {
		if (isEnglishAndNumber(e.value) == false) {
			e.errorText = "必须输入英文+数字";
			e.isValid = false;
		}
	}
}
function onChineseValidation(e) {
	if (e.isValid) {
		if (isChinese(e.value) == false) {
			e.errorText = "必须输入中文";
			e.isValid = false;
		}
	}
}
function onIDCardsValidation(e) {
	if (e.isValid) {
		var pattern = /\d*/;
		if (e.value.length < 15 || e.value.length > 18
				|| pattern.test(e.value) == false) {
			e.errorText = "必须输入15~18位数字";
			e.isValid = false;
		}
	}
}

// //////////////////////////////////
/* 是否英文 */
function isEnglish(v) {
	var re = new RegExp("^[a-zA-Z\_]+$");
	if (re.test(v))
		return true;
	return false;
}

/* 是否英文+数字 */
function isEnglishAndNumber(v) {
	var re = new RegExp("^[0-9a-zA-Z\_]+$");
	if (re.test(v))
		return true;
	return false;
}

/* 是否汉字 */
function isChinese(v) {
	var re = new RegExp("^[\u4e00-\u9fa5]+$");
	if (re.test(v))
		return true;
	return false;
}

/* 自定义vtype */
mini.VTypes["englishErrorText"] = "请输入英文";
mini.VTypes["english"] = function(v) {
	var re = new RegExp("^[a-zA-Z\_]+$");
	if (re.test(v))
		return true;
	return false;
}
//数据验证   end