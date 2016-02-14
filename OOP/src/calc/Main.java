package calc;

public class Main {

	public static void main(String[] args) {
		CalcTheCalculator calculator=new CalcTheCalculator();
		String expr="2^3+(5+3)^2";
		//String[] expr={"2^3+(5+3)^2"};
		//for(int i=0; i<expr.length;i++){
		//	System.out.println(calculator.calculate(expr[i]));
		//}
		System.out.println(calculator.calculate(expr));
	}

}
