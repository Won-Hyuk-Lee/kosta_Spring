package com.kosta.semi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity 
@Table(name = "reply")
public class ReplyEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_seq_gen")
    @SequenceGenerator(name = "reply_seq_gen", sequenceName = "reply_seq", allocationSize = 1)
    @Column(name = "rseq")
	private Long rseq;        //PK
	
	@Column(name = "reply", nullable = false, length = 30)
    private String reply;
	
	@Column(name = "regid",  length = 10)
	private String regid = "jpauser";    //session cookie
	
	@Column(name = "regdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate = new Date();
	
	@ManyToOne
	@JoinColumn(name="seq", referencedColumnName="seq" )
	private BoardEntity board;
	//****주의주의 private int seq ;        //FK - reference board(seq)
	
}
