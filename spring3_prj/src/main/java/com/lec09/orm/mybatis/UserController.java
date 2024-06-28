package com.lec09.orm.mybatis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserService userService; //= new UserServiceImple();
	 
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	  public ArrayList<UserVO> userInsert() {
		  UserVO uvo = new UserVO();
		  uvo.setUserId("uwe");
		  uvo.setUserPw("wwe");
		  uvo.setUserName("wwe");
		  uvo.setUserGubun("a");
	  	return userService.userSelectAll();
	  }
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	  public int userUpdate() {
		  UserVO uvo = new UserVO();
		  uvo.setUserId("uwe");
		  uvo.setUserPw("wwe");
		  uvo.setUserName("wwe");
		  uvo.setUserGubun("a");
	  	return userService.userUpdate(uvo);
	  }
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	  public int userDelete() {
		  UserVO uvo = new UserVO();
		  uvo.setUserId("uwe");
		  uvo.setUserPw("wwe");
		  uvo.setUserName("wwe");
		  uvo.setUserGubun("a");
	  	return userService.userDelete(uvo);
	  }
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	  public UserVO userSelect() {
		  UserVO uvo = new UserVO();
		  uvo.setUserId("uwe");
		  uvo.setUserPw("wwe");
		  uvo.setUserName("wwe");
		  uvo.setUserGubun("a");
	  	return userService.userSelectOne(uvo);
	  }
}
