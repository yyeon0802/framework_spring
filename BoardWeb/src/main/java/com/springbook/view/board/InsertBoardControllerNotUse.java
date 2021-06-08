/*package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; //doPost�� �������� �޼ҵ� mapping

/* ������ �����̳� ���� :
 * 	�� ��� ������ �����ϰ� �Է� -> ������ insertBoard.do��û ���� -> �����̳ʴ� @Controller�� ���� ��� ��Ʈ�ѷ� ��ü�� ���� ->
 *  InsertBoardController�� ������ �ִ� insertBoard()�޼ҵ带 ���� -> 
 *  �̶� �Ű������� �ش��ϴ� BoardVO��ü�� �����������̳ʰ� �����Ͽ� ����*/

//@Controller //container ��ü �ڵ�����
//public class InsertBoardController  { // implements Controller
		
	//FINAL : annotation ver.
	
	//@Override -> ��� ���� ���� �ƴ϶� ����
	
	// �Ʒ��� ������, Ŭ���̾�Ʈ�κ��� "/insertBoard.do"��� ��û�� �ö� insertBoard() ��� method�� mapping�ϰڴٴ� ����.
	//��ü�� �ƴ� doPost�� �������� method(= insertBoard() )�� ! mapping / value ��������(��κ� ����)
	//@RequestMapping(value="/insertBoard.do") 
	//public String  insertBoard(BoardVO vo, BoardDAO boardDAO) { 
		
		//annotation ver. �Ű����� BoardDAO boardDAO �߰� -> void => String ����
		
		//ModelAndView -> void�� ���� / �޼ҵ�� handleRequest ���� -> insertBoard
	
		// �Ű����� HttpServletResponse response ����
		// HttpServletRequest request �Ű������� ���� ���� �ٷ� BoardVO�� �޾� command��ü ���
		
		//System.out.println("�� ��� ó��");
		
		//boardDAO.insertBoard(vo);
		//return "getBoardList.do";
		
		//view ��θ� �����ϸ� �⺻������ ������ ����̹Ƿ�, �����̷�Ʈ�� ���Ҷ��� redirect���λ縦 �ٿ� �Ѱܾ� �Ѵ�.
		//�Ʒ� �ҽ��� �� ��� ó�� �� "getUserList.do"�� �����̷�Ʈ �Ǿ� ���� url�� ������ ����.
		// =>http://localhost:8090/BoardWeb/getBoardList.do
		//return "redirect:getBoardList.do";
		
		
		// 1. ����� �Է� ���� ����
		
		//String title = request.getParameter("title");
		//String writer = request.getParameter("writer");
		//String content = request.getParameter("content");
		
		// 2. DB ���� ó��
		//BoardVO vo = new BoardVO();
		//vo.setTitle(title);
		//vo.setWriter(writer);
		//vo.setContent(content);
		
		//BoardDAO boardDAO = new BoardDAO();
		//�Ű������� BoardVO vo�� �ٷ� �������, insertBoard()����� command ��ü�� �ڵ����� ����, �������� setting��
		
		/* ���� �����̳ʴ� Ŭ���̾�Ʈ�� http��û�� ������ ���޵Ǵ� ����,
		 * HttpServletRequest ��ü�� �����ϰ� http�������ݿ� ������ ��� ������ �����Ͽ� HttpServletRequest ��ü�� �����Ѵ�.
		 * �� HttpServletRequest ��ü�� service() �޼ҵ带 ȣ���Ҷ�, ���ڷ� ���� �Ѵ�.*/
		
		
		// annotation ������� ȭ�� ������̼� �κ� ����
		
		// 3. ȭ�� ������̼�
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("getBoardList.do");
		
		//ViewResolver����� ���� ����
		//mav.setViewName("redirect:getBoardList.do");
		//return mav;
		
		//����� ���� �����Ͽ� ��˻� �� BoadList�� ��� �ؾ� �ϹǷ� .do	
		//return "getBoardList.do";
	//}

//}
