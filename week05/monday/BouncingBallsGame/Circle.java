package monday.BouncingBallsGame;

public class Circle {

	private double radius;
	private Point center;
	//constructor with two arguments - numbers, which describes its radius and center.
	public Circle(double radius, Point center){
		this.setRadius(radius);
		this.setCenter(center);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
}
