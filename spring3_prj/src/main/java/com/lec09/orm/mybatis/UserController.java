package com.lec09.orm.mybatis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
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
		//return userDAO.userInsert(uvo);
		//return session.insert("userNameSpace.userInsert", uvo);
	}
	
	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public String ctlUserSelectAll() {
		 ArrayList<UserVO> list  = userService.svcUserSelectAll();
		 System.out.println(list.toString());
		return "hello";
		//return userDAO.userSelectAll();
		//return (ArrayList)session.selectList("userNameSpace.allUser");
	}

	@RequestMapping(value = "/user_detail", method = RequestMethod.GET)
	public String ctlUserSelectOne(@ModelAttribute UserVO uvo){
		uvo.setUserId("admin");
		uvo.setUserPw("0000"); 
			
		uvo = userService.svcUserSelectOne(uvo);
		System.out.println(uvo.toString());
		return "hello";
		//return userDAO.userSelectOne(uvo);
		//return session.selectOne("userNameSpace.login", uvo);
	}

	@RequestMapping(value = "/user_update", method = RequestMethod.GET)
	
	public String ctlUserUpdate(@ModelAttribute UserVO uvo){
		uvo.setUserPw("777");
		uvo.setUserId("park");
			
		int res = userService.svcUserUpdate(uvo);
		System.out.println("수정" + res);
		return "hello";
		//return userDAO.userUpdate(uvo);
		//return session.update("userNameSpace.userUpdate", uvo);
	}
	
	//http://localhost:8091/user_delete?userSeq=16
	@RequestMapping(value = "/user_delete", method = RequestMethod.GET)
	public String ctlUserDelete(@ModelAttribute UserVO uvo){
		//uvo.setUserSeq(16);
		
		int res = userService.svcUserDelete(uvo);
		System.out.println("삭제" + res);
		return "hello";
		//return userDAO.userDelete(uvo) ;
		//return session.delete("userNameSpace.userDelete", uvo);
	}
}

