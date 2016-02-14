package friday;

public final class Triangle implements AreaShape,Center{

	public static void main(String[] args) {
		Point a=new Point(1,5);
		Point b=new Point(5,2);
		Point c=new Point(2,1);
		Triangle triangle=new Triangle(a, b, c);
		Triangle copy=new Triangle(triangle);
		triangle.display3Vertices();
		triangle.display3Edges();
		System.out.println("base: "+triangle.base());
		System.out.println("height: "+triangle.height());
		System.out.println("center: "+ triangle.center());
		System.out.println("Perimeter: "+triangle.getPerimeter());
		System.out.println("Area: "+triangle.getArea());
		System.out.println("Rectangle: "+ triangle.toString());
		System.out.println(triangle.equals(copy));
		System.out.println("Hashcode: "+ triangle.hashCode());

	}

	private Point a;
	private Point b;
	private Point c;
	
	//constructor with 3 arguments of type Point - the three points of the triangle.
	//if the points are on the same coordinate axis print a message "Points are on the same axis."
	Triangle(Point a, Point b, Point c){
		if(a.getX()==b.getX()||a.getY()==b.getY() ||
		   c.getX()==b.getX()||c.getY()==b.getY() ||
		   a.getX()==c.getX()||a.getY()==c.getY()){
			System.out.println("Points are on the same axis.");
		}
		else{
			this.a=a; this.b=b; this.c=c;
		}
	}
	//constructor that makes a copy of a Triangle
	Triangle(Triangle other){
		this.a=other.a;
		this.b=other.b;
		this.c=other.c;
	}
	//3 methods for displaying the 3 vertices of the triangle (of type Point).
	public Point getA() {
		return a;
	}
	public Point getB() {
		return b;
	}
	public Point getC() {
		return c;
	}
	
	public void display3Vertices(){
		System.out.println("3 vertices: "+
				getA().toString()+", "+
				getB().toString()+", "+
				getC().toString());
	}
	//3 methods for displaying the 3 edges of the triangle (of type LineSegment)
	public LineSegment AB() {
		return new LineSegment(getA(), getB());
	}

	public LineSegment BC() {
		return new LineSegment(getB(), getC());
	}

	public LineSegment CA() {
		return new LineSegment(getC(), getA());
	}
	
	public LineSegment median() {
		return new LineSegment(getC(), halfBase());
	}
	public void display3Edges(){
		System.out.println("4 edges: "+
				AB().toString()+", "+
				BC().toString()+", "+
				CA().toString());
	}
	//2 methods for displaying the base and height of the triangle
	public double base(){
		return AB().getLength();
	}
	public double height(){
		return (2*getArea())/base();
	}
	//method for displaying the center of the triangle
	public Point center(){
		return new Point(((halfBase().getX() + getC().getX())/3)*2,
				((halfBase().getY() + getC().getY())/3)*2); //TODO
	}
	//help method for calculating center of the triangle
	private Point halfBase(){
		return new Point((getA().getX() + getB().getX())/2, (getA().getY() + getB().getY())/2);
	}
	//methods getPerimeter(), getArea()
	public double getPerimeter(){
		 return AB().getLength() + BC().getLength() + CA().getLength();
	}
	//Heron's Formula
	@Override
	public double getArea(){
		double s=getPerimeter()/2;
		return Math.sqrt(s*(s-AB().getLength())*(s-BC().getLength())*(s-CA().getLength()));
	}
	//Override toString(): Triangle[(x,y), (height,base)]
	@Override
	public String toString(){
		return new String("["+center().toString()+","+"("+height()+","+base()+")]");
	}
	//Override equals()
	public boolean equals(Triangle other){
		return this.AB().getLength()==other.AB().getLength() &&
			   this.BC().getLength()==other.BC().getLength() &&
			   this.CA().getLength()==other.CA().getLength();
	}
	//Override hashCode()
	@Override
	public int	hashCode(){
		int hash = 17;
	    hash = hash * 23 + getA().hashCode();
	    hash = hash * 23 + getB().hashCode();
	    hash = hash * 23 + getC().hashCode();
	    return hash;
	}
}
