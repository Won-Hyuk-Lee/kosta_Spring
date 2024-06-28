package com.lec08.dao;

public class LombokCallTest {

	public static void main(String[] args) {
		UserVO nvo = new UserVO();
		nvo.setUserName("안녕수야");
		
		String title = nvo.getUserName();
		System.out.println(title);

	}

}
