<%@page import="com.ppp.vo.Hotel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Hotel h = (Hotel) session.getAttribute("hotel");
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- Modal content-->
<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4 class="modal-title">호텔 회원 정보</h4>
	</div>
	<form id="orner_info_form" action="" method="post"
		enctype="multipart/form-data">
		<div class="modal-body">
			<div class="form-group">
				<label for="who">H O T E L </label>
				<div class="form-group">
					<label for="usr">Business name:</label> <input type="text"
						class="form-control" id="business_name"
						value="<%=h.getHotelName()%>" name='business_name'
						readonly="readonly">
				</div>
				<div class="form-group">
					<label for="usr">Orner name:</label> <input type="text"
						class="form-control" id="orner_name" name='orner_name'
						value="<%=h.getHotelOrnerName()%>" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="usr">Orner no:</label> <input type="text"
						class="form-control" id="orner_no" name='orner_no'
						value="<%=h.getHotelOrnerNo()%>" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="usr">I D:</label> <input type="text"
						class="form-control" id="orner_id" name='orner_id'
						value="<%=h.getHotelId()%>" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="usr" id="la_pwd" style="display:none">Password:</label> <input type="password"
						class="form-control" id="orner_pwd" name='orner_pwd'
						value="<%=h.getHotelPwd()%>" style="display:none">
				</div>
				<div class="form-group">
					<label for="usr">Phone:</label> <input type="text"
						class="form-control" id="orner_phone" name='orner_phone'
						value="<%=h.getHotelPhone()%>" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="usr">Mail:</label><input type="text"
						class="form-control" id="orner_mail" name='orner_mail'
						value="<%=h.getHotelMail()%>" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="usr">Address:</label> <input type="text"
						class="form-control" id="orner_address" name='orner_address'
						value="<%=h.getHotelAddress()%>" readonly="readonly"> <input
						type="button" class="form-control" id="address_btn"
						onclick="postcode()" value="주소검색" style="display:none">
					<span id="guide" style="color: #999"></span>

				</div>

				<!-- <div>
							<input type='hidden' value='1' name='orner_active'> <input
								type='hidden' value='1' name='orner_adminno'><input
								type="hidden" value='0' name="score"><input
								type="hidden" value='0' name="count_review">
						</div> -->

				<div class="form-group">
					<label for="usr">Photo:</label> <input type="file"
						class="form-control" id="image" onchange="InputImage()"
						name='orner_photo' style="display:none">
					<div id="imagePreview">
						<img src='/ppp/hotels/hotelimg/<%=h.getHotelPhoto()%>'
							width='150px'>
					</div>
				</div>


			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-default" id="commit_btn"
					onclick="commit_orner()" value="Update Commit"
					style="visibility: hidden"> 
					<input type="button"
					class="btn btn-default" id="rollback_btn"
					onclick="rollback_orner()" value="Update Rollback"
					style="visibility: hidden"> 
					<input type="button"
					class="btn btn-default" id="update_btn" onclick="update_orner()"
					value="Update">
			</div>
	</form>
</div>

</body>
<script>
	var businessName = document.getElementById("business_name");
	var ornerName = document.getElementById("orner_name");
	var ornerNo = document.getElementById("orner_no");
	var ornerId = document.getElementById("orner_id");
	var ornerPhone = document.getElementById("orner_phone");
	var ornerMail = document.getElementById("orner_mail");
	var ornerAddress = document.getElementById("orner_address");
	var ornerPwd = document.getElementById("orner_pwd");
	var labelPwd = document.getElementById("la_pwd");
	var infoForm = document.getElementById("orner_info_form");
	
	var updateBtn = document.getElementById("update_btn");
	var ornerPhoto = document.getElementById("image");
	var commitBtn = document.getElementById("commit_btn");
	var rollbackBtn = document.getElementById("rollback_btn");
	var addressBtn = document.getElementById("address_btn");

	var commit_orner = function() {
		
		$.ajax({
			type:'POST',
			url:'/ppp/hotel/hotelupdate',
			data: {hotel_name:$("#business_name").val(),hotel_phone:$("#orner_phone").val(),hotel_mail:$("#orner_mail").val(),hotel_address:$("#orner_address").val(),hotel_pwd:$("#orner_pwd").val()},
			success:function(response){
				alert("성공");
			}
		})
		
		businessName.readOnly = true;
		ornerPhone.readOnly = true;
		ornerMail.readOnly = true;
		ornerAddress.readOnly = true;
		updateBtn.style.visibility = "visible";
		commitBtn.style.visibility = "hidden";
		labelPwd.style.display = "none";
		ornerPwd.style.display = "none";
		ornerPhoto.style.diplay = "none";
		rollbackBtn.style.visibility = "hidden";
		addressBtn.style.display = "none";
		
		
	}
	
	var rollback_orner = function() {
		businessName.value = "<%=h.getHotelName()%>";
		ornerPhone.value = "<%=h.getHotelPhone()%>";
		ornerMail.value = "<%=h.getHotelMail()%>";
		ornerAddress.value = "<%=h.getHotelAddress()%>";
		ornerPwd.value = "<%=h.getHotelPwd()%>";
		
		businessName.readOnly = true;
		ornerPhone.readOnly = true;
		ornerMail.readOnly = true;
		ornerAddress.readOnly = true;
		updateBtn.style.visibility = "visible";
		commitBtn.style.visibility = "hidden";
		labelPwd.style.display = "none";
		ornerPwd.style.display = "none";
		ornerPhoto.style.display = "none";
		rollbackBtn.style.visibility = "hidden";
		addressBtn.style.display = "none";
	}

	function update_orner() {
		businessName.readOnly = false;
		ornerPhone.readOnly = false;
		ornerMail.readOnly = false;
		ornerAddress.readOnly = false;
		updateBtn.style.visibility = "hidden";
		commitBtn.style.visibility = "visible";
		ornerPhoto.style.display = "inline-block";
		labelPwd.style.display = "inline-block";
		ornerPwd.style.display = "inline-block";
		rollbackBtn.style.visibility = "visible";
		addressBtn.style.display = "inline-block";
	}
</script>
</html>