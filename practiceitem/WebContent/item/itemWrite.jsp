<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력 완료된 정보</h1>
<table width='800' border='1'>
	<c:forEach var="item" items="${itemList}">
		<tr class = "record">
			<td> ${item.name} </td>
			<td> ${item.price} </td>
			<td> ${item.description} </td>
		</tr>
</c:forEach>
</table>
</body>
</html>