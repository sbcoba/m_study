<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	이건 jsp입니다.
	<% for (int i=1; i<10; i++) {%>
	이건반복문입니다. <%=i %><br/> 
	<% }%>
	<br/>
	이건 서블릿에서 계산된 결과입니다.<%= request.getAttribute("cal") %>
</body>
</html>