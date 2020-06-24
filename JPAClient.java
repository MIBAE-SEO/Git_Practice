package kr.or.sol;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kr.or.sol.domain.Board2;

public class JPAClient {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			//Board2 board = em.find(Board2.class, 3);
			//board.setTitle("검색한 게시글의 제목 수정");
			
			/*
			 * Board2 board = new Board2(); board.setTitle("JPA 제목");
			 * board.setWriter("관리자"); board.setContent("JPA 글 등록 잘 되네요.");
			 * board.setCreateDate(new Date()); board.setCnt(0);
			 * 
			 * em.persist(board); tx.commit();
			 */
			
			String jpql = "select b from Board2 b order by b.seq desc";
			List<Board2> boardList = em.createQuery(jpql,Board2.class).getResultList();
			for(Board2 brd : boardList) {
				System.out.println("------->"+brd.toString());
			}
			tx.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
}
