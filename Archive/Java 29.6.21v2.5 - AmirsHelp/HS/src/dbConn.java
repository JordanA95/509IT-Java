//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

//import com.mysql.cj.jdbc.CallableStatement;

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
			e.printStackTrace() ;
			System.out.println("Not Connected");
		}
		
	}
	public ResultSet GetAllPersonal()
	{
		ResultSet rs=null;
		String sql="{call GetAllPersonal()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet InsertPersonal()
	{
		ResultSet rs=null;
		String sql="{call InsertPersonal()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	
	public void AddPersonal (String id, String f, String l, String em, String addr1, String addr2, String city, String postcode, String perphone)
	{
		String sql="{call InsertPersonal(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setString(1, id);
			cst.setString(2, f);
			cst.setString(3, l);
			cst.setString(4, em);
			cst.setString(5, addr1);
			cst.setString(6, addr2);
			cst.setString(7, city);
			cst.setString(8, postcode);
			cst.setString(9, perphone);
			cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet UpdatePersonal (String id, String f, String l, String p, String em, String addr1, String addr2, String city, String postcode, String perphone)
	{
		ResultSet rs=null;
		String sql="{call UpdatePersonal(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			cst.setString(1, id);
			cst.setString(2, f);
			cst.setString(3,  l);
			cst.setString(4,  p);
			cst.setString(5, em);
			cst.setString(6, addr1);
			cst.setString(7, addr2);
			cst.setString(8, city);
			cst.setString(9, postcode);
			rs=cst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet DeletePersonal()
	{
		ResultSet rs=null;
		String sql="{call DeletePersonal()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void DeletePersonal(String id)
	{
		String sql="{call DeletePersonal(?)}";
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
	
	public ResultSet GetAllBusiness()
	{
		ResultSet rs=null;
		String sql="{call GetAllBusiness()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet AddBusiness()
	{
		ResultSet rs=null;
		String sql="{call InsertBusiness()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void AddBusiness (String id, String f, String l, String em, String addr1, String addr2, String city, String postcode, String busphone)
	{
		String sql="{call InsertBusiness(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setString(1, id);
			cst.setString(2, f);
			cst.setString(3,  l);
			cst.setString(4, em);
			cst.setString(5, addr1);
			cst.setString(6, addr2);
			cst.setString(7, city);
			cst.setString(8, postcode);
			cst.setString(9, busphone);
			cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet UpdateBusiness (String id, String f, String l, String em, String addr1, String addr2, String city, String postcode, String busphone)
	{
		ResultSet rs=null;
		String sql="{call UpdateBusiness(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			cst.setString(1, id);
			cst.setString(2, f);
			cst.setString(3,  l);
			cst.setString(4, em);
			cst.setString(5, addr1);
			cst.setString(6, addr2);
			cst.setString(7, city);
			cst.setString(8, postcode);
			cst.setString(9, busphone);
			rs=cst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet DeleteBusiness()
	{
		ResultSet rs=null;
		String sql="{call DeleteBusiness()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void DeleteBusiness(String id)
	{
		String sql="{call DeleteBusiness(?)}";
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
