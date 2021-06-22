import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConn {

	String connString = "harrisandsons.cxw8qnxlxaco.us-east-1.rds.amazonaws.com/HarrisAndSons";
	String username = "HarrisAndSons";
	String password = "HarrisAndSons";
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
	

}
