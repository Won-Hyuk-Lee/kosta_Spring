//package com.lec04.di.board;
//
//             
//import org.springframework.ui.Model;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired; //@Autowired
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping; //@RequestMapping
//import org.springframework.web.bind.annotation.RequestMethod;  //@RequestMapping
//import org.springframework.web.bind.annotation.ResponseBody;
////import org.springframework.stereotype.Controller; 		   //@Controller
//import org.springframework.web.bind.annotation.RequestBody;	   //@RequestBody
// 
//import org.springframework.web.bind.annotation.RestController; //@RestController
/////**
// * 
// * Spring Boot 1.x: Spring Framework 4.x와 호환
// * Spring Boot 2.x: Spring Framework 5.x와 호환
// * Spring Boot 3.x: Spring Framework 6.x와 호환 (예정)
// */
//@RestController 
//public class BoardRestController  {
//	@Autowired
//	private BoardDAO boardDAO;
//	
////	@RequestMapping(value = "/board_json", method = RequestMethod.POST)
////	@ResponseBody
////	public String ctlBoardJSON(Model model, @RequestBody BoardVO bvo){
////		System.out.println(bvo.getSeq() + "," +  bvo.getRegid());
////		return "status 200 ok";
////	}
//	
//	@RequestMapping(value = "/restctl_json_str", method = RequestMethod.POST)
//	//@ResponseBody
//	public String restctlBoardJsonStr(Model model, @RequestBody BoardVO bvo){
//		System.out.println(bvo.getSeq() + "," +  bvo.getRegid());
//		return "status rest 200 ok";
//	}
//	
//	@RequestMapping(value = "/restctl_json_json", method = RequestMethod.POST)
//	//@ResponseBody
//	public ResponseEntity<Map<String, Object>> restctlBoardJsonJson(Model model, @RequestBody BoardVO bvo){
//		System.out.println(bvo.getSeq() + "," +  bvo.getRegid());
//		
//		Map<String, Object> response = new HashMap<String, Object>();
//	    response.put("status", 200);
//	    response.put("message", "ok");
//	    return new ResponseEntity<>(response, HttpStatus.OK);
//	}
//	
//	
//	
//}
