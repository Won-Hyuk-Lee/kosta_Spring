package com.lec08.dao;

public class LombokCallTest {

	public static void main(String[] args) {
		UserVO nvo = new UserVO();
		nvo.setUser_name("아무개");
		
		String name = nvo.getUser_name();
		System.out.println(name);

	}

}
