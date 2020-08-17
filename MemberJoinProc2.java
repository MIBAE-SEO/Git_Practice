package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;

@WebServlet("/MProc2")
public class MemberJoinProc2 extends HttpServlet {
      //서블릿 자체 이름은 상관없음 ("/")부분만 jsp와 맞춰주면 됨!  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//직접 Bean클래스를 사용할 수 없기에 객체 생성을 시켜야함.
		MemberBean bean = new MemberBean();
		
		bean.setId(request.getParameter("id"));
		bean.setPassword(request.getParameter("password"));
		bean.setEmail(request.getParameter("email"));
		bean.setTel(request.getParameter("tel"));
		bean.setAddress(request.getParameter("address"));
		
		//request객체에 bean클래스 추가
		request.setAttribute("bean", bean);
		RequestDispatcher dis = request.getRequestDispatcher("MemberView.jsp");
	
			dis.forward(request, response);
	}

}
