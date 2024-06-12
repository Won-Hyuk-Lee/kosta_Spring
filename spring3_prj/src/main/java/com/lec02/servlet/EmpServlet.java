package com.lec02.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.servlet.annotation.WebServlet;

//@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.empSelect();
//		System.out.println("총:" + list.size());
//		for(EmpVO evo  : list) {
//			System.out.println(evo.getSal());
//		}
		
		request.setAttribute("KEY_EMPLIST", list);
		request.getRequestDispatcher("lec02_servlet.jsp").forward(request, response);
		
	}


}
