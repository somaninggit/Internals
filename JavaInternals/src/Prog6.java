<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="q6" method = "get">
First Number:<input type="text" name="fn"><br>
Second Number:<input type="text" name="sn"><br>
<input type="radio" name="op" value="add">Addition
<input type="radio" name="op" value="sub">Subtraction
<input type="radio" name="op" value="mul">Multiplication
<input type="radio" name="op" value="div">Division
<input type="radio" name="op" value="ex">x^y
<input type="submit" value="submit">
</form>
</body>
</html>

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class q6
 */
@WebServlet("/q6")
public class q6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		double fn = Double.parseDouble(request.getParameter("fn"));
		double sn = Double.parseDouble(request.getParameter("sn"));
		String op = request.getParameter("op");
		double res=0;
		if(op.equals("add"))
			res=fn+sn;
		else if(op.equals("sub"))
			res = fn-sn;
		else if(op.equals("mul"))
			res=fn*sn;
		else if(op.equals("div"))
			res = fn/sn;
		else 
			res = Math.pow(fn, sn);
		out.println("<html><body>Result is: "+res+"</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}