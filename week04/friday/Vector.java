package friday;

import java.util.ArrayList;

public class Vector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private ArrayList<Point> arguments=new ArrayList<>();
	//Create a constructor that takes a variable number of arguments - the coordinates
	public Vector(ArrayList<Point>arguments){
		for(int i=0; i<arguments.size(); i++){
			this.arguments.add(arguments.get(i));
		}
	}
	
	//Create a constructor that copies an existing vector
	public Vector(Vector v){
		this.arguments=v.arguments;
	}
	
	//Think of a way to get and set each coordinate of the vector
	public Point getCoordinate(int index){
		return arguments.get(index);
	}
	public void setCoordinate(int index, Point p){
		this.arguments.add(index, p);
	}
	
	//Create a method for returning the dimensionality of the vector 
	//(E.g. for a 3D vector it should return 3)
	int dimension(){
		return this.arguments.size();
	}
	
	//Create a method for returning the length of the vector
	//Override toString()
	//Override equals()
	//Override hashCode()
	//define methods add(Vector vector), subtract(Vector vector between vectors (First check if the 2 vectors have the same dimension! If they don't, print a message that they cannot be added.)
	//define methods add(float by), subtract(flaot by), multiply(float by), divide(float by) between a vector and a scalar
	//define dotProduct(Vector vector) - the dot product of 2 vectors (First check if the 2 vectors have the same dimension!)
}
