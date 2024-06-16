package com.lec03.spring;


//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpController {   //extends HttpServlet {
	@RequestMapping(value = "/emp_list_servlet", method = RequestMethod.GET)
	public String empList(Model model) {
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.empSelect();
		model.addAttribute("KEY_EMPLIST", list);
		return "lec02_servlet";		
	}
}







