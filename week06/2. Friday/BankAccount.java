

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

	public static void main(String[] args) throws InvalidInputException, InvalidNameException {
		
	}

	private String accountNumber;
	private double balance;
	private double interest;
	private enum TypeOfInterest {SIMPLE,COMPLEX}
	private TypeOfInterest typeOfInterest;
	private String typeOfInterestInput;
	private Owner оwner;
	private List<String> operations=new ArrayList<>(5);
	static int count=1;
	public BankAccount(Owner accountOwner,double balance,double interest, String typeOfIntinput) throws InvalidInputException  {
		this.accountNumber=createUniqueNumber(accountOwner);
		this.оwner=accountOwner;
		setBalance(balance);
		setInterest(interest);
		typeOfInterest=TypeOfInterest.valueOf(typeOfIntinput.toUpperCase());
	}	

	public Owner getOwner() {
		return оwner;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String createUniqueNumber(Owner o){		
		return Integer.toString(++count)+Integer.toString(o.getAge())+
				o.getFirstName().charAt(0)+o.getLastName().charAt(0);	
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) throws InvalidInputException{
		if(balance<0){
			throw new InvalidInputException("Balance must be greater then zero");
		}
		else{
			this.balance = balance;
		}
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) throws InvalidInputException {
		if(interest<0){
			throw new InvalidInputException("Interest must be greater then zero");
		}
		else{
			this.interest = interest;
		}
	}	
	public String getTypeOfInterest() {
		return typeOfInterestInput;
	}

	public void setTypeOfInterest(TypeOfInterest typeOfInterest) {
		this.typeOfInterest = typeOfInterest;
	}
	
	
	public void add(double money) throws InvalidInputException{
		this.setBalance(this.getBalance()+money);
		operations.add("add: "+money);
	}
	
	
	public void withdraw(double money) throws InvalidInputException, ForbidenWithdrawException{
		if(this.getInterest()>1){
			throw new ForbidenWithdrawException("Interest is greater than 1");
		}
		else{
			this.setBalance(this.getBalance()-money);
			operations.add("withdraw: "+money);
			
		}
	}
	public void transfer(double money,BankAccount other) throws InvalidInputException, ForbidenWithdrawException{
		this.withdraw(money);
		other.add(money);
		operations.add("transfer: "+money);
	} 
	
	public void history(){
		for(String s: operations){
			System.out.println(s);
		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((оwner == null) ? 0 : оwner.hashCode());
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
		BankAccount other = (BankAccount) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (оwner == null) {
			if (other.оwner != null)
				return false;
		} else if (!оwner.equals(other.оwner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", interest=" + interest
				+ ", typeOfInterest=" + typeOfInterest + ", оwner=" + оwner + "]";
	}
	
}
