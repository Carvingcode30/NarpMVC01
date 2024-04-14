package kr.bit.model;

import java.sql.*;

// Data Access Object
// JDBC -> myBatis, JPA

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps; // sql 전송 객체
	private ResultSet rs; // DB에서 가져온 값 저장
	
	
}

// 1. 회원 등록 할 UI 만들기 