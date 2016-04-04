package matrices;

import java.util.Arrays;
import java.util.Random;

public class Matrix {

	private int row;
	private int col;
	private Cell matrix[][];
	
	public Matrix(int row, int col) {
		this.row=row;
		this.col=col;
		matrix= new Cell[row][col];
	}

	public Cell[][] getMatrix() {
		return matrix;
	}

	//fill matrix with random numbers
	public void fillMatrix(){
		Random r=new Random();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j]=new Cell(r.nextInt(10));
			}
		}		
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}

	public void print(){
		for (int i = 0; i <row; i++) {
	        for (int j = 0; j < col; j++) {
	            System.out.print(matrix[i][j]+" ");
	        }
	        System.out.println();
	    }
		System.out.println();
	} 
	
}
