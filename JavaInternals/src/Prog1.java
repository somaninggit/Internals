import java.sql.*;
public class q1 {
	static void display(ResultSet rs)
	{
		String f1,f2,f3,f4;
		double f5;
		try
		{
			System.out.println("Details: ");
			while(rs.next())
			{
				f1 = rs.getString(1);
				f2 = rs.getString(2);
				f3 = rs.getString(3);
				f4 = rs.getString(4);
				f5 = rs.getDouble(5);
				System.out.println(f1+" "+f2+" "+f3+" "+f4+" "+f5);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String dc = "jdbc:mysql://localhost:3306/";
		String db = "mydb";
		String us="root";
		String pass="";
		String query1 = "select * from employee";
		String query2 = "select * from employee where project='web development'";
		String query3 = "select * from employee where project='web development' and salary>75000";
		String query4 = "select count(id) from employee where salary<50000";
		try {
			Connection con = null;
			Class.forName(driver);
			con = DriverManager.getConnection(dc+db,us,pass);
			System.out.println("Connected to Database");
			Statement st  = con.createStatement();
			ResultSet rs1 = st.executeQuery(query1);
			display(rs1);
			ResultSet rs2 = st.executeQuery(query2);
			display(rs2);
			ResultSet rs3 = st.executeQuery(query3);
			display(rs3);
			ResultSet rs4 = st.executeQuery(query4);
			rs4.next();
			String f = rs4.getString("count(id)");
			System.out.println("Number of employees who have salary less than 50,000/- is "+f);
			con.close();
			System.out.println("Disconnected from Database");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}