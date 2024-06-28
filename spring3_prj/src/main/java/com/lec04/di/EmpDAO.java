package com.lec04.di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
@Repository
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
				EmpVO evo = new EmpVO();
				evo.setEmpno( rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
				evo.setSal(rs.getInt("sal"));
				
				list.add(evo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mc.oracleClose(conn, pstmt);
		}
		return list;
	}

}
