package friday;

public final class Circle implements AreaShape,Center{

	public static void main(String[] args) {
		Point center=new Point(2,1);
		double radius=5;
		Circle circle=new Circle(radius,center);
		Circle copy=new Circle(circle);
		circle.displayCoordinates();
		System.out.println("center: "+ circle.center());
		System.out.println("Perimeter: "+circle.getPerimeter());
		System.out.println("Area: "+circle.getArea());
		System.out.println("Circle: "+ circle.toString());
		System.out.println(circle.equals(copy));
		System.out.println("Hashcode: "+ circle.hashCode());

	}

	private double radius;
	private Point center;
	//constructor with two arguments - numbers, which describes its radius and center.
	public Circle(double radius, Point center){
		this.radius=radius;
		this.center=center;
	}
	//constructor that makes a copy of a Circle
	public Circle(Circle other){
		this.radius=other.radius;
		this.center=other.center;
	}
	//four methods for displaying each point of the bounds of the circle. 
	//(e.g. the coordinates of an imaginary rectangle that encloses the circle)
	public Point left(){
		return new Point(center().getX() - radius, center().getY());
	}
	public Point up(){
		return new Point(center().getX(), center().getY() + radius);
	}
	public Point right(){
		return new Point(center().getX() + radius, center().getY());
	}
	public Point down(){
		return new Point(center().getX() , center().getY() - radius);
	}
	
	public void displayCoordinates(){
		System.out.println("Coordinates: "+
				left().toString()+", "+
				up().toString()+", "+
				right().toString()+", "+
				down().toString());
	}
	//method for displaying the center of the circle.
	public Point center(){
		return center;
	}
	public double getRadius(){
		return radius;
	}
	//methods getPerimeter(), getArea()
	public double getPerimeter(){
		return 2*Math.PI*radius;
	} 
	public double getArea(){
		return Math.PI*radius*radius;
	}
	///Override toString(): Circle[(x,y), (height,width)]
	public String toString(){
		return new String("["+center().toString()+", "+"("+radius+")]");
	}
	//Override equals()
	public boolean equals(Circle other){
		return this.center().equals(other.center()) && 
				this.radius==other.radius;
	}
	//Override hashCode()
	public int	hashCode(){
		int hash = 17;
	    hash = hash * 23 + left().hashCode();
	    hash = hash * 23 + up().hashCode();
	    hash = hash * 23 + right().hashCode();
	    hash = hash * 23 + down().hashCode();
	    return hash;
	}

	
}
