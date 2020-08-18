package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

@WebServlet("/BoardUpdateProcCon.do")
public class BoardUpdateProcCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("UTF-8");
		
		//form에서 넘어온 데이터를 받아줌
		// 다섯개의 데이터를 form으로 부터 받아옴
		int num = Integer.parseInt(request.getParameter("num"));
		String password = request.getParameter("password"); //사용자로부터 입력받은 값
		String pass = request.getParameter("pass");//실제 데이터베이스에 입력된 값
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//password값과 pass값을 비교 
		if(password.equals(pass)) {
			BoardDAO bdao = new BoardDAO();
			bdao.updateBoard(num, subject, content);
			//수정이 완료되었다면 전체 게시글 보기로 이동
			request.setAttribute("msg", "수정이 완료되었습니다.");
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request, response);
			
		}else {
			//비밀번호가 틀리다면 이전페이지로 이동 
			request.setAttribute("msg", "1");
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request, response);
			
		}
	
	}
}
