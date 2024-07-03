package com.kosta.semi.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;


@Repository
public class BoardDAO {
	
	//board 전체 목록
//	ArrayList<BoardVO>  list = sessoin.selectList("____.boardSelect")
//	<select id="boardSelect" parameterType="BoardVO" resultType="BoardVO">
//		select * from board order by seq desc
//	</select>
//	
//	//board 입력
//	int res = session.insert("____.boardInsert", bvo)
//	<insert id="boardInsert" parameterType="BoardVO">
//	insert into board values(board_seq.nextval,?,?,?,sysdate)
//	</insert>
//	
//	
//	//조인 사용 x번 게시물 : board 상세보기 + reply 목록
//	session.selectOne("_________.boardReplySelect", 4);
//	<map id="board_reply_join_map">
//	   vo
//	   vo
//	   vo
//	   <collect  >
//	      rvo
//	      rvo
//	   </collect>
//	</map>
//	
//	<select id="boardReplySelect" parameterType="int" resultMap="board_reply_join_map">
//		select b.seq, b.title, b.contents, b.regid, b.regdate, 
//			r.rseq , r.reply, r.regid as rregid, r.regdate as rregdate 
//			from board b, reply r 
//			where b.seq=? 
//			and b.seq = r.seq(+)
//			order by r.rseq desc	
//	</select>
//		
//	//x번 게시물의 board 상세보기 
//	session.selectOne("____.boardSelectOne", 2);
//	<select id="boardSelectOne" parameterType="int" resultType="BoardVO">
//		select * from board where seq=?
//	</select>
//	
//	//x번 게시물의 reply 목록
//	session.selectList("_____.replySelect", 2);
//	<select id="replySelect" parameterType="int" resultType="BoardVO">
//	select * from reply where seq=? order by rseq desc
//	</select>
//	
//	//reply 입력
//	session.insert("_____.replyInsert", rvo);
//	<insert id="replyInsert" parameterType="ReplyVO">
//		insert into reply values(reply_seq.nextval,?,'testid',sysdate,?)
//	</insert>
//		
//	//board 수정
//	session.update("_____.replyInsert", bvo);
//	<update id="boardUpdate" parameterType="BoardVO">
//		update board set title=?, contents=? where seq=?
//	</updadte>
//	
//	//board 삭제
//	session.delete("_____.boardDelete", 3);
//	<delete id="boardDelete" parameterType="int">
//		delete from board where seq=?
//	</delete>
//		
//	// reply 댓글삭제
//	session.delete("_____.replyDelete", 1);
//	<delete id="boardDelete" parameterType="int">
//		delete from reply where rseq=?
//	</delete>

	
	
}
