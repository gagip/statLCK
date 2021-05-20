<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8"); 
%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>statLCK</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/index.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://d3js.org/d3.v4.js"></script>
</head>
<body>
  <jsp:include page="common/header.jsp"/>
  
  <div class="container-fluid">
    <div class="row">
      <jsp:include page="common/side_nav.jsp"/>

      <!-- main start -->
      <main class="col-md-10 col-xs-6 ms-auto px-4">
        <!-- 탭 -->
        <jsp:include page="common/tab.jsp"/>
        
        <!-- 탭 내용 -->
        <div id="tab-content" class="tab-content">
        
          <!-- 메인 -->
          <div class="tab-pane fade show active" id="total-view">
            <jsp:include page="main/content/total_view.jsp"/>
          </div>

          <!-- 팀 -->
          <div class="tab-pane fade" id="team">
            <div id="my_dataviz" style="float:left"></div>
            <div id="my_data" style="float:right"></div>
          </div>

          <!-- 선수  -->
          <div class="tab-pane fade" id="player-view">
            <jsp:include page="main/content/player_view.jsp"/>
          </div>
        </div>
      </main>
      <!-- main end -->
    </div>
  </div>
  <script src="<%=request.getContextPath()%>/static/js/chart.js"></script>
  <script src="<%=request.getContextPath()%>/static/chart2.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/index.js"></script>

</body>
</html>