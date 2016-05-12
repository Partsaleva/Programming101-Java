package polynomial;

import java.util.ArrayList;
import java.util.List;

public class Run {

	public static void main(String[] args) {
		Operation oper=new Operation();
		Run run=new Run();
		String p1="2x^4 + 3x^2 - 10x + 3";
		String p2="8x^3 + 6x - 10";
		Polynomial pol1=run.parse(p1);
		Polynomial pol2=run.parse(p2);
		System.out.println(oper.makeOperation(pol1,pol2,'+'));
		System.out.println(oper.makeOperation(pol1,pol2,'-'));
		System.out.println(oper.makeOperation(pol1,pol2,'*'));
		System.out.println(oper.multiplPolynomialByConstant(4, pol1));
		System.out.println(oper.getFirstDerivative(pol1));
		System.out.println(oper.evaluatePolynomial(pol1, 2));
	}

	public  Polynomial parse(String p) {
		List<Member<Number,Integer>> members = new ArrayList<Member<Number,Integer>>();
		//replace all whitesp and replace - with +- so we get get sign
		String polin=p.replaceAll("\\s", "").replaceAll("-", "+-");
		//System.out.println(polin);
		String[] polinomialParts = polin.split("\\+");
		
		for (String mem : polinomialParts) {
			//if the part contains x -> has a degree>0
			if(mem.contains("x")){
				String[] memParts=mem.split("x");
				//degree >1
				if (memParts.length > 1) {
					members.add(new Member<Number,Integer>(Integer.parseInt(memParts[0]), 
							Integer.parseInt(memParts[1].substring(1))));
				}
				else{
					members.add(new Member<Number,Integer>(Integer.parseInt(memParts[0]), 1));
				}
			}
			else{
				//is a number -> degree =0
				members.add(new Member<Number,Integer>(Integer.parseInt(mem), 0));
			}
		}
		return new Polynomial(members);
		
	}
	
	
	
	
}
