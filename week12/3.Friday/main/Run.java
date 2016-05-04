package main;

import java.util.Scanner;

import educationalSystem.session.UserSession;

public class Run {

	public static void main(String[] args) {
		UserSession session=new UserSession();
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String user=scanner.nextLine();
		
		session.startTest(user);
		scanner.close();
	}

}
