package com.ppp.util;

import java.sql.*;

public class JdbcUtil {
	private static final String driverName = "net.sf.log4jdbc.DriverSpy";
	private static final String url = "jdbc:log4jdbc:oracle:thin:@localhost:1521:XE";
	private static final String id = "ppp";
	private static final String password = "1111";
	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
	public static void close(Connection conn) {
		if(conn!=null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
}
