import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class dbConn {

	String connString ="jdbc:mysql://harris.cxw8qnxlxaco.us-east-1.rds.amazonaws.com:3306/harris";
	String username = "admin";
	String password = "Harrisandsons";
	Connection con = null;
	
	public dbConn()
	{
		/*TryCatch block for connecting to the databsse. If connection succeeds after trying, Connected is printed as output. If connection fails, Catch prints Not Connected*/
		try {
			con = DriverManager.getConnection(connString,username,password);
			System.out.println("Connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Not Connectd");
		}
	}
	public ResultSet GetAllPersonal()
	{
		/*TryCatch block for initiating the selectAllPersonal database stored procedure.*/
		ResultSet rs=null;
		String sql="{call selectAllPersonal()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet GetAllBusiness()
	{
		/*TryCatch block for initiating the selectAllBusiness database stored procedure.*/
		ResultSet rs=null;
		String sql="{call selectAllBusiness()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void UpdatePersonal(String f, String l, String em, String addr1, String addr2, String city, String postcode, String pertel, String id)
	{
		/*TryCatch block for initiating the updatePersonal database stored procedure.*/
		ResultSet rs=null;
		String sql="{call updatePersonal(?,?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			cst.setString(1, id);
			cst.setString(2, f);
			cst.setString(3, l);
			cst.setString(4, em);
			cst.setString(5, addr1);
			cst.setString(6, addr2);
			cst.setString(7, city);
			cst.setString(8, postcode);
			cst.setString(9, pertel);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void UpdateBusiness(String f, String l, String em, String addr1, String addr2, String city, String postcode, String bustel,String id)
	{
		/*TryCatch block for initiating the updateBusiness database stored procedure.*/
		ResultSet rs=null;
		String sql="{call updateBusiness(?,?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			cst.setString(1, id);
			cst.setString(2, f);
			cst.setString(3, l);
			cst.setString(4, em);
			cst.setString(5, addr1);
			cst.setString(6, addr2);
			cst.setString(7, city);
			cst.setString(8, postcode);
			cst.setString(9, bustel);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void AddPersonal(String f, String l, String em, String addr1, String addr2, String city, String postcode, String pertel)
	{
		/*TryCatch block for initiating the insertPersonal database stored procedure.*/
		String sql="{Call insertPersonal(?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setString(1, f);
			cst.setString(2, l);
			cst.setString(3, em);
			cst.setString(4, addr1);
			cst.setString(5, addr2);
			cst.setString(6, city);
			cst.setString(7, postcode);
			cst.setString(8, pertel);
			cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AddBusiness(String f, String l, String em, String addr1, String addr2, String city, String postcode, String bustel)
	{
		/*TryCatch block for initiating the insertBusiness database stored procedure.*/
		String sql="{Call insertBusiness(?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setString(1, f);
			cst.setString(2, l);
			cst.setString(3, em);
			cst.setString(4, addr1);
			cst.setString(5, addr2);
			cst.setString(6, city);
			cst.setString(7, postcode);
			cst.setString(8, bustel);
			cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeletePersonal (String id)
	{
		/*TryCatch block for initiating the deletePersonal database stored procedure.*/
		String sql="{call deletePersonal(?)}";
		java.sql.CallableStatement cst;
		try {
			cst = con.prepareCall(sql);
			cst.setString(1, id);
			cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeleteBusiness (String id)
	{
		/*TryCatch block for initiating the deleteBusiness database stored procedure.*/
		String sql="{call deleteBusiness(?)}";
		java.sql.CallableStatement cst;
		try {
			cst = con.prepareCall(sql);
			cst.setString(1, id);
			cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
