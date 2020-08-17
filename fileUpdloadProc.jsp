<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>
<%

	request.setCharacterEncoding("UTF-8");

	//프로젝트에 만들어질 폴더를 저장할 이름 변수선언
	String realfolder="";
	//실제 만들어질 폴더명을 설정한다
	String savefolder="/uploadfile";
	//한글설정
	String encType="euc-kr";
	//저장될 파일 사이즈 설정
	int maxSize = 1024*1024*5;//5M
	//파일이 저장될 경로값을 읽어오는 객체
	ServletContext context = getServletContext();
	realfolder = context.getRealPath(savefolder);
	
	try{
		// 클라이언트로부터 넘어온 데이터를 저장해주는 객체
		MultipartRequest multi = new MultipartRequest(request, realfolder, maxSize, encType,
				 new DefaultFileRenamePolicy()); //파일이름변경 자동설정
%>
	당신의 이름은 <%=multi.getParameter("name") %>	
<% 		 
	out.println(realfolder);
	}catch(Exception e){
		e.printStackTrace();
	}
	
%>

</body>
</html>