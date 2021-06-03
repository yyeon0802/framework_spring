package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.common.LogAdvice;
//import com.springbook.biz.common.Log4jAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {      //상속받은 인터페이스로 메소드를 구현한다.

   @Autowired
   private BoardDAOSpring boardDAO;
//   private BoardDAO boardDAO;
//   private Log4jAdvice log;
   
   //LogAdvice log 사용을 위한 생성자
   /*
    * public BoardServiceImpl() { log = new Log4jAdvice(); }
    */
      
   public void insertBoard(BoardVO vo) {
//      log.printLogging();
      
//    if(vo.getSeq() == 0) { 
//       throw new IllegalArgumentException("0번 글은 등록 할 수 없습니다."); } 
      
      boardDAO.insertBoard(vo);      // 100번 글 등록 성공
      
//      [transaction test]
//      boardDAO.insertBoard(vo);      // Exception 발생 (동일한 seq가 두번 들어가기에 commit이 실행 xx rollback 실행 oo
      
   }

   public void updateBoard(BoardVO vo) {
//      log.printLogging();
      boardDAO.updateBoard(vo);
   }

   public void deleteBoard(BoardVO vo) {
//      log.printLogging();
      boardDAO.deleteBoard(vo);
   }

   public BoardVO getBoard(BoardVO vo) {
//      log.printLogging();
      return boardDAO.getBoard(vo);
   }

   public List<BoardVO> getBoardList(BoardVO vo) {
//      log.printLogging();
      return boardDAO.getBoardList(vo);
   }
   
}