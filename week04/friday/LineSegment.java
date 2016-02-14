package friday;

public final class LineSegment {

	public static void main(String[] args) {
		try{
			Point p1=new Point(2,3);
			Point p2=new Point(5,6);
			//Point p3=new Point(p2);
			LineSegment line1=new LineSegment(p1,p2);
			System.out.println(line1.toString());
			System.out.println(line1.getLength());
			System.out.println(line1.hashCode());
		}catch(NullPointerException e){
			System.err.println("NullPointerException: " + e.getMessage());
		}
	}

	Point start;
	Point end;
	
	//constructor with 2 arguments of type Point - the two ends of the line segment
	LineSegment(Point start, Point end){
		if(start.equals(end)){
			throw new NullPointerException("Cannot create a line segment with zero length");
		}
		else{
			this.start=start;
			this.end=end;
		}
	}
	//constructor that makes a copy of a LineSegment
	public LineSegment(LineSegment other) {
		this.start=other.start;
		this.end=other.end;			
	}
	//2 getter methods for displaying the two ends of the segment
	public Point getStart(){
		return start;
	}
	public Point getEnd(){
		return end;
	}
	//calculates the length of the segment
	public double getLength(){
		double X=end.getX()-start.getX();
		double Y=end.getY()-start.getY();
		return Math.sqrt(X*X+Y*Y);
	}
	//Override toString(): Line[(x1,y1), (x2,y2)]
	public String toString(){
		String result="";
		result+="["+start.toString()+","+end.toString()+"]";
		return result;
	}
	//Override equals()
	public boolean equals(LineSegment other){
		return this.start==other.start&& this.end==other.end;	
	}
	//Override hashCode():
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + start.hashCode();
	    hash = hash * 23 + end.hashCode();
	    return hash;
	}
}
