<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>intro</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/index.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
  <script src="https://d3js.org/d3.v4.js"></script>
</head>
<body>
  <jsp:include page="../common/header.jsp"/>
  
  <div class="container-fluid">
    <div class="row">
      <jsp:include page="../common/side_nav.jsp"/>

      <!-- main start -->
      <main class="col-md-10 col-xs-6 ms-auto px-4">
        
      
      </main>
      <!-- main end -->
    </div>
  </div>
</body>
</html>