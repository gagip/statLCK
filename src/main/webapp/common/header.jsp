<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- header start -->
<header id="headers" class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">statLCK</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <input class="form-control form-control-dark w-100 mt-2 mb-2" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <c:if test="${sessionScope.sessionId == null}">
        <a class="nav-link" href="signin.me">Login</a>
      </c:if>
      <c:if test="${sessionScope.sessionId != null}">
        <a class="nav-link" href="#">${sessionScope.sessionId}</a>
      </c:if>
    </li>
  </ul>
</header>
<!-- header end -->