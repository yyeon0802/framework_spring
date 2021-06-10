package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

// DAO(Data Access Object)
@Repository
public class BoardDAOMybatis { //extends SqlSessionDaoSupport
   
   @Autowired
   private SqlSessionTemplate mybatis;
   
   /*
    * public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) { //
    * SqlSession�������� super.setSqlSessionFactory(sqlSessionFactory); // �޼ҵ�
    * ���� @autowired�� �ٿ��ְԵǸ� ������ ������ �ƴ� �ڵ����� ȣ�� // �̷��� �ϸ� CURD�� �ش��ϴ� �޼ҵ�� �� ��밡�� }
    */
   
   //CRUD ����� �޼ҵ� ����
   // �� ���
   public void insertBoard(BoardVO vo) {
      System.out.println("===> Mybatis�� insertBoard() ��� ó��");
      mybatis.insert("BoardDAO.insertBoard", vo);
//      getSqlSession().insert("BoardDAO.insertBoard", vo);
   }
   
   // �� ����
   public void updateBoard(BoardVO vo) {
      System.out.println("===> Mybatis�� updateBoard() ��� ó��");
      mybatis.update("BoardDAO.updateBoard", vo);
//      getSqlSession().update("BoardDAO.updateBoard", vo);
   }
   
   // �� ���� 
   public void deleteBoard(BoardVO vo) {
      System.out.println("===> Mybatis�� deleteBoard() ��� ó��");
      mybatis.delete("BoardDAO.deleteBoard", vo);
//      getSqlSession().delete("BoardDAO.deleteBoard", vo);
   }
   
   // �� �� ����
   public BoardVO getBoard(BoardVO vo) {
      System.out.println("===> Mybatis�� getBoard() ��� ó��");
      return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
//      return (BoardVO) getSqlSession().selectOne("BoardDAO.getBoard", vo);
   }
   
   // �� ��� ��ȸ
   public List<BoardVO> getBoardList(BoardVO vo){
      System.out.println("===> Mybatis�� getBoardList() ��� ó��");
      return mybatis.selectList("BoardDAO.getBoardList", vo);
//      return getSqlSession().selectList("BoardDAO.getBoardList", vo);
   }
   
}