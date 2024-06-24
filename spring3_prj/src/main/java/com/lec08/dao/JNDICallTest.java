//package com.lec08.dao;
//
//import javax.naming.Context; 
//import javax.naming.InitialContext; 
//import javax.sql.DataSource; 
//import java.sql.Connection;
//public class JNDICallTest {
//	public static void main(String[] args) {
//		
//		try {
//			Context initialContext = new InitialContext(); 
//			Context ctx = (Context)initialContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource)ctx.lookup("jdbc/MyDataSource_MYNAME");
//			Connection conn = ds.getConnection(); 
//			//TODO
//			if(conn != null) {
//				System.out.println("conn ok");
//			} else {
//				System.out.println("faild");
//			}
//			
//			conn.close(); 
//		}
//		catch (Exception e) {
//			e.printStackTrace(); 
//		}
//	}
//}
//
//
