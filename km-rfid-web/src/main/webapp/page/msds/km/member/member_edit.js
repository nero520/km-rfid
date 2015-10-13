mini.parse();




var province = mini.get("province");
var city = mini.get("city");
var area = mini.get("area");
var brand = mini.get("brand");
var series = mini.get("series");
var year = mini.get("year");



function provinceChange(e) {
    var id = province.getValue();
    city.setValue("");
    area.setValue("");
    var url = ctx+"/bespeak/getArea.action?parent=" + id
    city.setUrl(url);
    city.select(0);
}

function cityChange(e) {
    var id = city.getValue();
    area.setValue("");
    var url = ctx+"/bespeak/getArea.action?parent=" + id
    area.setUrl(url);
    area.select(0);
}

function onBrand(e) {
    var id = brand.getValue();
    series.setValue("");
    year.setValue("");
    var url = ctx+"/bespeak/getModelList.action?level=2&pid=" + id;
    series.setUrl(url);
    series.select(0);
}

function onSeries(e) {
    var id = series.getValue();
    year.setValue("");
    var url = ctx+"/bespeak/getModelList.action?level=3&pid=" + id;
    year.setUrl(url);
    year.select(0);
}




var grid = mini.get("datagrid_member");
grid.load();


var Genders = [{ id: 1, text: '已确认' }, { id: 2, text: '已完成'}];
function onGenderRenderer(e) {
    for (var i = 0, l = Genders.length; i < l; i++) {
        var g = Genders[i];
        if (g.id == e.value) return g.text;
    }
    return "";
}

grid.on("drawcell", function (e) {
	
	 var record = e.record;
	 var column = e.column;
	 var field  = e.field;
	 var value  = e.value;
//	 action列，超连接操作按钮
	 if (field == "action") {
		 
	     e.cellStyle = "text-align:center";
	     e.cellHtml = '<a href="javascript:getBespeakInfo(\'true\',\'' + record.id + '\',\'编辑预约单\')">修改</a>&nbsp; ';
		 
	 }
	 if(field == "bespeakSn"){
		 e.cellStyle = "text-align:center";
	     e.cellHtml = '<a href="javascript:getBespeakInfo(\'false\',\'' + record.id + '\',\'查看预约单\')">'+record.bespeakSn+'</a>&nbsp; ';
	 }
});

/**
 * 根据ID查询预约单
 */
function getBespeakInfo(isEdit,recordId,title)   {          
	
	parent.addTabUrl(ctx+"/bespeak/getBespeak.action?isEdit="+isEdit+"&id="+recordId,title);
}


var form = new mini.Form("#editform");
function searchByPhone(type,newPhone) {
		var phone = mini.getbyName("phone").getValue();
		if(type == "1"){
			phone = newPhone;
		}
		
	
		if(phone == '' || phone.length != 11){
			return;
		}
		$.ajax({
			url : ctx+'/bespeak/getMemberByPhone.action?phone=' + phone,
			cache : false,
			success : function(text) {
				
				form.setData(text);
				
				//设置隐藏域的值，用于创建预约单时校验车主信息是否已经保存
				var license = mini.getbyName("license_check");
				license.setValue(text.license);
				
				//设置区域下拉列表值
				province.setValue(text.province);
				
				var url = ctx+"/bespeak/getArea.action?level=2&parent=" + text.province;
			    city.setUrl(url);
				city.setValue(text.city);
				
				var urlarea = ctx+"/bespeak/getArea.action?level=3&parent=" + text.city;
			    area.setUrl(urlarea);
				area.setValue(text.area);
				
				//设置车型下拉列表值
				brand.setValue(text.shopId);
				
				var urlseries = ctx+"/bespeak/getModelList.action?level=2&pid=" + text.shopId;
				series.setUrl(urlseries);
				series.setValue(text.seriesId);
				
				
				var urlyear = ctx+"/bespeak/getModelList.action?level=3&pid=" + text.seriesId;
			    year.setUrl(urlyear);
				year.setValue(text.modelId);

				//加载当前用户预约单
				grid.setUrl(ctx+"/bespeak/getBespeakList.action");
				grid.load({ memberId:text.id });

			}
		});
	
}




function cancelRow() {
	CloseWindow("close");
}
function saveOrUpdate() {

	form.validate();
	if (form.isValid() == false)
		return;
	var o = form.getData();
	var json = mini.encode(o);
	
	var provinceId = province.getValue();
	var cityId = city.getValue();
	var areaId = area.getValue();
	var sex = mini.getbyName("sex").getValue();
	var buyDate = mini.formatDate ( mini.getbyName("buyDate").getValue(), "yyyy-MM-dd" );
	var lastServiceDate = mini.formatDate ( mini.getbyName("lastServiceDate").getValue(), "yyyy-MM-dd" );
	var modelId = year.getValue();
	var modelName = brand.getText()+series.getText()+year.getText();
	
	$.ajax({
		url : ctx+"/bespeak/saveOrUpdateMember.action",
		type : "post",
		data: {
			id:         mini.getbyName("id").getValue(),
			memberModelId:         mini.getbyName("memberModelId").getValue(),
			phone:  	mini.getbyName("phone").getValue(),
			name: 		mini.getbyName("name").getValue(),
			sex:  mini.getbyName("sex").getValue(),
			province:     provinceId,
			city:  cityId,
			area:    areaId,
			address : mini.getbyName("address").getValue(),
			fullAddress : province.getText()+city.getText()+area.getText()+mini.getbyName("address").getValue(),
			buyDate : buyDate,
			mileage : mini.getbyName("mileage").getValue(),
			lastServiceDate : lastServiceDate,
			license : mini.getbyName("license").getValue(),
			vin : mini.getbyName("vin").getValue(),
			modelGroupName : modelName,
			modelId : modelId
		},
		success : function(text) {
			
			if(text == true){
				msg('操作成功');
				searchByPhone("1",mini.getbyName("phone").getValue());
			}else{
				mini.alert(text);
			}
			
//			CloseWindow("success");
		},
		error : function(text, textStatus, errorThrown) {
			mini.alert("操作失败,请重试");
//			CloseWindow(text.responseText);
		}
	});
}



function addBespeak(){
	form.validate();
	if (form.isValid() == false)
		return;
	
	var memberId = mini.getbyName("id").getValue();
	var memberModelId = mini.getbyName("memberModelId").getValue();
	var license =  mini.getbyName("license_check").getValue();
	if(memberId == '' || license == '' || memberModelId == ''){
		mini.alert("请先保存车主信息");
		return;
	}
	var url = ctx+'/bespeak/toBespeak.action?isEdit=true&memberId='+memberId+'&memberModelId='+memberModelId;
	var title = '新增预约单';
	parent.addTabUrl(url,title);
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