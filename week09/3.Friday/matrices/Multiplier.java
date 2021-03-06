package matrices;



public class Multiplier extends Thread{

	private int row;
	private int col;
	Matrix A;
	Matrix B;
	Matrix result;
	
	public Multiplier(int row, int col, Matrix A,Matrix B, Matrix result){
	    this.row = row;
        this.col = col;
        this.A = A;
        this.B = B;
        this.result = result;
	}
	
	
	public void run(){
		 result.getMatrix()[row][col] = new Cell(A.getMatrix()[row][col].getValue() * 
				 								B.getMatrix()[col][row].getValue()) ; 
	}

}
