package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.common.LogAdvice;
//import com.springbook.biz.common.Log4jAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {		//상속받은 인터페이스로 메소드를 구현한다.

	@Autowired
	private BoardDAO boardDAO;
//	private Log4jAdvice log;
	
	//LogAdvice log 사용을 위한 생성자
	/*
	 * public BoardServiceImpl() { log = new Log4jAdvice(); }
	 */
		
	public void insertBaord(BoardVO vo) {
//		log.printLogging();
		

/*
 * if(vo.getSeq() == 0) { throw new
 * IllegalArgumentException("0번 글은 등록 할 수 없습니다."); }
 */
 
		
		boardDAO.insertBoard(vo);
	}

	public void updateBaord(BoardVO vo) {
//		log.printLogging();
		boardDAO.updateBoard(vo);
	}

	public void deleteBaord(BoardVO vo) {
//		log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
//		log.printLogging();
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBaordList(BoardVO vo) {
//		log.printLogging();
		return boardDAO.getBoardList(vo);
	}
	
}
