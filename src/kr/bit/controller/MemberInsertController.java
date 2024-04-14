package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글깨짐 > utf 8 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 1. 파라미터 수집 (VO)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		// 디버깅
		System.out.println(vo); // .toString() 생략가능
		
		
		// Model과 연동부분
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		if(cnt>0) {
			// 가입성공
			// out.println("insert success"); // 다시 회원 리스트로 가야된다
			response.sendRedirect("/MVC01/memberList.do");
		} else {
			// 가입 실패 -> 예외 객체를 만들어서 WAS에게 던지자
			throw new ServletException("not insert");
		}
	}
}
