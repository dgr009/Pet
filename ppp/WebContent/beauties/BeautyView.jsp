<%@page import="com.ppp.vo.Beauty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Beauty h = (Beauty)request.getAttribute("beauty");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>PetPaPa BeautyList</title>
    <link href="/ppp/css/reset.css" rel="stylesheet" />
    <link href="/ppp/css/view_detail.css" rel="stylesheet" />
   
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

var beauticianDetail = <%=request.getAttribute("beautician")%>
var beauty = <%=session.getAttribute("beautygson") %>
$(document).ready(function() {
	
	var div_btn1 = $("<div class='btns'></div>");
	var div_btn2 = $("<div class='btns'></div>");
	var div_btn3 = $("<div class='btns'></div>");
	var div_btn4 = $("<div class='btns'></div>");
	var reserve_btn = div_btn1.append('<a href="/ppp/member/reserveBeauty"><span id="fon">예약</span><img src="/ppp/images/reserv.png" alt="Alternate Text" width="150" height="70" /></a>');
	var update_btn = div_btn2.append('<a href="/ppp/beauty/beauticianupdate"><span id="fon">수정</span><img src="/ppp/images/update.png" alt="Alternate Text" width="150" height="70" /></a>')
	var regist_btn = div_btn3.append('<a href="/ppp/beauty/beauticianregister"><span id="fon">추가</span><img src="/ppp/images/regist.png" alt="Alternate Text" width="150" height="70" /></a>')
	var delete_btn = div_btn4.append('<a href="/ppp/beauty/beauticiandelete"><span id="fon">삭제</span><img src="/ppp/images/delete.png" alt="Alternate Text" width="150" height="70" /></a>')
	
	if(beauty!=null){
		if(beauty.beautyNo==<%=h.getBeautyNo()%>){
			$(".detail_header").append(update_btn);
			$(".detail_header").append(regist_btn);
			$(".detail_header").append(delete_btn);
		}
	}else{
		 $(".detail_header").append(reserve_btn);
	}
	
	$.each(beauticianDetail, function(index, r) {
		var beauticianPhoto = $("<img src='/ppp/beauties/beauticianimg/"+r.beauticianPhoto+"' alt='Alternate Text' width='300' height='300' >");
		$(".detail_img").append(beauticianPhoto);
		var beauticianName = $("<td></td>").html(r.beauticianName);
		var beauticianIntro = $("<td></td>").html(r.beauticianIntroduce);
		var tr = $('<tr></tr>').append(beauticianName).append(beauticianIntro);
		$("#beautician_info tbody").append(tr);
			
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
                <h2><%= h.getBeautyName() %></h2>
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
                        <p><%=h.getBeautyAddress() %></p>
                    </div>
                    <div>
                        <p>전화번호</p>
                        <p><%=h.getBeautyPhone() %></p>
                    </div>
                    <div>
                        <p>이메일</p>
                        <p><%=h.getBeautyMail() %></p>
                    </div>
                </div>
                <div class="detail_row info2">
                    <table id='beautician_info'>
                        <thead>
                            <tr>
                                <th>무게</th>
                                <th>가격</th>
                            </tr>
                        </thead>
                        <tbody>
                          
                        </tbody>
                    </table>
                </div>
            </div>
        </article>
    </section>

</body>
</html>