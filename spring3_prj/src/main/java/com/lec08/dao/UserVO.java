package com.lec08.dao;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class UserVO {
	private int userSeq;
	private String userId;
	private String userPw;
	private String userName;
	private String userGubun;
	private String regdate;

}
