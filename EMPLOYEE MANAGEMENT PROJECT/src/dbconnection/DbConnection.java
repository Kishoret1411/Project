package dbconnection;

import java.sql.*;

public class DbConnection {

	public Connection con;
	public Statement s;

	public DbConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","Kishore");
		 s = con.createStatement();
		
		
		
	}

}
