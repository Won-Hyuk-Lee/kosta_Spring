package com.lec08.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CtxCallTest {

	/**
	   기능 : xml을 읽어 해당 설정에 있는 (클래스들의 인스턴스 초기화) == (new)
	    <interface>				<class>
	    BeanFactory    			XmlBeanFactory
		ApplicationContext   	ClassPathXmlApplicationContext  : src/main/resources
								FileSystemXmlApplicationContext : full path
		WebApplicationContext	XmlWebApplicationContext        : + session request..
	 */
	
	
	public static void main(String[] args) {
		
//        String xmlFile08 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec08-servlet-context.xml";
//        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile08);
//
//        try {
//        	DataSource ds = (DataSource)ctx.getBean("MY_tomcat_ds");
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
//       
		
		// Spring 컨텍스트 초기화
        String xmlFile08 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec08-servlet-context.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile08);

        // Spring 컨텍스트에서 BoardDAO 빈을 가져옴
        BoardDAO bdao = (BoardDAO) ctx.getBean("boardDAO");

        // BoardDAO의 메서드 호출
        System.out.println(bdao.boardSelect());

        try {
        	DataSource ds = (DataSource) ctx.getBean("dataSource");
			Connection conn = ds.getConnection();
			//TODO
			if (conn != null) {
				System.out.println("conn ok");
			} else {
				System.out.println("faild");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
	}

}
