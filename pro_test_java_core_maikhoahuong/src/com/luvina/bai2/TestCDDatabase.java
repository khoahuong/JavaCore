/**
 *
 * Copyright (C) 2018 Luvina JSC
 * Bai2.java Nov 12, 2018 Mai Khoa Huong
 */
package com.luvina.bai2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class thực hiện test chương trình.
 * 
 * @author: Huong Mai Khoa
 *
 */
public class TestCDDatabase {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			run(scanner);
		} while (true);
	}

	/**
	 * @param scanner
	 */
	private static void run(Scanner scanner) {
		CDDatabase test = new CDDatabase();
		String chosse;
		do {
			System.out.println(
					"Hãy chọn chức năng cần test: \n1. insertCD() \n2. removeCD() \n3. findCD() \n4. Thoát chương trình");
			chosse = scanner.nextLine();
			switch (chosse) {
			case "1":
				String insertArt;
				do {
					System.out.println("Nhập Artist: ");
					insertArt = scanner.nextLine();
				} while (insertArt.length() == 0 || checkLength(insertArt, "Artist") == true
						|| checkIsEmpty(insertArt, "Artist"));
				String insertTit;
				do {
					System.out.println("Nhập Title: ");
					insertTit = scanner.nextLine();
				} while (insertTit.length() == 0 || checkLength(insertTit, "Title") == true
						|| checkIsEmpty(insertTit, "Title"));
				CDs cd1 = new CDs(insertArt, insertTit);
				test.insertCD(cd1);
				break;
			case "2":
				int t = 0;
				int deleteId = 0;
				String str = "";
				do {
					System.out.println("Nhập mã CD cần xóa.");
					str = scanner.nextLine();

					// Kiểm tra chưa nhập gì.
					if (str.isEmpty()) {
						System.out.println("Hãy nhập mã CD cần xóa.");
						continue;
					}

					// Kiểm tra id nhập vào ở dạng số hay không.
					Pattern pattern = Pattern.compile("\\d*");
					Matcher matcher = pattern.matcher(str);
					if (matcher.matches()) {
						deleteId = Integer.parseInt(str);
						t = 1;
					} else {
						System.out.println("Hãy nhập mã CD cần xóa.");
						continue;
					}
				} while (t != 1);
				CDs cd2 = new CDs(deleteId);
				test.removeCD(cd2);
				break;
			case "3":
				String findArt;
				String findTit;
				ListCD listFind;
				System.out.println("Nhập Artist: ");
				findArt = scanner.nextLine();
				System.out.println("Nhập Title: ");
				findTit = scanner.nextLine();
				listFind = test.findCD(findArt, findTit);
				if (listFind.checkNull()) {
					System.out.println("Không có CD phù hợp.");
				} else {
					listFind.show();
				}
				break;
			case "4":
				System.out.println("Tạm biệt!");
				// thoát chương trình.
				System.exit(0);
				break;
			default:
				System.out.println("Hãy nhập hàm cần test là từ 1 đến 4.");
			}
		} while (chosse == "1" || chosse == "2" || chosse == "3" || chosse == "4");
		// TODO Auto-generated method stub

	}

	/**
	 * Phương thức kiểm tra không nhập gì của một xâu.
	 * 
	 * @param str
	 * @param name
	 * @return
	 */
	private static boolean checkIsEmpty(String str, String name) {
		// TODO Auto-generated method stub
		if (str.length() == 0) {
			System.out.println("Hãy nhâp " + name + ".");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Hàm kiểm tra độ dài của một xâu nhập vào không được quá 255 ký tự.
	 * 
	 * @param string
	 * @param name
	 * @return
	 */
	private static boolean checkLength(String string, String name) {
		if (string.length() > 255) {
			System.out.println(name + " không được lớn hơn 255 ký tự.");
			return true;
		} else {
			// TODO Auto-generated method stub
			return false;
		}
	}
}
