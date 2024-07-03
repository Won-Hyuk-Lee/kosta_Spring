//package com.kosta.semi;
//
//import java.sql.Connection;
//import java.util.ArrayList;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//
//public class CtxCallTest {
//
//	/**
//	   기능 : xml을 읽어 해당 설정에 있는 (클래스들의 인스턴스 초기화) == (new)
//	    <interface>				<class>
//	    BeanFactory    			XmlBeanFactory
//		ApplicationContext   	ClassPathXmlApplicationContext  : src/main/resources
//								FileSystemXmlApplicationContext : full path
//		WebApplicationContext	XmlWebApplicationContext        : + session request..
//	 */
//	
//	
//	public static void main(String[] args) {
//		
//        String xmlFile08 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec09-servlet-context.xml";
//        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile08);
//
//        try {
//        	DataSource ds = (DataSource)ctx.getBean("MY_tomcat_ds");
//			Connection conn = ds.getConnection();
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
//       
//        
//        
//	}
//
//}
