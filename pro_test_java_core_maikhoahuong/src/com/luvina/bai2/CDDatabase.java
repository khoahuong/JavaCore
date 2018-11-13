/**
 *
 * Copyright (C) 2018 Luvina JSC
 * CDDatabase.java Nov 12, 2018 Mai Khoa Huong
 */
package com.luvina.bai2;

import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

/**
 * Xây dựng các phương thức để thực hiện các thao tác với Database.
 * 
 * @author: Huong Mai Khoa
 *
 */
public class CDDatabase extends ConnectDB {

	/**
	 * Xây dựng phương thức insertCD() để thêm dữ liệu vào database
	 * 
	 * @param cd
	 */
	public void insertCD(CDs cd) {
		try {
			this.conn = this.connection();
			String sqlInsert = "INSERT INTO cds(artist, title) VALUES(?, ?)";
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sqlInsert);
			stmt.setString(1, cd.getArtist());
			stmt.setString(2, cd.getTitle());
			stmt.execute();
			stmt.executeUpdate();
			System.out.println("Đã Insert thành công.");
		} catch (Exception e) {
			System.out.println("Hệ thống đang có lỗi.");
			// TODO: handle exception
		} finally {
			this.closeDB();
		}

	}

	/**
	 * Xây dựng phương thức removeCD() để xóa một dữ liệu trong database.
	 * 
	 * @param cd
	 */
	public void removeCD(CDs cd) {

		try {
			// Kiểm tra ID có tồn tại hay không
			if (!checkEmpty(cd)) {
				System.out.println("ID không tồn tại.");
			} else {
				this.conn = this.connection();
				String sqlRemove = "DELETE FROM cds WHERE id_cd = ?";
				PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sqlRemove);
				stmt.setInt(1, cd.getId_cd());
				stmt.execute();
				System.out.println("Đã Remove thành công.");
			}
		} catch (Exception e) {
			System.out.println("Hệ thống đang có lỗi.");
			// TODO: handle exception
		} finally {
			this.closeDB();
		}
	}

	/**
	 * Phương thức kiểm tra sự tồn tại của id_cd
	 * 
	 * @param cd
	 * @return
	 */
	private boolean checkEmpty(CDs cd) {
		boolean bool = false;
		try {
			this.conn = this.connection();
			String sql = "SELECT * FROM cds WHERE id_cd = ?";
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setInt(1, cd.getId_cd());
			stmt.executeQuery();
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				bool = true;
			} else {
				bool = false;
			}
		} catch (Exception e) {
			System.out.println("Hệ thống đang có lỗi.");
			// TODO: handle exception
		} finally {
			this.closeDB();
		}
		// TODO Auto-generated method stub
		return bool;
	}

	/**
	 * Phương thức findCD() thực hiện các tìm kiếm theo artist và title
	 * 
	 * @param artist
	 * @param title
	 * @return listC danh sách kết quả tìm được
	 */
	public ListCD findCD(String artist, String title) {
		ListCD listC = new ListCD();

		try {
			this.conn = this.connection();
			String sqlFind = "SELECT * FROM cds WHERE 1 = 1";
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sqlFind);
			stmt.setString(1, "%" + artist + "%");
			stmt.setString(2, "%" + title);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CDs cd = new CDs(rs.getInt("id_cd"), rs.getString("artist"), rs.getString("title"));
				listC.listCD.add(cd);
			}
		} catch (Exception e) {
			System.out.println("Hệ thống đang có lỗi.");
			// TODO: handle exception
		} finally {
			this.closeDB();
		}
		return listC;
	}

}
