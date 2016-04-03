package matrices;

import java.util.Random;

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
		 result.getMatrix()[row][col] = (A.getMatrix()[row][0] * B.getMatrix()[0][col])+ 
				       (A.getMatrix()[row][1]*B.getMatrix()[1][col]) ; 
	}

}
