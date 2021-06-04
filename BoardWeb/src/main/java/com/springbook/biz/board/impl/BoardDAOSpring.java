package com.springbook.biz.board.impl;


//import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.board.common.JDBCUtil;

//DAO(Data Access Object)
@Repository //Repository : component���� ������ó���� ȿ����(why? ����ó������)
public class BoardDAOSpring { //extends JdbcDaoSupport : bean���ÿ��� getTemplate�� ��ü ������ �����Ƿ� �θ��� X 

   
   //SQL��ɾ�(final�� Ȯ���Ѵ�.)
   
//   [transaction test]
//   private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?, ?, ?, ?)";
   private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board), ?, ?, ?)";
   private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
   private final String BOARD_DELETE = "delete board where seq=?";
   private final String BOARD_GET = "select * from board where seq=?";
   private final String BOARD_LIST = "select * from board order by seq desc";
   
   //getJdbcTemplate()�޼ҵ尡 JdbcTemplate ��ü�� �����Ϸ���, �θ�Ŭ������ setDataSource() �޼ҵ带 ȣ���Ͽ� ������ �ҽ� ��ü�� ������ ���� �ؾ� �Ѵ�.
   /*
    * public void setSuperDataSource(DataSource dataSource) {
    * super.setDataSource(dataSource); }
    */
   @Autowired
   private JdbcTemplate jdbcTemplate;   
   
   
    /*getJdbcTemplate().*/
   //CRUD ����� �޼ҵ� ����
   //�� ���
   public void insertBoard(BoardVO vo) {
      System.out.println("===> JDBC template�� insertBoard()��� ó�� ");
//      getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
//      jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
      jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(),vo.getWriter(), vo.getContent());
      
   }
   
   //�� ����
      public void updateBoard(BoardVO vo) {
         System.out.println("===> JDBC template�� updateBoard()��� ó�� ");
//         getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
         jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
         
      }
      
   //�� ����
      public void deleteBoard(BoardVO vo) {
         System.out.println("===> JDBC template�� deleteBoard()��� ó�� ");
//         getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
         jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
         
      }
      
   //�� �� ��ȸ
      public BoardVO getBoard(BoardVO vo) {
         System.out.println("===> JDBC template�� getBoard()��� ó��");
         Object[] args = {vo.getSeq()};
//         return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
         return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
      }
         
      
   // �� ��� ��ȸ
      public List<BoardVO> getBoardList(BoardVO vo) {         // ������� �������̹Ƿ� List�� return
         
         System.out.println("===> JDBC template�� getBoardList()��� ó��");
//         return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
         return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
      }
   
}
