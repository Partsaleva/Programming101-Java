package friday;

public final class Ellipse implements AreaShape,Center{

	public static void main(String[] args) {
		Point center=new Point(2,1);
		double majorAxis=6,minorAxis=3;
		Ellipse ellipse=new Ellipse(majorAxis, minorAxis, center);
		Ellipse copy=new Ellipse(ellipse);
		ellipse.displayCoordinates();
		System.out.println("height: "+ellipse.height());
		System.out.println("width: "+ellipse.width());
		System.out.println("center: "+ ellipse.center());
		System.out.println("Perimeter: "+ellipse.getPerimeter());
		System.out.println("Area: "+ellipse.getArea());
		System.out.println("Ellipse: "+ ellipse.toString());
		System.out.println(ellipse.equals(copy));
		System.out.println("Hashcode: "+ ellipse.hashCode());

	}

	private double majorAxis;
	private double minorAxis;
	private Point center;
	// constructor with 3 arguments - numbers, which describe the major axis and the minor axis and center.
	public Ellipse(double majorAxis,double minorAxis, Point center) {
		this.majorAxis=majorAxis;
		this.minorAxis=minorAxis;
		this.center=center;
	}
	//constructor that makes a copy of an Ellipse
	public Ellipse(Ellipse other){
		this.majorAxis=other.majorAxis;
		this.minorAxis=other.minorAxis;
		this.center=other.center;
	}
	//four methods for displaying each point of the bounds of the ellipse.
	//(e.g. the coordinates of an imaginary rectangle that encloses the ellipse)
	public Point left(){
		return new Point(center().getX() - 0.5*width(), center().getY());
	}
	public Point up(){
		return new Point(center().getX(), center().getY() + 0.5*height());
	}
	public Point right(){
		return new Point(center().getX() + 0.5*width(), center().getY() );
	}
	public Point down(){
		return new Point(center().getX(), center().getY() + 0.5*height());
	}
	
	public void displayCoordinates(){
		System.out.println("Coordinates: "+
				left().toString()+", "+
				up().toString()+", "+
				right().toString()+", "+
				down().toString());
	}
	//method for displaying the center of the ellipse.
	public Point center(){
		return center;
	}
	//encapsulate axises
	public double width(){
		return majorAxis;
	}
	public double height(){
		return minorAxis;
	}
	
	//methods getPerimeter(), getArea()
	public double getPerimeter(){
		double a=majorAxis/2;
		double b=minorAxis/2;
		//Ramanujan approximation
		return Math.PI*(3*(a+b) - Math.sqrt((3*a+b) * (a+3*b)));
	} 
	public double getArea(){
		double a=majorAxis/2;
		double b=minorAxis/2;
		return Math.PI*a*b;
	}
	//Override toString(): Ellipse[(x,y), (height,width)]
	public String toString(){
		return new String("["+center().toString()+", "+"("+height()+", "+width()+")]");
	}
	//Override equals()
	public boolean equals(Ellipse other){
		return this.center().equals(other.center()) && 
				this.width()==other.width() && 
				this.height()==other.height();
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
