package kr.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Data Access Object
// 데이터베이스와의 연결 및 데이터 액세스 작업을 수행하는 클래스
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
	
	// 회원저장 동작
	public int memberInsert(MemberVO vo) {
		String SQL = "insert into member (id, pass, name, age, email, phone) values(?, ?, ?, ?, ?, ?)";
		getConnect();
		// SQL문장을 전송하는 객체 생성
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
		
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt; // 1성공 or 0실패
	}
	
	// 회원(VO) 전체 리스트(ArrayList) 가져오기
	public ArrayList<MemberVO> memberList() {
		String SQL = "select * from member";
		getConnect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery(); // rs -> 커서
			while(rs.next()) {
				int num = rs.getInt("num");
				String id =	rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				// 묶고 -> 담고
				MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
				list.add(vo);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	} // memberList
	
	
	// 삭제
	public int memberDelete(int num) {
		String SQL = "delete from member where num=?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	// 상세보기
	public MemberVO memberContent(int num) {
		String SQL = "select * from member where num=?";
		getConnect();
		MemberVO vo = null;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				// 회원 한명의 정보를 가져와서 > VO에 저장
				num = rs.getInt("num");
				String id =	rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				vo = new MemberVO(num, id, pass, name, age, email, phone);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}
	
	public int memberUpdate(MemberVO vo) {
		String sql = "update member set age=?, email=?, phone=? where num=?";
		getConnect();
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getAge());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setInt(4, vo.getNum());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	// 데이터베이스 연결 끊기
	public void dbClose() {
		try {
			if(rs !=null) rs.close();
			if(rs !=null) ps.close();
			if(rs !=null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

