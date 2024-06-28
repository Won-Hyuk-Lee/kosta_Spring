package com.lec02.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
	public ArrayList<EmpVO> empSelect()
	{
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		MyOracleConnection mc = new MyOracleConnection();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select empno,ename,nvl(sal,0) as sal from emp";
		try {
			conn = mc.oracleConn().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList();
			while (rs.next() == true) {
				EmpVO vo= new EmpVO
				(rs.getInt("empno"),
				rs.getString("ename"),
				rs.getInt("sal"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mc.oracleClose(conn, pstmt);
		}
		return list;
	}

}
