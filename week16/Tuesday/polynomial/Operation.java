package polynomial;

import java.util.ArrayList;
import java.util.List;

public class Operation {

	
	//Add, substract and multiplicate Polynomials
	public Polynomial makeOperation(Polynomial a, Polynomial b, char operation){
		int oper=0;
		List<Member> members=new ArrayList<Member>();
		
		for (Member mem1 : a.getPolinom()) {
			for (Member mem2 : b.getPolinom()) {
				
				if(mem1.compareTo(mem2)==0){
					mem1.setMark(true);
					mem2.setMark(true);
					
					if (operation=='+') {
						oper=add(mem1, mem2);
					} else if(operation=='-'){
						oper=subtract(mem1, mem2);
					} else if(operation=='*'){
						oper=multiplicate(mem1, mem2);
					}
					members.add(new Member(oper, mem1.getDegree()));
				}
			}
		}
		for (Member member : a.getPolinom()) {
			if (member.getmark()==false) {
				members.add(member);
			}
		}
		for (Member member : b.getPolinom()) {
			if (member.getmark()==false) {
				members.add(member);
			}
		}
		return new Polynomial(members);
		
	}
	
	private int add(Member a, Member b){
		return a.getCoef() + b.getCoef();
		
	}
	private int subtract(Member a, Member b){
		return a.getCoef() - b.getCoef();
		
	}
	private int multiplicate(Member a, Member b){
		return a.getCoef() * b.getCoef();
		
	}
	//Method for multiplicating the polynomial by a constant
	public Polynomial multiplPolynomialByConstant(int c, Polynomial p){
		List<Member> polinom=new ArrayList<>();
		for (Member member : p.getPolinom()) {
			polinom.add(new Member(c * member.getCoef(), member.getDegree()));
		}
		return new Polynomial(polinom);		
	}
	
	//Method for returning the first derivative of a Polynomial
	//For example the Polynomial 2x^4 + 3x^2 - 10x + 3 has a first derivative 8x^3 + 6x - 10
	public Polynomial getFirstDerivative (Polynomial p){
		List<Member> polinom=new ArrayList<>();
		for (Member m : p.getPolinom()) {
			polinom.add(new Member(m.getCoef() * m.getDegree(), m.getDegree()-1));
		}
		return new Polynomial(polinom);
		
	}
	//Method for evaluating a Polynomial
	public double evaluatePolynomial(Polynomial p, double x){
		double result=0;
		for (Member m : p.getPolinom()) {
			result+=m.getCoef()* (Math.pow(x, m.getDegree()));
		}
		return result;
		
	}

}
