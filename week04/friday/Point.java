package friday;

public final class Point {

	public static void main(String[] args) {
		Point p1=new Point(); Point p2=new Point(2,3);
		Point p3=new Point(p2); 
		Point p4=new Point(p1); 
		System.out.println(p3.equals(p2));
		System.out.println(getOrigin().toString());
		System.out.println(p3.toString());
		System.out.println(p4.toString());
		System.out.println(p3.hashCode());
	}

	private double x;
	private double y;
	
	//constructor with 2 arguments - the x and the y coordinate
	public Point(double x, double y){
		this.x=x;
		this.y=y;
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
	
	public double getY() {
		return y;
	}
	
	//static method that returns the origin of the coordinate system Point getOrigin()
	public static Point getOrigin(){
		return new Point();
	}
	//Override toString() to return the coordinates of the point. Point(x, y) E.g. Point(2,5)
	public String toString(){
		String result="";
		result+="("+this.getX()+","+this.getY()+")";
		return result;
	}
	//Override equals()
	 public boolean equals(Point other){
		 return this.getX()==other.getX()&&this.getY()==other.getY();
	 }
	 
	 //Override hashCode()
	 public int hashCode() {
	        int hash = 17;
	        hash = (int) (hash * 23 + x/11);
	        hash = (int) (hash * 23 + y/11);
	        return hash;
	}
}
