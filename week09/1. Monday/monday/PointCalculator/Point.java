package monday.PointCalculator;

public class Point {

	private final int x;
	private final int y;
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public double calculateDist(Point other) {
		//((x1 - x2)^2 + (y1 - y2)^2)^-2 
		return Math.sqrt(Math.pow(this.x - other.x, 2) - Math.pow(this.y - other.y, 2));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
