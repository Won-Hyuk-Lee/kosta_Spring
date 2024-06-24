package com.lec08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDAO {
	@Autowired
	DataSource ds;
	
	/** 
	 * ----------------------------------------------------------------
	 *  board 전체 목록 
	 * ----------------------------------------------------------------- 
	 */
	public ArrayList<BoardVO> boardSelect() {	
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		//DataSource ds = null;
		//MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			//ds = moc.myOracleDataSource();
			conn = ds.getConnection();  
			String sql = "select * from board order by seq desc";
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setSeq(rs.getInt("seq"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContents(rs.getString("contents"));
				bvo.setRegid(rs.getString("regid"));
				bvo.setRegdate(rs.getString("regdate"));
				list.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			moc.oracleClose(conn, pstmt, rs);
//		}
		return list;
	}
	
	
	/** 
	 * ----------------------------------------------------------------
	 *  board 입력
	 * ----------------------------------------------------------------- 
	 */
	public int boardInsert(BoardVO bvo) {
		//seq       *title *contents *regid            regdate
		//nextval                    session,cookies   sysdate  
		Connection conn = null;
		PreparedStatement pstmt  = null;
		int insertRows = 0;
		//DataSource ds = null;
		//MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			//ds = moc.myOracleDataSource();
			conn = ds.getConnection();  

			String sql = "insert into board values(board_seq.nextval,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContents());   	
			pstmt.setString(3, bvo.getRegid());
			insertRows =  pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			moc.oracleClose(conn, pstmt);
//		}
		return insertRows;
	}
	
	/** 
	 * ----------------------------------------------------------------
	 *  조인 사용
	 *    - x번 게시물 : board 상세보기 + reply 목록 
	 * ----------------------------------------------------------------- 
	 */
	public BoardVO boardReplySelect(int seq) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		//DataSource ds = null;
		//MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		
		BoardVO bvo = null;
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			//ds = moc.myOracleDataSource();
			conn = ds.getConnection();  
			
			String sql = "select b.seq, b.title, b.contents, b.regid, b.regdate, "
					+ "r.rseq , r.reply, r.regid as rregid, r.regdate as rregdate "
					+ "from board b, reply r "
					+ "where b.seq=? "
					+ "and b.seq = r.seq(+) "
					+ "order by r.rseq desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs =  pstmt.executeQuery();
			List<ReplyVO> replyList = new ArrayList<ReplyVO>();
			while(rs.next()) { 
				if (bvo == null) {
					bvo = new BoardVO();
					bvo.setSeq(rs.getInt("seq"));
					bvo.setTitle(rs.getString("title"));
					bvo.setContents(rs.getString("contents"));
					bvo.setRegid(rs.getString("regid"));
					bvo.setRegdate(rs.getString("regdate"));
				}
				
				ReplyVO rvo = new ReplyVO();  //rseq  reply  rregid rregdate
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setReply(rs.getString("reply"));
				rvo.setRegid(rs.getString("rregid"));
				rvo.setRegdate(rs.getString("rregdate"));
				//BarodVO List<ReplyVO> replies;      //1:N
				//List<ReplyVO> replyList
				replyList.add(rvo);
			}
			bvo.setReplies(replyList);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			moc.oracleClose(conn, pstmt, rs);
//		}
		return bvo;
	}
	
	
	/** 
	 * ----------------------------------------------------------------
	 *  x번 게시물의 board 상세보기 
	 * ----------------------------------------------------------------- 
	 */
	//boardSelectOne(int seq)
	public BoardVO boardSelectOne(int seq) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		BoardVO bvo = new BoardVO();		
		//DataSource ds = null;
		//MyOracleConnection moc = new MyOracleConnection();
		
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			//ds = moc.myOracleDataSource();
			conn = ds.getConnection();  
			String sql = "select * from board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs =  pstmt.executeQuery();
			rs.next();  
			bvo.setSeq(rs.getInt("seq"));
			bvo.setTitle(rs.getString("title"));
			bvo.setContents(rs.getString("contents"));
			bvo.setRegid(rs.getString("regid"));
			bvo.setRegdate(rs.getString("regdate"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			moc.oracleClose(conn, pstmt, rs);
//		}
		return bvo;
				
	}
	
	/** 
	 * ----------------------------------------------------------------
	 *  x번 게시물의 reply 목록 
	 * ----------------------------------------------------------------- 
	 */
	public ArrayList<ReplyVO> replySelect(int seq) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();
		//DataSource ds = null;
		//MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			//ds = moc.myOracleDataSource();
			conn = ds.getConnection();  
			String sql = "select * from reply where seq=? order by rseq desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO rvo = new ReplyVO();
				rvo.setSeq(rs.getInt("seq"));
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setReply(rs.getString("reply"));
				rvo.setRegid(rs.getString("regid"));
				rvo.setRegdate(rs.getString("regdate"));
				list.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			moc.oracleClose(conn, pstmt, rs);
//		}
		return list;
	}
	
	
	/** 
	 * ----------------------------------------------------------------
	 *  reply 입력
	 * ----------------------------------------------------------------- 
	 */
	public int replyInsert(ReplyVO rvo) {
		//RSEQ      *REPLY      REGID             REGDATE    *SEQ
		//nextval               session,cookies   sysdate  
		Connection conn = null;
		PreparedStatement pstmt  = null;
		int insertRows = 0;
		//DataSource ds = null;
		//MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			//ds = moc.myOracleDataSource();
			conn = ds.getConnection();  

			String sql = "insert into reply values(reply_seq.nextval,?,'testid',sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getReply());   	
			pstmt.setInt(2, rvo.getSeq());
			insertRows =  pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			moc.oracleClose(conn, pstmt);
//		}
		return insertRows;
	}
	
	
	/** 
	 * ----------------------------------------------------------------
	 *  board 수정
	 * ----------------------------------------------------------------- 
	 */
	//public int boardUpdate(String title, String contetns, String regdate ) {
	public int boardUpdate(BoardVO bvo ) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		int updateRows = 0;
		//DataSource ds = null;
		//MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			//ds = moc.myOracleDataSource();
			conn = ds.getConnection();  

			String sql = "update board set title=?, contents=? where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContents());   	
			pstmt.setInt(3, bvo.getSeq());   	
			updateRows =  pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			moc.oracleClose(conn, pstmt);
//		}
		return updateRows;
	}

	/** 
	 * ----------------------------------------------------------------
	 *  board 삭제
	 * ----------------------------------------------------------------- 
	 */
	public int boardDelete(int seq) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		int delRows = 0;
		//DataSource ds = null;
		//MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			//ds = moc.myOracleDataSource();
			conn = ds.getConnection();  

			String sql = "delete from board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);   							
			delRows =  pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			moc.oracleClose(conn, pstmt);
//		}
		return delRows;
	}

	
	/** 
	 * ----------------------------------------------------------------
	 *  reply 댓글삭제
	 * ----------------------------------------------------------------- 
	 */
	public int replyDelete(int rseq) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		int delRows = 0;
		//DataSource ds = null;
		//MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			//ds = moc.myOracleDataSource();
			conn = ds.getConnection();  

			String sql = "delete from reply where rseq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rseq);   							
			delRows =  pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			moc.oracleClose(conn, pstmt);
//		}
		return delRows;
	}
	
	
	
}
