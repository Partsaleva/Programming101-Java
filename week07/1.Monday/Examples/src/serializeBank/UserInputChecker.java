package serializeBank;



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
		phoneValidation.validate("+359888111000");
		ageValidator.validate("13");
		creditcardValidaion.validate("1111 1111 1111 1111");
		IpVersion4Val.validate("255.255.250.240");
		IpVersion6Val.validate("2001:0db8:0000:0000:0000:ff00:0042:8329");
		MacAddressVal.validate("01-23-45-67-89-ab");
		
	}


	public UserInputChecker(){
		
	}
	public interface Validator{
		public String validate(String input);
	}
	
	 class PersonNameValidator implements Validator{
		@Override
		public String validate(String input) {
			if(input.length()<2 || input.length()>100){
				throw new IllegalArgumentException("Name is less then 2 or bigger then 100");
			}		
			return input;		
		}
	}
		
	

	class BulgarianPhoneNumberValidator implements Validator{

		@Override
		public String validate(String input) {
			if(input.matches("//+?[359]8[7-9][0-9]{7}")){
				throw new IllegalArgumentException("Not a bulgarian number");
			}
			return input;	
		}
	}

	class PersonAgeValidator implements Validator{

		@Override
		public String validate(String input) {
			int age=Integer.parseInt(input);
			if(age<0||age>127){
				throw new IllegalArgumentException("age must be between 0 and 127");
			}
			return input;	
	}
	}
	class CreditCardNumberValidator implements Validator{

		@Override
		public String validate(String input) {
			String[] parts=input.split(" ");
			if(parts.length!=4){
				throw new IllegalArgumentException("not valid credit cart number");
			}
			for(String s:parts){
				if(s.matches("^[0-9]") || s.length()!=4){
					throw new IllegalArgumentException("not valid credit cart number");
				}
			}
			return input;
			
		}}

	class IpVersion4Validator implements Validator{
		@Override
		public String validate(String input) {
			String[] parts=input.split("\\.");
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
			return input;
		}
	}

	class IpVersion6Validator implements Validator{
		@Override
		public String validate(String input) {
			if(!input.matches("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}")){
				throw new IllegalArgumentException("not valid IPV6 address");
			}
			return input;	
			                                                         
		}}

	class MacAddressValidator implements Validator{
		@Override
		public String validate(String input) {
			if(!input.matches("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$")){
				throw new IllegalArgumentException("not valid MAC address");
			}
			return input;	
		}}


}
