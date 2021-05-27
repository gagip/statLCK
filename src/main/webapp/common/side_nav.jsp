<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- nav start -->
<nav id="side-nav" class="side-nav d-flex flex-column justify-content-center p-3 text-white bg-dark col-xs-6 col-md-2">
  <div class="nav-btn-container">
    <ul class ="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="<%=request.getContextPath()%>/index.jsp" class="nav-link active">대시보드</a>
      </li>
      <li>
        <a href="<%=request.getContextPath()%>/intro/intro.jsp" class="nav-link text-white">사이트 소개</a>
      </li>
      <li>
        <a href="<%=request.getContextPath()%>/board/board_list.jsp" class="nav-link text-white">게시판</a>
      </li>
      <li>
        <c:if test="${sessionScope.sessionId == null}">
          <a href="signin.me" class="nav-link text-white">로그인</a>
        </c:if>
        <c:if test="${sessionScope.sessionId != null}">
          <a href="logoutAction.me" class="nav-link text-white">로그아웃</a>
        </c:if>
      </li>
    </ul>
  </div>
</nav>
<!-- nav end -->