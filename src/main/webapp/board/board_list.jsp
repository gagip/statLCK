<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <button type="button" class="btn btn-primary">전체</button>
        <button type="button" class="btn btn-primary">개념글</button>
        <button type="button" class="btn btn-primary">공지</button>
        <span><a href="#" class="text-decoration-none text-reset">전체</a></span>
        <span><a href="#" class="text-decoration-none text-reset">일반</a></span>
        <span><a href="#" class="text-decoration-none text-reset">LCK</a></span>
        <span><a href="#" class="text-decoration-none text-reset">뉴스/정보</a></span>
        <span><a href="#" class="text-decoration-none text-reset">해외리그</a></span>
        <span><a href="#" class="text-decoration-none text-reset">이벤트</a></span>
        <span><a href="#" class="text-decoration-none text-reset">영상</a></span>
        <table class="table table-hover">
          <thead>
            <tr>
              <th scope="col">번호</th>
              <th scope="col">말머리</th>
              <th scope="col">제목</th>
              <th scope="col">글쓴이</th>
              <th scope="col">작성일</th>
              <th scope="col">조회</th>
              <!-- <th scope="col">추천</th> -->
            </tr>
          </thead>
          <tbody>
          
            <c:forEach var="board" items="${boardList}">
            <tr>
              <th scope="row">${board.boardNum}</th>
              <td>${board.cate}</td>
              <td>
                <a href="boardDetailAction.bo?boardNum=${board.boardNum}&pageNum=${spage}" class="text-decoration-none text-reset">
                ${board.title}
                </a>
              </td>
              <td>${board.author}</td>
              <td><fmt:formatDate value="${board.pubDate}" pattern="MM.dd"/></td>
              <td>${board.viewCnt}</td>
              <!-- <td>${board.likeCnt}</td> -->
            </tr>
            </c:forEach>
          </tbody>
        </table>
        
        
        
        <!-- 하단 -->
        <div class="container clearfix">
          <form class="row gy-2 gx-3 justify-content-center align-items-center align-self-center" action="boardListAction.bo" method="GET">
          <div class="col-auto">
            <select class="form-select" id="opt" name="opt">
              <option value="0" selected>제목</option>
              <option value="1">글쓴이</option>
              <option value="2">내용</option>
              <option value="3">제목+내용</option>
            </select>
          </div>
          
          <div class="col-auto">
            <div class="input-group align-items-center">
              <input type="text" class="form-control" id="condition" name="condition" placeholder="">
              <button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
            </div>
          </div>
          
          
          </form>
          <button type="button" class="btn btn-primary float-end col-1" onclick="location.href='board_write.bo'">글쓰기</button>
        </div>
        <!-- 페이지 넘버링 -->
        <div class="d-flex justify-content-center">
        <c:if test="${startPage != 1}">
          <a href="boardListAction.bo?page=${startPage-1}">[이전]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
          <c:if test="${pageNum==spage}">
            <b>${pageNum}</b>&nbsp;
          </c:if>
          <c:if test="${pageNum!=spage}">
            <a href="boardListAction.bo?page=${pageNum}" class="text-decoration-none text-reset">${pageNum}&nbsp;</a>
          </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage}">
          <a href="boardListAction.bo?page=${endPage+1}">[다음]</a>
        </c:if>
        </div>
        
      </main>
      <!-- main end -->
    </div>
  </div>
  <script src="<%=request.getContextPath()%>/static/js/index.js"></script>
  <script>
  var error = "${requestScope.fail}";
  switch (error) {
    case "auth":
      alert("인증오류");
      break;
  
    default:
      break;
  }
  
  var delete_result = Boolean("${requestScope.deleteResult}");
  if (delete_result){
	  alert("게시글이 삭제되었습니다.");
  }

  function selectElement(id, valueToSelect){
    let element = document.getElementById(id);
    element.value = valueToSelect;
  }

  var board_search_opt = "${param.opt}";
  var board_search_condition = "${param.condition}";
  if (board_search_opt){
    selectElement("opt", board_search_opt);
    document.getElementById("condition").value = board_search_condition;
  }
  </script>
</body>
</html>