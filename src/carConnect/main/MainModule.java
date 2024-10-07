package carConnect.main;
import java.util.*;

import carConnect.dao.*;
import carConnect.entity.*;

public class MainModule {
	
	static Scanner scan= new Scanner(System.in);
	static ICustomerService cust= new CustomerService();//upcasting

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("\n *** Welcome to Car Connect***");
			System.out.println("1.Regester Customer");
			System.out.println("2.EXIT");
			System.out.println("Enter your choice: ");
			int opt= scan.nextInt();
			
			switch(opt) {
			// -----------------Case 1----------------------
			case 1:
				System.out.println("Enter customer first name: ");
				String fname= scan.next();
				System.out.println("Enter customer last name: ");
				String lname= scan.next();
				System.out.println("Enter customer email ID: ");
				String email= scan.next();
				System.out.println("Enter customer PhoneNumber: ");
				String phone= scan.next();
				System.out.println("Enter customer Address: ");
				String address= scan.next();
				scan.nextLine();// It will consume the new line;
				System.out.println("Enter customer Username: ");
				String uname= scan.nextLine();
				System.out.println("Enter customer Password: ");
				String pass= scan.nextLine();
				
				Customer c= new Customer( fname, lname, email, phone, address, uname, pass);
				
				cust.registerCustomer(c);
				
				break;
			
			//---------------------------case 2-------------------------------------------------------
				
			case 2:
				System.out.println("Thank you!");
				scan.close();
				System.exit(0);
				break;
				
				default:
					System.out.println("Invalid option. Please try again!");
			}
			
			
		}
		
		

	}

}
