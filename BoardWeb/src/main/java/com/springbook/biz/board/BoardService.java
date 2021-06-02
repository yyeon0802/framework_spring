package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	//�������̽��̱⿡, ���⼭�� �޼ҵ带 ���� XX ���� �Ѵ�.

	// CRUD ����� �޼ҵ� ����
	
	// �۵��
	void insertBaord(BoardVO vo);
	
	// �ۼ���
	void updateBaord(BoardVO vo);
	
	// �ۻ���
	void deleteBaord(BoardVO vo);
	
	// �� �� ��ȸ
	BoardVO getBoard(BoardVO vo);
	
	// �� ��� ��ȸ
	List<BoardVO> getBaordList(BoardVO vo);
}
