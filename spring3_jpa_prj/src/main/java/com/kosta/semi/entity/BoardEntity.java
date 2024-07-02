package com.kosta.semi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity 
@Table(name = "board")
public class BoardEntity {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_gen")
    @SequenceGenerator(name = "board_seq_gen", sequenceName = "board_seq", allocationSize = 1)
    @Column(name = "seq")
	private Long seq;            //PK sequence
	
	@Column(name = "title", nullable = false, length = 30)
    private String title;
	
	@Column(name = "contents",  length = 50)
	private String contents;
	
	@Column(name = "regid",  length = 10)
	private String regid="jpauser";       //session cookie
	
	@Column(name = "regdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate = new Date();
	
	@OneToMany(mappedBy = "board")
	List<ReplyEntity> replies;      //1:N
}
