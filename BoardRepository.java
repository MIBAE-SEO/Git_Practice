package kr.co.sol.board.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import kr.co.sol.board.dto.Board2;

public interface BoardRepository extends CrudRepository<Board2,Integer> {

	 List<Board2> findByTitle(String searchKeyword);
	 List<Board2> findByContentContaining(String searchKeyword);
	 List<Board2> findByTitleContainingOrContentContaining(String title, String content);
	 List<Board2> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	 //List<Board2> findByTitleContaining(String searchKeyword, Pageable paging);
	 Page<Board2> findByTitleContaining(String searchKeyword, Pageable paging);
	 
	 
}
