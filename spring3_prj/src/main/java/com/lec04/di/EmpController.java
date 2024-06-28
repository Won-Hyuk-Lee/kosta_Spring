package com.lec04.di;

//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
//@Controller
public class EmpController extends MultiActionController{   //extends HttpServlet {
//	private EmpDAO edao;
//	public EmpController(EmpDAO edao)
//	{
//		this.edao=edao;	
//	}
	private EmpDAO dao;
	public void setDao(EmpDAO dao)
	{
		this.dao=dao;
	}
	private String str;
	public void setStringTest(String str) {
		this.str = str;
	}
//	@RequestMapping(value = "/emp_list_servlet", method = RequestMethod.GET)
	public ModelAndView empList(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		ArrayList<EmpVO> list = dao.empSelect();
		mav.addObject("KEY_EMPLIST", list);
		mav.setViewName("lec02_servlet");
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

}

