package serializeBank;


public class Owner{


	private static final long serialVersionUID = 1242316004734170323L;
	private String firstName;
	private String lastName;
	private int age;
	UserInputChecker uic=new UserInputChecker();
	UserInputChecker.PersonNameValidator nameValidator=uic.new PersonNameValidator();
	UserInputChecker.PersonAgeValidator ageValidator=uic.new PersonAgeValidator();
	Owner(String firstName,String lastName, int age){
		this.firstName=nameValidator.validate(firstName);
		this.lastName=nameValidator.validate(lastName);
		this.age=Integer.parseInt(ageValidator.validate(Integer.toString(age)));
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {	
		return lastName;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Owner [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
}
