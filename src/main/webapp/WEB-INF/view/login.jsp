<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/taglib.jspf" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<div class="error">${error}</div>
<body>
	<form action="" method="post">
		用户名：
		<input type="text" name="username">
		<br /> 密码：
		<input type="password" name="password">
		<br />
		<input type="submit" value="登录">
	</form>
</body>
</html>