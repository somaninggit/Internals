Prog 9:
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter subject marks</h1>
<form action="q9.jsp" method = "get">
marks:<input type="number" name="m1"><br>
marks:<input type="number" name="m2"><br>
marks:<input type="number" name="m3"><br>
marks:<input type="number" name="m4"><br>
marks:<input type="number" name="m5"><br>
<input type="submit" value="submit">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.lang.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Report card:</h1>
<%
int m[] = new int[5];
String grade[] = new String[5];
m[0] = Integer.parseInt(request.getParameter("m1"));
m[1] = Integer.parseInt(request.getParameter("m2"));
m[2] = Integer.parseInt(request.getParameter("m3"));
m[3] = Integer.parseInt(request.getParameter("m4"));
m[4] = Integer.parseInt(request.getParameter("m5"));
for(int i=0;i<5;i++)
{
	if(m[i]>=90)
		grade[i] = "S";
	else if(m[i]>=80)
		grade[i] = "A";
	else if(m[i]>=70)
		grade[i] = "B";
	else if(m[i]>=60)
		grade[i] = "C";
	else if(m[i]>=50)
		grade[i] = "D";
	else 
		grade[i] = "FAIL";
}%>
<table>
<thead>
<tr>
<td>marks</td><td>grades</td></tr></thead>
<tbody>
<%for(int i=0;i<5;i++)
	{
	out.println("<tr><td>"+m[i]+"</td><td>"+grade[i]+"</td></tr>");
	}%>
</tbody>
</table>
</body>
</html>