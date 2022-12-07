<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Voting Page</h1>
<form action="q4" method = "get">
FirstName:<input type="text" name="fn"><br>
LastName:<input type="text" name="ln"><br>
E-MailID:<input type="text" name="mail"><br>
Date of Birth:<input type="date"  name="dob"><br>
<input type="submit" value="submit">
</form>
</body>
</html>



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

/**
 * Servlet implementation class q4
 */
@WebServlet("/q4")
public class q4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String dob=request.getParameter("dob");
		LocalDate givendate =LocalDate.parse(dob); 
		LocalDate currentdate = LocalDate.now();
		int age=Period.between(givendate,currentdate).getYears();
		System.out.println(age);
		if(age>18)
			out.println("<html><body>Valid</body></html>");
		else
			out.println("<html><body>Invalid</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
