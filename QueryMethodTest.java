package kr.co.sol;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.sol.board.dto.Board2;
import kr.co.sol.board.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {

@Autowired
	private BoardRepository boardRepo;
	
//@Before
//	public void dataPrepare() {
//	for(int i =1; i<=200; i++) {
//		Board2 board = new Board2();
//		board.setTitle("테스트 제목 "+ i);
//		board.setWriter("테스터");
//		board.setContent("테스트 내용 "+i);
//		board.setCreateDate(new Date());
//		board.setCnt(0);
//		boardRepo.save(board);
//	}
//}

//public void testFindByContentContaining() {
//	List<Board2> boardList = boardRepo.findByContentContaining("17");
//	
//	System.out.println("검색 결과");
//	for(Board2 board : boardList) {
//		System.out.println("----->"+board.toString());
//	}
//}
//@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5);
//		List<Board2> boardList = boardRepo.findByTitleContaining("제목", paging);
//		
//		System.out.println("검색 결과");
//		for(Board2 board : boardList) {
//			System.out.println("----->"+board.toString());
	
//	Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//	List<Board2> boardList = boardRepo.findByTitleContaining("제목", paging);
//	
//	System.out.println("검색 결과");
//	for(Board2 board : boardList) {
//		System.out.println("----->"+board.toString());
@Test
public void testFindByTitleContaining() {
	Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
	Page<Board2> pageInfo = boardRepo.findByTitleContaining("제목", paging);
	
	
	System.out.println("PAGE SIZE : " + pageInfo.getSize());
	System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
	System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
	System.out.println("NEXT : " + pageInfo.nextPageable());
	
	List<Board2> boardList = pageInfo.getContent();
	
	System.out.println("검색 결과");
	for(Board2 board : boardList) {
		System.out.println("----->"+board.toString());
}
}
}
