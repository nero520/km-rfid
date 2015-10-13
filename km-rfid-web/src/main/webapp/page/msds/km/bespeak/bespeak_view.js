var form = new mini.Form("#editform");
mini.parse();
var company = mini.get("companyId");

function SetData(data) {
    if (data.action == "edit") {
        data = mini.clone(data);
        $.ajax({
            url: ctx + "/orderLog/getId.action?id=" + data.id,
            cache: false,
            success: function (text) {
                form.setData(text);
                form.setChanged(false);
            }
        });
    }
}
function cancelRow() {
    CloseWindow("close");
}


function aaaaaa(){
	
	//获取工序列表
    var rows = $('.srvItem');
	var a,b,p,data=[];
	var prices = rows.find('[name=processName]');
	rows.each(function(i,v){
		++i;
		a = mini.get('a' + i);
		b = mini.get('b' + i);
		p = mini.get('p' + i);
		data.push({
			'processPId':a.getValue(),
			'processid':b.getValue(),
			'processPName':a.getText(),
			'processName':b.getText(),
			'price':p.getValue()
		});
	})
	
	var jsonText = JSON.stringify(data);
	
	alert(jsonText);
	
}

function updateRow() {

    form.validate();
    if (form.isValid() == false)
        return;
    var o = form.getData();
    var json = mini.encode(o);

    var bespeakDate = mini.formatDate(mini.getbyName("bespeakDate").getValue(), "yyyy-MM-dd HH:mm:ss");

    $.ajax({
        url: ctx + "/bespeak/saveOrUpdateBespeak.action",
        type: "post",
        data: {
            id: mini.getbyName("id").getValue(),
            problem: mini.getbyName("problem").getValue(),
            answer: mini.getbyName("answer").getValue(),
            laborcost: mini.getbyName("laborcost").getValue(),
            totalPrice: mini.getbyName("totalPrice").getValue(),
            bespeakDate: bespeakDate,
            companyId: company.getValue(),
            memberId: mini.getbyName("memberId").getValue(),
            memberModelId: mini.getbyName("memberModelId").getValue(),
            bespeakSn: mini.getbyName("bespeakSn").getValue()
        },
        success: function (text) {
            CloseWindow("success");
        },
        error: function (text, textStatus, errorThrown) {
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

/**
var tbody = $("#serviceItems").children("tbody"), inBefore;
inBefore = $(".inBefore");
function onDeptChanged(e) {
    var f, s, tr, trIndex;
    tr = $(this.getEl()).closest('tr');
    trIndex = tr.index() + 1;
    f = mini.get('a' + trIndex);
    s = mini.get('b' + trIndex);

    var id = f.getValue(); // first.getValue();
    s.setValue("");

    var url = "/kmo2o/bespeak/getSecondById.action?id=" + id
    s.setUrl(url);

    s.select(0);
}



   //获取工序列表
    var rows = $('.srvItem');
	var a,b,p,data=[];
	var prices = rows.find('[name=processName]');
	rows.each(function(i,v){
		++i;
		a = mini.get('a' + i);
		b = mini.get('b' + i);
		p = mini.get('p' + i);
		data.push({
			'processId':a.getValue(),
			'processPid':b.getValue(),
			'processName':a.getText(),
			'processPname':b.getText(),
			'price':p.getValue()
		});
	})
	
	var jsonText = JSON.stringify(data);
 

function addRow() {
    var tr, trNum, trs;
    tr = $(this).closest('tr');
    trs = inBefore.prevAll();
    trNum = trs.length + 1;
    $('<tr class="srvItem"><td class="form-label">服务项目：</td><td><input class="mini-combobox" id="a' +
        trNum + '" style="width: 150px;" textfield="processName" valuefield="id" onvaluechanged="onDeptChanged" url="/kmo2o/bespeak/getFirstLevel.action" shownullitem="true" /></td><td><input class="mini-combobox" id="b' +
        trNum + '" style="width: 150px;" textfield="processName" valuefield="id" /></td><td class="form-label" style="text-align:right;">金额：</td><td style="width: 150px;"><input name="price" id="p' +
        trNum + '" class="mini-textbox" style="width: 90%;" /></td><td><a class="dcr">-</a><a class="icr">+</a></td></tr>').
    insertBefore(inBefore);
    mini.parse();
    if (trs.filter('.srvItem').length === 1) {
        tr.find('.dcr').show();
    }
    tr.find('.icr').hide();
}
function removeRow() {
    var tr, trs, ptmp, trIndex;
    tr = $(this).closest('tr');

    trs = $(inBefore.prevAll().get().reverse());
    trIndex = trs.index(tr);
    mini.get('a' + (trIndex + 1)).destroy();
    mini.get('b' + (trIndex + 1)).destroy();
    mini.get('p' + (trIndex + 1)).destroy();
    tr.removeClass("srvItem").hide();

    trs = tbody.children('.srvItem');

    if (trs.length === 1) {
        trs.first().find('.dcr').hide().
        end().find('.icr').show();
    }
    trs.last().find('.icr').show();
}
$('body').on('click', '.icr', function (e) {
    e.preventDefault();
    addRow.call(this);
}).on('click', '.dcr', function (e) {
    e.preventDefault();
    removeRow.call(this);
});

*/