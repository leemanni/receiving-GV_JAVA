package stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBUtill {
	public static Connection getMySQLConnection() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3307/exer?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "0000");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드리아버 클래스가 없거나 읽어올 수 없습니다");
		}catch (SQLException e) {
			System.out.println("데이터 베이스를 접속 정보가 옳바르지 않습니다..");
		}
		
		return conn;
	}
	public static void close(Connection conn) {
		if(conn != null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
	}
	public static void close(Statement stmt) {
		if(stmt != null) {try {stmt.close();} catch (SQLException e) {e.printStackTrace();}}
	}
	public static void close(PreparedStatement psmt) {
		if(psmt != null) {try {psmt.close();} catch (SQLException e) {e.printStackTrace();}}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
	}
	
	
	
}
