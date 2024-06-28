package com.lec08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	DataSource ds;

	public int boardDelete(int seq) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int delCount = 0;
		try {
			conn = ds.getConnection();
			String sql = "delete from board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			delCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return delCount;
	}

	public int replyDelete(int rseq) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int delCount = 0;
		try {
			conn = ds.getConnection();
			String sql = "delete from reply where rseq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rseq);
			delCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return delCount;
	}

	public int replyInsert(int seq, String contents) throws SQLException {
		// seq *title *contents *regid regdate
		// nextval session,cookies sysdate
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertRows = 0;

		try {
			// ---------------DBCP를 사용한 DB 연결 -----------------------
			// conn = moc.oracleConn();
			conn = ds.getConnection();

			String sql = "insert into reply values(reply_seq.nextval,?,'testid',sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contents);
			pstmt.setInt(2, seq);
			insertRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return insertRows;
	}

	public int boardInsert(BoardVO bvo) throws SQLException {
		// seq *title *contents *regid regdate
		// nextval session,cookies sysdate
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertRows = 0;
		try {
			// ---------------DBCP를 사용한 DB 연결 -----------------------
			// conn = moc.oracleConn();
			conn = ds.getConnection();

			String sql = "insert into board values(board_seq.nextval,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContents());
			pstmt.setString(3, bvo.getRegid());
			insertRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return insertRows;
	}

	// public int boardUpdate(String title, String contetns, String regdate ) {
	public int boardUpdate(BoardVO bvo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updateRows = 0;
		try {
			// ---------------DBCP를 사용한 DB 연결 -----------------------
			// conn = moc.oracleConn();
			conn = ds.getConnection();

			String sql = "update board set title=?, contents=? where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContents());
			pstmt.setInt(3, bvo.getSeq());
			updateRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return updateRows;
	}

	public ArrayList<BoardVO> boardSelect() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = null;
		String sql = "select * from board";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while (rs.next() == true) {
				BoardVO vo = new BoardVO(rs.getString("CONTENTS"), rs.getString("TITLE"), rs.getInt("SEQ"),
						rs.getString("REGID"), rs.getString("REGDATE"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return list;
	}

	public BoardVO boardSelectOne(int seq) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		// set바인딩값타입(1번째물음표에 , 바인딩될값)
		try {
			conn = ds.getConnection();
			String sql = "select * from board where SEQ= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq); // --------런타임시 : 동적 바인딩
			rs = pstmt.executeQuery();
			while (rs.next() == true) {
				vo = new BoardVO(rs.getString("contents"), rs.getString("title"), rs.getInt("seq"),
						rs.getString("regid"), rs.getString("regdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return vo;
	}

	public ArrayList<ReplyVO> replyListOne(int seq) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReplyVO> list = null;
		// set바인딩값타입(1번째물음표에 , 바인딩될값)
		try {
			conn = ds.getConnection();
			String sql = "select * from reply where SEQ= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq); // --------런타임시 : 동적 바인딩
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while (rs.next() == true) {
				ReplyVO rvo = new ReplyVO(rs.getInt("RSEQ"), rs.getString("REPLY"), rs.getString("RREGID"),
						rs.getString("RREGDATE"), rs.getInt("SEQ"));
				list.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return list;
	}

	public BoardVO boardReplySelect(int seq) throws SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		ArrayList<ReplyVO> replyList = new ArrayList();
		// set바인딩값타입(1번째물음표에 , 바인딩될값)
		try {
			conn = ds.getConnection();
			String sql = "select b.seq,b.contents,b.title, b.regid, b.regdate, r.rseq , r.reply, r.regid as rregid, r.regdate as rregdate from board b, reply r where b.seq=? and b.seq = r.seq(+) order by r.rseq asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq); // --------런타임시 : 동적 바인딩
			rs = pstmt.executeQuery();
			while (rs.next() == true) {

				int a = rs.getInt("seq");
				vo = new BoardVO(rs.getString("contents"), rs.getString("title"), a, rs.getString("regid"),
						rs.getString("regdate"));

				ReplyVO rvo = new ReplyVO(rs.getInt("rseq"), rs.getString("reply"), rs.getString("rregid"),
						rs.getString("rregdate"), a);
				replyList.add(rvo);

			}
			vo.setReplies(replyList);
			list.add(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return vo;
	}
}
