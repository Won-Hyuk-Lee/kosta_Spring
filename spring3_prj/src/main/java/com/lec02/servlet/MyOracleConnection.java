package com.lec02.servlet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class MyOracleConnection {
	static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static final String DB_ID = "it";
	static final String DB_PW = "0000";

	public DataSource oracleConn() {

		OracleConnectionPoolDataSource obj = null;
		try {
			obj = new OracleConnectionPoolDataSource();
			obj.setURL(DB_URL);
			obj.setUser(DB_ID);
			obj.setPassword(DB_PW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Connection oracleConn2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			if (conn != null) {
				System.out.println("conn ok");
			} else {
				System.out.println("faild");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void oracleClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void oracleClose(Connection conn, PreparedStatement pstmt) {
		try {
			if (conn != null) {
				pstmt.close();
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void oracleClose(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		BoardDAO bd = new BoardDAO();
//		BoardVO bvo = bd.boardReplySelect(1);
//		int seq = bvo.getSeq();
//		String title = bvo.getTitle();
//		System.out.println(seq + "\t" + title);
//		List<ReplyVO> rlist = bvo.getReplies();
//
//		for (ReplyVO ass : rlist) {
//			System.out.print(ass.getRseq() + "  ");
//			System.out.print(ass.getReply() + "\n");
//		}

	}
}