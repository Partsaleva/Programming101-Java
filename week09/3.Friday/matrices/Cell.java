package matrices;

public class Cell {

	private int value;
	
	
	public Cell(int value) {		
		setValue(value);
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[" + value + "]";
	}
	
	
}
