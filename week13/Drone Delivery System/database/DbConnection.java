package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		
	}

	public static Connection getDbConnection(){
		
		Connection connection=null;
		try {
			String dbUrl="jdbc:postgresql://192.168.0.100:5432/DroneDeliveryDB";
			String user="postgres";
			String pass="mariana";
			connection=DriverManager.getConnection(dbUrl, user, pass);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}