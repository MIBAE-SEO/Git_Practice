package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

@WebServlet("/BoardListCon.do")
public class BoardListCon extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//화면에 보여질 게시글의 개수 지정 
		int pageSize = 10;
		
		//현재 보여지고 있는 페이지의 넘버 값을 읽어들임.
		String pageNum = request.getParameter("pageNum");
		//Null처리
		if(pageNum==null) {
			pageNum="1";
		}
		//전체 게시글의 개수를 파악
		int count=0;
		
		//jsp페이지 내에서 보여지는 넘버링 숫자값을 저장하는 변수 선언
		int number = 0;
		
		//현재 보여지고있는 페이지 문자를 숫자로 형변환
		int currentPage = Integer.parseInt(pageNum);
		
		//전체게시글의 개수를 가져와야하기에 DB 객체 생성
		BoardDAO bdao = new BoardDAO();
		count = bdao.getAllCount();
		
		
		//현재 보여질 페이지 시작번호 설정
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage * pageSize;
		
		//최신글 10개를 기준으로 게시글을 return받아주는 메소드 호출 
		Vector<BoardBean> v = bdao.getAllBoard(startRow, endRow);
		number = count - (currentPage-1)*pageSize;
		
		
		String msg = (String) request.getAttribute("msg");
		
		////////////BoardList.jsp쪽으로 request 객체에 담아서 넘겨줌
		
		request.setAttribute("v", v);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("msg", msg);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("BoardList.jsp");
		dis.forward(request, response);
	}
}
