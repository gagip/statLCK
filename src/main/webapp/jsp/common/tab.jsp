<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- https://getbootstrap.com/docs/4.0/components/navbar/ -->
<nav id="tab" class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse">
    <ul class="nav nav-pills">
      <li class="nav-item">
        <a class="nav-link" href="#total" data-tab="total">종합</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#team" data-tab="team">상세분석</a>
      </li>
      <!-- 드롭다운 -->
      <!-- https://getbootstrap.com/docs/5.0/components/dropdowns/ -->
      <li class="nav-item dropdown">
        <a class="nav-link btn dropdown-toggle" href="#player" data-bs-toggle="dropdown" aria-expanded="false" data-tab="player">선수 항목</a>
        <ul class="dropdown-menu">
          <li><a href="" class="dropdown-item">DWG</a></li>
          <li><a href="" class="dropdown-item">Gen.G</a></li>
          <li><a href="" class="dropdown-item">T1</a></li>
        </ul>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
  </div>
</nav>