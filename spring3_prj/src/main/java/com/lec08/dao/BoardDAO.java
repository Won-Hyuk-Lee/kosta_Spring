package com.lec08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	BasicDataSource ds;

	public ArrayList<BoardVO> boardSelect() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM board ORDER BY seq DESC");
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
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
		return list;
	}

	public int boardInsert(BoardVO bvo) {
		int insertRows = 0;
		String sql = "INSERT INTO board (seq, title, contents, regid, regdate) VALUES (board_seq.nextval, ?, ?, ?, sysdate)";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContents());
			pstmt.setString(3, bvo.getRegid());
			insertRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertRows;
	}

	public BoardVO boardReplySelect(int seq) {
		BoardVO bvo = null;
		List<ReplyVO> replyList = new ArrayList<>();
		String sql = "SELECT b.seq, b.title, b.contents, b.regid, b.regdate, "
				+ "r.rseq, r.reply, r.regid AS rregid, r.regdate AS rregdate "
				+ "FROM board b LEFT JOIN reply r ON b.seq = r.seq WHERE b.seq = ? ORDER BY r.rseq DESC";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, seq);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					if (bvo == null) {
						bvo = new BoardVO();
						bvo.setSeq(rs.getInt("seq"));
						bvo.setTitle(rs.getString("title"));
						bvo.setContents(rs.getString("contents"));
						bvo.setRegid(rs.getString("regid"));
						bvo.setRegdate(rs.getString("regdate"));
					}
					ReplyVO rvo = new ReplyVO();
					rvo.setRseq(rs.getInt("rseq"));
					rvo.setReply(rs.getString("reply"));
					rvo.setRegid(rs.getString("rregid"));
					rvo.setRegdate(rs.getString("rregdate"));
					replyList.add(rvo);
				}
			}
			if (bvo != null) {
				bvo.setReplies(replyList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bvo;
	}

	public BoardVO boardSelectOne(int seq) {
		BoardVO bvo = new BoardVO();
		String sql = "SELECT * FROM board WHERE seq = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, seq);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					bvo.setSeq(rs.getInt("seq"));
					bvo.setTitle(rs.getString("title"));
					bvo.setContents(rs.getString("contents"));
					bvo.setRegid(rs.getString("regid"));
					bvo.setRegdate(rs.getString("regdate"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bvo;
	}

	public ArrayList<ReplyVO> replySelect(int seq) {
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();
		String sql = "SELECT * FROM reply WHERE seq = ? ORDER BY rseq DESC";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, seq);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ReplyVO rvo = new ReplyVO();
					rvo.setSeq(rs.getInt("seq"));
					rvo.setRseq(rs.getInt("rseq"));
					rvo.setReply(rs.getString("reply"));
					rvo.setRegid(rs.getString("regid"));
					rvo.setRegdate(rs.getString("regdate"));
					list.add(rvo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int replyInsert(ReplyVO rvo) {
		int insertRows = 0;
		String sql = "INSERT INTO reply (rseq, reply, regid, regdate, seq) VALUES (reply_seq.nextval, ?, 'testid', sysdate, ?)";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, rvo.getReply());
			pstmt.setInt(2, rvo.getSeq());
			insertRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertRows;
	}

	public int boardUpdate(BoardVO bvo) {
		int updateRows = 0;
		String sql = "UPDATE board SET title = ?, contents = ? WHERE seq = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContents());
			pstmt.setInt(3, bvo.getSeq());
			updateRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRows;
	}

	public int boardDelete(int seq) {
		int delRows = 0;
		String sql = "DELETE FROM board WHERE seq = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, seq);
			delRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delRows;
	}

	public int replyDelete(int rseq) {
		int delRows = 0;
		String sql = "DELETE FROM reply WHERE rseq = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, rseq);
			delRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delRows;
	}
}
