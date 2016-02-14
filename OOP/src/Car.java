
public class Car {


	private boolean testing;
	private int mileage;
	
	public Car(){
		setTesting(testing);
		setMileage(mileage);
	}
	
	boolean isEcoFriendly(boolean testing){
		return testing==true;
	}
	
	public void setTesting(boolean test){
		testing=test;
	}
	public void setMileage(int mil) {
		mileage=mil;
	}
}
