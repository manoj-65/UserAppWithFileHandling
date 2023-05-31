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
				String[] res = userInfo.toString().split(":-");
				String[] result = res[1].split(",");
				if (result[0].equals("" + id)) {
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
		boolean flag = true;
		FileOutputStream outputStream = null;
		String str = "";
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			Scanner readLine = new Scanner(inputStream);
			while (readLine.hasNextLine()) {
				String userInfo = readLine.nextLine();
				String[] res = userInfo.toString().split(":-");
				String[] result = res[1].split(",");
				if (result[0].equals("" + id)) {
					flag = false;
					System.out.println("User with the Given Id = " + id + " Removed");
				} else {
					str += userInfo + "\n";
				}
			}
			if (flag) {
				System.out.println("User not Found");
			} else {
				outputStream = new FileOutputStream(filePath);
				String userinfo = str.toString();
				byte[] strToBytes = userinfo.getBytes();
				outputStream.write(strToBytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
