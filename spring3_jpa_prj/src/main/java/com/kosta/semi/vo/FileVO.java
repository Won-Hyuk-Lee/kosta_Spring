package com.kosta.semi.vo;

import lombok.Data;

@Data
public class FileVO {
	private int fseq;		//board_file_seq.nextval
	private String oname;   //사용자가 올린 파일 원본명         aa.jpg
	private String sname;	//시스템에 올릴때 리네임되는 파일명   2015777_aa.jpg
	private long fsize = 0;		//바이트  457848787
	private String fpath;	//파일저장경로 :  </webapp>   /uploads/2015777_aa.jpg
	private int seq;		//게시물번호
	private String regid = "tester";
	private String regdate;
}
