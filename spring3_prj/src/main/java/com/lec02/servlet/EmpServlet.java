package com.lec02.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=euc-kr");
		
		EmpDAO edao = new EmpDAO();
		ArrayList<EmpVO> list = edao.empSelect();
		
		request.setAttribute("KEY_EMP",list);
		request.getRequestDispatcher("lec02_servlet.jsp").forward(request, response);
	}


}
