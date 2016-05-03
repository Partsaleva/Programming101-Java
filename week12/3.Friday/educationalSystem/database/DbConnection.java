package educationalSystem.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DbConnection {

	public static void main(String[] args) throws SQLException {
		SQLQuery sql=new SQLQuery();
		//sql.createDatabase();
	}

	
	public Connection getConnectionToDb(){
		Connection connection=null;
		try {
			
			String dbUrl="jdbc:postgresql://192.168.0.100:5432/testDB?allowMultiQueries=true";
			String user="postgres";
			String pass="mariana";
			connection=DriverManager.getConnection(dbUrl, user, pass);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
}
