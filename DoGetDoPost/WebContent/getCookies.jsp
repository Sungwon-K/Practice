<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Cookie 읽기</h3>
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		out.println(c.getName()+":"+c.getValue()+"<br>");
	}
%>
</body>
</html>