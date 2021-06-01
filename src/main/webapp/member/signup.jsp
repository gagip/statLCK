<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>signup</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.css">
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>
<div class="container">    
  <div id="signupbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="panel panel-info">
      <div class="panel-heading">
          <div class="panel-title">회원가입</div>
          <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="signin.me">로그인</a></div>
      </div>  
      <div class="panel-body" >
        <form id="signupform" class="form-horizontal" role="form" action="signupAction.me" method="POST" onsubmit="return checkPw();">
                
        <div id="signupalert" style="display:none" class="alert alert-danger">
          <p>Error:</p>
          <span></span>
        </div>
                
        <div class="form-group">
          <label for="userId" class="col-md-3 control-label">아이디*</label>
          <div class="col-md-9">
              <input type="text" class="form-control" name="id" placeholder="최대 20글자" maxlength="20" required>
          </div>
        </div>
                    
        <div class="form-group">
          <label for="userPw" class="col-md-3 control-label">비밀번호*</label>
          <div class="col-md-9">
              <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호" maxlength="20" required>
          </div>
        </div>
        
        <div class="form-group">
          <label for="userPw" class="col-md-3 control-label">비밀번호 확인*</label>
          <div class="col-md-9">
              <input type="password" class="form-control" id="pw2" name="pw2" placeholder="비밀번호 확인" maxlength="20" required>
          </div>
        </div>
        
        <div class="form-group">
            <label for="userName" class="col-md-3 control-label">이름</label>
            <div class="col-md-9">
                <input type="text" class="form-control" name="name" placeholder="홍길동">
            </div>
        </div>
        
        <div class="form-group">
          <label for="email" class="col-md-3 control-label">이메일*</label>
          <div class="col-md-9">
              <input type="email" class="form-control" name="email" placeholder="이메일" required>
          </div>
        </div>
                    
        <div class="form-group">
          <label for="address" class="col-md-3 control-label">주소</label>
          <div class="col-md-9">
              <input type="text" class="form-control" name="address" placeholder="">
          </div>
        </div>

        <div class="form-group">
          <label for="tel" class="col-md-3 control-label">전화번호</label>
          <div class="col-md-9">
              <input type="text" class="form-control" name="tel" placeholder="숫자만 입력하세요">
          </div>
        </div>
        
        <div class="form-group">
          <label for="tel" class="col-md-3 control-label">이미지</label>
          <div class="col-md-9">
            <input type="file" class="form-control" id="inputGroupFile01" name="pImage">
          </div>
        </div>
        
        <div class="form-group">
            <!-- Button -->                                        
            <div class="col-md-offset-3 col-md-9">
                <button id="btn-signup" type="submit" class="btn btn-info"><i class="icon-hand-right"></i>회원가입</button>
                <span style="margin-left:8px;">or &nbsp;</span>  
                <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i>취소</button>
            </div>
        </div>

      </form>
   </div>
  </div>
 </div> 
</div>
<script type="text/javascript">
// 비밀번호 일치
function checkPw(){
  if (document.signupform.pw.value != document.signupform.pw2.value2){
	alert("비밀번호가 서로 상이합니다");
    return false;
  }

  return true;
}
</script>
</body>

