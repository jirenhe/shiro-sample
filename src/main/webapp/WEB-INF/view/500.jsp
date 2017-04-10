<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<html>
<head>
<title>500!</title>
</head>
<body>
	<H2>500错误!</H2>
	<hr />
	<P>错误描述：</P>
	该页无法显示!
	<br /> 请与系统管理员联系!
	<P>错误信息：</P>
	<%
		Throwable e = (Throwable) request.getAttribute("ex");
		if (e != null) {
			out.println("Exception：" + e.getClass().getSimpleName() + "<br/>");
			out.println("message：" + e.getMessage() + "<br/>");
			out.println("stack：" + "<br/>");
			for (StackTraceElement ele : e.getStackTrace()) {
				out.println(ele);
			}
		} else {
			out.println("Unkonwn exception.");
		}
	%>
</body>
</html>