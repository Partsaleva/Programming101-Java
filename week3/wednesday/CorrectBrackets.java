package wednesday;

public class CorrectBrackets {

	public static void main(String[] args) {
		CorrectBrackets brackets=new CorrectBrackets();
		String[] expr={"()()()((()))","()()())))((())(","())(()"};
		for(int i=0; i<expr.length;i++){
			System.out.println(brackets.correctBrackets(expr[i]));
		}
	}

	public boolean correctBrackets(String exression){
		int count=0;
		char[] expr=exression.toCharArray();
		for(int i=0; i<expr.length;i++){
			if(count<0){
				return false;
			}
			if(expr[i]=='('){
				count++;
			}
			else if(expr[i]==')'){
				count--;
			}
		}
		return count==0;
	} 
}
