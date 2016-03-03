package fastAndFurious;

public class Car {

	protected int mileage;
	protected boolean testing;
	
	Car(){
		setMileage(mileage);
		setTesting(testing);
	}
	boolean isEcoFriendly(){
		return getTesting();
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public boolean getTesting() {
		return testing;
	}
	public void setTesting(boolean testing) {
		this.testing = testing;
	}
	
}
