<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Movie tickets:</h1>
<form action = "q10.jsp" method = "get">
Username:<input type="text" name="us"><br>
Age:<input type="number" name="age"><br>
<input type="submit" value="submit">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Ticket price:Rs.
<%
String us = request.getParameter("us");
int age = Integer.parseInt(request.getParameter("age"));
if(age>62)
{
%>
50
<%
}
else if(age<10)
{
%>
30
<%
}
else
{
%>
80
<%
}
%>
</body>
</html>