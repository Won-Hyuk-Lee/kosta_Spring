package com.kosta.semi.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component    //--------------Spring <bean>  JPA:@Entity
@Data         //--------------lombok
public class ReplyVO {
	private int rseq;        //PK
	private String reply;
	private String regid;    //session cookie
	private String regdate;  //default sysdate
	private int seq ;        //FK - reference board(seq)
	
}
