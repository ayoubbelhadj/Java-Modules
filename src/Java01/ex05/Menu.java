package Java01.ex05;

import java.util.Scanner;

public class Menu {
	private TransactionsService servise;
	private boolean	devMode;
	private Scanner scanner;

	Menu(boolean devMode){
		this.servise = new TransactionsService();
		this.scanner = new Scanner(System.in);
		this.devMode = devMode;
	}

	public void display(){
		while(true){
			System.out.println("	1. Add a user");
			System.out.println("	2. View user balances");
			System.out.println("	3. Perform a transfer");
			System.out.println("	4. View all transactions for a specific user");
			if(devMode){
				System.out.println("	5. DEV - remove a transfer by ID");
				System.out.println("	6. DEV - check transfer validity");
			}
			System.out.println("	7. Finish execution");
			try {
				System.out.print("->	");
				int nbr = scanner.nextInt();
				if (check(nbr))
					break;
				System.out.println("	---------------------------------------------------------");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				scanner.nextLine();
			}
		}
	}
	private boolean check(int nbr){
		try {
			switch (nbr){
				case 1:
					AddUser();
					break;
				case 7:
					return true;
				default:
					System.out.println("Invalid choice");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			scanner.nextLine();
		}
		return false;
	}

	private void AddUser(){
		System.out.println("	Enter a user name and a balance");
		System.out.print("->	");
		String name = scanner.next();
		int balance = scanner.nextInt();
		User user = servise.addUser(name, balance);
		System.out.println("User with id = "+ user.getIdentifier() +" is added");
	}

}