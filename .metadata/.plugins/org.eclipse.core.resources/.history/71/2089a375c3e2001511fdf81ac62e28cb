import java.io.Console;
import java.util.Scanner;


public class CLI {

	public static void main(String[] args) {
		
		TheBank bank=new TheBank();
		try {
			//It should prompt the user for the needed information and if 
			//everything is ok it should create a new bank account
			bank.addAccount();
			//It should prompt the user for the bank account number and show its history.
			bank.showHistoryOfAccount();
			//It should prompt the user for the amount and the bank account number.
			bank.addMoney();
			//It should prompt the user for the amount and the bank account number.
			bank.withdrawMoney();
			//It should prompt the user for the origin and destination bank account numbers and the amount
			bank.transferMoney();
			//It should prompt the user for bank account number and number of months.
			//It should return the amount after the given number of months.
			System.out.println(bank.calculateAmount());
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ForbidenWithdrawException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
