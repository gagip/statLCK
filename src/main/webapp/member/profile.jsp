<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>${member.id} Profile</title>
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
        <div class="container">
          <h3>프로필</h3>
          <hr>
          <div class="table-wrapper profile-container">
            <table class="alt profile-table">
              <tbody>
              <!-- 
                <tr>
                  <td class="label">이미지</td>
                  <td class="context">
                    <c:if test="${member.pImage != null}"> 
                    <img src="{{ member.profile.picture.url }}" alt="" class="profile"><br>
                    </c:if>
                  </td>
                </tr>  -->
                <tr>
                  <td>아이디</td>
                  <td>${member.id}</td>
                </tr>
                <tr>
                  <td>이름</td>
                  <td>${member.name}</td>
                </tr>
                <tr>
                  <td>이메일 주소</td>
                  <td>${member.email}</td>
                </tr>
                <tr>
                  <td>전화번호</td>
                  <td>${member.tel}</td>
                </tr>
                <tr>
                  <td>주소</td>
                  <td>${member.address}</td>
                </tr>
                <tr>
                  <td>포인트</td>
                  <td>${member.point}</td>
                </tr>
              </tbody>
            </table>
          </div>
        
          <!-- 자신 프로필일 경우 -->
          <c:if test="${member.id == sessionScope.sessionId}">
            <div class="profile-edit">
              <a href="memberUpdateAction.me?memberId=${member.id}" class="button special">프로필 변경</a>
              <a href="memberDeleteAction.me?memberId=${member.id}" class="button">탈퇴</a>
            </div>  
          </c:if>
        
        </div>
      </main>
      <!-- main end -->
    </div>
  </div>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
</body>

</html>