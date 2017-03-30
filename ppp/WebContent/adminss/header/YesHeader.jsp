<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
         <div class="navbar-header">
        
            <button type="button" class="navbar-toggle" data-toggle="collapse" 
               data-target="#myNavbar">
               <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                  class="icon-bar"></span>
            </button>
            <a ><img  src="/ppp/adminss/image/logos.png"></a>
         </div>
         <div>
            <div class="collapse navbar-collapse" id="myNavbar">
               <ul class="nav navbar-nav navbar-right">
                  <li class="dropdown"><a class="dropdown-toggle"
                     data-toggle="dropdown" href="#">회원리스트 <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                     <li><a href="user/allList.jsp">회원 리스트</a></li>
                     <li><a href="company/companyList.jsp">기업회원 리스트</a></li>
               
                        <li><a href="admin/adminList.jsp">관리자회원 리스트</a></li>
                        
                     </ul>
                               <li class="dropdown"><a class="dropdown-toggle"
                     data-toggle="dropdown" href="#">회원상세보기 <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                     
                        <li><a href="company/HotelDetailList.jsp">호텔회원 상세보기</a></li>
                        <li><a href="company/SalonDetailList.jsp">미용회원 상세보기</a></li>
 						<li><a href="company/HospitalDetailList.jsp">병원회원 상세보기</a></li>  
 						<li><a href="admin/adminDetailList.jsp">관리자 상세보기</a></li>                     
                     </ul>
                      <li class="dropdown"><a class="dropdown-toggle"
                     data-toggle="dropdown" href="#">비활성화 회원리스트 <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                     
                        <li><a href="activation/normalActivate.jsp">일반회원보기</a></li>
                        <li><a href="activation/companyActivate.jsp">기업회원보기</a></li>
 						                 
                     </ul>
                     <li class="dropdown"><a class="dropdown-toggle"
                     data-toggle="dropdown" href="#">쪽지함<span class="caret"></span></a>
                     <ul class="dropdown-menu">
                     
                        
                        <li><a href="Message/sendMessage.jsp">보낸쪽지함</a></li>
 						                
                     </ul>
                      <li class="dropdown"><a class="dropdown-toggle"
                     data-toggle="dropdown" href="#">쿠폰<span class="caret"></span></a>
                     <ul class="dropdown-menu">
                     
                        <li><a href="coupon.html">쿠폰선물함</a></li>
                        
 						                
                     </ul>
                     <li><a href="#section3">고객센터</a></li>
                  <li><a href="#" data-toggle="modal" data-target="#myModall" ><span class="glyphicon glyphicon-user"></span> My Page</a></li>
                  <li><a href="#" data-toggle="modal" data-target="#myModal" ><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
               </ul>
            </div>
         </div>
      </div>
   </nav>
     <div class="modal fade" id="myModall" role="dialog">
         <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">Modal Header</h4>
               </div>
               <form action="/ppp/member/memberregister" method="post">
               <div class="modal-body">
               
                  <div class="form-group">
                     <label for="usr">Name:</label> <input type="text"
                        class="form-control" id="usr" name='member_name'>
                  </div>
                  <div class="form-group">
                     <label for="usr">I D:</label> <input type="text"
                        class="form-control" id="usr" name='member_id'>
                  </div>
                  <div class="form-group">
                     <label for="pwd">Password:</label> <input type="password"
                        class="form-control" id="pwd" name='member_pwd'>
                  </div>
                  <div class="form-group">
                     <label for="pwd">PasswordCheck:</label> <input type="password"
                        class="form-control" id="pwd" >
                  </div>
                  <div class="form-group">
                     <label for="usr">phone:</label> <input type="text"
                        class="form-control" id="usr" name='member_phone'>
                  </div>
                  <div class="form-group">
                     <label for="usr">mail:</label> <input type="text"
                        class="form-control" id="usr" name='member_mail'>
                  </div>
                  <div class="form-group">
                     <label for="usr">address:</label> <input type="text"
                        class="form-control" id="usr" name='member_address'>
                  </div>
                  <div class="form-group">
                     <label for="usr">Gender:</label>
                        <select class="form-group" name="member_gender" id="usr">
                          <option value="M">남자</option>
                          <option value="F">여자</option>
                       </select>
                  </div>
                  
               </div>
               <div class="modal-footer">
                  <button type="submit" class="btn btn-default">관리자추가</button> 
               </div>
               </form>
            </div>
         </div>
      </div>