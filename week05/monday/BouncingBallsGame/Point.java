package monday.BouncingBallsGame;

public class Point {

	private double x;
	private double y;
	
	//constructor with 2 arguments - the x and the y coordinate
	public Point(double x, double y){
		setX(x);
		setY(y);
	}
	//default constructor which initializes the 
	//Point with the origin of the coordinate system
	Point(){
		x=0; y=0;
	}
	//constructor that makes a copy of a Point
	Point(Point p){
		this.x=p.x;
		this.y=p.y;
	}
	//  methods for displaying the coordinates of the point - getX() and getY()
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
}
