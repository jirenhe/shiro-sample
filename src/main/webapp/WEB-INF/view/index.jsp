<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/taglib.jspf" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="permissionName"/>
	<button id="bt_checkPermission1">click</button>
	<button id="bt_checkPermission2">check1</button>
	<button id="bt_checkPermission3">check2</button>
	<button id="bt_hello">hello</button>
	<button id="bt_loginOut">登出</button>
</body>
<script type="text/javascript">
	require(["index"],function(page){
		page.initPage();
	});
</script>
</html>