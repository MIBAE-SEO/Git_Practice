package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginProc.do")
public class LoginProc extends HttpServlet {
	//jsp는 내장객체로 서블릿 리퀘스트가 있지만 자바는 HttpServlet으로 상속받아야 사용 가능.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	
	//get방식이던 post방식이던 reqPro가 처리할 수 있도록 만들어줌. 
 	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String id = request.getParameter("id");
 		String pass = request.getParameter("password");
 		
 		request.setAttribute("id", id); //request객체에 데이터를 저장
 		request.setAttribute("pass", pass); //request객체에 데이터를 저장
 		
 		//request객체 jsp파일로 떠넘기기
 		RequestDispatcher dis = request.getRequestDispatcher("LoginProc.jsp");
 		dis.forward(request, response);
 	}
 	



}


