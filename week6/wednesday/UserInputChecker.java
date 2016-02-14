package wednesday;


public class UserInputChecker {

	public static void main(String[] args) {
		String name="ab";
		UserInputChecker uic=new UserInputChecker();
		UserInputChecker.PersonNameValidator nameValidation=uic.new PersonNameValidator();
		UserInputChecker.BulgarianPhoneNumberValidator phoneValidation=uic.new BulgarianPhoneNumberValidator();
		UserInputChecker.PersonAgeValidator ageValidator=uic.new PersonAgeValidator();
		UserInputChecker.CreditCardNumberValidator creditcardValidaion=uic.new CreditCardNumberValidator();
		UserInputChecker.IpVersion4Validator IpVersion4Val=uic.new IpVersion4Validator();
		UserInputChecker.IpVersion6Validator IpVersion6Val=uic.new IpVersion6Validator();
		UserInputChecker.MacAddressValidator MacAddressVal=uic.new MacAddressValidator();
		nameValidation.validate(name);
		//phoneValidation.validate("+359888111000");
		ageValidator.validate("13");
		creditcardValidaion.validate("1111 1111 1111 1111");
		IpVersion4Val.validate("255.255.250.240");
		IpVersion6Val.validate(name);
		MacAddressVal.validate("01-23-45-67-89-ab");
		
	}

	private String input;
	UserInputChecker(){
		this.input=input;
	}
	public interface Validator{
		public void validate(String input);
	}
	
	private class PersonNameValidator implements Validator{

		@Override
		public void validate(String input) {
			if(input.length()<2 || input.length()>100){
				throw new IllegalArgumentException("Name is less then 2 or bigger then 100");
			}
		}
		
	}

	class BulgarianPhoneNumberValidator implements Validator{

		@Override
		public void validate(String input) {
			if(input.matches("^[0-9]\\+")|| input.length()!= 13 || 
					input.indexOf(1)!='3' || input.indexOf(2)!='5' || input.indexOf(3)!='9'){
				throw new IllegalArgumentException("Not a bulgarian number");
			}		
		}
	}

	class PersonAgeValidator implements Validator{

		@Override
		public void validate(String input) {
			int age=Integer.parseInt(input);
			if(age<0||age>127){
				throw new IllegalArgumentException("age must be between 0 and 127");
			}
		}
	}

	class CreditCardNumberValidator implements Validator{

		@Override
		public void validate(String input) {
			String[] parts=input.split(" ");
			if(parts.length!=4){
				throw new IllegalArgumentException("not valid credit cart number");
			}
			for(String s:parts){
				if(s.matches("^[0-9]") || s.length()!=4){
					throw new IllegalArgumentException("not valid credit cart number");
				}
			}
		}}

	class IpVersion4Validator implements Validator{
		@Override
		public void validate(String input) {
			String[] parts=input.split(".");
			if(parts.length!=4){
				throw new IllegalArgumentException("not valid IPV4 address");

			}
			for(String s: parts){
				int num=Integer.parseInt(s);
				if(num<0||num>255){
					throw new IllegalArgumentException("not valid IPV4 address");
				}
			}
			if(input.endsWith(".")){
				throw new IllegalArgumentException("not valid IPV4 address");

			}
		}
	}

	class IpVersion6Validator implements Validator{
		@Override
		public void validate(String input) {
			
		}}

	class MacAddressValidator implements Validator{
		//Six groups of two hexadecimal digits separated by hyphens (-), like 01-23-45-67-89-ab
		//Six groups of two hexadecimal digits separated by colons (:), like 01:23:45:67:89:ab
		//Three groups of four hexadecimal digits separated by dots (.), like 0123.4567.89ab
		@Override
		public void validate(String input) {
			String[] p1=input.split("-");
			String[] p2=input.split(":");
			String[] p3=input.split(".");
			if(p1.length!=6 || p2.length!=6 ||p3.length!=3){
				throw new IllegalArgumentException("not valid MAC address");
			}
			for(String s:p1){
				if(s.matches("^[0-9] A-F a-f")|| s.length()!=2);
				throw new IllegalArgumentException("not valid MAC address");
			}
			for(String s:p2){
				if(s.matches("^[0-9] A-F a-f") || s.length()!=2);
				throw new IllegalArgumentException("not valid MAC address");
			}
			for(String s:p3){
				if(s.matches("^[0-9] A-F a-f") || s.length()!=4);
				throw new IllegalArgumentException("not valid MAC address");
			}
		}}


}
