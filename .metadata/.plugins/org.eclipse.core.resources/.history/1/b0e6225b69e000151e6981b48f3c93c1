package week1;
/*35. Credit card validation
Implement a function, called is_credit_card_valid(String number),
 which returns True/False based on the following algorithm:
Each credit card number must contain odd count of digits.
We transform the number with the following steps (based on the fact that we start from index 0)
All digits, read from right to left, at even positions (index), remain the same.
Every digit, read from right to left, at odd position is replaced by the result, that is obtained from doubling the given digit.
After the transformation, we find the sum of all digits in the transformed number.
The number is valid, if the sum is divisible by 10.*/
public class CreditCardValidation {

	public static void main(String[] args) {
		CreditCardValidation num=new CreditCardValidation();
		System.out.println(num.isCreditCardValid("79927398715"));
		System.out.println(num.isCreditCardValid("79927398713"));

	}

	public boolean isCreditCardValid(String number){
		if (number.length()%2==0){
			return false;
		}
		int sum=0;
		for(int i=0; i<number.length(); i++){
			if(i%2==0){			
				sum+=Character.getNumericValue(number.charAt(i));
			}
			else{				
				sum+=2*Character.getNumericValue(number.charAt(i));
			}
		}
		return sum%10==0;
	}
	
}