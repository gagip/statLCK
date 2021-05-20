<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>board detail</title>
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
        <h3>일정 항의중이라는데</h3>
        <div>
          <span>ㅇㅇ</span> <span>2021.05.19 13:29:49</span>
        </div>
        
        <div class="" style="margin: 50px 0;">
        시차 적응도 안 되었는데 혹독하게 일정 잡는다고 감독이 나섬ㅋㅋ
        </div>
        
        <div style="border-top: 1px solid black;">
        <div>
          댓글 1개
          <div>gagip: dddd</div>
          
        </div>
        <div>
          <input type="text">
        </div>
      </main>
      <!-- main end -->
    </div>
  </div>
  <script src="<%=request.getContextPath()%>/static/js/index.js"></script>
  
</body>
</html>