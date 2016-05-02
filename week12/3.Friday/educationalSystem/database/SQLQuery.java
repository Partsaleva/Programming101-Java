package educationalSystem.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	
	public List<QuestionAnswers> getTestQuestions(Set<Integer>questionsForSession) throws SQLException{
		List<QuestionAnswers> result=new ArrayList<>();
		String queryQ="SELECT questions.q_id, question, answer, iscorrect "
				+ "FROM questions,answers "
				+ "where questions.q_id=answers.q_id and questions.q_id=?";
				
		DbConnection dbConn=new DbConnection();
		ResultSet rs=null;
		Connection dbConnection=dbConn.getConnectionToDb();
		PreparedStatement preparedStatement=null;
		
		try {		
			System.out.println("Connected");
			for (Integer i: questionsForSession) {
				preparedStatement=dbConnection.prepareStatement(queryQ);
				preparedStatement.setInt(1, i);
				rs=preparedStatement.executeQuery();
				while(rs.next()){
					int id=rs.getInt("q_id");
					String ques=rs.getString("question");
					String ans=rs.getString("answer");
					boolean corr=rs.getBoolean("isCorrect");
					System.out.println(id+" "+ques+" "+ans+" "+corr);
				}
			}
			
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}
	
			if (dbConnection != null) {
				dbConnection.close();
				System.out.println("Connection is closed");
			}

	}

		return null;
		
	}
	
	
}
