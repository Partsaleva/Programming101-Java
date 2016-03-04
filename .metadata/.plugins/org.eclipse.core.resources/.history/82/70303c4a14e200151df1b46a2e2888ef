package friday;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

	public static void main(String[] args) throws InvalidInputException, InvalidNameException {
		
	}

	private String accountNumber;
	private double balance;
	private double interest;
	private enum TypeOfInterest{complex,simple}
	private TypeOfInterest typeOfInterest;
	private Owner accountOwner;
	private List<String> operations=new ArrayList<>(5);
	public BankAccount() throws InvalidInputException{
		setAccountNumber(accountNumber);
		setAccountOwner(accountOwner);
		setBalance(balance);
		setInterest(interest);
		setTypeOfInterest(typeOfInterest);
	}
	public BankAccount(String accountNumber,Owner accountOwner,double balance,
						double interest, TypeOfInterest typeOfInterest) throws InvalidInputException {
		setAccountNumber(accountNumber);
		setAccountOwner(accountOwner);
		setBalance(balance);
		setInterest(interest);
		setTypeOfInterest(typeOfInterest);
	}	

	public Owner getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(Owner accountOwner) {
		this.accountOwner = accountOwner;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) throws InvalidInputException{
		if(accountNumber.length()!=22){
			throw new InvalidInputException("not valid account number");
		}
		else{
			this.accountNumber = accountNumber;
		}
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
		if(balance<0){
			throw new InvalidInputException("Interest must be greater then zero");
		}
		else{
			this.interest = interest;
		}
	}	
	public TypeOfInterest getTypeOfInterest() {
		return typeOfInterest;
	}

	public void setTypeOfInterest(TypeOfInterest typeOfInterest) {
		this.typeOfInterest = typeOfInterest;
	}
	
	
	public void add(double money) throws InvalidInputException{
		this.setBalance(this.getBalance()+money);
		operations.add("add: "+money);
	}
	public void withdraw(double money) throws InvalidInputException{
		if(this.getInterest()>1){
			return;
		}
		else{
			this.setBalance(this.getBalance()-money);
			operations.add("withdraw: "+money);
			
		}
	}
	public void transfer(double money,BankAccount other) throws InvalidInputException{
		this.withdraw(money);
		other.add(money);
		operations.add("transfer: "+money);
	} 
	
	public void history(){
		for(String s: operations){
			System.out.println(s);
		}
	}
	

}
