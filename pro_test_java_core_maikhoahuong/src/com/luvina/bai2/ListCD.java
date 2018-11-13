/**
 *
 * Copyright (C) 2018 Luvina JSC
 * ListCD.java Nov 13, 2018 Mai Khoa Huong
 */
package com.luvina.bai2;

import java.util.ArrayList;

/**
 * Class hiển thị danh sách kết quả.
 * 
 * @author: Huong Mai Khoa
 *
 */
public class ListCD {
	ArrayList<CDs> listCD = new ArrayList<CDs>();

	/**
	 * Phương thức hiển thị các cột trong listCD
	 */
	public void show() {
		System.out.print("ID\t");
		System.out.print("Artist\t");
		System.out.println("Title");
		for (CDs cd : listCD) {
			System.out.print(cd.getId_cd());
			System.out.print(" | " + cd.getArtist());
			System.out.println(" | " + cd.getTitle());
		}
	}

	/**
	 * Kiểm tra size của listCD
	 * 
	 * @return nếu size = 0 thì trả về true
	 */
	public boolean checkNull() {
		if (listCD.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
