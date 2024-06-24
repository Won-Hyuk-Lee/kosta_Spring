package com.lec08.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CtxMybatisCallTest {

    public static void main(String[] args) {
        
        String xmlFile08 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec08-servlet-context.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile08);

        //----------------------------------------------------------------------------
        // Mybatis DBCP 설정을 통한 DB 연결
        //   - 설정파일 : src/main/resources/mybatis-context.xml
        //   - 매퍼파일 : src/main/resources/user-map.xml
        //----------------------------------------------------------------------------
        // Mybatis session build
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
            UserVO uvo = new UserVO();
            
            // 한명 출력
            uvo.setUser_seq(4);
            uvo = (UserVO) session.selectOne("userNameSpace.selectUserOne", uvo);
            System.out.println("한명출력: " + uvo.getUser_name());
            System.out.println();
            
            // 전체 출력
            List<UserVO> userList = session.selectList("userNameSpace.selectUser");
            System.out.println("전체출력:");
            for (UserVO user : userList) {
                System.out.println(user.getUser_id() + " " + user.getUser_name() + " " + user.getUser_gubun() + " " + user.getRegdate());
            }
            System.out.println();
            
            // 삽입
            UserVO newUser = new UserVO();
            newUser.setUser_seq(5); // 새로운 user_seq 값을 설정
            newUser.setUser_id("newUser");
            newUser.setUser_pw("password");
            newUser.setUser_name("New User");
            newUser.setUser_gubun("G");
            int insertCount = session.insert("userNameSpace.insertUser", newUser);
            session.commit(); // 삽입 후 커밋
            System.out.println("삽입된 레코드 수: " + insertCount);
            
            // 삽입된거 확인
            userList = session.selectList("userNameSpace.selectUser");
            System.out.println("삽입 후 전체출력:");
            for (UserVO user : userList) {
                System.out.println(user.getUser_id() + " " + user.getUser_name() + " " + user.getUser_gubun() + " " + user.getRegdate());
            }
            System.out.println();
            
            // 수정 시도
            newUser.setUser_name("Updated User");
            newUser.setUser_gubun("U");
            int updateCount = session.update("userNameSpace.updateUser", newUser);
            session.commit(); // 수정 후 커밋
            System.out.println("수정된 레코드 수: " + updateCount);
            
            // 수정 확인
            userList = session.selectList("userNameSpace.selectUser");
            System.out.println("수정 후 전체출력:");
            for (UserVO user : userList) {
                System.out.println(user.getUser_id() + " " + user.getUser_name() + " " + user.getUser_gubun() + " " + user.getRegdate());
            }
            System.out.println();
            
            // 삭제 시도
            int deleteCount = session.delete("userNameSpace.deleteUser", newUser);
            session.commit(); // 삭제 후 커밋
            System.out.println("삭제된 레코드 수: " + deleteCount);
            
            // 삭제 확인
            userList = session.selectList("userNameSpace.selectUser");
            System.out.println("삭제 후 전체출력:");
            for (UserVO user : userList) {
                System.out.println(user.getUser_id() + " " + user.getUser_name() + " " + user.getUser_gubun() + " " + user.getRegdate());
            }
            System.out.println();
        
            session.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
