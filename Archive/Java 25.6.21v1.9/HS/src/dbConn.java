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
	
	public ResultSet UpdatePersonal()
	{
		ResultSet rs=null;
		String sql="{call UpdatePersonal()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
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
	
	public ResultSet InsertBusiness()
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
	
	public ResultSet UpdateBusiness()
	{
		ResultSet rs=null;
		String sql="{call UpdateBusiness()}";
		try {
			java.sql.CallableStatement cst= con.prepareCall(sql);
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
}
