<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "q7" method = "get">
<input type="radio" name = "ei" value="area">Area<br>
<input type="radio" name = "ei" value="phno">Phone no.<br>
Enter area/phno: <input type="text" name="wish"><br>
<input type="submit" value="submit">
</form>
</body>
</html>

import java.sql.*;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class q7
 */
@WebServlet("/q7")
public class q7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String wish=request.getParameter("wish");
		String ei = request.getParameter("ei");
		String driver = "com.mysql.jdbc.Driver";
		String dc = "jdbc:mysql://localhost:3306/";
		String db = "mydb";
		String us = "root";
		String pass="";
		String query;
		try
		{
			Connection con = null;
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(dc+db,us,pass);
			System.out.println("Connected to database");
			if(ei.equals("area"))
			{
				query="select * from police where name=?";
			}
			else 
			{
				query="select * from police where phno=?";
			}
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, wish);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String f2,f3,f4;
			int f1;
			f1 = rs.getInt(1);
			f2 = rs.getString(2);
			f3 = rs.getString(3);
			f4 = rs.getString(4);
			out.println("<html><body>"+f1+" "+f2+" "+f3+" "+f4+"</body></html>");
			con.close();
			System.out.println("Disconnected from database");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}