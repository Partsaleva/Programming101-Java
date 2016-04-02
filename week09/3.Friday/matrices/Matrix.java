package matrices;

import java.util.Arrays;

public class Matrix {

	private int row;
	private int col;
	private int matrix[][];
	
	public Matrix(int row, int col) {
		this.row=row;
		this.col=col;
		matrix= new int[row][col];
	}

	public int[][] getMatrix() {
		return matrix;
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

	@Override
	public String toString() {
		return "Matrix [matrix=" + Arrays.toString(matrix) + "]";
	}

	
}
