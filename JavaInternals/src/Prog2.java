import java.sql.*;
import java.util.*;
public class q2 {
	static void display(ResultSet rs)
	{
		String f1,f2,f3,f4;
		int f5;
		try
		{
			while(rs.next())
			{
				f1 = rs.getString(1);
				f2 = rs.getString(2);
				f3 = rs.getString(3);
				f4 = rs.getString(4);
				f5 = rs.getInt(5);
				System.out.println(f1+" "+f2+" "+f3+" "+f4+" "+f5);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String driver = "com.mysql.jdbc.Driver";
		String dc = "jdbc:mysql://localhost:3306/";
		String db = "mydb";
		String us = "root";
		String pass="";
		String query1 = "select * from department";
		String query2="select * from department where yearestablished=(?)";
		String query3="select * from department where id=(?) and name=(?)";
		//String query4="insert into department values('CIV','CIVIL ENGINEEERING','1998','G',16)";
		try {
			Connection con = null;
			Class.forName(driver);
			con = DriverManager.getConnection(dc+db,us,pass);
			System.out.println("Connected to database");
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(query1);
			display(rs1);
			PreparedStatement ps1 = con.prepareStatement(query2);
			System.out.println("Enter the year: ");
			String year = sc.next();
			ps1.setString(1,year);
			ResultSet rs2  = ps1.executeQuery();
			display(rs2);
			PreparedStatement ps2 = con.prepareStatement(query3);
			System.out.println("Enter Dept_ID ");
			String id1 = sc.next();
			System.out.println("Department name:");
			String name1 = sc.nextLine();
			sc.next();
			System.out.println("name:"+name1+" id:"+id1);
			ps2.setString(1, id1);
			ps2.setString(2, name1);
			ResultSet rs3 = ps2.executeQuery();
			display(rs3);
			//PreparedStatement ps3 = con.prepareStatement(query4);
			//int c = ps3.executeUpdate();
			//if(c!=0)
				//System.out.println("Details updated successfully");
			con.close();
			System.out.println("Disconnected from Database");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}