package com.lec10.orm.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec10.orm.hibernate.entity.UserEntity;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	//목록보기
	//http://localhost:8089/hiber_list
	@RequestMapping(value="/hiber_list")
	public String ctlHiberSelect(ModelMap model) {
		List<UserEntity> list = userService.svcAllUsers();
		model.addAttribute("MY_LIST", list);
		System.out.println(list.toString());
		return "hello";
	}

	//상세
	//http://localhost:8089/hiber_detail/1
	@RequestMapping(value="/hiber_detail/{sss}")
	public String ctlHiberSelectOne(ModelMap model, @PathVariable("sss") Long userSeq) {
		UserEntity entity = userService.svcUserDetail(userSeq);
		model.addAttribute("MY_LIST", entity);
		System.out.println(entity.toString());
		return "hello";
	}

	//입력 & 수정
	//http://localhost:8089/hiber_insert
	@RequestMapping(value="/hiber_insert")
	public String ctlHiberInsert(ModelMap model) { //, @ModelAttribute @UserVO userVO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId("hiber");
		userEntity.setUserPw("000");
		userService.svcInsertUser(userEntity);
		return "hello";
	}

	//삭제
	//http://localhost:8089/hiber_delete/39
	@RequestMapping(value="/hiber_delete/{sss}") 
	public String ctlHiberUpdate(ModelMap model, @PathVariable("sss") Long userSeq) {
		userService.svcDeleteUser(userSeq);
		return "hello";
	}

}
