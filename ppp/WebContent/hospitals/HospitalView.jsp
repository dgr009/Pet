<%@page import="com.ppp.vo.Hospital"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Hospital h = (Hospital)request.getAttribute("hospital");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>PetPaPa HospitalList</title>
    <link href="/ppp/css/reset.css" rel="stylesheet" />
    <link href="/ppp/css/view_detail.css" rel="stylesheet" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

var vetDetail = <%=request.getAttribute("vet")%>
var hospital = <%=session.getAttribute("hospitalgson") %>
var hospitalReview = <%=request.getAttribute("review")%>

$(document).ready(function() {
	
	var div_btn1 = $("<div class='btns'></div>");
	var div_btn2 = $("<div class='btns'></div>");
	var div_btn3 = $("<div class='btns'></div>");
	var div_btn4 = $("<div class='btns'></div>");
	var reserve_btn = div_btn1.append('<a href="/ppp/member/reservehospital?hospital_no=<%=h.getHospitalNo()%>"><span id="fon">예약</span><img src="/ppp/images/reserv.png" alt="Alternate Text" width="150" height="70" /></a>');
	var update_btn = div_btn2.append('<a href="/ppp/hospital/vetupdate"><span id="fon">수정</span><img src="/ppp/images/update.png" alt="Alternate Text" width="150" height="70" /></a>')
	var regist_btn = div_btn3.append('<a href="/ppp/hospital/vetregister"><span id="fon">추가</span><img src="/ppp/images/regist.png" alt="Alternate Text" width="150" height="70" /></a>')
	var delete_btn = div_btn4.append('<a href="/ppp/hospital/vetdelete"><span id="fon">삭제</span><img src="/ppp/images/delete.png" alt="Alternate Text" width="150" height="70" /></a>')
	if(hospital!=null){
		if(hospital.hospitalNo==<%=h.getHospitalNo()%>){
			$(".detail_header").append(update_btn);
			$(".detail_header").append(regist_btn);
			$(".detail_header").append(delete_btn);
		}
	}else{
		 $(".detail_header").append(reserve_btn);
	}
	
	$.each(vetDetail, function(index, r) {
		var vetPhoto = $("<img src='/ppp/hospitals/vetimg/"+r.vetPhoto+"' alt='Alternate Text' width='300' height='300' >");
		$(".detail_img").append(vetPhoto);
		var vetName = $("<td></td>").html(r.vetName);
		var vetIntro = $("<td></td>").html(r.vetIntroduce);
		var tr = $('<tr></tr>').append(vetName).append(vetIntro);
		$("#vet_info tbody").append(tr);
			
	})
	$.each(hospitalReview, function(index,hr){
		var hrNo = $("<td style='text-align:center; border:1px solid black;'></td>").html(hr.hospitalReviewNo);
		var hrScore = $("<td style='text-align:center; border:1px solid black;'></td>").html(hr.hospitalReviewScore);
		var hrEpil = $("<td style='text-align:center; border:1px solid black;'></td>").html(hr.hospitalReviewEpilogue);
		
		var tr = $('<tr></tr>').append(hrNo).append(hrScore).append(hrEpil);
		$('.hospital_review tbody').append(tr);
	})
	
});
</script>
</head>
<body>
<!-- 헤더 -->
	<%@ include file="../members/BigHeader.jsp"%>
	
	 <header>
	 수민이형 바보
    </header>
    <section class="hotel_section">
        <div class="detail_header">
            <div>
                <h2><%= h.getHospitalName() %></h2>
            </div>
           
        </div>
        <hr />
        <article class="detail_article">
            <div class="detail_img">

            </div>
            <div class="detail_description">
                <div class="detail_row info">
                    <div>
                        <p>주소</p>
                        <p><%=h.getHospitalAddress() %></p>
                    </div>
                    <div>
                        <p>전화번호</p>
                        <p><%=h.getHospitalPhone() %></p>
                    </div>
                    <div>
                        <p>이메일</p>
                        <p><%=h.getHospitalMail() %></p>
                    </div>
                </div>
                <div class="detail_row info2">
                    <table id='vet_info'>
                        <thead>
                            <tr>
                                <th>이름</th>
                                <th>소개</th>
                            </tr>
                        </thead>
                        <tbody>
                          
                        </tbody>
                    </table>
                </div>
            </div>
        </article>
    </section>
    <hr />
    <h3 style='text-align:center;'>리뷰</h3>
				<table class='hospital_review' width='90%'  style='margin: 50px; border:1px solid skyblue; '>
                        <thead id='hospital_review_header'>
                            <tr style='border:1px solid skyblue;'>
                                <th width='10%' style='text-align:center; border:1px solid black;'>번호</th>
                                <th width='10%' style='text-align:center; border:1px solid black;'>점수</th>
                                <th width='70%' style='text-align:center; border:1px solid black;'>내용</th>
                            </tr>
                        </thead>
                        <tbody id='hospital_review_body'>
                          	
                        </tbody>
                    </table>
</body>
</html>