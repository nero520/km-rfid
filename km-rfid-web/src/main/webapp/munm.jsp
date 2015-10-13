
<script type="text/javascript">
	var munmList;
	$(document)
			.ready(
					function() {
						$.ajax({
							url : "${ctx}/permission/MenuList.action",
							dataType : 'json',
							async : false,
							success : function(result) {
								munmList = result;
							}
						});
						var obj = eval(munmList);
						for ( var i = 0; i < obj.length; i++) {
							if (obj[i].parentNode == 0) {
								var content = "<ul class='main_li'>";
								for ( var q = 0; q < obj.length; q++) {
									if (obj[i].id == obj[q].parentNode) {
										content = content
												+ "<li onclick=\"openMainTab('"
												+ obj[q].name + "','"
												+ obj[q].codename
												+ "',true);\">" + obj[q].name
												+ "</li>";
									}
								}
								content = content + "</ul>";
								openMainMunm(obj[i].name, content);
							}
						}

					});

	function openMainMunm(title, content) {
		$('#mainMunm').accordion('add', {
			title : title,
			content : content,
			selected : false
		})

	}
</script>
<div class="easyui-accordion" id="mainMunm" fit='true'></div>