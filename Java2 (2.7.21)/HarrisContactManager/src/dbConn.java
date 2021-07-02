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
	
	public void UpdateBusiness(String f, String l, String em, String addr1, String addr2, String city, String postcode, String bustel, String id)
	{
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
}
