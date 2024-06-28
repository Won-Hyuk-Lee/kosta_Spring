package com.lec08.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
public class BoardVO {
	int SEQ;
	String title;
	String contents;
	String regid;
	String regdate;
	List<ReplyVO> replies;
	public List<ReplyVO> getReplies() {
		return replies;
	}
	public void setReplies(List<ReplyVO> replies) {
		this.replies = replies;
	}
	public int getSeq() {
		return SEQ;
	}
	public void setSeq(int sEQ) {
		SEQ = sEQ;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String tITLE) {
		title = tITLE;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String cONTENTS) {
		contents = cONTENTS;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String rEGID) {
		regid = rEGID;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String rEGDATE) {
		regdate = rEGDATE;
	}
	public BoardVO(String cONTENTS, String tITLE, int sEQ, String rEGID, String rEGDATE) {
		SEQ = sEQ;
		title = tITLE;
		contents = cONTENTS;
		regid = rEGID;
		regdate = rEGDATE;
	}
	public BoardVO( String tITLE, int sEQ, String rEGID, String rEGDATE) {
		SEQ = sEQ;
		title = tITLE;
		regid = rEGID;
		regdate = rEGDATE;
	}
	public BoardVO() {
	}
}
//String CREATED;
//String LAST_DDL_TIME;
//String SEQUENCE_OWNER;
//String SEQUENCE_NAME;
//int MIN_VALUE;
//int MAX_VALUE;
//int INCREMENT_BY;
//String CYCLE_FLAG;
//String ORDER_FLAG;
//int CACHE_SIZE;
//int LAST_NUMBER;