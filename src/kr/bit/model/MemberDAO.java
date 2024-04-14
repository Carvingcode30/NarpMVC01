package kr.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Data Access Object
// JDBC -> myBatis, JPA

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps; // sql 전송 객체
	private ResultSet rs; // DB에서 가져온 값 저장
	
	// 데이터베이스 연결객체(Connection) 생성
	public void getConnect() {
		String URL="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String user="root";
		String password="admin1234";
		
		// MySQL Driver Loading
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}

