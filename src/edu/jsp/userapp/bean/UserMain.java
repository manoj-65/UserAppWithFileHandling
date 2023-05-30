package edu.jsp.userapp.bean;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserOperation operation = new UserOperation();
		Scanner read = new Scanner(System.in);
		while (true) {
			System.out.println("Select Choice:");
			System.out.println("1.Create User\n2.Diaplay UserDetalies By id\n3.Remove User");
			int choice = read.nextInt();
			switch (choice) {
			case 1:
				operation.addUsertoFile(readUserInfo(read));
				break;
			case 2:
				operation.displayUserById(displayUserById(read));
				break;
			case 3:
				operation.removeUserById(displayUserById(read));
			default:
				break;
			}
		}
	}

	public static int displayUserById(Scanner read) {
		System.out.println("Enter the User Id :- ");
		return read.nextInt();
	}

	public static User readUserInfo(Scanner read) {
		User user = new User();
		System.out.println("Enter the User Id:");
		user.setId(read.nextInt());
		System.out.println("Enter the User Name: ");
		user.setName(read.next());
		System.out.println("Enter the User Email: ");
		user.setEmail(read.next());
		System.out.println("Enter the User Password: ");
		user.setPassword(read.next());
		return user;
	}

}
