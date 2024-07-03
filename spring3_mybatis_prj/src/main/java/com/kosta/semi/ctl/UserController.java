package com.kosta.semi.ctl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosta.semi.svc.UserService;
import com.kosta.semi.vo.UserVO;


@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService; //= new UserServiceImple();
	
	//http://localhost:8088/user_insert?userId=hong&userPw=111
	@RequestMapping(value = "/user_insert", method = RequestMethod.GET)
	public String ctlUserInsert(@ModelAttribute UserVO uvo) {
//		uvo.setUserId("user2");
//		uvo.setUserPw("999");
		int res = userService.svcUserInsert(uvo);
		System.out.println("입력" + res);
		return "hello";
	}
	
	
	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public String ctlUserSelectAll() {
		 ArrayList<UserVO> list  = userService.svcUserSelectAll();
		 System.out.println(list.toString());
		return "hello";
	}

	@RequestMapping(value = "/user_detail", method = RequestMethod.GET)
	public String ctlUserSelectOne(@ModelAttribute UserVO uvo){
		uvo.setUserId("admin");
		uvo.setUserPw("0000");
		uvo = userService.svcUserSelectOne(uvo);
		System.out.println(uvo.toString());
		return "hello";
	}

	@RequestMapping(value = "/user_update", method = RequestMethod.GET)
	public String ctlUserUpdate(@ModelAttribute UserVO uvo){
		uvo.setUserPw("999");
		uvo.setUserId("lee");
		int res = userService.svcUserUpdate(uvo);
		System.out.println("수정" + res);
		return "hello";
	}
	
	//http://localhost:8091/user_delete/4/2024
	@RequestMapping(value = "/user_delete/{aaa}/2024", method = RequestMethod.GET)
	public String ctlUserDelete(@PathVariable("aaa") int seq){
		int res = userService.svcUserDelete(seq);
		System.out.println("삭제" + res);
		return "hello";
	}
}

