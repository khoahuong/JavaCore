/**
 *
 * Copyright (C) 2018 Luvina JSC
 * Bai_1.java Nov 9, 2018 Mai Khoa Huong
 */
package com.luvina.bai1javacore;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Viết chương trình chia 2 số A/B và hiển thị các thông báo lỗi.
 * 
 * @author Huong Mai Khoa
 *
 */
public class Bai1 {

	private static Scanner scanner;

	/**
	 * Nhập vào 2 số A và B, rồi kiểm tra tính hợp lệ của 2 số và thực hiện tính
	 * phép chia 2 số.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		double A = 0.0;
		double B = 0.0;
		int t = 0;
		scanner = new Scanner(System.in);
		String str = "";

		// Thực hiện kiểm tra tính hợp lệ của số A.
		do {
			System.out.print("Giá trị [A]: ");

			str = scanner.nextLine();

			// Kiểm tra điều kiện chưa nhập gì của số A.
			if (str.isEmpty()) {
				System.out.println("Hãy nhập giá trị cho [A].");
				continue;
			}

			// Kiểm tra điều kiện có phải là giá trị số không của số A.
			Pattern pattern = Pattern.compile("\\d*\\.\\d*|\\d*");
			Matcher matcher = pattern.matcher(str);
			if (matcher.matches()) {
				A = Double.parseDouble(str);
			} else {
				System.out.println("Giá trị [A] phải là giá trị số và > 0. Hãy nhập lại.");
				continue;
			}

			// Kiểm tra điều kiện là số lớn hơn 0 của số A.
			if (A <= 0) {
				System.out.println("Giá trị [A] phải là giá trị số và > 0. Hãy nhập lại.");
				continue;
			}

			// Kiểm tra điều kiện số A không được lớn hơn 5 số.
			if (str != null && str.length() > 5) {
				System.out.println("Giá trị [A] không được lớn hơn 5 số. Hãy nhập lại.");
				continue;
			} else {
				t = 1;
			}
		} while (t != 1);

		// Thực hiện kiểm tra tính hợp lệ của số B.
		do {
			System.out.print("Giá trị [B]: ");

			str = scanner.nextLine();

			// Kiểm tra điều kiện chưa nhập gì của số B.
			if (str.isEmpty()) {
				System.out.println("Hãy nhập giá trị cho [B].");
				continue;
			}

			// Kiểm tra điều kiện có phải là giá trị số không của số B.
			Pattern pattern = Pattern.compile("\\d*\\.\\d*|\\d*");
			Matcher matcher = pattern.matcher(str);
			if (matcher.matches()) {
				B = Double.parseDouble(str);
			} else {
				System.out.println("Giá trị [B] phải là giá trị số và > 0. Hãy nhập lại.");
				continue;
			}

			// Kiểm tra điều kiện là số lớn hơn 0 của số B.
			if (B <= 0) {
				System.out.println("Giá trị [A] phải là giá trị số và > 0. Hãy nhập lại.");
				continue;
			}

			// Kiểm tra điều kiện số B không được lớn hơn 5 số.
			if (str != null && str.length() > 5) {
				System.out.println("Giá trị [B] không được lớn hơn 5 số. Hãy nhập lại.");
				continue;
			} else {
				t = 2;
			}
		} while (t != 2);

		// Tinh thương của 2 số A và B, rồi đưa ra màn hình.
		double thuong = A / B;

		System.out.println("Thương của A/B bằng: " + thuong + ".");
	}

}
