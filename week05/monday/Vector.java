package monday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Vector {

	public static void main(String[] args) {
		ArrayList <Double> magn = new ArrayList <Double> (Arrays.<Double>asList (1.,2.,3.,4.,5.,5.,5.));
		ArrayList <Double> magn2 = new ArrayList <Double> (Arrays.<Double>asList (0.,6.,2.,4.,5.,4.,6.));
		Vector vector=new Vector(magn, 1);
		Vector vector2=new Vector(magn2, 1);
		Vector vector3=new Vector(vector2);
		System.out.println(vector.toString());
		System.out.println(vector.dimension());
		System.out.println(vector.length());
		System.out.println(vector2.equal(vector3));
	    System.out.println(vector.hashCode());
		System.out.println();
	
		System.out.println(vector.addVector(vector3).toString());
		System.out.println(vector.add(3).toString());
		System.out.println(vector.subtract(4).toString());
		System.out.println(vector.multiply(3).toString());
		System.out.println(vector.divide(2).toString());
		System.out.println(vector.dotProduct(vector3).toString());

	}

	ArrayList<Double> magnitude=new ArrayList<>();
	private int direction;
	//Create a constructor that takes a variable number of arguments - the coordinates
	public Vector(ArrayList<Double> magnitude,int direction){
		setMagnitude(magnitude);
		setDirection(direction);
		
	}
	
	public ArrayList<Double> getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(ArrayList<Double> magnitude) {
		this.magnitude=magnitude;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		if(direction!=1 && direction != -1){
			System.out.println("1 and -1 are allowed");
		}
		else{
			this.direction = direction;
		}
	}

	//Create a constructor that copies an existing vector
	public Vector(Vector other){
		this.magnitude=other.magnitude;
		this.direction=other.direction;
	}
	
	//Think of a way to get and set each coordinate of the vector
	double getCoordinate(int index){
		return this.getMagnitude().get(index);
	}
	void setCoordinate(int index, double d){
		this.getMagnitude().set(index, d);
	}
	//Create a method for returning the dimensionality of the vector 
	//(E.g. for a 3D vector it should return 3)
	int dimension(){
		return getMagnitude().size();
	}

	//Create a method for returning the length of the vector
	double length(){
		double sum=0, diff=0;
		for(int i=0; i< getMagnitude().size()-1; i++){
			diff=getMagnitude().get(i)-getMagnitude().get(i+1);
			sum+=diff*diff;
		}
		return Math.sqrt(sum);
	}
	//Override toString()
	public String toString(){
		return new String("( magnitude: "+getMagnitude().toString()+
				", direction: "+getDirection());
	}
	//Override equals()
	public boolean equal(Vector other){
		return this.getMagnitude().equals(other.getMagnitude()) && 
				this.getDirection() == other.getDirection();
		
	}
	//Override hashCode()
	public int	hashCode(){
		int hash = 17;
	    hash = hash * 23 + getMagnitude().hashCode();
	    hash = hash * 23 + getMagnitude().hashCode();
	    return hash;
	}
	//define methods add(Vector vector), subtract(Vector vector between vectors (First check 
	//if the 2 vectors have the same dimension! If they don't, print a message that they cannot be added.)
	Vector addVector(Vector other){	
		for(int i=0; i< magnitude.size(); i++){
			this.setCoordinate(i,(this.getCoordinate(i)+other.getCoordinate(i)));		
		}
		return this;
	}
		
	
	//define methods add(float by), subtract(flaot by), multiply(float by), divide(float by) 
	//between a vector and a scalar
	Vector add(double by){
		for(int i=0; i< getMagnitude().size(); i++){
			this.setCoordinate(i,(int) (this.getCoordinate(i)+by));;			
		}
		return this;
	}
	Vector subtract(double by){
		for(int i=0; i< getMagnitude().size(); i++){
			this.setCoordinate(i,(int) (this.getCoordinate(i)-by));;			
		}
		return this;
	}
	Vector multiply(double by){
		for(int i=0; i< getMagnitude().size(); i++){
			this.setCoordinate(i,this.getCoordinate(i)*by);;			
		}
		return this;
	}
	Vector divide(double by){
		for(int i=0; i< getMagnitude().size(); i++){
			this.setCoordinate(i,(int)this.getCoordinate(i)/by);;			
		}
		return this;
	} 
	
	//define dotProduct(Vector vector) - the dot product of 2 vectors (First check if 
	//the 2 vectors have the same dimension!)
	Vector dotProduct(Vector other){
		if(this.getMagnitude().size()!=other.getMagnitude().size()){
			System.out.println("different sizes");
		}
		else{
			for(int i=0; i< magnitude.size(); i++){
				this.setCoordinate(i,(this.getCoordinate(i)*other.getCoordinate(i)));		
			}
		}
		return this;
	}
}



