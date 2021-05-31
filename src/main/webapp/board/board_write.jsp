<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>free board</title>
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/index.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.css">
</head>
<body>
  <jsp:include page="../common/header.jsp"/>
  <div class="container-fluid">
    <div class="row">
      <jsp:include page="../common/side_nav.jsp"/>

      <!-- main start -->
      <main class="col-md-10 col-xs-6 ms-auto px-4 mt-3">
        <c:choose>
        <c:when test="${sessionScope.sessionMemberNum == null}">
        로그인해야 글쓰기 가능합니다
        </c:when>
        
        <c:otherwise>
        <!-- 게시글 작성 -->
        <h2>게시글 작성</h2>
        <hr>
        <form action="boardWriteAction.bo" method="POST">
          <input type="hidden" name="member_num" value="${sessionScope.sessionMemberNum}">
          <div class="mb-3">
            <label for="cate" class="form-label">글성격</label>
            <select class="form-select" id="cate" name="cate">
              <option value="1">공지</option>
              <option value="2" selected>일반</option>
              <option value="3">질문</option>
            </select>
            <div class="form-text fst-italic"></div>
          </div>
          
          <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="tite" name="title">
            <div class="form-text fst-italic">제목은 50글자만 가능합니다.</div>
          </div>
          
          <div class="mb-3">
            <label for="content" class="form-label">내용</label>
            <textarea rows="10" class="form-control" id="content" name="content"></textarea>
            <div class="form-text fst-italic">욕설 또는 과도한 비난은 제재 사유가 됩니다.</div>
          </div>
          
          <div align="center">
            <input type="submit" value="작성">
            <input type="button" value="취소">
          </div>
        </form>
        </c:otherwise>
        </c:choose>
        
      </main>
      <!-- main end -->
    </div>
  </div>
  <script src="<%=request.getContextPath()%>/static/js/index.js"></script>
  
</body>
</html>