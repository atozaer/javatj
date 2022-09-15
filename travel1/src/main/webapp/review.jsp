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

<!-- review페이지 개선해야 할 사항 -->


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
      <script src="http://code.jquery.com/jquery-latest.min.js"></script>
      <script type="text/javascript" src="jquery.raty.js"></script>
      <link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css"/>
      <script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
      <style>
      html,
      body {
        position: relative;
        height: 100%;
      }

      body {
        background: #eee;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color: #000;
        margin: 0;
        padding: 0;
      }

      .swiper {
        width: 600px;
        height: 500px;
      }

      .swiper-slide {
        text-align: center;
        font-size: 18px;
        background: #fff;

        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
      }

      .swiper-slide img {
        display: block;
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
    </style>
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
                              <h1>리뷰</h1>
                           </header>
                           <div id="reviewWrite" style="text-align: right" >
                           <a class="button primary" href="reviewWrite.do">수정</a>
                           
                           </div>
                           <hr>

                           <div class="row gtr-uniform">
                           <!-- c태그로 div생성 및 내용물 넣기 -->
                           <c:forEach var="bs" items="${review}">
                              <c:set var="rvo" value="${bs.reviewboardVO}"/>
                                                         
                              <div class="col-8 off-2"  style="justify-content:center;">
                                 
                                 <table>
                                    
                                    <tr style="background: transparent; border: none;">
                                       <td style="width:5%;">
                                          <div id="review_mphoto" style=" display:inline-block; border-radius: 70%; width:40px; height:40px; overflow: hidden; margin-bottom: -10px;">
                                             
                                          </div>
                                       </td>
                                       <td style=" width:60%; text-align: left">
                                          <div id="review_mname" style="display:inline-block;">
                                             <a href="myReviewBoard.do?a=${rvo.mid}" style="font-size:30px;">${rvo.mid}</a>
                                          </div>
                                          
                                       </td>
                                       <td style=" width:15%; text-align: left">
                                          
                                          <a href="#" class="icon" style="font-size: 30px;"><span>★<hc:fmt rthumbsup="${rvo.rthumbsup}"></hc:fmt></span></a>
                                       </td>
                                       <td style=" width:15%; text-align: left">
                                          
                                          <span>${rvo.rdate}</span>
                                       </td>
                                                                                                            
                                    </tr>
                                    
                                    <tr style="background: transparent; border: none;">
                                       <td colspan="5">                                           
                                          <span style="width:100%; height:100%; overflow: hidden" class="image fit">
                                             <!-- Swiper -->
                                              <div class="swiper mySwiper">
                                                 <div class="swiper-wrapper">
                                                     <div class="swiper-slide"><img alt="리뷰이미지" src='./images/${rvo.rfile}' style="width:100%; height:100%;"></div>
                                                     <div class="swiper-slide">
                                                        <div id="map" style="width:100%;height:350px;"></div>
                                                      
                                                         <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9d66568cb497f8969704401e174afea5&libraries=services"></script>
                                                         <script>
                                                         var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                                                             mapOption = {
                                                                 center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                                                                 level: 3 // 지도의 확대 레벨
                                                             };  
                                                         
                                                         // 지도를 생성합니다    
                                                         var map = new kakao.maps.Map(mapContainer, mapOption); 
                                                         
                                                         // 주소-좌표 변환 객체를 생성합니다
                                                         var geocoder = new kakao.maps.services.Geocoder();
                                                         
                                                         // 주소로 좌표를 검색합니다   << '제주특별자치도 ... 여기에다가 값 넣기!'
                                                         geocoder.addressSearch('${rvo.raddress}', function(result, status) {
                                                         
                                                             // 정상적으로 검색이 완료됐으면 
                                                              if (status === kakao.maps.services.Status.OK) {
                                                         
                                                                 var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                                                         
                                                                 // 결과값으로 받은 위치를 마커로 표시합니다
                                                                 var marker = new kakao.maps.Marker({
                                                                     map: map,
                                                                     position: coords
                                                                 });
                                                         
                                                                 // 인포윈도우로 장소에 대한 설명을 표시합니다
                                                                 var infowindow = new kakao.maps.InfoWindow({
                                                                     content: '<div style="width:150px;text-align:center;padding:6px 0;">Here!</div>'
                                                                 });
                                                                 infowindow.open(map, marker);
                                                         
                                                                 // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                                                                 map.setCenter(coords);
                                                             } 
                                                         });    
                                                         </script>
                                                      </div>                                                                                                    
                                                   </div>
                                                <div class="swiper-button-next"></div>
                                                <div class="swiper-button-prev"></div>
                                                <div class="swiper-pagination"></div>
                                                 </div>
                                             
                                          </span>
                                       </td>
                                    </tr>
                                    
                                    <tr style="border-top: none;">
                                       <td colspan="5"><textarea readonly="readonly" style="background: transparent;">${rvo.rcontent}</textarea></td>
                                    </tr>
                                    
                                    
                                 </table>
                                    
                                    
                                 <form method="post" action="r_comment_insert.do?rnum=${rvo.rnum}&mid=${member.mid}">
                                    <div class="row gtr-uniform">
                                       <!-- Break -->
                                       <div class="col-6 col-12-xsmall">
                                          <input type="text" placeholder="댓글을 입력해보세요" class="fit" style="height:24px;" name="ccontent"/>
                                       </div>
                                       
                                       <!-- Break -->
                                       <div class="col-3">             
                                          <div id="star" ></div>
 											<input type="hidden" id="starRating" name="cthumbsup">
    
                                              <script type="text/javascript">
                                                  $(function() {
                                                      $('div#star').raty({
                                                         
                                                          score: 3
                                                          ,path : "./images"
                                                          ,width : 200
                                                          ,click: function(score, evt) {
                                                              $("#starRating").val(score);
                                                              $("#displayStarRating").html(score);
                                                          },half:     true,
                                                          starHalf: 'star-half.png'
                                                      });
                                                  });
                                              </script>                                            
                                       </div>      
                                       
                                       <!-- Break -->
                                       <div class="col-2">
                                          <input type="submit" value="등록" class="primary" name="searchSubject" />                                    
                                       </div>
                                    </div>
                                 </form>
                                 <table>   
                                    <tr>
                                       <td style="width:10%;">작성자</td>
                                       <td style=" width:75%; text-align: left">내용</td>
                                       <td>별점</td>
                                       <td>작성일</td>
                                    </tr>
                                 <c:forEach var="cvo" items="${bs.comments}">
                                   
                                    <tr>
                                       <td>${cvo.mid}</td>
                                       <td>${cvo.ccontent}</td>
                                       <td>★${cvo.cthumbsup}</td>
                                       <td>${cvo.cdate}</td>
                                       <hc:reviewCommentDelete mid="${cvo.mid}" cnum="${cvo.cnum}" rnum="${rvo.rnum}"></hc:reviewCommentDelete>
                                       
                                    </tr>
                                 </c:forEach>      
                                 </table>                     
                              </div>   
                           </c:forEach>                                 
                           </div>
                        </section>
                        <section style="text-align: center;">
                           <div class="row">
                              <div class="col-4 off-4" style="margin-top: 30px">
                              <a href="reviewBoard.do" class="button fit">목록으로</a>
                              </div>
                              
                           </div>
                        </section>
                     </div>
                  </div>
                           

            <!-- Sidebar -->
               <div id="sidebar">
                  <div class="inner">

                     <!-- Search -->
                        <section id="search" class="alt">
                           <form method="post" action="#">
                              <input type="text" name="query" id="query" placeholder="Search" />
                           </form>
                        </section>

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
         <!-- Swiper JS -->
          <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
      
          <!-- Initialize Swiper -->
          <script>
            var swiper = new Swiper(".mySwiper", {
              pagination: {
                el: ".swiper-pagination",
                type: "fraction",
              },
              navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev",
              },
            });
          </script>
         <script src="assets/js/browser.min.js"></script>
         <script src="assets/js/breakpoints.min.js"></script>
         <script src="assets/js/util.js"></script>
         <script src="assets/js/main.js"></script>
         

   </body>
   
</html>