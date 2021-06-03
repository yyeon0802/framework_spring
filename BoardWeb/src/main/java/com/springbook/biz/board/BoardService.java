package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	//�������̽��̱⿡, ���⼭�� �޼ҵ带 ���� XX ���� �Ѵ�.

	// CRUD ����� �޼ҵ� ����
	
	// �۵��
	void insertBoard(BoardVO vo);
	
	// �ۼ���
	void updateBoard(BoardVO vo);
	
	// �ۻ���
	void deleteBoard(BoardVO vo);
	
	// �� �� ��ȸ
	BoardVO getBoard(BoardVO vo);
	
	// �� ��� ��ȸ
	List<BoardVO> getBoardList(BoardVO vo);
}
