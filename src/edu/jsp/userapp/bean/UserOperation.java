package edu.jsp.userapp.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class UserOperation {

	private static String filePath = "C:\\Users\\Alpha\\Documents\\UserInfo.txt";

	public void addUsertoFile(User user) {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(filePath, true);
			String userinfo = user.toString();
			byte[] strToBytes = userinfo.getBytes();
			outputStream.write(strToBytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void displayUserById(int id) {
		boolean flag = true;
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			Scanner readLine = new Scanner(inputStream);
			while (readLine.hasNextLine()) {
				String userInfo = readLine.nextLine();
				if (userInfo.contains("" + id)) {
					System.out.println(userInfo);
					flag = false;
				}
			}
			if (flag) {
				System.out.println("User with the Given Id = " + id + " Not Found");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void removeUserById(int id) {

	}

}
