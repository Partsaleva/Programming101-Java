package week16;

import java.util.ArrayList;
import java.util.List;

public class Run {

	public static void main(String[] args) {
		String p1="2x^4 + 3x^2 - 10x + 3";
		String p2="8x^3 + 6x - 10";
		parse(p1);
		parse(p2);

	}

	public static void parse(String p) {
		List<Member> members = new ArrayList<Member>();
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
					members.add(new Member(Integer.parseInt(memParts[0]), 
							Integer.parseInt(memParts[1].substring(1))));
				}
				else{
					members.add(new Member(Integer.parseInt(memParts[0]), 1));
				}
			}
			else{
				//is a number -> degree =0
				members.add(new Member(Integer.parseInt(mem), 0));
			}
		}
		Polynomial polinomial=new Polynomial(members);
		System.out.println(polinomial);
	}
	
	
	
	
}
