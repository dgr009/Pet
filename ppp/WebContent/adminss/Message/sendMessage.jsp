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
</head>
<body>
<div id="section60" class="container-fluid">
     
           <div data-role="page" id="test">
     
<div data-role="panel" data-display="push" id="panel2-push" data-position="right">
		<div style="background-color:#333; padding:10px 0 10px 10px; color:#fff;"><h3><i class="ui-circle ui-circle-e newIcon" style="display:none">N</i> 보낸쪽지 <span class="messageViewBtn" style="float:right; font-size:1.0em; margin-right:0.8em;"><a href="notify.html" data-rel="external" style="color:#ffffff;"><i class="pe-7s-plus"></i></a></span></h3></div>
		<div class="ui-padding">
			
			<div data-role="listview" id="leftMessageList"></div>
		</div>
      </div>

   
     
       <div data-role="content" class="ui-padding">
        <h2>보낸쪽지 목록</h2>
		
		<table data-role="table" data-mode="columntoggle" class="ui-responsive table-stripe" id="msgTable">
         <thead>
         <colgroup>
								<col width="15%" />
								<col width="50%" />
								<col width="18%" />
								<col width="15%" />
								
								
							</colgroup>
           <tr>
             <th data-priority="3">No.        &emsp;&emsp;&emsp;&emsp;  &emsp; </th>
           
             <th class="align-left">제목       &emsp;&emsp; &emsp;&emsp;&emsp; </th>
             <th data-priority="2">날짜         &emsp;&emsp;&emsp;&emsp;&emsp; </th>
             <th data-priority="1">보낸이       &emsp;&emsp; &emsp;&emsp;&emsp;</th>
           </tr>
        
         </thead>
         <tbody id="msgList">
                      
         </tbody>
       </table>
	   <div class="ac">
			<a class="ui-btn ui-btn-f ui-btn-inline ui-icon-md-email ui-btn-icon-left ui-shadow ui-corner-all" href="Message.jsp" data-rel="dialog" data-transition="slideup" data-rel="external">쪽지보내기</a>
			<a class="ui-btn ui-btn-a ui-btn-inline ui-icon-md-expand-less ui-btn-icon-left ui-shadow ui-corner-all" href="MessageRecieve.html">쪽지보관함</a>
		 </div>
      </div>
      </div>
      </div>
</body>
</html>