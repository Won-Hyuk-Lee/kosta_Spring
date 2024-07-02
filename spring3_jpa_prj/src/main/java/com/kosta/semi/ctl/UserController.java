package com.kosta.semi.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.semi.entity.UserEntity;
import com.kosta.semi.svc.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/jpa_login")
	//http://localhost:9089/jpa_login?userId=kim&userPw=111
	public String ctlUserLogin(ModelMap model, @ModelAttribute UserEntity userEntity) {
		//UserEntity userEntity = userService.svcUserLogin("admin","0000");
		userEntity = userService.svcUserLogin(userEntity.getUserId(),userEntity.getUserPw());
		model.addAttribute("MY_ENTITY", userEntity);
		System.out.println(userEntity.toString());
		return "hello";
	}
	
	@RequestMapping(value="/jpa_list")
	//http://localhost:9089/jpa_list
	public String ctlUserList(ModelMap model) {
		List<UserEntity> list = userService.svcUserList();
		model.addAttribute("MY_LIST", list);
		System.out.println(list.toString());
		return "hello";
	}
	
	
	//http://localhost:9089/jpa_detail?userSeq=1
	//@RequestMapping(value="/jpa_detail")
	//public String ctlUserDetail(ModelMap model, @RequestParam("userSeq") int userSeq) {
		
	//http://localhost:9089/jpa_detail/1
	@RequestMapping(value="/jpa_detail/{aaa}")
	public String ctlUserDetail(ModelMap model, @PathVariable("aaa") Long userSeq) {
		UserEntity entity = userService.svcUserDetail(userSeq);
		model.addAttribute("MY_ENTITY", entity);
		System.out.println(entity.toString());
		return "hello";
	}

	//http://localhost:9089/jpa_update
	@RequestMapping(value="/jpa_update")
	public String ctlUserUpdate(ModelMap model, @ModelAttribute UserEntity userEntity) {
		//update users3 set user_pw=#{userPw} where user_id=#{userId}
		userEntity.setId(1L);
		userEntity.setUserId("admin");
		userEntity.setUserPw("777");
		userService.svcUserUpdate(userEntity);
		return "hello";
	}

	//http://localhost:9089/jpa_delete/1
	@RequestMapping(value="/jpa_delete/{aaa}")
	public String ctlUserDelete(ModelMap model, @PathVariable("aaa") Long userSeq) {
		//delete from users3 where user_seq=#{userSeq}
		userService.svcUserDelete(userSeq);
		return "hello";
	}
	
}
