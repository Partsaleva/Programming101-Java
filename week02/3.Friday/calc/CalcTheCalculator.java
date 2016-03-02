package calc;

import java.util.Stack;

public class CalcTheCalculator {

	 public static Character[] ops = {'-','+','/','*','!'};
	 
	 static int getPrec(char operator){
		 int prec=0;
		 for (int i = 0; i < ops.length; i++){
			 if(operator==ops[i]){
				 prec=i;
			 }
		 }
		 if(operator=='^'){prec=3;}
		 return prec;
	 }
private static boolean isHigerPrec(char tokens, char character){
    if(getPrec(tokens)<getPrec(character)){
    	return true;
    }
    return false;
} 

	public double calculate(String expression){
		 	char[] tokens = expression.toCharArray();
		 	Stack <Character> operators=new Stack<>();
		 	Stack<Double> numbers = new Stack<>();
		 	//Stack<Double> result = new Stack<>();
		 	for (int i = 0; i < tokens.length; i++)
	        { 
	            // Current token is a number, push it to stack for numbers
	            if (tokens[i] >= '0' && tokens[i] <= '9')
	            {
	                numbers.push((double) tokens[i]-'0');
	            }
	            // Current token is an operator.
	            else if (tokens[i] == '+' || tokens[i] == '-' ||
	                     tokens[i] == '*' || tokens[i] == '/' || 
	                     tokens[i] == '^' || tokens[i] == '!' )
	            {
	                // While top of 'operators' has same or greater precedence to current
	                // token, which is an operator. Apply operator on top of 'operators'
	                // to top two elements in values stack
	                while (!operators.empty() && isHigerPrec(tokens[i], operators.peek()))
	                  numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));
	                
	                // Push current token to 'operators'.
	                operators.push(tokens[i]);
	            }
	            // Current token is an opening brace, push it to 'operators'
	            else if (tokens[i] == '(')
	                operators.push(tokens[i]);
	 
	            // Closing brace encountered, solve entire brace
	            else if (tokens[i] == ')')
	            {
	                while (operators.peek() != '(')
	                	numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));
	                operators.pop();
	            }
	  
		
		}
		 	 // Entire expression has been parsed at this point, apply remaining
	        // operators to remaining values
	        while (!operators.empty())
	        	numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));
	 
	        // Top of 'numbers' contains result, return it
	        return numbers.pop();
	}
 	public static double applyOp(char op, double b, double a)
    {
        if(op=='+')
            return a + b;
        if(op=='-')
            return a - b;
        if(op=='*')
            return a * b;
        if(op=='/'){
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        if(op=='^'){
        	double res=1;
        	for(int i=0; i<b;i++){
        		res*=a;
        	}
        	return res;
        }
       // if(op=='!'){
        	//while
        //}
        return 0;
       }		       
	
}



