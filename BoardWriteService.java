package kr.co.sol.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sol.board.dto.BoardVO;
import kr.co.sol.board.dto.PageVO;


public interface BoardWriteService {

	public PageVO writeArticle(PageVO pdto);
	public void writeProArticle(BoardVO bdto,HttpServletRequest request, HttpServletResponse response);
	
	public PageVO updatePro(PageVO pdto, BoardVO bdto,HttpServletRequest request, HttpServletResponse response);
	public PageVO deletePro(PageVO pdto, int num);

	
}
