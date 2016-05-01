package educationalSystem.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DbConnection {

	public static void main(String[] args) throws SQLException {
		DbConnection dbConn=new DbConnection();
		
		Connection dbConnection=dbConn.getConnectionToDb();
		SQLQuery q=new SQLQuery();
		PreparedStatement preparedStatement=null;
		try {
			
			System.out.println("Connected");
			List<String> initialQueries= q.initialQueries();
			//System.out.println(initialQueries);
		
			for (String query : initialQueries) {
				preparedStatement=dbConnection.prepareStatement(query);
				preparedStatement.executeUpdate();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

		if (preparedStatement != null) {
			preparedStatement.close();
		}

		if (dbConnection != null) {
			dbConnection.close();
		}

	}

	}

	
	public Connection getConnectionToDb(){
		Connection connection=null;
		try {
			
			String dbUrl="jdbc:postgresql://192.168.0.101:5432/testDB?allowMultiQueries=true";
			String user="postgres";
			String pass="mariana";
			connection=DriverManager.getConnection(dbUrl, user, pass);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
}
