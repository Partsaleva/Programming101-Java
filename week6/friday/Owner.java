package friday;


public class Owner{

	private String firstName;
	private String lastName;
	private int age;

	Owner(String firstName,String lastName, int age) throws InvalidNameException, InvalidInputException{
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws InvalidNameException{
		if(firstName.length()<2 || firstName.length()>20 || firstName.matches("^[a-zA-z]")){
			throw new InvalidNameException("not valid first name");
		}
		else{
			this.firstName = firstName;
		}	
	}

	public String getLastName() {
		
		return lastName;
	}

	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName.length()<2 || lastName.length()>20 || lastName.matches("^[a-zA-z]")){
			throw new InvalidNameException("not valid last name");
		}
		else{
			this.lastName = lastName;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws InvalidInputException {
		if(age<18 || age >120){
			throw new InvalidInputException("Age must be between 18 and 120");
		}
		else{
			this.age = age;
		}
	}	
	
}
