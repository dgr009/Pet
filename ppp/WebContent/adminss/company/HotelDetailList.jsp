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
 <div id="section50-1" class="container-fluid">
      
     <section class="wrapper">
    <section class="page_head">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                  
                    <div class="page_title">
                     
                    </div>
                </div>
            </div>
        </div>
    </section>


		  <div id="subRight">

				
<!-- ������ Ÿ��Ʋ -->
<div class="padgeName">
	<h2>ȣ�ھ�ü�󼼺���</h2>
	<div>
		<input class="input-text" name="s" id="s" placeholder="Enter Search keywords..." type="text" />
		<input id="searchsubmit" value="Search" type="submit" />
</div>
</div>
<!-- ������ Ÿ��Ʋ -->



				<!-- con -->
            	<form method="post" name="frmMem" id="frmMem" action="/Front/Join/Mem_IM.asp"> 
				<input type='hidden' name='gMnu1' id='gMnu1' value='206'>   
				<input type='hidden' name='gMnu2' id='gMnu2' value='20602'>   
				<input type="hidden" name="sKind" id="sKind" value="M">

				<div class="con">
					
					<!-- �Խ��� -->
					<div class="t_board">
						<table class="board_write" summary="�̸�, �����̸�, ���̵�, �г���, ����й�ȣ, ����й�ȣ Ȯ��, ��ȭ��ȣ, �޴���, �̸���, ���԰��, ��õ��ID ���� ����">
							<caption>ȸ�������Է�</caption>
							<colgroup>
								<col width="15%"/><col width="35%"/>
								<col width="15%"/><col width="35%"/>
							</colgroup>
							<tbody>

							<tr>
								<th>���̵�</th>
								<td colspan="3">
									<span class="bold"></span>
								</td> 
							</tr>

							
							
							<tr>
								<td colspan="4" style="height:2px;"></td>
							</tr>

							<tr>
								<th>�г���</th>
								<td>
								
								<input type="hidden" name="sNick" id="sNick" maxlength="20" class="input_txt2 ipt_type1" value="ronron" readOnly />
								
								</td>
								<th>�������</th>
								<td></td>
							</tr>

							<tr>
								<th>�̸�</th>
								<td></td>
								<th>�����̸�</th>
								<td>
									<input type="text" name="sMemEnNm" id="sMemEnNm" maxlength="30" class="input_txt2 ipt_type1" value="" />
								</td>
							</tr>

							<tr>
								<th>������ ��й�ȣ</th>
								<td>
									<input type="password" name="sMemPw" id="sMemPw" maxlength="20" class="input_txt2 ipt_type1" value="" />
								</td>
								<th>��й�ȣ Ȯ��</th>
								<td>
									<input type="password" name="sMemPw1" id="sMemPw1" maxlength="20" class="input_txt2 ipt_type1" value="" />
								</td>
							</tr>

							<tr> 
								<th>�޴���</th>
								<td>
									<input type="text" name="sMobNo1" id="sMobNo1" maxlength="4" class="input_txt2 hp" value="" onClick="fnMobSmsAuthSend();" readOnly />  
									
									
								</td>
								
							</tr>

							<tr>
								<th>�̸���</th>
								<td colspan="3"><input type="email" id="sEmail1" name="sEmail1" maxlength="30" class="input_txt2 email_1" value=""/>
								
									
								</td> 
							</tr>

							<tr>
								<th>ȸ��Ż�𿩺�</th>
								<td>
									<label><input type="radio" name="sEmailRcvYN" id="sEmailRcvYN" class="input_chk2" value="Y"  /> Ż��</label> &nbsp;
									<label><input type="radio" name="sEmailRcvYN" id="sEmailRcvYN" class="input_chk2" value="N" checked /> Ż�����</label>
								</td>
								<th>ȸ��Ȱ��ȭ����</th>
								<td>
									<label><input type="radio" name="sSmsRcvYN" id="sSmsRcvYN" class="input_chk2" value="Y"  /> Ȱ��ȭ</label> &nbsp;
								<label><input type="radio" name="sSmsRcvYN" id="sSmsRcvYN" class="input_chk2" value="N" checked /> Ȱ��ȭ����</label>
								</td>
							</tr>
								<tr>
								<th>ȸ������</th>
								<td>
								<input id="searchsubmit" value="����" type="submit" />
									
								</td> 
								<th>ȸ������</th>
								<td>
								<input id="searchsubmit" value="������Ʈ" type="submit" />
									
								</td> 
							</tr>
								
								
							
								
							

							</tbody>
						</table>
					</div>
					<!-- //�Խ��� -->

					
					

				</div>
				</form>
				<!-- //con -->


			</div>
		
   </div>
    <br>
    <br>
    <br>     <br>
    <br>
    <br>    
     <br>
    <br>
    <br>   
     <br>
    <br>
    <br>    
     <br>
    <br>
    <br>    
     <br>
    <br>
    <br>     
</body>
</html>