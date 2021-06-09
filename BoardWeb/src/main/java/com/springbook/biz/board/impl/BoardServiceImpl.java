package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.common.LogAdvice;
//import com.springbook.biz.common.Log4jAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {      //��ӹ��� �������̽��� �޼ҵ带 �����Ѵ�.

	/* Controller ���� ���� DAO�� ȣ���ϱ⿡�� ���������� ������� �ִ�. ����
       boardService���� ���� DAO�� ȣ���ϰ� Autowired�� �̿��� Controller�� ����Ѵ�.  
 
	 *   80%�� ������Ʈ�� AOP�� Service impl���� �����Ѵ�. => �̸� ���� Controller���� AOP�����Ѵ�.
	 */
	
	@Autowired
   private BoardDAO boardDAO;
//   private BoardDAOSpring boardDAO;
//   private Log4jAdvice log;
   
   //LogAdvice log ����� ���� ������
   /*
    * public BoardServiceImpl() { log = new Log4jAdvice(); }
    */
      
   public void insertBoard(BoardVO vo) {
//      log.printLogging();
      
//    if(vo.getSeq() == 0) { 
//       throw new IllegalArgumentException("0�� ���� ��� �� �� �����ϴ�."); } 
      
      boardDAO.insertBoard(vo);      // 100�� �� ��� ����
      
//      [transaction test]
//      boardDAO.insertBoard(vo);      // 2�������Ͽ� Exception �߻� (������ seq�� �ι� ���⿡ commit�� ���� xx rollback ���� oo)
      
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