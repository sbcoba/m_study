<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp start!!</title>
</head>
<body>
	<h3>jsp start</h3>
	
	이것은 멤버 페이지입니다.
	<% 
	for(int i = 1; i < 10; i ++) {
	%>
	안녕하세요 ^^ <%=i %> <br/>
	<%} %>
</body>
</html>