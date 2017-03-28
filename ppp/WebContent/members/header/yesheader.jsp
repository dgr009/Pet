<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
         <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" 
               data-target="#myNavbar">
               <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                  class="icon-bar"></span>
            </button>
          <a href="/ppp/member/membermain"><img src="/ppp/images/logo2.png"></a>
         </div>
         <div>
            <div class="collapse navbar-collapse" id="myNavbar">
               <ul class="nav navbar-nav navbar-right">
                  <li class="dropdown"><a class="dropdown-toggle"
                     data-toggle="dropdown" href="#">예약 <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                        <li><a href="#section41">호텔</a></li>
                        <li><a href="#section42">병원</a></li>
                        <li><a href="#section43">미용</a></li>
                     </ul>
                     <li><a href="#section2">게시판</a></li>
                     <li><a href="#section3">고객센터</a></li>
                  <li><a href="/ppp/member/memberinfo" data-toggle="modal" data-target="#myModall" ><span class="glyphicon glyphicon-user"></span> My Page</a></li>
                  <li><a href="/ppp/member/memberlogout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
               </ul>
            </div>
         </div>
      </div>
   </nav>
</body>
</html>