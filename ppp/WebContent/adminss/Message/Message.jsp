<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
   position: relative;
}

#section1  {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}

#section2 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}

#section3 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}

#section41 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}

#section42 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white;
}
#section43 {
   padding-top: 50px;
   height: 770px;
   color: black;
   background-color: white; 
}
</style>
<title>Insert title here</title>
</head>
<body>

       <div id="section41" class="container-fluid">
      <h1>쪽지</h1>
      <div class="container">
  <h4 >쪽지보내기</h4>
  <p class="text-center"><em></em></p>
  <div class="row test">
    <div class="col-md-8">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="subject" name="subject" placeholder="subject" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="id" name="id" placeholder="ID" type="text" required>
        </div>
      </div>
      <textarea class="form-control" id="contents" name="contents" placeholder="contents" rows="5"></textarea>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">Send</button>
        </div>
      </div> 
    </div>
  </div>
</div>
   </div>
      

</body>
</html>