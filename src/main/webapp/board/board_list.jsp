<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
              <th scope="col">추천</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td>일반</td>
              <td><a href="<%=request.getContextPath()%>/board/board_detail.jsp" class="text-decoration-none text-reset">일정 항의중이라는데 [1]</a></td>
              <td>ㅇㅇ</td>
              <td>05.19</td>
              <td>39</td>
              <td>0</td>
            </tr>
            <tr>
              <th scope="row">2</th>
              <td>일반</td>
              <td>야 챌린저 생각보다 못하더라? [3]</td>
              <td>ㅇㅅㅇ</td>
              <td>05.19</td>
              <td>37</td>
              <td>0</td>
            </tr>
            <tr>
              <th scope="row">3</th>
              <td>일반</td>
              <td>담원 결승 예상</td>
              <td>ㅇㅅㅇ</td>
              <td>05.19</td>
              <td>20</td>
              <td>0</td>
            </tr>
            <tr>
              <th scope="row">4</th>
              <td>일반</td>
              <td>미드킨드는 뭐야</td>
              <td>ㅇㅇ</td>
              <td>05.15</td>
              <td>6</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">5</th>
              <td>일반</td>
              <td>세나 선픽을 안한다고 ?</td>
              <td>ㅇㅇ</td>
              <td>05.15</td>
              <td>9</td>
              <td>2</td>
            </tr>
          </tbody>
        </table>
        <!-- 하단 -->
        <div class="container clearfix">
          <form class="row gy-2 gx-3 justify-content-center align-items-center align-self-center">
          <div class="col-auto">
            <select class="form-select">
              <option selected>제목</option>
              <option value="1">내용</option>
              <option value="2">글쓴이</option>
              <option value="3">제목+내용</option>
            </select>
          </div>
          
          <div class="col-auto">
            <div class="input-group align-items-center">
              <input type="text" class="form-control" placeholder="" aria-label="Recipient's username" aria-describedby="button-addon2">
              <button class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
            </div>
          </div>
          
          
          </form>
          <button type="button" class="btn btn-primary float-end col-1" onclick="location.href='<%=request.getContextPath()%>/board/board_write.jsp'">글쓰기</button>
        </div>
        <div class="d-flex justify-content-center">
        1 2 3 4 5
        </div>
        
      </main>
      <!-- main end -->
    </div>
  </div>
  <script src="<%=request.getContextPath()%>/static/js/index.js"></script>
  
</body>
</html>