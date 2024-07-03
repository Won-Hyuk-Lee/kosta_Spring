package com.kosta.semi.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component    //--------------Spring <bean>  JPA:@Entity
@Data         //--------------lombok
public class BoardVO {
	private int seq;            //PK sequence
	private String title;
	private String contents;
	private String regid;       //session cookie
	private String regdate;     //default sysdate
	List<ReplyVO> replies;      //1:N
	//FileVO fileVO;				//1:1
	List<FileVO> files;				//1:N
}


