package educationalSystem;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) {
		DbConnection conn=new DbConnection();
		try {
			Statement stat=conn.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("PostgreSQL JDBC Driver Registered!");
			
			String dbUrl="jdbc:postgresql://192.168.0.101:5432/testDB";
			String user="postgres";
			String pass="mariana";
			connection=DriverManager.getConnection(dbUrl, user, pass);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
