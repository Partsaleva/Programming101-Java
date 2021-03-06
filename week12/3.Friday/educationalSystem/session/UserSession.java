package educationalSystem.session;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import educationalSystem.database.SQLQuery;
import educationalSystem.models.QuestionAnswers;

public class UserSession {

	
	public  void startTest(String userName){
		TestPreparation test=new TestPreparation();
		SQLQuery query=new SQLQuery();
		List<QuestionAnswers> quiz;
		try {
			quiz = query.getTestQuestions(test.createListOfNumbers());
			int points=solve(test.getQuiz(quiz));
			System.out.println("Result: "+points);
			
			submitResult(userName, points);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	private int solve(List<QuestionAnswers> quiz){
		Scanner scan=new Scanner(System.in);
		int answer;
		int points=0;
		for (QuestionAnswers qa : quiz) {
			System.out.println(qa.getQ().getText());
			for (int i = 0; i < qa.getAns().size(); i++) {
				System.out.println((i+1)+ ". " +qa.getAns().get(i).getData());
			}
			answer=scan.nextInt();
			if (qa.getAns().get(answer-1).isCorrect() == true) {
				points+=1;
			}
		}
		scan.close();
		return points;
	}
	
	private static void submitResult(String user, int points) throws SQLException{
		SQLQuery s=new SQLQuery();
		s.putScore(user,points);
	}
}
