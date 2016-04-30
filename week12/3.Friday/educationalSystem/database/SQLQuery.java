package educationalSystem.database;

import java.util.ArrayList;
import java.util.List;

public class SQLQuery {


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
}
