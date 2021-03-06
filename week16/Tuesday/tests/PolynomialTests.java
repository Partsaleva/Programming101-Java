package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import polynomial.Operation;
import polynomial.Polynomial;
import polynomial.Run;

public class PolynomialTests {


	@Test
	public void testevaluatePolynomial() {
		Operation o=new Operation();
		Run run=new Run();
		String p1="8x^3 + 6x - 10";
		Polynomial pol1=run.parse(p1);
		double result=o.evaluatePolynomial(pol1, 1);
		assertEquals(4, result, 0.001);
	}

	@Test
	public void testAdd(){
		Operation oper=new Operation();
		Run run=new Run();
		String p1="2x^4 + 3x^2 + 3";
		String p2="8x^2 + 6x - 10";
		Polynomial pol1=run.parse(p1);
		Polynomial pol2=run.parse(p2);
		Polynomial res=oper.makeOperation(pol1,pol2,'+');
		double result=oper.evaluatePolynomial(res, 1);
		assertEquals(12.0, result, 0.001);
	}
	
	@Test
	public void testSubtract(){
		Operation oper=new Operation();
		Run run=new Run();
		String p1="2x^4 + 3x^2 + 3";
		String p2="8x^2 + 6x - 10";
		Polynomial pol1=run.parse(p1);
		Polynomial pol2=run.parse(p2);
		Polynomial res=oper.makeOperation(pol1,pol2,'-');
		double result=oper.evaluatePolynomial(res, 1);
		assertEquals(16.0, result, 0.001);
	}
	
	@Test
	public void testMultiplicate(){
		Operation oper=new Operation();
		Run run=new Run();
		String p1="2x^4 ";
		String p2="8x^2 ";
		Polynomial pol1=run.parse(p1);
		Polynomial pol2=run.parse(p2);
		Polynomial res=oper.multiplicatePolynomials(pol1,pol2);
		double result=oper.evaluatePolynomial(res, 1);
		assertEquals(16, result, 0.001);
	}
}
