package educationalSystem.session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import educationalSystem.models.Answer;
import educationalSystem.models.QuestionAnswers;

public class TestPreparation {

	private int numberOfQuestions=19;
	private Set<Integer>questionsForSession=new HashSet<Integer>();
	
	//create list of 10 random numbers
	public Set<Integer>createListOfNumbers(){
		Random random=new Random();
		while(questionsForSession.size()<10){
			questionsForSession.add(1 + random.nextInt(numberOfQuestions));
		}
		return questionsForSession;
	}
	
	
	//reduce answers
	List<QuestionAnswers> getQuiz(List<QuestionAnswers> qa){
		for (QuestionAnswers qAns : qa) {
			List<Answer> answers=chooseAnswersToSolve(qAns.getAns());
			qAns.setAns(answers);
		}
		return qa;		
	}
	
	//choose 3 wrong and 1 correct answer from all 
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
