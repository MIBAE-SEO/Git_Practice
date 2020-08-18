package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

@WebServlet("/BoardInfoCon.do")
public class BoardInfoCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//num값 리턴
		int num = Integer.parseInt(request.getParameter("num"));
		
		//DB에 접근
		BoardDAO bdao = new BoardDAO();
		
		//하나의 게시글에 대한 정보 리턴
		BoardBean bean = bdao.getOneBoard(num );
		request.setAttribute("bean", bean);
		
		//view(jsp쪽)으로 데이터를 넘겨줌
		RequestDispatcher dis = request.getRequestDispatcher("BoardInfo.jsp");
		dis.forward(request, response);
		
	}
}
