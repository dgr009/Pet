package com.ppp.dao;

public interface Sql {
	// 1.회원 리스트 조회
	public String allMember = "select member_no,member_id,member_address,member_name,member_phone,member_mail,member_gender,member_coupon from member where member_active=1 ";
	// 2.아이디로 회원 리스트 조회
	public String allMemberId="select member_no,member_id,member_address,member_name,member_phone,member_mail,member_gender,member_coupon from member where member_id=? and member_active=1";
	//3. 병원 리스트 조회
	public String allHospital="select hospital_no,hospital_name,hospital_orner_name,hospital_orner_no,hospital_mail,hospital_address,hospital_phone from hospital where hospital_active=1";
	//4. 미용실 리스트 조회
	public String allBeauty="select beauty_no,beauty_name,beauty_orner_name,beauty_orner_no,beauty_mail,beauty_address,beauty_phone from beauty where beauty_active=1";
	//5. 호텔 리스트 조회
	public String allHotel="select hotel_no,hotel_name,hotel_orner_name,hotel_orner_no,hotel_mail,hotel_address,hotel_phone from hotel where hotel_active=1";
	//6. 아이디로 병원 리스트 조회
	public String allHospitalId="select hospital_no,hospital_name,hospital_orner_name,hospital_orner_no,hospital_mail,hospital_address,hospital_phone from hospital where hospital_id=? and hospital_active=1";
	//7. 아이디로 미용실 리스트 조회
	public String allBeautyId="select beauty_no,beauty_name,beauty_orner_name,beauty_orner_no,beauty_mail,beauty_address,beauty_phone from beauty where beauty_id=? and beauty_active=1";
	//8. 아이디로 호텔 리스트 조회
	public String allHotelId="select hotel_no,hotel_name,hotel_orner_name,hotel_orner_no,hotel_mail,hotel_address,hotel_phone from hotel where hotel_id=? and hotel_active=1";
	//9. 관리자 리스트 조회
	public String allAdmin="select * from admin";
	//10. 회원 쿠폰수 조회
	public String memberCoupon="select member_no,member_id,member_address,member_name,member_phone,member_mail,member_gender,member_coupon from member where member_coupon=? and member_active=1";
	//11. 회원 쿠폰수 수정
	public String updateMemberCoupon="update member set member_coupon = 0 where member_no=?";
	//12. 회원 비활성화
	public String inactiveMember="update member set member_active = 2 where member_no=?";
	//13. 비활성화 된 회원 조회
	public String allInactiveMember="select member_no,member_id,member_address,member_name,member_phone,member_mail,member_gender,member_coupon from member where member_active=2 order by member_active_date desc";
	//14. 병원회원 비활성화
	public String inactiveHospital="update hospital set hospital_active=2 where hospital_no=?";
	//15. 미용실회원 비활성화
	public String inactiveBeauty="update beauty set beauty_active=2 where beauty_no=?";
	//16. 호텔회원 비활성화
	public String inactiveHotel="update hotel set hotel_active=2 where hotel_no=?";
	//17. 비활성화 된 병원회원 조회
	public String allInactiveHospital="select hospital_no,hospital_name,hospital_orner_name,hospital_orner_no,hospital_mail,hospital_address,hospital_phone from hospital where hospital_active=2 order by  hospital_active_date desc";
	//18. 비활성화 된 미용실회원 조회
	public String allInactiveBeauty="select beauty_no,beauty_name,beauty_orner_name,beauty_orner_no,beauty_mail,beauty_address,beauty_phone from beauty where beauty_active=2 order by beauty_active_date desc";
	//19. 비활성화 된 호텔회원 조회
	public String allInactiveHotel="select hotel_no,hotel_name,hotel_orner_name,hotel_orner_no,hotel_mail,hotel_address,hotel_phone from hotel where hotel_active=2 order by hotel_active_date desc";
	//20. 회원 삭제
	public String deleteMember="delete from member where member_no=?";
	//21. 병원 삭제
	public String deleteHospital="delete from hospital where hospital_no=?";
	//22. 미용실 삭제
	public String deleteBeauty="delete from beauty where beauty_no=?";
	//23. 호텔 삭제
	public String deleteHotel="delete from hotel where hotel_no=?";
	//24. 자유게시판 글 삭제
	public String deleteFreeBoard="delete from free_board where free_board_no=? and member_no=?";
	//25. 관리자 삭제
	public String deleteAdmin="delete from admin where admin_no=?";
	//26. 병원 리뷰삭제
	public String deleteHospitalReview="delete from hospital_review where hospital_review_no=? and member_no=?";
	//27. 미용실 리뷰삭제
	public String deleteBeautyReview="delete from beauty_review where beauty_review_no=? and member_no=?";
	//28. 호텔 리뷰삭제
	public String deleteHotelReview="delete from hotel_review where hotel_review_no=? and member_no=?";
	//29. 내가 쓴 글 조회
	public String allArticle="select free_borad_title from free_board where member_no=?";
	//30. 개인회원 병원예약내역 확인
	public String allReserveHospital="select * from reserve_hospital where member_no=?";
	//31. 개인회원 미용실예약내역 확인
	public String allReserveBeauty="select * from reserve_beauty where member_no=?";
	//32. 개인회원 호텔예약내역 확인
	public String allReserveHotel="select * from reserve_hotel where member_no=?";
	//33. 회원 정보수정
	public String updateMember="update member set member_name=?,member_pwd=?,member_address=?,member_phone=?,member_mail=?,member_gender=? where member_no=?";
	//34. 회원 비밀번호 수정
	public String updateMemberPwd="update member set member_pwd=? where member_no=?";
	//35. 회원 아이디 찾기
	public String findMemberId="select member_id from member where member_mail=? and member_name=?";
	//36. 회원 비밀번호 찾기
	public String findMemberPwd="select member_pwd from member where member_mail=? and member_name=? and member_id=?";
	//37. 반려동물 수정
	public String updateAnimal="update animal set ANIMAL_NAME=?,animal_kind=?, ANIMAL_GENDER=?,animal_breed=?, ANIMAL_WEIGHT=? where member_no=? and animal_no=?";
	//38. 반려동물 삭제
	public String deleteAnimal="delete from animal where member_no=? and animal_no=?";
	//39. 병원 정보 수정
	public String updateHospital="update hospital set hospital_name=?,hospital_mail=?,hospital_address=?,hospital_phone=?,hospital_orner_name=? where hospital_no=?";
	//40. 미용실 정보 수정
	public String updateBeauty="update beauty set beauty_name=?,beauty_mail=?,beauty_address=?,beauty_phone=?,beauty_orner_name=? where beauty_no?";
	//41. 호텔 정보 수정
	public String updateHotel="update hotel set hotel_name=?,hotel_mail=?,hotel_address=?,hotel_phone=?,hotel_orner_name=? where hotel_no=?";
	//42. 병원 아이디 찾기
	public String findHospitalId="select hospital_id from hospital where hospital_mail=? and hospital_orner_no=?";
	//43. 미용실 아이디 찾기
	public String findBeautyId="select beauty_id from beauty where beauty_mail=? and beauty_orner_no=?";
	//44. 호텔 아이디 찾기
	public String findHotelId="select hotel_id from hotel where hotel_mail=? and hotel_orner_no=?";
	//45. 병원 비밀번호 찾기
	public String findHospitalPwd="select hospital_pwd from hospital where hospital_mail=? and hospital_orner_no=? and hospital_id=?";
	//46. 미용실 비밀번호 찾기
	public String findBeautyPwd="select beauty_pwd from beauty where beauty_mail=? and beauty_orner_no=? and beauty_id=?";
	//47. 호텔 비밀번호 찾기
	public String findHotelPwd="select hotel_pwd from hotel where hotel_mail=? and hotel_orner_no=? and hotel_id=?";
	//48. 호텔 방 수정
	public String updateRoom="update room set room_kind=? , room_price=? where hotel_no=? and room_no=?";
	//49. 호텔 방 삭제
	public String deleteRoom="delete from room where hotel_no=? and room_no=?";
	//50. 예약된 방 확인
	public String rserveHotel="select * from reserve_hotel where hotel_no=? order by reserve_hotel_date des";
	//51. 지역별 병원 검색
	public String findAreaHospital="select hospital_no,hospital_name,hospital_orner_name,hospital_orner_no,hospital_mail,hospital_address,hospital_phone from hospital where hospital_address like '%?%'";
	//52. 지역별 미용실 검색
	public String findAreaBeauty="select beauty_no,beauty_name,beauty_orner_name,beauty_orner_no,beauty_mail,beauty_address,beauty_phone from beauty where beauty_address like %?%";
	//53. 지역별 호텔 검색
	public String findAreaHotel="select hotel_no,hotel_name,hotel_orner_name,hotel_orner_no,hotel_mail,hotel_address,hotel_phone from hotel where hotel_address like '%?%";
	//54. 리뷰순 병원 검색
	public String findReviewCntHospital="select h.hospital_name,h.hospital_address,h.hospital_phone,h.hospital_mail from hospital h,hospital_review r where h.hospital_no=r.hospital_no order by r.hospital_review_cnt desc";
	//55. 리뷰순 미용실 검색
	public String findReviewCntBeauty="select h.hotel_name,h.hotel_address,h.hotel_phone,h.hotel_mail from hotel h,hotel_review r where h.hotel_no=r.hotel_no order by r.hotel_review_cnt desc";
	//56. 리뷰순 호텔 검색
	public String findReviewCntHotel="select b.beauty_name,b.beauty_address,b.beauty_phone,b.beauty_mail from beauty b,beauty_review r where b.beauty_no=r.beauty_no order by r.beauty_review_cnt desc";
	//57. 평점별 병원 검색
	public String findScoreHospita="select hospital_name,hospital_orner_name,hospital_orner_no,hospital_mail,hospital_address,hospital_phone from hospital h, hospital_review r where h.hospital_no=r.hospital_no order by hospital_review_score desc";
	//58. 평점별 미용실 검색
	public String findScoreBeauty="select beauty_name,beauty_orner_name,beauty_orner_no,beauty_mail,beauty_address,beauty_phone from beauty b, beauty_review r where b.beauty_no=r.beauty_no order by beauty_review_score desc";
	//59. 평점별 호텔 검색
	public String findScoreHotel="select hotel_name,hotel_orner_name,hotel_orner_no,hotel_mail,hotel_address,hotel_phone from hotel h, hotel_review r where h.hotel_no=r.hotel_no order by hotel_review_score desc";
	//60. 병원별 전체 예약내역 확인
	public String findAllReserveHospital="select * from reserve_hospital where hospital_no=?";
	//61. 미용실별 전체 예약내역 확인
	public String findAllReserveBeauty="select * from reserve_beauty where beauty_no=?";
	//62. 호텔별 전체 예약내역 확인
	public String findAllReserveHotel="select * from reserve_hotel where hotel_no=?";
	//63. 날짜별 병원 예약내역 확인
	public String findDateReserveHospital="select * from reserve_hospital where hospital_no=? and reserve_hospital_date=?";
	//64. 날짜별 미용실 예약내역 확인
	public String findDateReserveBeauty="select * from reserve_beauty where beauty_no=? and reserve_beauty_date=?";
	//65. 날짜별 호텔 예약내역 확인
	public String findDateReserveHotel="select * from reserve_hotel where hotel_no=? and reserve_hotel_date=?";
	//66. 자유게시판 수정
	public String updateFreeBoard="update free_board set free_board_title='?', free_board_content='?' where member_no=?";
	//67. 자유게시판 최신순으로 보기
	public String findDateFreeBoard="select * from free_board order by free_board_date desc";
	//68. 아이디로 작성한 글 찾기
	public String findIdFreeBoard="select * from free_board f , member m where m.member_no=f.member_no and m.member_id=?";
	//69. 자유게시판 댓글 수정
	public String updateFreeBoardComment="update free_board_comment set free_board_comment_content='?' where member_no=?";
	//70. 자유게시판 댓글 삭제
	public String deleteFreeBoardComment="delete free_board_comment where member_no=? and free_board_comment_no=?";
	//71. 관리자 보낸 쪽지함 보기
	public String allAdminMessage="select * from message where admin_no=?;";
	//72. 문의게시판 수정
	public String updateInquireBoard="update inquire_board set inquire_board_content='?' where admin_no=?";
	//73. 제목으로 문의게시판 글 검색
	public String findTitleInquireBoard="select * from inquire_board where inquire_board_title like '%?%'";
	//74. 문의게시판 글 삭제
	public String deleteInquireBoard="delete inquire_board where member_no=? and inquire_board_no=?";
	//75. 병원별 리뷰 보기
	public String allReviewHospital="select hospital_review_no,hospital_review_score,hospital_review_epilogue from hospital_review where hospital_no=?";
	//76. 미용실별 리뷰 보기
	public String allReviewBeauty="select beauty_review_no,beauty_review_score,beauty_review_epilogue from beauty_review where beauty_no=?";
	//77. 호텔별 리뷰 보기
	public String allReviewHotel="select hotel_review_no,hotel_review_score,hotel_review_epilogue from hotel_review where hotel_no=?";
	//78. 수의사 프로필 보기
	public String allVet="select v.vet_no,v.vet_name,v.vet_introduce,h.hospital_name from hospital h, vet v where h.hospital_no=v.hospital_no and h.hospital_no=?";
	//79. 미용사 프로필 보기
	public String allBeautician="select b.beautician_no,b.beautician_name,b.beautician_introduce,be.beauty_name from beauty be , beautician b where be.beauty_no=b.beauty_no and be.beauty_no=?";
	//80. 호텔 방 보기
	public String allRoom="select r.room_no,r.room_kind,r.room_price,h.hotel_name from hotel h, room r where h.hotel_no=r.hotel_no and h.hotel_no=?";
	//81. 수의사 프로필 수정
	public String updateVet="update vet set vet_name='?', vet_introduce='?' where vet_no=? and hospital_no=?";
	//82. 미용사 프로필 수정
	public String updateBeautician="update beautician set beautician_name='?', beautician_introduce='?' where beautician_no=? and beauty_no=?";
	//83. 수의사 프로필 삭제
	public String deleteVet="delete vet where vet_no=? and hospital_no=?";
	//84. 미용사 프로필 삭제
	public String deleteBeautician="delete beautician where beautician_no=? and beauty_no=?";
	//85. 동물 리스트 보기
	public String allAnimal="select a.member_no,a.animal_no,a.animal_name,a.animal_kind,a.animal_gender,a.animal_breed,a.animal_weight from animal a, member b where a.member_no=b.member_no and b.member_no=?";
	//86. 병원 예약시간대 수정
	public String updateReserveHospitalTime="update reserve_hospital_time set hospital_time_kind='?' where  reserve_hospital_time_no=? and hospital_no=?";
	//87. 미용실 예약시간대 수정
	public String updateReserveBeautyTime="update reserve_beauty_time set beauty_time_kind='?' where reserve_beauty_time_no=? and beauty_no=?";
	//88. 병원 예약시간대 삭제
	public String deleteReserveHospitalTime="delete reserve_hospital_time where reserve_hospital_time_no=? and hospital_no=?";
	//89. 미용실 예약시간대 수정
	public String deleteReserveBeautyTime="delete reserve_beauty_time where reserve_beauty_time_no=? and beauty_no=?";
	//90. 관리자 추가
	public String insertAdmin="INSERT INTO admin(admin_no,admin_id,admin_pwd,admin_name,admin_mail) VALUES(?,?,?,?,?)";
	//91. 회원 추가
	public String insertMember="insert into member(member_no,member_address,member_id,member_pwd,member_gender,member_phone,member_name,member_mail,member_coupon,member_active,admin_no) values(?,?,?,?,?,?,?,?,?,1,?)";
	//92. 병원회원 추가
	public String insertHospital="insert into hospital(hospital_no,hospital_name,hospital_orner_name,hospital_orner_no,hospital_mail,hospital_phone,hospital_address,hospital_id,hospital_pwd,hospital_photo,hospital_active,admin_no) values(?,?,?,?,?,?,?,?,?,?,1,?)";
	//93. 미용실회원 추가
	public String insertBeauty="insert into beauty(beauty_no,beauty_name,beauty_orner_name,beauty_orner_no,beauty_mail,beauty_phone,beauty_address,beauty_id,beauty_pwd,beauty_photo,beauty_active,admin_no) values(?,?,?,?,?,?,?,?,?,?,1,?)";
	//94. 호텔회원 추가
	public String insertHotel="insert into hotel(hotel_no,hotel_name,hotel_orner_name,hotel_orner_no,hotel_mail,hotel_phone,hotel_address,hotel_id,hotel_pwd,hotel_photo,hotel_active,admin_no) values(?,?,?,?,?,?,?,?,?,?,1,?)";
	//95. 병원예약 추가
	public String insertReserveHospital="insert into reserve_hospital(reserve_hospital_no,reserve_hospital_date,member_no,hospital_no) values(?,?,?,?)";
	//96. 미용실예약 추가
	public String insertReserveBeauty="insert into reserve_beauty(reserve_beauty_no,reserve_beauty_date,member_no,beauty_no) values(?,?,?,?)";
	//97. 호텔 방 추가
	public String insertRoom="insert into room(room_no,hotel_no,room_kind,room_price) values(?,?,?,?)";
	//98. 호텔예약 추가
	public String insertReserveHotel="insert into reserve_hotel(reserve_hotel_no,reserve_hotel_date,member_no,hotel_no,room_no) values(?,?,?,?,?)";
	//99. 병원 상세예약 추가
	public String insertReserveHospitalDetail="insert into reserve_hospital_detail(reserve_hospital_no,member_no,hospital_no,animal_kind,animal_weight) values(?,?,?,?,?)";
	//100. 미용실 상세예약 추가
	public String insertReserveBeautyDetail="insert into reserve_beauty_detail(reserve_beauty_no,member_no,beauty_no,animal_kind,animal_weight) values(?,?,?,?,?)";
	//101. 호텔 상세예약 추가
	public String insertReserveHotelDetail="insert into reserve_hotel_detail(reserve_hotel_no,member_no,hotel_no,room_no,animal_kind, animal_weight, check_in, check_out, reserve_hotel_price) values(?,?,?,?,?,?,?,?,?)";
	//102. 병원 리뷰 추가
	public String insertHospitalReview="insert into hospital_review(hospital_review_no,hospital_review_score,hospital_review_epilogue,hospital_no,member_no) values(?,?,?,?,?)";
	//103. 미용실 리뷰 추가
	public String insertBeautyReview="insert into beauty_review(beauty_review_no,beauty_review_score,beauty_review_epilogue,beauty_no,member_no) values(?,?,?,?,?)";
	//104. 호텔 리뷰 추가
	public String insertHotelReview="insert into hotel_review(hotel_review_no,hotel_review_score,hotel_review_epilogue,hotel_no,member_no) values(?,?,?,?,?)";
	//105. 자유게시판 글 추가
	public String insertFreeBoard="insert into free_board(free_board_no,free_board_title,free_board_count,free_board_comment_count,free_board_content,FREE_BOARD_DATE,member_id,member_no) values(?,?,?,?,?,?,?,?)";
	//106. 자유게시판 댓글 추가
	public String insertFreeBoardComment="insert into free_board_comment(free_board_no,free_board_comment_no,member_id,free_board_comment_content,free_board_date,member_no) values(?,?,?,?,?,?)";
	//107. 문의게시판 글 추가
	public String insertInquireBoard="insert into inquire_board(inquire_board_no,member_id,inquire_board_title,inquire_board_content,inquire_board_date,inquire_board_comment_count,member_no,admin_no) values(?,?,?,?,?,?,?,?)";
	//108. 문의게시판 댓글 추가
	public String insertInquireBoardComment="insert into inquire_board_comment(inquire_board_no,inquire_board_comment_no,admin_id,inquire_board_comment_content,inquire_board_comment_date,admin_no) values(?,?,?,?,?,?)";
	//109. 반려동물 추가
	public String insertAnimal="insert into animal(member_no,animal_no,animal_name,animal_kind,animal_gender,animal_breed,animal_weight) values(?,?,?,?,?,?,?)";
	//110. 관리자 쪽지 추가
	public String insertMessage="insert into message(message_no,message_title,message_content,message_date,admin_no,member_no) values(?,?,?,?,?,?)";
	//111. 회원 쪽지 검색
	public String insertMemberMessage="select m.message_no,m.message_title,m.message_content,m.message_date ,b.member_id from message m, member b where m.member_no=b.member_no and  b.member_no=?";
	//112. 수의사 추가
	public String insertVet="insert into vet(vet_no,vet_name,vet_introduce,hospital_no) values(?,?,?,?)";
	//113. 미용사 추가
	public String insertBeautician="insert into beautician(beautician_no,beautician_name,beautician_introduce,beauty_no) values(?,?,?,?)";
	//114. 병원 예약 시간대
	public String insertHospitalReserveTiem="insert into reserve_hospital_time(reserve_hospital_no,hospital_time_kind,hospital_no) values(?,?,?)";
	//115. 미용실 예약 시간대 추가
	public String insertBeautyReserveTime="insert into reserve_beauty_time(reserve_beauty_time_no,BEAUTY_TIME_KIND,BEAUTY_NO) values(?,?,?)";
	//116. 회원 마지막번호 조회
	public String memberNoMax="select max(member_no)+1 from member";
	//117. 병원 마지막번호 조회
	public String hospitalNoMax="select max(hospital_no)+1 from hospital";
	//118. 미용실 마지막번호 조회
	public String beautyNoMax="select max(beauty_no)+1 from beauty";
	//119. 호텔 마지막번호 조회
	public String hotelNoMax="select max(hotel_no)+1 from hotel";
	//회원. 회원 로그인
	public String memberLogin="select member_no,member_address,member_id,member_pwd,member_gender,member_phone,member_name,member_mail,member_coupon,member_active,admin_no from member where member_id=? and member_pwd=?";
	//관리자. 관리자 로그인
	public String adminLogin="select admin_no from admin where admin_id=? and admin_pwd=?";
	//120. 관리자 마지막번호 조회
	public String adminNoMax="select max(admin_no)+1 from admin";
	// 관리자 아이디 중복확인
	public String adminidCheck="select count(*) from admin where admin_id=?";
	// 병원회원 아이디 중복확인
	public String hospitalIdCheck="select count(*) from hospital where hospital_id=?";
	// 병원 사업자 등록번호 중복확인
	public String hospitalOnerNoCheck="selelct count(*) from hospital where hospital_orner_no=?";
	// 미용실회원 아이디 중복확인
	public String beautyIdCheck="select count(*) from beauty where beauty_id=?";
	// 미용실회원 사업자 등록번호 중복확인
	public String beuatyOrnerNoCheck="select count(*) from beauty where beauty_orner_no=?";
	// 호텔회원 아이디 찾기
	public String hotelIdCheck="select count(*) from hotel where hotel_id=?";
	// 호텔회원 사업자 등록번호 중복확인
	public String hotelOrnerNoCheck="select count(*) from hotel where hotel_orner_no";
	// 애완동물 마지막 번호 찾기
	public String animalMaxNo = "select max(animal_no)+1 from animal where member_no=?";
}
