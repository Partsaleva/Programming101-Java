package theOne;
import theOne.Matrix;

 public class Main {

	public static void main(String[] args) {
		Matrix m=new Matrix(20,10);
		m.operate(m);
		System.out.println(m.toString());
		Matrix g=m,b=m;
		
		g.grayscale(g);
		System.out.println(g.toString());
		
		b.brightnesReduce(b, 0.1);
		System.out.println(b.toString());
	}

}
