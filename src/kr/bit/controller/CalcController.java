package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MyCalc;

@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 클라이언트에서 넘어오는 폼 파라미터 받기(파라미터 수집, su1, su2)
		// request 객체가 받음 service 메서드가 실행 될 때 메모리에 request 객체 할당됨
		
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		// 비즈니스 로직 -> Model로 분리하기
		// su1~su2 합?
		
//		int sum = 0;
//		for(int i=su1; i<=su2; i++) {
//			sum+=i;
//		}

		MyCalc my = new MyCalc();
		int sum = my.hap(su1, su2);
		
		PrintWriter out = response.getWriter();
		out.println("total="+sum);
	}
}
