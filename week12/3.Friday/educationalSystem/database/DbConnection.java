package educationalSystem.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {

	public static void main(String[] args) {
		DbConnection conn=new DbConnection();
		Statement stat=null;
		try {
			
			System.out.println("Connected");
			List<String> initialQueries= conn.initialQueries();
			System.out.println(initialQueries);
		
			ResultSet rs=null;
			for (String query : initialQueries) {
				stat=conn.getConnectionToDb().createStatement();
				rs=stat.executeQuery(query);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public List<String> initialQueries(){
		List <String> queries=new ArrayList<>();
		String tableQuestions="create table questions("
				+ "q_id int not null,"
				+ "question varchar (255),"
				+ "primary key(q_id)"
				+ ");";
		//queries.add(tableQuestions);
		System.out.println("Created table questions");
		
		String tableAnswers="create table answers("
				+ "a_id int not null,"
				+ "q_id int not null,"
				+ "answer varchar(255),"
				+ "isCorrect boolean,"
				+ "FOREIGN KEY (q_id) REFERENCES questions(q_id)"
				+ ");";
		//queries.add(tableAnswers);
		System.out.println("Created table answers");
		String tableScore="create table scoreboard("
				+ "username varchar(50) not null,"
				+ "score int,"
				+ "primary key(username)"
				+ ");";
		//queries.add(tableScore);
		System.out.println("Created table scoreboard");
		
		//fill tables 
		String boolValue="'true'";
		for (int i = 1; i <= 20; i++) {
			queries.add("INSERT INTO questions(q_id, question)"
					+ " VALUES (" + i + "," + "Question" + i + ");");
			for (int j = 1; j <= 7; j++) {
				if (j%3==0) {
					boolValue="'false'";
				}
				queries.add("INSERT INTO answers(a_id, q_id, answer, isCorrect)"
						+ " VALUES(" + j + "," + i + ","+ "Answer" + j+ "," + boolValue + ");");	
			}
		}
		return queries;
	}
}