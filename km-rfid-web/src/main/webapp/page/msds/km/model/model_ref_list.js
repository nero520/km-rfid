 mini.parse();

    var grid = mini.get("grid1");

    //动态设置URL
    grid.setUrl(ctx+"/model/refDataList.action");
//    alert(grid.url);
    //也可以动态设置列 grid.setColumns([]);

    grid.load();

    function GetData() {
        var row = grid.getSelected();
        return row;
    }
    function search() {
        var brandName = mini.get("brandName").getValue();
        var shopName = mini.get("shopName").getValue();
        var name = mini.get("name").getValue();
        grid.load({ brandName: brandName,shopName:shopName,name:name });
    }
    function onKeyEnter(e) {
        search();
    }
    function onRowDblClick(e) {
        onOk();
    }
    //////////////////////////////////
    function CloseWindow(action) {
        if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
        else window.close();
    }

    function onOk() {
        CloseWindow("ok");
    }
    function onCancel() {
        CloseWindow("cancel");
    }