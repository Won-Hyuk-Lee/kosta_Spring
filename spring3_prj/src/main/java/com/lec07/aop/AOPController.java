package com.lec07.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AOPController{
	
	//property 방식으로 DI 주입
	@Autowired
	private AOPService aOPService;
	
	
	@RequestMapping(value = "/ano_aop_ctl", method = RequestMethod.GET)
	public String ctlDelete() {
		System.out.println("1.___AOPController.ctlDelete() 실행");
		aOPService.svcDelete();
		return "hello";
 	}
}
