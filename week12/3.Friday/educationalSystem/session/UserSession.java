package educationalSystem.session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

import educationalSystem.database.SQLQuery;
import educationalSystem.models.Answer;
import educationalSystem.models.QuestionAnswers;

public class UserSession {

	public static void main(String[] args){
		UserSession session=new UserSession();
		SQLQuery query=new SQLQuery();
		System.out.println(session.createListOfNumbers());
		try {
			List <QuestionAnswers> quiz=query.getTestQuestions(session.createListOfNumbers());
			System.out.println(session.getQuiz(quiz));
			
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
	
	
	
	List<QuestionAnswers> getQuiz(List<QuestionAnswers> qa){
		for (QuestionAnswers qAns : qa) {
			List<Answer> answers=chooseAnswersToSolve(qAns.getAns());
			qAns.setAns(answers);
		}
		return qa;
		
	}
	//choose 3 wrong and 1 correct answer
			private List<Answer> chooseAnswersToSolve(List<Answer> ans){
				List<Answer> result=new ArrayList<>();
				List<Answer> correct=new ArrayList<>();
				List<Answer> wrong=new ArrayList<>();
				for (Answer answer :ans) {
					if(answer.isCorrect()==true){
						correct.add(answer);
					}
					else{
						wrong.add(answer);
					}
				}
				Random random=new Random();
				//remove one correct
				correct.remove(random.nextInt(1));
				//remove all but 3 wrong
				while(wrong.size()>3){
					wrong.remove(random.nextInt(wrong.size()-1));
				}
				
				result.addAll(correct);
				result.addAll(wrong);
				return result;
			}
}
