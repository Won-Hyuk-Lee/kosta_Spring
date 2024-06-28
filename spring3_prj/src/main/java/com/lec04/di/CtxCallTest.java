package com.lec04.di;


import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lec03.spring.EmpDAO;
import com.lec03.spring.EmpVO;

public class CtxCallTest {
	public static void main(String[] args) {

		String url1 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\servlet-context.xml";

		ApplicationContext ctx1 = new FileSystemXmlApplicationContext(url1);

		InternalResourceViewResolver ds = (InternalResourceViewResolver) ctx1.getBean("MY_IR_VIEW_RESOLVER_BEAN_NAME");
		if(ds!=null) System.out.println("success");
		else System.out.println("fail");
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.empSelect();
		System.out.println(list.size()+"java");
//자바 방식	
		
		String url2 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec04-servlet-context.xml";
		ApplicationContext ctx2 = new FileSystemXmlApplicationContext(url2);
		EmpDAO edao = (EmpDAO)ctx2.getBean("MY_EMPDAO_BEAN_NAME");
		ArrayList<EmpVO> list2 = edao.empSelect();
		System.out.println(list2.size()+"spring");
		}
}
