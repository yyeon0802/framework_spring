package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
   public static void main(String[] args) {
      // 1. spring �����̳ʸ� �����Ѵ�
      AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
      
      // 2. spring �����̳ʷκ��� BoardServiceImp ��ü�� Lookup�Ѵ�.
      BoardService boardService = (BoardService) container.getBean("boardService");
      
      // 3. �� ��� ��� �׽�Ʈ
      BoardVO vo = new BoardVO();
      
//      [transaction test : �ӽ÷� 100��° seq����]
//      vo.setSeq(100); 
      
      vo.setTitle("�ӽ� ����");
      vo.setWriter("ȫ�浿");
      vo.setContent("�ӽó���.........");
//      [transaction test �� ��� xx �ּ�ó��]
      boardService.insertBoard(vo);

      // 4. �� ��� �˻� ��� �׽�Ʈ
      List<BoardVO> boardList = boardService.getBoardList(vo);
      for (BoardVO board : boardList) {
         System.out.println("---->" + board.toString());         
      }
      
      // 5. spring �����̳� ����
      container.close();
   }
   
}