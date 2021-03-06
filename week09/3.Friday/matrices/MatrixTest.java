package matrices;

public class MatrixTest {

	public static void main(String[] args) {
		Matrix A=new Matrix(4, 4); 
		A.fillMatrix();
		Matrix B=new Matrix(4, 4);
		B.fillMatrix();
		Matrix C=new Matrix(4, 4);
		try {
			multiply(A, B, C);
		} catch (Exception e) {
			e.printStackTrace();
		}
		A.print();
		B.print();	
		C.print();
	}
	
	public static void multiply(Matrix A, Matrix B,Matrix C) throws Exception{
		Multiplier[][] m=new Multiplier[A.getRow()][B.getCol()];
		if(A.getRow()!=B.getCol()){
			throw new Exception("Row!= Col");
		}
		else{
			for (int i = 0; i < A.getRow(); i++) {
				for (int j = 0; j < B.getCol(); j++) {
					m[i][j]=new Multiplier(i,j,A,B,C);
					m[i][j].start();
					try {
						m[i][j].join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
}
