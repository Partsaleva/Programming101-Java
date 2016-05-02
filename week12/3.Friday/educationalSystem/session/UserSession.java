package educationalSystem.session;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import educationalSystem.database.SQLQuery;

public class UserSession {

	public static void main(String[] args){
		UserSession session=new UserSession();
		SQLQuery query=new SQLQuery();
		System.out.println(session.createListOfNumbers());
		try {
			query.getTestQuestions(session.createListOfNumbers());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private String user="user1";
	private int numberOfQuestions=19;
	private Set<Integer>questionsForSession=new HashSet<Integer>();
	
	
	
	private Set<Integer>createListOfNumbers(){
		Random random=new Random();
		while(questionsForSession.size()<10){
			questionsForSession.add(1 + random.nextInt(numberOfQuestions));
		}
		return questionsForSession;
	}
}
