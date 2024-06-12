package com.lec01.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/board1")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HelloServlet() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get call ......");
		response.getWriter().append("hello : ").append(request.getContextPath());
	}

	//@WebServlet("/board2")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
