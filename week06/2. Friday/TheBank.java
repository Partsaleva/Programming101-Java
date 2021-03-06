import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Map<String, BankAccount> bankAccounts=new HashMap<>();
	
	TheBank(){}
	
	public void addAccount() throws InvalidInputException{
		Scanner scanIn = new Scanner(System.in);
		
		System.out.println("Your first name: ");
		String firstName=scanIn.nextLine();
		
		System.out.println("Your last name: ");
		String lastName=scanIn.nextLine();
		
		System.out.println("Age: ");
		String age=scanIn.nextLine();
		
		scanIn.close();
		
		Owner owner=new Owner(firstName, lastName, Integer.parseInt(age));		
		BankAccount account=new BankAccount(owner, 0, 1,"complex");
		
		bankAccounts.put(account.getAccountNumber(), account);
		System.out.println(account.toString());
	}
	
		private BankAccount bankAccount() throws NonExistingBankAccountException{
			Scanner scanIn = new Scanner(System.in);
			System.out.println("Enter your account number: ");
			String accountNumber=scanIn.nextLine();
			scanIn.close();
			if(!bankAccounts.containsKey(accountNumber)){
				throw new NonExistingBankAccountException("Account doesn't exist");
			}
			return bankAccounts.get(accountNumber);
		}
	
		//It should prompt the user for the bank account number and show its history.
		public void showHistoryOfAccount() throws NonExistingBankAccountException{
			bankAccount().history();
		}
		

		//It should prompt the user for the amount and the bank account number.
		public void addMoney() throws InvalidInputException, NonExistingBankAccountException{
			BankAccount ba=bankAccount();
			Scanner scanIn = new Scanner(System.in);			
			System.out.println("Amount of money to add: ");
			double sumOfmoney=scanIn.nextDouble();
			scanIn.close();
			
			ba.add(sumOfmoney);
		}
		//It should prompt the user for the amount and the bank account number.
		public void withdrawMoney() throws InvalidInputException, 
											ForbidenWithdrawException, 
											NonExistingBankAccountException, 
											InsufficientFundsException{
			BankAccount ba=bankAccount();
			
			Scanner scanIn = new Scanner(System.in);
			System.out.println("Amount of money to take: ");
			double money=scanIn.nextDouble();
			scanIn.close();	

			ba.withdraw(money);
		}
		//It should prompt the user for the origin and destination bank account numbers and the amount
		public void transferMoney() throws InvalidInputException, 
											ForbidenWithdrawException, 
											NonExistingBankAccountException,
											InsufficientFundsException{
			BankAccount ba=bankAccount();
			Scanner scanIn = new Scanner(System.in);
			
			System.out.println("Enter destination account number: ");
			String destAccountNumber=scanIn.nextLine();
			
			System.out.println("Amount of money to transfer: ");
			double money=scanIn.nextDouble();
			scanIn.close();	
			
			ba.transfer(money, bankAccounts.get(destAccountNumber));
		}
		
		//It should prompt the user for bank account number and number of months.
		//It should return the amount after the given number of months.
		public double calculateAmount() throws InvalidInputException, 
											   NonExistingBankAccountException{
			BankAccount ba=bankAccount();
			Scanner scanIn = new Scanner(System.in);	
			System.out.println("months: ");
			int months=scanIn.nextInt();
			scanIn.close();
			
			String typeOfInt=ba.getTypeOfInterest();
			if(typeOfInt.equals("SIMPLE")){
				return (ba.getBalance()*ba.getInterest())/12 *months;
			}
			else if(typeOfInt.equals("COMPLEX")){
				calculateComplexInterest(ba,months);
			}
			
			return ba.getBalance();				
		}
		
		
		private double calculateComplexInterest(BankAccount account, int months) throws InvalidInputException{
			for(int i=0; i<months; i++){
				double balance=account.getBalance();
				account.setBalance(balance*(account.getInterest()/12));
				
			}
			return account.getBalance();			
		}
}
