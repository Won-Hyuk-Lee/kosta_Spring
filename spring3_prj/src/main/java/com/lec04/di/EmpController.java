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
import org.springframework.web.bind.annotation.RequestMapping; //@RequestMapping
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


//@Controller
public class EmpController extends MultiActionController {   //extends HttpServlet {
	//-------------------------- XML 기반 ---------------------
	//생성자
//	private EmpDAO dao;
//	public EmpController(EmpDAO dao) {
//		this.dao = dao;
//	}
	
	
	//프로퍼티(setter)
	private EmpDAO dao;
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	
	private String str;
	public void setStr(String str) {
		this.str = str;
	}
	
	

	
	
	//@RequestMapping(value = "/emp_list_servlet", method = RequestMethod.GET)
	public ModelAndView empList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		//Model
		ArrayList<EmpVO> list = dao.empSelect();
		mav.addObject("KEY_EMPLIST", list);
		mav.addObject("KEY_TESTSTR", this.str);
		//View
		mav.setViewName("lec02_servlet");
		
		System.out.println("DI로 주입받은 스트링값:" + this.str);
		return mav;
	}

	
	public ModelAndView empDumy(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		//Model
		mav.addObject("KEY_EMPLIST", new ArrayList<EmpVO>() );
		mav.addObject("KEY_TESTSTR", "empDumy : DumyTest");
		//View
		mav.setViewName("lec02_servlet");
		return mav;
	}

	
//	@Override 
//	// import org.springframework.web.servlet.mvc.AbstractController;
//	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
}
