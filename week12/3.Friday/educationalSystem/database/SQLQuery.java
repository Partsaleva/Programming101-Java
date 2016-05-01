package educationalSystem.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import educationalSystem.models.QuestionAnswers;

public class SQLQuery {

	public void createDatabase() throws SQLException{
		DbConnection dbConn = new DbConnection();
		Connection dbConnection = dbConn.getConnectionToDb();
		PreparedStatement preparedStatement = null;
		try {
			System.out.println("Connected");
			List<String> initialQueries = initialQueries();
			// System.out.println(initialQueries);

			for (String query : initialQueries) {
				preparedStatement = dbConnection.prepareStatement(query);
				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	public List<String> initialQueries(){
		List <String> queries=new ArrayList<>();
		String tableQuestions="create table questions("
				+ "q_id int not null,"
				+ "question varchar (255),"
				+ "primary key(q_id)"
				+ ");";
		queries.add(tableQuestions);
		System.out.println("Created table questions");
		
		String tableAnswers="create table answers("
				+ "a_id int not null,"
				+ "q_id int not null,"
				+ "answer varchar(255),"
				+ "isCorrect boolean,"
				+ "primary key(a_id),"
				+ "FOREIGN KEY (q_id) REFERENCES questions(q_id)"
				+ ");";
		queries.add(tableAnswers);
		System.out.println("Created table answers");
		
		String tableScore="create table scoreboard("
				+ "username varchar(50) not null,"
				+ "score int,"
				+ "primary key(username)"
				+ ");";
		queries.add(tableScore);
		System.out.println("Created table scoreboard");
		
		StringBuilder questionQuery=new StringBuilder("INSERT INTO questions VALUES");
		StringBuilder answerQuery=new StringBuilder("INSERT INTO answers VALUES");
		//fill tables 
		String boolValue="'true'";
		for (int i = 1; i <= 20; i++) {
			questionQuery.append("(" + i + "," + "'Question" + i + "'"+"),");
			for (int j = 1; j <= 7; j++) {
				if (j%3==0) {
					boolValue="'false'";
				}
				answerQuery.append("(" + j+i + "," + i + ","+ "'Answer" + j+ "'"+"," + boolValue + "),");	
				boolValue="'true'";
			}
		}
		questionQuery.setCharAt(questionQuery.length()-1, ';');
		answerQuery.setCharAt(answerQuery.length()-1, ';');
		
		queries.add(questionQuery.toString());
		queries.add(answerQuery.toString());
		return queries;
	}
	
	public List<QuestionAnswers> getTestQuestions() throws SQLException{
		List<QuestionAnswers> result=new ArrayList<>();
		String queryQ="SELECT q_id, question "
				+ "FROM questions "
				+ "ORDER BY RANDOM() "
				+ "LIMIT 10";
		String queryA="";
		DbConnection dbConn=new DbConnection();
		ResultSet rs=null;
		Connection dbConnection=dbConn.getConnectionToDb();
		PreparedStatement preparedStatement=null;
		try {		
			System.out.println("Connected");
			preparedStatement=dbConnection.prepareStatement(queryQ);
			rs=preparedStatement.executeQuery();
			while(rs.next()){
				int id=rs.getInt("q_id");
				String data=rs.getString("question");
				System.out.println(id+" "+data);
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

		return null;
		
	}
}
