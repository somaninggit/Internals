import java.sql.*;
import java.util.*;
public class q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String driver="com.mysql.jdbc.Driver";
		String dc = "jdbc:mysql://localhost:3306/";
		String db="mydb";
		String us="root";
		String pass="";
		String query1="select * from movie ";
		String query2="select * from movie order by id limit 1 offset 4";
		String query3="insert into movie values(?,?,?,?,?)";
		String query4="select id from movie where rate<5";
		String query5="select * from movie where id='e'";
		try {
			Connection con = null;
			Class.forName(driver);
			con = DriverManager.getConnection(dc+db,us,pass);
			System.out.println("Connected to database");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = st.executeQuery(query1);
			String f1,f2,f3,f5;
			double f4;
			System.out.println("Details:");
			while(rs1.next())
			{
				f1 = rs1.getString(1);
				f2 = rs1.getString(2);
				f3 = rs1.getString(3);
				f4 = rs1.getDouble(4);
				f5 = rs1.getString(5);
				System.out.println(f1+" "+f2+" "+f3+" "+f4+" "+f5);
			}
			ResultSet rs2 = st.executeQuery(query2);
			rs2.next();
			f1 = rs2.getString(1);
			f2 = rs2.getString(2);
			f3 = rs2.getString(3);
			f4 = rs2.getDouble(4);
			f5 = rs2.getString(5);
			System.out.println(f1+" "+f2+" "+f3+" "+f4+" "+f5);
			PreparedStatement ps = con.prepareStatement(query3);
			System.out.println("Enter id,name,genre,rate and year: ");
			String id = sc.next();
			String name = sc.next();
			String genre = sc.next();
			double rate = sc.nextDouble();
			String year = sc.next();
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, genre);
			ps.setDouble(4, rate);
			ps.setString(5, year);
			int c = ps.executeUpdate();
			if(c!=0)
				System.out.println("Details updated successful");
			ResultSet rs3 = st.executeQuery(query1);
			while(rs3.next())
			{
				f1 = rs3.getString(1);
				f2 = rs3.getString(2);
				f3 = rs3.getString(3);
				f4 = rs3.getDouble(4);
				f5 = rs3.getString(5);
				System.out.println(f1+" "+f2+" "+f3+" "+f4+" "+f5);
			}
			Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs4 = st1.executeQuery(query4);
			while(rs4.next())
			{
				rs4.deleteRow();		
			}
			System.out.println("Row deleted successfully");
			Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs5 = st2.executeQuery(query5);
			while(rs5.next())
			{
				rs5.updateString(3,"Sci-fi");
				rs5.updateRow();
			}
			System.out.println("Row updated succefully");
			con.close();
			System.out.println("Disconnected to database");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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