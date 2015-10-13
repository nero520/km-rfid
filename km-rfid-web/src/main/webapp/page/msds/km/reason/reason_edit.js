var form = new mini.Form("#editform");
function SetData(data) {
	if (data.action == "edit") {
		data = mini.clone(data);
		$.ajax({
			url : ctx+"/reason/getId.action?id=" + data.id,
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
function updateRow() {
	form.validate();
	if (form.isValid() == false)
		return;
	var o = form.getData();
	var json = mini.encode(o);
	$.ajax({
		url : ctx+"/reason/save.action",
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : json,
		success : function(text) {
			CloseWindow("success");
		},
		error : function(text, textStatus, errorThrown) {
			CloseWindow(text.responseText);
		}
	});
}
function CloseWindow(action) {
	if (action == "close" && form.isChanged()) {
		if (confirm("数据被修改了，是否先保存？")) {
			return false;
		}
	}
	if (window.CloseOwnerWindow) {
		return window.CloseOwnerWindow(action);
	} else {
		window.close();
	}
}