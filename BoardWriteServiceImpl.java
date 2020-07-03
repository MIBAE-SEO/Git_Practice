package kr.co.sol.board.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import kr.co.sol.board.dao.BoardDAO;
import kr.co.sol.board.dto.BoardVO;
import kr.co.sol.board.dto.PageVO;
import kr.co.sol.board.service.BoardWriteService;

@Service("boardWriteService")
public class BoardWriteServiceImpl implements BoardWriteService {

	@Resource
	BoardDAO boardDao;
   //writeForm에 해당, DAO 필요 없음
   @Override
   public PageVO writeArticle(PageVO pdto) {

      if(pdto.getCurrentPage()==0) {
         pdto.setCurrentPage(1);
         }
      if(pdto.getCurrPageBlock()==0) {
         pdto.setCurrPageBlock(1);
         }

      return pdto;
   }
   
   @Override
   public void writeProArticle(BoardVO bdto, 
		   HttpServletRequest request, 
         HttpServletResponse resonse) {
 //     Map<String, Object> mutlDTO =
 //           ServletUpload.uploadEx(req, res);
          //DAO를 통해서 받은 데이터 저장하기
         //DAO에 대한 인스턴스 받아오기
 //        dao.boardWrite((BoardDTO)mutlDTO.get("dto"));
 //        req.setAttribute("pdto",(PageDTO)mutlDTO.get("pdto"));   

	   
	   //number구하기 (새로운 num)
	   int number = boardDao.getNewNum();
	   
	   //num == 0 (제목글)
	   //num이 0이 아니면 답글

	   if(bdto.getNum()==0) {
		   bdto.setNum(number); //새글
		   bdto.setRef(number);
		   bdto.setRe_level(1);
		   bdto.setRe_step(1);
	   }else {
		   bdto.setNum(number);
		   bdto.setRe_level(bdto.getRe_level()+1);
		   bdto.setRe_step(bdto.getRe_step()+1);
	   }
	   
	   	boardDao.boardWrite(bdto);
   }
   

@Override
public PageVO updatePro(PageVO pdto, BoardVO bdto, HttpServletRequest request, HttpServletResponse response) {
	//페이지에 대한 처리
	
	 if(pdto.getCurrentPage()==0) {
         pdto.setCurrentPage(1);
         }
      if(pdto.getCurrPageBlock()==0) {
         pdto.setCurrPageBlock(1);
         }
	
	boardDao.boardUpdate(bdto);
	return pdto;
	
}





@Override
public PageVO deletePro(PageVO pdto, int num) {
   if(pdto.getCurrentPage()==0) {
         pdto.setCurrentPage(1);
         }
      if(pdto.getCurrPageBlock()==0) {
         pdto.setCurrPageBlock(1);
         }            
   boardDao.deleteArticle(num);
   return pdto;
}
}