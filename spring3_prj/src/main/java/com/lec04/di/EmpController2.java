package com.lec04.di;


import java.lang.annotation.Annotation;

//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;              //@Controller
import org.springframework.beans.factory.annotation.Autowired; //@Autowired
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping; //@RequestMapping
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;



//public class EmpController2 extends MultiActionController {   

@Controller
    //1. 컨트롤러로 동작    : extends **Controller
	//2. 인스턴스 생성(new) :<bean name="MY_EMPCTL_BEAN_NAME" class="com.lec04.di.EmpController" scope="singleton">
public class EmpController2  {
	@Autowired
	//1. <property name="dao" ref="MY_EMPDAO_BEAN_NAME" />
	private EmpDAO dao;
	
	@Value("abcd")
	//<property name="stringTest" value="abcd" />
	private String str;
	
	@RequestMapping(value = "/emp_list", method = RequestMethod.GET)
	public String empList(Model model) {
		ArrayList<EmpVO> list = dao.empSelect();
		model.addAttribute("KEY_EMPLIST", list);
		model.addAttribute("KEY_TESTSTR", this.str);
		return "lec02_servlet";
	}
	@RequestMapping(value = "/emp_dummy", method = RequestMethod.GET)
	public String empDumy(Model model) {
		model.addAttribute("KEY_EMPLIST", new ArrayList<EmpVO>() );
		model.addAttribute("KEY_TESTSTR", "empDumy : DumyTest");
		return "lec02_servlet";
	}
	
//	@RequestMapping(value = "/emp_list", method = RequestMethod.GET)
//	public ModelAndView empList(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView();
//		//Model
//		ArrayList<EmpVO> list = dao.empSelect();
//		mav.addObject("KEY_EMPLIST", list);
//		mav.addObject("KEY_TESTSTR", this.str);
//		//View
//		mav.setViewName("lec02_servlet");
//		
//		System.out.println("DI로 주입받은 스트링값:" + this.str);
//		return mav;
//	}

	
	
}
