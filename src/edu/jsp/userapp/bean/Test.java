package edu.jsp.userapp.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		String filepath = "C:\\Users\\Alpha\\Documents\\UserInfo.txt";
		int userId = 1001;
		boolean flag = true;

		try {
			FileInputStream inputStream = new FileInputStream(filepath);
			Scanner readLine = new Scanner(inputStream);
			while (readLine.hasNextLine()) {
				String userInfo = readLine.nextLine();
				if (userInfo.contains("" + userId)) {
					System.out.println(userInfo);
					flag = false;
				}

			}
			if (flag) {
				System.out.println("User not Found");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
