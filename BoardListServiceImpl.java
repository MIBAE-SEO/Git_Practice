package kr.co.sol.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.sol.board.dao.BoardDAO;
import kr.co.sol.board.dto.BoardVO;
import kr.co.sol.board.dto.PageVO;
import kr.co.sol.board.service.BoardListService;

@Service("boardListService")
public class BoardListServiceImpl implements BoardListService {
   
   private static final Logger logger = LoggerFactory.getLogger(BoardListServiceImpl.class);
   
   @Resource //DI
   BoardDAO boardDao;
   
   @Override
   public int getAllcount() {
      return boardDao.getAllcount();
   }

   @Override
   public List<BoardVO> getArticles(PageVO pdto) {
      logger.info("service: " + pdto.getAllCount());
      if (pdto.getAllCount() % pdto.getLinePerPage() == 0) {
         // 몫이 전체 페이지 수
         pdto.setAllPage(pdto.getAllCount() / pdto.getLinePerPage());
      } else {
         // 몫+1이 전체 페이지 수
         pdto.setAllPage(pdto.getAllCount() / pdto.getLinePerPage() + 1);
      }
        
         if(pdto.getCurrentPage()==0) {
          pdto.setCurrentPage(1);
         }
         //현재 블럭 받아오기
         if(pdto.getCurrPageBlock()==0) {
            pdto.setCurrPageBlock(1);
         }      
         int startPage = 1;
         int endPage=1;
        
          startPage = (pdto.getCurrPageBlock()-1)*pdto.getPageBlock()+1;
          endPage = pdto.getCurrPageBlock()*pdto.getPageBlock()>pdto.getAllPage()?pdto.getAllPage():pdto.getCurrPageBlock()*pdto.getPageBlock(); 
//         }
         pdto.setStartPage(startPage);
         pdto.setEndPage(endPage);
        
         // 가져올 start레코드와 end 레코드
         int start=(pdto.getCurrentPage()-1)*pdto.getLinePerPage()+1;
         int end = pdto.getCurrentPage()*pdto.getLinePerPage();
         Map<String, Integer> hmap = new HashMap<String, Integer>();
         hmap.put("start", start);
         hmap.put("end", end);
         List<BoardVO> list = boardDao.getArticles(hmap);
          //view에서 사용할 결과 값 저장
         
      return list;
   }

@Override
public Map<String, Object> getArticle(BoardVO bdto, PageVO pdto) {
	//현재 페이지를 받아오는 데 못받아올경우 0이므로 1로 setting
		if(pdto.getCurrentPage()==0) {
			pdto.setCurrentPage(1);
       }
       if(pdto.getCurrPageBlock()==0) {
          pdto.setCurrPageBlock(1);
       }     
  
       //해당되는 게시글 가져오기 (DB다녀오기)
       BoardVO bdto2 = boardDao.getArticles(bdto);
       //처리된 결과를 controller에게 전달하기 위해 담기 위한 작업 
       Map<String, Object> cmap = new HashMap<String, Object>();
       cmap.put("pdto", pdto);
       cmap.put("bdto", bdto2);

       return cmap;
}

}