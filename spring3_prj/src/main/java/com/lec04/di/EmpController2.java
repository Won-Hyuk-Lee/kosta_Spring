//package com.lec04.di;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//@Controller
//public class EmpController2 {   
//	
//@Autowired
//private EmpDAO dao;
//@Autowired
//private String str;
//
//
//@RequestMapping(value = "/emp_list", method = RequestMethod.GET)
//
//	public String empList(Model model) {
//		ArrayList<EmpVO> list = dao.empSelect();
//		model.addAttribute("KEY_EMPLIST", list);
//		return "lec02_servlet";		
//	}
//	public ModelAndView empDumy(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView();
//		//Model
//		mav.addObject("KEY_EMPLIST", new ArrayList<EmpVO>() );
//		mav.addObject("KEY_TESTSTR", "empDumy : DumyTest");
//		//View
//		mav.setViewName("lec02_servlet");
//		return mav;
//	}
//
//}
//
