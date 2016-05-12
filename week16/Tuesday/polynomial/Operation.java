package polynomial;

import java.util.ArrayList;
import java.util.List;

public class Operation {

	
	//Add, substract and multiplicate Polynomials
	public Polynomial makeOperation(Polynomial a, Polynomial b, char operation){
		double oper=0;
		List<Member<Number,Integer>> members=new ArrayList<Member<Number,Integer>>();
		
		for (Member<Number,Integer> mem1 : a.getPolinom()) {
			for (Member<Number,Integer> mem2 : b.getPolinom()) {
				
				if(mem1.compareTo(mem2)==0){
					mem1.setMark(true);
					mem2.setMark(true);
					
					if (operation=='+') {
						oper=add(mem1, mem2);
					} else if(operation=='-'){
						oper=subtract(mem1, mem2);
					} 
					members.add(new Member<Number,Integer>(oper, mem1.getDegree()));
				}
			}
		}
		for (Member<Number,Integer> member : a.getPolinom()) {
			if (member.getmark()==false) {
				members.add(member);
			}
		}
		for (Member<Number,Integer> member : b.getPolinom()) {
			if (member.getmark()==false) {
				members.add(member);
			}
		}
		return new Polynomial(members);
		
	}

	public Polynomial multiplicatePolynomials(Polynomial a, Polynomial b) {
		List<Member<Number, Integer>> members = new ArrayList<Member<Number, Integer>>();

		for (Member<Number, Integer> mem1 : a.getPolinom()) {
			for (Member<Number, Integer> mem2 : b.getPolinom()) {
				members.add(new Member<Number, Integer>(mem1.getCoef().doubleValue() * 
						mem2.getCoef().doubleValue(), 
						mem1.getDegree() + mem2.getDegree()));

			}
		}
		return new Polynomial(members);
	}
		
		
		
	
	
	private double add(Member<Number,Integer> a, Member<Number,Integer> b){
		return a.getCoef().doubleValue() + b.getCoef().doubleValue();
		
	}
	private double subtract(Member<Number,Integer> a, Member<Number,Integer> b){
		return a.getCoef().doubleValue() - b.getCoef().doubleValue();
		
	}
	
	//Method for multiplicating the polynomial by a constant
	public Polynomial multiplPolynomialByConstant(int c, Polynomial p){
		List<Member<Number,Integer>> polinom=new ArrayList<>();
		for (Member<Number,Integer> member : p.getPolinom()) {
			polinom.add(new Member<Number, Integer>(c * member.getCoef().doubleValue(), member.getDegree()));
		}
		return new Polynomial(polinom);		
	}
	
	//Method for returning the first derivative of a Polynomial
	//For example the Polynomial 2x^4 + 3x^2 - 10x + 3 has a first derivative 8x^3 + 6x - 10
	public Polynomial getFirstDerivative (Polynomial p){
		List<Member<Number,Integer>> polinom=new ArrayList<>();
		for (Member<Number,Integer> m : p.getPolinom()) {
			polinom.add(new Member<Number,Integer>(m.getCoef().doubleValue() * m.getDegree(), m.getDegree()-1));
		}
		return new Polynomial(polinom);
		
	}
	//Method for evaluating a Polynomial
	public double evaluatePolynomial(Polynomial p, double x){
		double result=0;
		for (Member<Number,Integer> m : p.getPolinom()) {
			result+=m.getCoef().doubleValue()* (Math.pow(x, m.getDegree()));
		}
		return result;
		
	}

}
