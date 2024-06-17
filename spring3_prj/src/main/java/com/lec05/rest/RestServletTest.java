package com.lec05.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lec04.di.board.BoardDAO;
import com.lec04.di.board.BoardVO;
import java.util.stream.Collectors;

public class RestServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RestServletTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//--------------------- str-str -------------------------
		String ename = request.getParameter("ename");
		System.out.println(ename);
		PrintWriter out = response.getWriter();
		
		//---------- 응답Str : 객체
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.boardSelect();
		//객체 리스트[VO]      --> [ {"title"="aaa" , "regid"="kim"} ]
		Gson gson = new Gson();
		String  listString = gson.toJson(list);
		//스트링 리스트[JSON]  --> "  [ {"title":"aaa" , "regid":"kim"} ]  "
		System.out.println(listString);
		out.println(listString);
		
		//---------- 응답Str : 단순문자열
		//out.println("200 ok");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#####################################################################
		// 2번째 테스트 JSON - STRING
		//--------------------- json-str -------------------------
//		String jsonStr = request.getReader().lines().collect(Collectors.joining());
//		System.out.println(jsonStr + "," + jsonStr.getClass());
//		Gson gson = new Gson();
//		BoardVO bvo = gson.fromJson(jsonStr, BoardVO.class);
//		
//		// $.ajax   : JSON.stringify({"title":"aaaaatitle","regid":"hong"});
//		// jsonStr  : "   {"title":"aaaaatitle","regid":"hong"}   "
//		// bvo      : {"title":"aaaaatitle","regid":"hong"}
//		System.out.println(bvo.getTitle()); 
//		
//		PrintWriter out = response.getWriter();
//		
//		//---------- 응답Str : ArrayList<VO>
//		BoardDAO dao = new BoardDAO();
//		ArrayList<BoardVO> list = dao.boardSelect();
//		//객체 리스트[VO]      --> [ {"title"="aaa" , "regid"="kim"} ]
//		String  listString = gson.toJson(list);
//		//스트링 리스트[JSON]  --> "  [ {"title":"aaa" , "regid":"kim"} ]  "
//		System.out.println(listString);
//		//out.println(listString);
//		
//		//---------- 응답Str : VO
//		out.println(jsonStr);   //" {"title":"aaa" , "regid":"kim"}  "
//		
//		//---------- 응답Str : 단순문자열
//		//out.println("200 ok");	
		
		
		//#####################################################################
		// 3번째 테스트 STRING - JSON
//		response.setContentType("application/json;charset=UTF-8");  //★★★★★★★★
//		
//		String ename = request.getParameter("ename");
//		System.out.println(ename);
//		PrintWriter out = response.getWriter();
//		Gson gson = new Gson();
//		
//		//---------- 응답Str : ArrayList<VO>
//		BoardDAO dao = new BoardDAO();
//		ArrayList<BoardVO> list = dao.boardSelect();
//		//객체 리스트[VO]      --> [ {"title"="aaa" , "regid"="kim"} ]
//		String  listString = gson.toJson(list);
//		//스트링 리스트[JSON]  --> "  [ {"title":"aaa" , "regid":"kim"} ]  "
//		out.println(listString);

		//#####################################################################
		// 4번째 테스트 JSON - JSON
		response.setContentType("application/json;charset=UTF-8");  //★★★★★★★★
		
		String jsonStr = request.getReader().lines().collect(Collectors.joining());
		System.out.println(jsonStr + "," + jsonStr.getClass());
		Gson gson = new Gson();
		BoardVO bvo = gson.fromJson(jsonStr, BoardVO.class);
		System.out.println(bvo.getTitle());
		
		PrintWriter out = response.getWriter();
		
		//---------- 응답Str : ArrayList<VO>
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.boardSelect();
		//객체 리스트[VO]      --> [ {"title"="aaa" , "regid"="kim"} ]
		String  listString = gson.toJson(list);
		//스트링 리스트[JSON]  --> "  [ {"title":"aaa" , "regid":"kim"} ]  "
		out.println(listString);
				
		
		
	}

}
