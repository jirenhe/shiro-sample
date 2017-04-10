<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/taglib.jspf" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello
	<shiro:principal />
	!
	<br />
	<shiro:hasRole name="r1">  
		拥有r1角色<br />
	</shiro:hasRole>
	<shiro:lacksRole name="rx">  
    	没有角色rx<br />
	</shiro:lacksRole>
	<shiro:hasAnyRoles name="r1,rx">  
		拥有角色r1或rx<br />
	</shiro:hasAnyRoles>
	<shiro:hasPermission name="user:create">  
		拥有权限user:create<br />
	</shiro:hasPermission>
	<shiro:lacksPermission name="px">  
		没有权限px<br />
	</shiro:lacksPermission>
</body>
</html>