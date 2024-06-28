package com.lec09.orm.mybatis;


import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TXCallTest {


	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("resource-servlet-context-lec09.xml");
		
		
		//----------------------------------------------------------------------------
		// Spring DBCP 설정을 통한 DB 연결 
		//   - 설정파일 : webapp/WEB-INF/servlet-context-lec09.xml
		//----------------------------------------------------------------------------
		String url2 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec09-servlet-context.xml";
		ApplicationContext ctx = new FileSystemXmlApplicationContext(url2);
	
		DataSource ds = (DataSource)ctx.getBean("MY_tomcat_ds");
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null)
				System.out.println("Properties DataSource myDS conn ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//TX rollback test용
		UserService svc = (UserService)ctx.getBean(UserService.class);
		if (svc!=null)
			System.out.println("dd");
		
		//-------------- 에러 상황 : 롤백처리 확인 --------------------
		//3건의 insert 중 에러 발생 시 TX에 의해 모두 rollback 처리됨
//		try {
//			UserVO vo = new UserVO(8880,"park","777","홍길동");
//			svc.svcDeleteRuntimeErrorFunc(vo);
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		}
		
		
		/**
		 * <tx:method name="*" rollback-for="RuntimeException"/> 설정한 경우 SQLException(checked)은 잡지못해 롤백 처리가 안된다.
		 *  Spring Transaction 은 기본적으로 unchecked Exception (RuntimeException)만 관리하며 checked Exception (IOException, SQLException 등) 은 관리하지 않는다.
		 *  처리방법	: @Transactional(rollbackFor=Exception.class) 와 같이 설정하여 모든 Exception 발생시 rollback 이 발생하게 처리 
		 *  	  	: <tx:method name="*" rollback-for="Exception"/>
		 */
//		try {
//			UserVO vo = new UserVO(8880,"park","6666","홍길동");
//			svc.svcDeleteSQLErrorFunc(vo);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
		
		
		//정상 입력되는 경우 확인
//		try {
//			UserVO vo = new UserVO(8880,"lee","888","홍길동");
//			svc.svcInsert(vo);
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		}
				
//		List<UserVO> list = svc.svcList();
//		System.out.println("건수:"+list.size());
//		System.out.println(list);
		
	}

}
