package matrices;

public class MatrixTest {

	public static void main(String[] args) {
		Matrix A=new Matrix(3, 4); 
		A.fillMatrix();
		Matrix B=new Matrix(3, 4);
		B.fillMatrix();
		Matrix C=new Matrix(3, 4);
		Multiplier m=new Multiplier(A.getRow(),A.getCol(), A, B, C);
		A.print();
		B.print();

	}

}
