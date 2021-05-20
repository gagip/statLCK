<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>signin</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.css">
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>


<body>
<div class="container">
  <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
    <div class="panel panel-info" >
      <div class="panel-heading">
          <div class="panel-title">로그인</div>
          <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">비밀번호를 잊으셨나요?</a></div>
      </div>     
    
      <div style="padding-top:30px" class="panel-body" >
        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
        <form id="loginform" class="form-horizontal" role="form">
                        
        <div style="margin-bottom: 25px" class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
          <input id="login-username" type="text" class="form-control" name="userId" value="" placeholder="아이디">                                        
        </div>
                    
        <div style="margin-bottom: 25px" class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
          <input id="login-password" type="password" class="form-control" name="password" placeholder="비밀번호">
        </div>
                        
    
        <div class="input-group">
          <div class="checkbox">
            <label>
              <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
            </label>
          </div>
        </div>
    
    
        <div style="margin-top:10px" class="form-group">
          <!-- Button -->
          <div class="col-sm-12 controls">
            <a id="btn-login" href="#" class="btn btn-success">로그인</a>
            <a id="btn-back" href="#" class="btn btn-primary">뒤로가기</a>
          </div>
        </div>
    
    
        <div class="form-group">
          <div class="col-md-12 control">
            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                계정이 없으시다면? 
            <a href="<%=request.getContextPath()%>/member/signup.jsp">
                회원가입
            </a>
            </div>
          </div>
        </div>    
        </form>     
      </div>                     
    </div>  
  </div>
</div>
</body>

</html>