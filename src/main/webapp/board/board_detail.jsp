<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>board detail</title>
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/index.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.css">
  
  <script>
    $(document).ready(function() {
      $("#boardUpdate").click(function() {
        location.href = "boardUpdateFormAction.bo?boardNum=${board.boardNum}";
      });
      
      $("#boardDelete").click(function() {
    	  var delete_confirm = confirm("정말 해당 게시글을 삭제할까요?");
    	  if (delete_confirm){
    		location.href = "boardDeleteAction.bo?boardNum=${board.boardNum}";  
    	  }
      });
    })  	
  </script>
</head>
<body>
  <jsp:include page="../common/header.jsp"/>
  
  <div class="container-fluid">
    <div class="row">
      <jsp:include page="../common/side_nav.jsp"/>

      <!-- main start -->
      <main class="col-md-10 col-xs-6 ms-auto px-4 mt-3">
        <h3>${board.title}</h3>
        <div>
          <span>${board.author}</span> <span><fmt:formatDate value="${board.pubDate}" pattern="yyyy.MM.dd hh:mm:ss"/></span>
        </div>
        
        <div class="" style="margin: 50px 0;">
        ${board.content}
        </div>
        
        <c:if test="${sessionScope.sessionId == board.author}">
        <div class="d-flex mt-3 mb-3 justify-content-end">
          <button id="boardUpdate">수정</button>
          <button id="boardDelete">삭제</button>
        </div>
        </c:if>
        
        <div id="reply" style="border-top: 1px solid black;">
        <div>
          
          <c:if test="${replyList != null}">
            댓글 ${fn:length(replyList)}개
            <c:forEach var="reply" items="${replyList}">
            <div class="mt-1 mb-1"><b>${reply.author}</b>: ${reply.content}</div>
            </c:forEach>
          </c:if>

        </div>
        
        <c:if test="${sessionScope.sessionId != null}">
        <div class="mt-3">
          <form id="replyWriteForm" onsubmit="writeRpy()">
          <div class="input-group mb-3">
            <input type="hidden" name="boardNum" value="${param.boardNum}">
            <input type="hidden" name="spage" value="${param.spage}"> 
            <input type="text" class="form-control" placeholder="댓글 입력" id="content" name="content">
            <button class="btn btn-outline-secondary" type="submit"">작성</button>
          </div>
          </form>
        </div>
        </c:if>
        </div>
      </main>
      <!-- main end -->
    </div>
  </div>
  <script src="<%=request.getContextPath()%>/static/js/index.js"></script>
  <script>
  var httpRequest = null;
  
  // httpRequest 객체 생성
  function getXMLHttpRequest(){
      var httpRequest = null;
  
      if(window.ActiveXObject){
          try{
              httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
          } catch(e) {
              try{
                  httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
              } catch (e2) { httpRequest = null; }
          }
      }
      else if(window.XMLHttpRequest){
          httpRequest = new window.XMLHttpRequest();
      }
      return httpRequest;    
  }
  
  // 댓글 등록
  function writeRpy()
  {
      var form = document.getElementById("replyWriteForm");
      
      var boardNum = form.boardNum.value;
      var content = form.content.value;
      
      if(!content)
      {
          alert("내용을 입력하세요.");
          return false;
      }
      else
      {    
          var param="boardNum="+boardNum+"&content="+content;
              
          httpRequest = getXMLHttpRequest();
          httpRequest.onreadystatechange = checkFunc;
          httpRequest.open("POST", "replyWriteAction.re", true);    
          httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=UTF-8'); 
          httpRequest.send(param);
      }
  }
  
  function checkFunc(){
      if(httpRequest.readyState == 4){
          // 결과값을 가져온다.
          var resultText = httpRequest.responseText;
          if(resultText == 1){ 
              document.location.reload(); // 상세보기 창 새로고침
          }
      }
  }
  </script>
</body>
</html>