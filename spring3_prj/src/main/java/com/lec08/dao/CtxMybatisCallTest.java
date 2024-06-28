package com.lec08.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class CtxMybatisCallTest {

	/**
	   기능 : xml을 읽어 해당 설정에 있는 (클래스들의 인스턴스 초기화) == (new)
	    <interface>				<class>
	    BeanFactory    			XmlBeanFactory
		ApplicationContext   	ClassPathXmlApplicationContext  : src/main/resources
								FileSystemXmlApplicationContext : full path
		WebApplicationContext	XmlWebApplicationContext        : + session request..
	 */
	
	
	public static void main(String[] args) {
		
        String xmlFile08 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec08-servlet-context.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile08);

        //----------------------------------------------------------------------------
  		// Mybatis DBCP 설정을 통한 DB 연결
  		//   - 설정파일 : src/main/resources/mybatis-context.xml
  		//   - 매퍼파일 : src/main/resources/user-map.xml
  		//----------------------------------------------------------------------------
  		//Mybatis session build
  		String path = "mybatis-context-lec08.xml";
  		Reader reader; 
  		try {
  			reader = Resources.getResourceAsReader(path);
  			SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
  			if(sqlSessionFactory == null)
  				System.out.println("err");
  			else
  				System.out.println("Mybatis session build ok");
  		
  			SqlSession session = sqlSessionFactory.openSession();
  			UserVO vo = new UserVO();
  			vo.setUserSeq(1);
  			
  			//1건 출력
  			vo = (UserVO)session.selectOne("userNameSpace.getUserBySeq", vo);
  			System.out.println("DB에서 가져온 값:" + vo.getUserSeq());
  			
  			//목록 출력
  			List<UserVO> list = session.selectList("userNameSpace.getUserBySeq", vo);
  			System.out.println("DB에서 가져온 값:" + list.toString());
  			
  			
  			
  			
  			
//  			----------------------------------------------------------------
//  			 Mybatis를 사용한 CRUD 예
//  			----------------------------------------------------------------
  			vo.setUserId("user2");
  			vo.setUserPw("999");
  			vo.setUserName("원승진");
  			vo.setUserGubun("u");
  			Integer res = (Integer)session.insert("userNameSpace.userInsert", vo);
  			session.commit();
  			System.out.println("RES:" + res);
  			
  			System.out.println("\n\n----------------------");
  			ArrayList<UserVO> list2 = (ArrayList)session.selectList("userNameSpace.allUser");
  			System.out.println(list2.size());
  			for(int i=0; i<list2.size(); i++) {
  				vo = list2.get(i);
  				System.out.println(vo.getUserId() + "," + vo.getUserSeq());
  			}
  			
  			vo.setUserId("admin");
  			vo.setUserPw("000"); 
  			vo = session.selectOne("userNameSpace.userLogin", vo);
  			System.out.println(vo.getUserName()+"로그인");
  			
  			vo.setUserSeq(2);
  			vo.setUserId("kim2");
  			vo.setUserPw("123");
  			int ur = session.update("userNameSpace.userUpdate", vo);
  			session.commit();
  			System.out.println("upt건수" + ur);
  			
  			vo.setUserSeq(16);
  			session.delete("userNameSpace.userDelete", vo);
  			System.out.println(vo.getUserName()+"삭제");
  			session.commit();
  			
  			
  			session.close();
  			
  		} catch(Exception e) {
  			e.printStackTrace();
  		}
       
        
        
	}

}
