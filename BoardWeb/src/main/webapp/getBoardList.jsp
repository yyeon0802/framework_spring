<%@ page import="java.util.List"%>
<%-- <%@ page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page import="com.springbook.biz.board.BoardVO"%> --%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
   /* // 1. ����� �Է� ���� ����(�˻������ ���Ŀ� ����)
   // 2. DB ���� ó��
   BoardVO vo = new BoardVO();
   BoardDAO boardDAO = new BoardDAO();
   List<BoardVO> boardList = boardDAO.getBoardList(vo); */
   
   // ���ǿ� ����� �� ����� ������.
   // List<BoardVO> boardList = (List)session.getAttribute("boardList");
   
%>

<!-- 3. ���� ȭ�� ���� -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
</head>
<body>
<center>
<h1>�� ���</h1>
<!-- <h3>�׽�Ʈ�� ȯ�� �մϴ�...<a href="logout_proc.jsp">Log-out</a></h3> -->
<h3>�׽�Ʈ�� ȯ�� �մϴ�...<a href="logout.do">Log-out</a></h3>

<!-- �˻����� -->
<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
   <tr>
      <td align="right">
         <select name="searchCondition">
            <option value="TITLE">����</option>
            <option value="CONTENT">����</option>
         </select>
         <input name="searchKeyword" type="text"/>
         <input type="submit" value="�˻�"/>
      </td>
   </tr>
</table>
</form>
<!-- �˻� ���� -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
   <tr>
      <th bgcolor="orange" width="100">��ȣ</th>
      <th bgcolor="orange" width="200">����</th>
      <th bgcolor="orange" width="150">�ۼ���</th>
      <th bgcolor="orange" width="150">�����</th>
      <th bgcolor="orange" width="100">��ȸ��</th>
   </tr>
   <c:forEach items="${boardList }" var="board">
   <tr>
      <td>${board.seq }</td>
      <td align="left"><a href="getBoard.do?seq=${board.seq }">
               ${board.title }</a></td>
      <td>${board.writer }</td>
      <td>${board.regDate }</td>
      <td>${baord.cnt }</td>
   </tr>
   </c:forEach>
   
   
<%-- <% for(BoardVO board : boardList){ %>
   <tr>
      <td><%= board.getSeq() %></td>
      <!-- <td align="left"><a href="getBoard.jsp?seq=<%= board.getSeq() %>">
               <%= board.getTitle() %></a></td> -->      
      <td align="left"><a href="getBoard.do?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
      <td><%= board.getWriter() %></td>
      <td><%= board.getRegDate() %></td>
      <td><%= board.getCnt() %></td>
   </tr>
<% } %> --%>

</table>
<br>
<a href="insertBoard.jsp">���� ���</a>
</center>
</body>
</html>      