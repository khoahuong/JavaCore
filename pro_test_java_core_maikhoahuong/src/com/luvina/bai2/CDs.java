/**
 *
 * Copyright (C) 2018 Luvina JSC
 * JavaBean.java Nov 12, 2018 Mai Khoa Huong
 */
package com.luvina.bai2;

/**
 * Xây dựng một class java bean để người dùng có thể truy cập đối tượng để hiển
 * thị danh sách CD.
 * 
 * @author: Huong Mai Khoa
 *
 */
public class CDs {

	private int id_cd;
	private String artist;
	private String title;

	/**
	 * @return the id_cd
	 */
	public int getId_cd() {
		return id_cd;
	}

	/**
	 * @param id_cd the id_cd to set
	 */
	public void setId_cd(int id_cd) {
		this.id_cd = id_cd;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param id_cd
	 * @param artist
	 * @param title
	 */
	public CDs(int id_cd, String artist, String title) {
		super();
		this.id_cd = id_cd;
		this.artist = artist;
		this.title = title;
	}

	/**
	 * Khởi tạo đối tượng CDs có 2 tham số là:
	 * 
	 * @param artist
	 * @param title
	 */
	public CDs(String artist, String title) {
		this.artist = artist;
		this.title = title;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_cd Khởi tạo đối tượng có 1 tham số là id_cd
	 */
	public CDs(int id_cd) {
		this.id_cd = id_cd;
		// TODO Auto-generated constructor stub
	}

}
