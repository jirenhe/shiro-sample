define([], function() {

	var page = {

		initPage : function() {
			this.bindEvent();
		},

		bindEvent : function() {
			$("#bt_checkPermission1").on("click", function() {
				var permissionName = $('#permissionName').val();
				permissionName && ($.ajax({
					url : contextPath + '/demo/checkPermission1',
					dataType : "json",
					timeout : $.timeout,
					data : {
						permission : permissionName,
					},
					success : function(data){
						if(data == '1'){
							alert("have "+permissionName+" permission!");
						}else{
							alert("have no "+permissionName+" permission!");
						}
					}
				}));
			});
			
			$("#bt_checkPermission2").on("click", function() {
				window.location.href = contextPath + "/demo/checkPermission2";
			});
			
			$("#bt_checkPermission3").on("click", function() {
				window.location.href = contextPath + "/demo/checkPermission3";
			});
			
			$("#bt_hello").on("click", function() {
				window.location.href = contextPath + "/demo/hello";
			});
			
			$("#bt_loginOut").on("click", function() {
				window.location.href = contextPath + "/demo/loginOut";
			});
		}

	};

	return {
		initPage : $.proxy(page.initPage, page)
	};
});