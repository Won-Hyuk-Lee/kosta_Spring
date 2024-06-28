package com.lec06.aop;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lec03.spring.EmpDAO;
import com.lec03.spring.EmpVO;

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
		
        String xmlFile06 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec06-servlet-context.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile06);
       
        AOPController ctl = (AOPController)ctx.getBean("/ctlDelete");
        HttpServletRequest request = null;    //mock
        HttpServletResponse response = null;  //mock
        ctl.ctlDelete(request, response);
        
        
//        AOPService svc = (AOPService)ctx.getBean("MY_SVC");
//        svc.svcDelete();
        
//        AOPDAO dao = (AOPDAO)ctx.getBean("MY_DAO");
//        dao.delete();
//       
        
        
	}

}
