package kr.co.sol;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.sol.board.dto.Board2;
import kr.co.sol.board.persistence.BoardRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testDeleteBoard() {
		
		boardRepo.deleteById(1);
		
//		System.out.println("=== 1번 게시글 조회 ===");
//		Board2 board = boardRepo.findById(1).get();
//		
//		System.out.println("=== 1번 게시글 제목 수정 ===");
//		board.setTitle("제목을 수정했습니다.");
		
//		Board2 board = boardRepo.findById(1).get();
//		System.out.println(board.toString());
		
//		testInsertBoard() {
//		Board2 board = new Board2();
//		board.setTitle("첫 번째 게시글");
//		board.setWriter("테스터");
//		board.setContent("잘 등록되나요?");
//		board.setCreateDate(new Date());
//		board.setCnt(0);
		
		
	}
}
