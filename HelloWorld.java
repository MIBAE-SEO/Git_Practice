package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloWorld") //HelloWorld라고 URL에 표시해주어야 이 서블릿클래스가 실행됨.
public class HelloWorld extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	//일괄처리 (doGet이던 doPost던 아래 reqPro메소드가 실행되게 함.)
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//화면에 helloWrold라고 출력하고싶음.jsp쪽으로 넘겨질 데이터 설정
		String msg = "Hello world~ 안녕하세요";
		Integer data = 17;
		
		//jsp쪽으로 데이터를  request에 부착하여 넘겨 줌 
		request.setAttribute("msg", msg);
		request.setAttribute("data", data);
		
		//서블릿에서 jsp를 호출하면서 데이터를 같이 넘겨주는 객체를 선언
		RequestDispatcher rd = request.getRequestDispatcher("HelloWorld.jsp"); //jsp파일 명 기술
		
		rd.forward(request, response);
	}

}
