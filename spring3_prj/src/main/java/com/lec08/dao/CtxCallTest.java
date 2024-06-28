package com.lec08.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CtxCallTest {

    @Autowired
    BoardDAO dao;

    public static void main(String[] args) throws SQLException {
        // 파일 시스템 상의 전체 경로를 사용합니다.
        String xmlFile08 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec08-servlet-context.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile08);

        CtxCallTest test = ctx.getBean(CtxCallTest.class);

        ArrayList<BoardVO> vo = test.dao.boardSelect();
        System.out.println(vo.get(0).getTitle());
    }
}
