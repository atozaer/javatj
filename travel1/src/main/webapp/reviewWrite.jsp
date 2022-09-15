<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hc" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<!--
   Editorial by HTML5 UP
   html5up.net | @ajlkn
   Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
   <head>
      <title>하이코딩 - TripReview</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="assets/css/main.css" />
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link rel="shortcut icon" href="/images/종이비행기.png" type="image/x-icon">
		<link rel="icon" href="images/종이비행기.png" type="image/x-icon">
      <link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
   </head>
   <body class="is-preload">

      <!-- Wrapper -->
         <div id="wrapper">

            <!-- Main -->
               <div id="main">
                  <div class="inner">

                     <!-- Header -->
								
								<header id="header" >
									<a href="main.do" class="logo"><strong>Trip</strong>review</a>	
									
																	
									<hc:login></hc:login>
								</header>

                     <!-- Content -->
                        <section>
                           <header class="main" style="text-align: center;">
                              <h1>리뷰 쓰기</h1>
                           </header>

                           <hr class="major" />

                              <form method="post" action="reviewWrite.do" enctype="multipart/form-data">
                                  <input type="hidden" name="mid" value="${member.mid}">
                                  <table width="700" border="3" bordercolor="lightgray" align="center">
                                      <tr>
                                          <td id="title">작성자</td>
                                          <td><input type="text" name="mid" value="${member.mid}" readonly="readonly"></td>
                                      </tr>
                                          <tr>
                                          <td id="title">
                                              제 목
                                          </td>
                                          <td>
                                              <input name="rtitle" type="text" size="70" maxlength="100"  placeholder="Enter your subject"/>
                                          </td>        
                                      </tr>
                                      <tr>
                                          <td id="title">
                                              내 용
                                          </td>
                                          <td>
                                              <textarea name="rcontent" cols="72" rows="20" placeholder="Enter your message"></textarea>            
                                          </td>        
                                      </tr>
                                      <tr>
                                          <td id="title">
                                              파일첨부
                                          </td>
                                          <td>
                                              <input type="file" name="rfile" />
                                          </td>    
                                      </tr>
                                      <tr>
                                         <td>
                                            주소
                                         </td>
                                          <td>
                                           <input type="text" id="sample5_address" placeholder="주소" name="raddress">
											<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
											<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
											
											<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
											<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=apikey&libraries=services"></script>
											<script>
											    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
											        mapOption = {
											            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
											            level: 5 // 지도의 확대 레벨
											        };
											
											    //지도를 미리 생성
											    var map = new daum.maps.Map(mapContainer, mapOption);
											    //주소-좌표 변환 객체를 생성
											    var geocoder = new daum.maps.services.Geocoder();
											    //마커를 미리 생성
											    var marker = new daum.maps.Marker({
											        position: new daum.maps.LatLng(37.537187, 127.005476),
											        map: map
											    });
											
											
											    function sample5_execDaumPostcode() {
											        new daum.Postcode({
											            oncomplete: function(data) {
											                var addr = data.address; // 최종 주소 변수
											
											                // 주소 정보를 해당 필드에 넣는다.
											                document.getElementById("sample5_address").value = addr;
											                // 주소로 상세 정보를 검색
											                geocoder.addressSearch(data.address, function(results, status) {
											                    // 정상적으로 검색이 완료됐으면
											                    if (status === daum.maps.services.Status.OK) {
											
											                        var result = results[0]; //첫번째 결과의 값을 활용
											
											                        // 해당 주소에 대한 좌표를 받아서
											                        var coords = new daum.maps.LatLng(result.y, result.x);
											                        // 지도를 보여준다.
											                        mapContainer.style.display = "block";
											                        map.relayout();
											                        // 지도 중심을 변경한다.
											                        map.setCenter(coords);
											                        // 마커를 결과값으로 받은 위치로 옮긴다.
											                        marker.setPosition(coords)
											                    }
											                });
											            }
											        }).open();
											    }
											</script>
                                          </td>  
                                      </tr>
                                  </table>  
                                  <ul class="actions" style="float: right;">
                                    <li><input type="submit" value="발행하기" class="primary" /></li>
                                    <li><input type="reset" value="다시작성" /></li>
                                    <li><input type="button" value="리뷰 목록보기" onclick="location.href='reviewBoard.jsp'" ></li>
                                 </ul>  
                               </form>

                           
                        </section>

                  </div>
               </div>

            <!-- Sidebar -->
               <div id="sidebar">
                  <div class="inner">

                     <!-- Search -->
								<section  class="alt">
								
									<form id="searchForm" method="post" action="searchPage.do">
										
								
									<table>
										<tr>
											<td>								
												<select name="keyword" style="float: left; vertical-align: text-top; font-size: 12pt; text-align-last: center; width: 100px; height: 40px; background-color: #D4F4FA; color: black; border: 1px solid gray;">
													<option value="rtitle">제목</option>
													<option value="mid">작성자</option>
												</select>
											</td>
											<td>										
												<input type="submit" value="검색하기" name="searchres" class="" style="float: right;">
											</td>		
										</tr>
										<tr>
											<td colspan="2">
												<input type="text" name="query" id="query" placeholder="Search" />
											</td>
										</tr>	
									</table>

                     <!-- Menu -->
                        <nav id="menu">
                           <header class="major">
                              <h2>메뉴</h2>
                           </header>
                           <ul>
								<li><a href="main.do">메인</a></li>
								<li><a href="newsBoard.do">공지사항</a></li>
								<li><a href="reviewBoard.do">리뷰 게시판</a></li>
								<li><a href="askBoard.do">문의 게시판</a></li>
							</ul>
                        </nav>

                     <!-- Section -->
                        <section>
									<header class="major">
										<h2>꿈을 담은 특별한 여행<br>하이코딩 TripReview!</h2>
									</header>
									<p>
										꿈을 담은 특별한 여행, 하이코딩 TripReview!<br>
										그 들의 후기가 궁금하다면?<br>
										하이코딩 Original 지금바로 리뷰페이지에서 만나보세요.<br>
										특별한 키워드를 담은 여행 후기들을 소개합니다.<br>
										#친환경 여행  #꿈의 숙박</p>
									<ul class="contact">
										<li class="icon solid fa-envelope"><a href="#">j38317_study@naver.com</a></li>
										<li class="icon solid fa-phone">010-4920-xxxx</li>
										<li class="icon solid fa-home">7, Bongcheon-ro 8-gil</li>
									</ul>
								</section>

                     <!-- Footer -->
                        <footer id="footer">
                           <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
                        </footer>

                  </div>
               </div>

         </div>

      <!-- Scripts -->
         <script src="assets/js/jquery.min.js"></script>
         <script src="assets/js/browser.min.js"></script>
         <script src="assets/js/breakpoints.min.js"></script>
         <script src="assets/js/util.js"></script>
         <script src="assets/js/main.js"></script>

   </body>
</html>