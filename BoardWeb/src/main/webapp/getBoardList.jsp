<%@ page import="java.util.List"%>
<%-- <%@ page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page import="com.springbook.biz.board.BoardVO"%> --%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
   /* // 1. 사용자 입력 정보 추출(검색기능은 추후에 구현)
   // 2. DB 연동 처리
   BoardVO vo = new BoardVO();
   BoardDAO boardDAO = new BoardDAO();
   List<BoardVO> boardList = boardDAO.getBoardList(vo); */
   
   // 세션에 저장된 글 목록을 꺼낸다.
   // List<BoardVO> boardList = (List)session.getAttribute("boardList");
   
   // jstl => c:user -> repository -> javax -> servlet -> jstl 1.2.jar -> tomcat설치 folder -> lib -> ctrl c+v
   
%>

<!-- 3. 응답 화면 구성 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 목록</title>
</head>
<body>
<center>
<h1>글 목록</h1>
<!-- <h3>테스트님 환영 합니다...<a href="logout_proc.jsp">Log-out</a></h3> -->
<h3>테스트님 환영 합니다...<a href="logout.do">Log-out</a></h3>

<!-- 검색시작 -->
<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
   <tr>
      <td align="right">
         <select name="searchCondition">
            <option value="TITLE">제목</option>
            <option value="CONTENT">내용</option>
         </select>
         <input name="searchKeyword" type="text"/>
         <input type="submit" value="검색"/>
      </td>
   </tr>
</table>
</form>
<!-- 검색 종료 -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
   <tr>
      <th bgcolor="orange" width="100">번호</th>
      <th bgcolor="orange" width="200">제목</th>
      <th bgcolor="orange" width="150">작성자</th>
      <th bgcolor="orange" width="150">등록일</th>
      <th bgcolor="orange" width="100">조회수</th>
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
<a href="insertBoard.jsp">새글 등록</a>
</center>
</body>
</html>      