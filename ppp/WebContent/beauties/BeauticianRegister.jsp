<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
var InputImage = (function loadImageFile() {
	if (window.FileReader) {
		var ImagePre;
		var ImgReader = new window.FileReader();
		var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i;

		ImgReader.onload = function(Event) {
			if (!ImagePre) {
				var newPreview = document.getElementById("imagePreview");
				ImagePre = new Image();
				ImagePre.style.width = "400px";
				ImagePre.style.height = "400px";
				newPreview.appendChild(ImagePre);
			}
			ImagePre.src = Event.target.result;

		};

		return function() {

			var img = document.getElementById("image").files;

			if (!fileType.test(img[0].type)) {
				alert("이미지 파일을 업로드 하세요");
				return;
			}

			ImgReader.readAsDataURL(img[0]);
		}

	}

	document.getElementById("imagePreview").src = document
			.getElementById("image").value;

})();
</script>
</head>
<body>
	<form id="room_form" action="/ppp/beauty/beauticianregister" method="post"
					enctype="multipart/form-data">
					<div class="modal-body">
						<div class="form-group">
							<label for="usr">Beautician Name:</label> <input type="text"
								class="form-control" id="usr" name='beautician_name'>
						</div>
						<div class="form-group">
							<label for="usr">Beautician Introduce:</label> <input type="text"
								class="form-control" id="usr" name='beautician_introduce'>
						</div>
						<div class="form-group">
							<label for="usr">Beautician Photo:</label> <input type="file"
								class="form-control" id="image" onchange="InputImage()"
								name='beautician_photo'>
							<div id="imagePreview"></div>
						</div>


					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-default" value="Register">
					</div>
				</form>
</body>
</html>