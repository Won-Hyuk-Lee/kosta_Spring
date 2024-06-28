package com.lec03.spring;

import java.util.ArrayList;
import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmpController{
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
       
	@RequestMapping(value = "/emp_spring", method = RequestMethod.GET)
	public String empSelect(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		EmpDAO edao = new EmpDAO();
		ArrayList<EmpVO> list = edao.empSelect();
		model.addAttribute("KEY_LIST",list);
		
		return "lec03_servlet";
	}	


}
